package org.codait.tf.simple;

import java.io.IOException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.codait.tf.TFModel;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AddFloat32Test {

	protected static Logger log = LogManager.getLogger(AddFloat32Test.class);

	public static final String ADD_FLOAT32_MODEL_DIR = "./simple/add_float32";

	private TFModel model = null;

	@Before
	public void init() throws IOException {
		model = new TFModel(ADD_FLOAT32_MODEL_DIR).sig("serving_default");
	}

	@After
	public void after() {
	}

	@Test
	public void inputFloatsOutputFloat() {
		float result = model.in("input1", 1.0f).in("input2", 2.0f).out("output").run().getFloat("output");
		Assert.assertTrue(3.0f == result);
	}

	@Test
	public void inputDoublesOutputFloat() {
		float result = model.in("input1", 1.0d).in("input2", 2.0d).out("output").run().getFloat("output");
		Assert.assertTrue(3.0f == result);
	}

	@Test
	public void inputIntsOutputFloat() {
		float result = model.in("input1", 1).in("input2", 2).out("output").run().getFloat("output");
		Assert.assertTrue(3.0f == result);
	}

	@Test
	public void inputLongsOutputFloat() {
		float result = model.in("input1", 1L).in("input2", 2L).out("output").run().getFloat("output");
		Assert.assertTrue(3.0f == result);
	}

	@Test
	public void inputStringsOutputFloat() {
		float result = model.in("input1", "1").in("input2", "2").out("output").run().getFloat("output");
		Assert.assertTrue(3.0f == result);
	}

	@Test
	public void inputFloatsOutputDouble() {
		double result = model.in("input1", 1.0f).in("input2", 2.0f).out("output").run().getDouble("output");
		Assert.assertTrue(3.0d == result);
	}

	@Test
	public void inputFloatsOutputInt() {
		int result = model.in("input1", 1.0f).in("input2", 2.0f).out("output").run().getInt("output");
		Assert.assertTrue(3 == result);
	}

	@Test
	public void inputFloatsOutputLong() {
		long result = model.in("input1", 1.0f).in("input2", 2.0f).out("output").run().getLong("output");
		Assert.assertTrue(3L == result);
	}

	@Test
	public void inputFloatsOutputString() {
		String result = model.in("input1", 1.0f).in("input2", 2.0f).out("output").run().getString("output");
		Assert.assertTrue("3.0".equals(result));
	}

	@Test
	public void inputFloatArraysOutputFloatArray() {
		float[] result = model.in("input1", new float[] { 1.0f, 2.0f }).in("input2", new float[] { 3.0f, 4.0f })
				.out("output").run().getFloatArray("output");
		Assert.assertArrayEquals(new float[] { 4.0f, 6.0f }, result, 0.0f);
	}

	@Test
	public void inputDoubleArraysOutputFloatArray() {
		float[] result = model.in("input1", new double[] { 1.0d, 2.0d }).in("input2", new double[] { 3.0d, 4.0d })
				.out("output").run().getFloatArray("output");
		Assert.assertArrayEquals(new float[] { 4.0f, 6.0f }, result, 0.0f);
	}

	@Test
	public void inputIntArraysOutputFloatArray() {
		float[] result = model.in("input1", new long[] { 1, 2 }).in("input2", new long[] { 3, 4 }).out("output").run()
				.getFloatArray("output");
		Assert.assertArrayEquals(new float[] { 4.0f, 6.0f }, result, 0.0f);
	}

	@Test
	public void inputLongArraysOutputFloatArray() {
		float[] result = model.in("input1", new long[] { 1L, 2L }).in("input2", new long[] { 3L, 4L }).out("output")
				.run().getFloatArray("output");
		Assert.assertArrayEquals(new float[] { 4.0f, 6.0f }, result, 0.0f);
	}

	@Test
	public void inputStringArraysOutputFloatArray() {
		float[] result = model.in("input1", new String[] { "1", "2" }).in("input2", new String[] { "3", "4" })
				.out("output").run().getFloatArray("output");
		Assert.assertArrayEquals(new float[] { 4.0f, 6.0f }, result, 0.0f);
	}

	@Test
	public void inputFloatArraysOutputDoubleArray() {
		double[] result = model.in("input1", new float[] { 1.0f, 2.0f }).in("input2", new float[] { 3.0f, 4.0f })
				.out("output").run().getDoubleArray("output");
		Assert.assertArrayEquals(new double[] { 4.0d, 6.0d }, result, 0.0d);
	}

	@Test
	public void inputFloatArraysOutputIntArray() {
		int[] result = model.in("input1", new float[] { 1.0f, 2.0f }).in("input2", new float[] { 3.0f, 4.0f })
				.out("output").run().getIntArray("output");
		Assert.assertArrayEquals(new int[] { 4, 6 }, result);
	}

	@Test
	public void inputFloatArraysOutputLongArray() {
		long[] result = model.in("input1", new float[] { 1.0f, 2.0f }).in("input2", new float[] { 3.0f, 4.0f })
				.out("output").run().getLongArray("output");
		Assert.assertArrayEquals(new long[] { 4L, 6L }, result);
	}

	@Test
	public void inputFloatArraysOutputStringArray() {
		String[] result = model.in("input1", new float[] { 1.0f, 2.0f }).in("input2", new float[] { 3.0f, 4.0f })
				.out("output").run().getStringArray("output");
		Assert.assertArrayEquals(new String[] { "4.0", "6.0" }, result);
	}

	@Test
	public void inputMultiFloatArraysOutputMultiFloatArray() {
		float[][] input1 = new float[][] { { 1.0f, 2.0f }, { 3.0f, 4.0f } };
		float[][] input2 = new float[][] { { 1.0f, 2.0f }, { 3.0f, 4.0f } };
		float[][] expected = new float[][] { { 2.0f, 4.0f }, { 6.0f, 8.0f } };
		float[][] result = (float[][]) model.in("input1", input1).in("input2", input2).out("output").run()
				.getFloatArrayMultidimensional("output");
		for (int i = 0; i < expected.length; i++) {
			Assert.assertArrayEquals(expected[i], result[i], 0.0f);
		}
	}

	@Test
	public void inputMultiDoubleArraysOutputMultiDoubleArray() {
		double[][] input1 = new double[][] { { 1.0d, 2.0d }, { 3.0d, 4.0d } };
		double[][] input2 = new double[][] { { 1.0d, 2.0d }, { 3.0d, 4.0d } };
		double[][] expected = new double[][] { { 2.0d, 4.0d }, { 6.0d, 8.0d } };
		double[][] result = (double[][]) model.in("input1", input1).in("input2", input2).out("output").run()
				.getDoubleArrayMultidimensional("output");
		for (int i = 0; i < expected.length; i++) {
			Assert.assertArrayEquals(expected[i], result[i], 0.0d);
		}
	}

	@Test
	public void inputMultiIntArraysOutputMultiIntArray() {
		int[][] input1 = new int[][] { { 1, 2 }, { 3, 4 } };
		int[][] input2 = new int[][] { { 1, 2 }, { 3, 4 } };
		int[][] expected = new int[][] { { 2, 4 }, { 6, 8 } };
		int[][] result = (int[][]) model.in("input1", input1).in("input2", input2).out("output").run()
				.getIntArrayMultidimensional("output");
		for (int i = 0; i < expected.length; i++) {
			Assert.assertArrayEquals(expected[i], result[i]);
		}
	}

	@Test
	public void inputMultiLongArraysOutputMultiLongArray() {
		long[][] input1 = new long[][] { { 1L, 2L }, { 3L, 4L } };
		long[][] input2 = new long[][] { { 1L, 2L }, { 3L, 4L } };
		long[][] expected = new long[][] { { 2L, 4L }, { 6L, 8L } };
		long[][] result = (long[][]) model.in("input1", input1).in("input2", input2).out("output").run()
				.getLongArrayMultidimensional("output");
		for (int i = 0; i < expected.length; i++) {
			Assert.assertArrayEquals(expected[i], result[i]);
		}
	}

	@Test
	public void inputMultiStringArraysOutputMultiStringArray() {
		String[][] input1 = new String[][] { { "1", "2" }, { "3", "4" } };
		String[][] input2 = new String[][] { { "1", "2" }, { "3", "4" } };
		String[][] expected = new String[][] { { "2.0", "4.0" }, { "6.0", "8.0" } };
		String[][] result = (String[][]) model.in("input1", input1).in("input2", input2).out("output").run()
				.getStringArrayMultidimensional("output");
		for (int i = 0; i < expected.length; i++) {
			Assert.assertArrayEquals(expected[i], result[i]);
		}
	}
}