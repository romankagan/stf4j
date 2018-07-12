package org.codait.tf.cifar_10;

import java.io.IOException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.codait.tf.ArrayUtil;
import org.codait.tf.TFModel;
import org.codait.tf.cifar_10.CIFAR10Util.DimOrder;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CIFAR10Test {

	protected static Logger log = LogManager.getLogger(CIFAR10Test.class);

	public static final String CIFAR10_TEST_BATCH_BIN = "./cifar10_data/cifar-10-batches-bin/test_batch.bin";
	public static final String CIFAR10_SAVED_MODEL_DIR = "./cifar10_saved_model/";

	private int[] labels = null;
	private float[][][][] images = null;
	private TFModel model = null;

	@Before
	public void init() throws IOException {
		labels = CIFAR10Util.getLabels(CIFAR10_TEST_BATCH_BIN);
		images = CIFAR10Util.getPreprocessedImages(CIFAR10_TEST_BATCH_BIN, DimOrder.ROWS_COLS_CHANNELS);
		model = new TFModel(CIFAR10_SAVED_MODEL_DIR);
	}

	@After
	public void after() {
	}

	@Test
	public void cifarSingleImageInputClassesOutput() {
		log.debug("CIFAR10 - input image as 3d primitive float array, output classes");
		int imageNum = 0;
		float[][][] image = images[imageNum];
		int label = labels[imageNum];

		int prediction = model.in("input", image).out("classes").run().getInt("classes");

		Assert.assertTrue(isClassificationCorrect(label, prediction, imageNum));
	}

	public void cifarMultiImageInputClassesOutput(int index, int size) {
		log.debug("CIFAR10 - input images (" + size + ") as 4d primitive float array, output classes");
		log.debug(String.format("Image batch index: %d, size: %d", index, size));
		float[][][][] imageBatch = getImageBatch(index, size);
		int[] labels = getLabelBatch(index, size);
		int[] imageNums = getImageNumBatch(index, size);

		int[] predictions = model.in("input", imageBatch).out("classes").run().getIntArray("classes");

		float accuracy = computeAccuracy(labels, predictions, imageNums);
		evaluateAccuracy(accuracy, 0.80f, predictions.length);
	}

	@Test
	public void cifarMultipleImage1InputClassesOutput() {
		cifarMultiImageInputClassesOutput(0, 1);
	}

	@Test
	public void cifarMultipleImage10InputClassesOutput() {
		cifarMultiImageInputClassesOutput(0, 10);
	}

	@Test
	public void cifarMultipleImage100InputClassesOutput() {
		cifarMultiImageInputClassesOutput(0, 100);
	}

	@Test
	public void cifarMultipleImage1000InputClassesOutput() {
		cifarMultiImageInputClassesOutput(0, 1000);
	}

	@Test
	public void cifarSingleImageInputProbabilitiesOutput() {
		log.debug("CIFAR10 - input image as 3d primitive float array, output probabilities");
		int imageNum = 1;
		float[][][] image = images[imageNum];
		int label = labels[imageNum];

		float[] probabilities = model.in("input", image).out("probabilities").run().getFloatArray("probabilities");
		displayProbabilities(label, probabilities);
		int prediction = ArrayUtil.maxIndex(probabilities);
		Assert.assertTrue(isClassificationCorrect(label, prediction, imageNum));
	}

	private void displayProbabilities(int label, float[] probabilities) {
		StringBuilder sb = new StringBuilder();
		sb.append("\nProbabilities:\n");
		for (int i = 0; i < probabilities.length; i++) {
			sb.append(String.format("  %d %-12s: %6.2f%%\n", i, "(" + CIFAR10Util.classes[i] + ")",
					probabilities[i] * 100));
		}
		sb.append(String.format("Expected label: %d (%s)\n", label, CIFAR10Util.classes[label]));
		log.debug(sb.toString());
	}

	private void evaluateAccuracy(float accuracy, float acceptableAccuracy, int numPredictions) {
		if (accuracy < acceptableAccuracy) {
			String message = String.format(
					"Failure, for %d predictions, accuracy (%5.2f%%) must be greater or equal to acceptable accuracy (%5.2f%%)",
					numPredictions, accuracy * 100, acceptableAccuracy * 100);
			log.debug(message);
			Assert.fail(message);
		} else {
			String message = String.format(
					"Success, for %d predictions, accuracy (%5.2f%%) is greater than or equal to acceptable accuracy (%5.2f%%)",
					numPredictions, accuracy * 100, acceptableAccuracy * 100);
			log.debug(message);
		}
	}

	private boolean isClassificationCorrect(long label, long prediction, int imageNum) {
		if (label == prediction) {
			log.debug(String.format("Success, image #%d label %d (%s) equals prediction %d (%s)", imageNum, label,
					CIFAR10Util.classes[(int) label], prediction, CIFAR10Util.classes[(int) prediction]));
			return true;
		} else {
			log.debug(String.format("Failure, image #%d label %d (%s) does not equal prediction %d (%s)", imageNum,
					label, CIFAR10Util.classes[(int) label], prediction, CIFAR10Util.classes[(int) prediction]));
			return false;
		}
	}

	private float computeAccuracy(int[] labels, int[] predictions, int[] imageNums) {
		int numCorrectPredictions = 0;
		for (int i = 0; i < labels.length; i++) {
			long label = labels[i];
			long prediction = predictions[i];
			int imageNum = imageNums[i];
			if (isClassificationCorrect(label, prediction, imageNum)) {
				numCorrectPredictions++;
			}
		}
		return (float) numCorrectPredictions / predictions.length;
	}

	private float[][][][] getImageBatch(int startingIndex, int batchSize) {
		float[][][][] imageBatch = new float[batchSize][32][32][3];
		for (int i = startingIndex; i < startingIndex + batchSize; i++) {
			imageBatch[i - startingIndex] = images[i];
		}
		return imageBatch;
	}

	private int[] getLabelBatch(int startingIndex, int batchSize) {
		int[] labelBatch = new int[batchSize];
		for (int i = startingIndex; i < startingIndex + batchSize; i++) {
			labelBatch[i - startingIndex] = labels[i];
		}
		return labelBatch;
	}

	private int[] getImageNumBatch(int startingIndex, int batchSize) {
		int[] imageNumBatch = new int[batchSize];
		for (int i = startingIndex; i < startingIndex + batchSize; i++) {
			imageNumBatch[i - startingIndex] = i;
		}
		return imageNumBatch;
	}
}