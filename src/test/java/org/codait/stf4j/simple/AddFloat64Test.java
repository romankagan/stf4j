// ------------------------------------------------------------------------
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//      http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.
//
// ------------------------------------------------------------------------

package org.codait.stf4j.simple;

import java.io.IOException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.codait.stf4j.TFModel;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AddFloat64Test {

	protected static Logger log = LogManager.getLogger(AddFloat64Test.class);

	public static final String ADD_FLOAT64_MODEL_DIR = "../stf4j-test-models/simple_saved_models/add_float64";

	private TFModel model = null;

	@Before
	public void init() throws IOException {
		model = new TFModel(ADD_FLOAT64_MODEL_DIR).sig("serving_default");
	}

	@After
	public void after() {
	}

	@Test
	public void inputDoublesOutputDouble() {
		double result = model.in("input1", 1.0d).in("input2", 2.0d).out("output").run().getDouble("output");
		Assert.assertTrue(3.0d == result);
	}

	@Test
	public void inputFloatsOutputDouble() {
		double result = model.in("input1", 1.0f).in("input2", 2.0f).out("output").run().getDouble("output");
		Assert.assertTrue(3.0d == result);
	}

	@Test
	public void inputIntsOutputDouble() {
		double result = model.in("input1", 1).in("input2", 2).out("output").run().getDouble("output");
		Assert.assertTrue(3.0d == result);
	}

	@Test
	public void inputLongsOutputDouble() {
		double result = model.in("input1", 1L).in("input2", 2L).out("output").run().getDouble("output");
		Assert.assertTrue(3.0d == result);
	}

	@Test
	public void inputStringsOutputDouble() {
		double result = model.in("input1", "1").in("input2", "2").out("output").run().getDouble("output");
		Assert.assertTrue(3.0d == result);
	}

	@Test
	public void inputDoublesOutputInt() {
		int result = model.in("input1", 1.0d).in("input2", 2.0d).out("output").run().getInt("output");
		Assert.assertTrue(3 == result);
	}

	@Test
	public void inputDoublesOutputLong() {
		long result = model.in("input1", 1.0d).in("input2", 2.0d).out("output").run().getLong("output");
		Assert.assertTrue(3L == result);
	}

	@Test
	public void inputDoublesOutputFloat() {
		float result = model.in("input1", 1.0d).in("input2", 2.0d).out("output").run().getFloat("output");
		Assert.assertTrue(3.0f == result);
	}

	@Test
	public void inputDoublesOutputString() {
		String result = model.in("input1", 1.0d).in("input2", 2.0d).out("output").run().getString("output");
		Assert.assertTrue("3.0".equals(result));
	}

	@Test
	public void inputDoubleArraysOutputDoubleArray() {
		double[] result = model.in("input1", new double[] { 1.0d, 2.0d }).in("input2", new double[] { 3.0d, 4.0d })
				.out("output").run().getDoubleArray("output");
		Assert.assertArrayEquals(new double[] { 4.0d, 6.0d }, result, 0.0d);
	}

	@Test
	public void inputIntArraysOutputDoubleArray() {
		double[] result = model.in("input1", new int[] { 1, 2 }).in("input2", new int[] { 3, 4 }).out("output").run()
				.getDoubleArray("output");
		Assert.assertArrayEquals(new double[] { 4.0d, 6.0d }, result, 0.0d);
	}

	@Test
	public void inputLongArraysOutputDoubleArray() {
		double[] result = model.in("input1", new long[] { 1L, 2L }).in("input2", new long[] { 3L, 4L }).out("output")
				.run().getDoubleArray("output");
		Assert.assertArrayEquals(new double[] { 4.0d, 6.0d }, result, 0.0d);
	}

	@Test
	public void inputFloatArraysOutputDoubleArray() {
		double[] result = model.in("input1", new float[] { 1.0f, 2.0f }).in("input2", new float[] { 3.0f, 4.0f })
				.out("output").run().getDoubleArray("output");
		Assert.assertArrayEquals(new double[] { 4.0d, 6.0d }, result, 0.0d);
	}

	@Test
	public void inputStringArraysOutputDoubleArray() {
		double[] result = model.in("input1", new String[] { "1", "2" }).in("input2", new String[] { "3", "4" })
				.out("output").run().getDoubleArray("output");
		Assert.assertArrayEquals(new double[] { 4.0d, 6.0d }, result, 0.0d);
	}

	@Test
	public void inputDoubleArraysOutputFloatArray() {
		float[] result = model.in("input1", new double[] { 1.0d, 2.0d }).in("input2", new double[] { 3.0d, 4.0d })
				.out("output").run().getFloatArray("output");
		Assert.assertArrayEquals(new float[] { 4.0f, 6.0f }, result, 0.0f);
	}

	@Test
	public void inputDoubleArraysOutputIntArray() {
		int[] result = model.in("input1", new double[] { 1.0d, 2.0d }).in("input2", new double[] { 3.0d, 4.0d })
				.out("output").run().getIntArray("output");
		Assert.assertArrayEquals(new int[] { 4, 6 }, result);
	}

	@Test
	public void inputDoubleArraysOutputLongArray() {
		long[] result = model.in("input1", new double[] { 1.0d, 2.0d }).in("input2", new double[] { 3.0d, 4.0d })
				.out("output").run().getLongArray("output");
		Assert.assertArrayEquals(new long[] { 4L, 6L }, result);
	}

	@Test
	public void inputDoubleArraysOutputStringArray() {
		String[] result = model.in("input1", new double[] { 1.0d, 2.0d }).in("input2", new double[] { 3.0d, 4.0d })
				.out("output").run().getStringArray("output");
		Assert.assertArrayEquals(new String[] { "4.0", "6.0" }, result);
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

	@Test
	public void inputMultiIntArrayIntScalarOutputMultiIntArray() {
		int[][] input1 = new int[][] { { 1, 2 }, { 3, 4 } };
		int input2 = 5;
		int[][] expected = new int[][] { { 6, 7 }, { 8, 9 } };
		int[][] result = (int[][]) model.in("input1", input1).in("input2", input2).out("output").run()
				.getIntArrayMultidimensional("output");
		for (int i = 0; i < expected.length; i++) {
			Assert.assertArrayEquals(expected[i], result[i]);
		}
	}

	@Test
	public void inputMultiLongArrayLongScalarOutputMultiLongArray() {
		long[][] input1 = new long[][] { { 1L, 2L }, { 3L, 4L } };
		long input2 = 5L;
		long[][] expected = new long[][] { { 6L, 7L }, { 8L, 9L } };
		long[][] result = (long[][]) model.in("input1", input1).in("input2", input2).out("output").run()
				.getLongArrayMultidimensional("output");
		for (int i = 0; i < expected.length; i++) {
			Assert.assertArrayEquals(expected[i], result[i]);
		}
	}

	@Test
	public void inputMultiFloatArrayFloatScalarOutputMultiFloatArray() {
		float[][] input1 = new float[][] { { 1.0f, 2.0f }, { 3.0f, 4.0f } };
		float input2 = 5.0f;
		float[][] expected = new float[][] { { 6.0f, 7.0f }, { 8.0f, 9.0f } };
		float[][] result = (float[][]) model.in("input1", input1).in("input2", input2).out("output").run()
				.getFloatArrayMultidimensional("output");
		for (int i = 0; i < expected.length; i++) {
			Assert.assertArrayEquals(expected[i], result[i], 0.0f);
		}
	}

	@Test
	public void inputMultiDoubleArrayDoubleScalarOutputMultiDoubleArray() {
		double[][] input1 = new double[][] { { 1.0d, 2.0d }, { 3.0d, 4.0d } };
		double input2 = 5.0d;
		double[][] expected = new double[][] { { 6.0d, 7.0d }, { 8.0d, 9.0d } };
		double[][] result = (double[][]) model.in("input1", input1).in("input2", input2).out("output").run()
				.getDoubleArrayMultidimensional("output");
		for (int i = 0; i < expected.length; i++) {
			Assert.assertArrayEquals(expected[i], result[i], 0.0d);
		}
	}

	@Test
	public void inputMultiStringArrayStringScalarOutputMultiStringArray() {
		String[][] input1 = new String[][] { { "1", "2" }, { "3", "4" } };
		String input2 = "5";
		String[][] expected = new String[][] { { "6.0", "7.0" }, { "8.0", "9.0" } };
		String[][] result = (String[][]) model.in("input1", input1).in("input2", input2).out("output").run()
				.getStringArrayMultidimensional("output");
		for (int i = 0; i < expected.length; i++) {
			Assert.assertArrayEquals(expected[i], result[i]);
		}
	}

	@Test
	public void inputIntArrayIntScalarOutputIntArray() {
		int[] result = model.in("input1", new int[] { 1, 2 }).in("input2", 3).out("output").run().getIntArray("output");
		Assert.assertArrayEquals(new int[] { 4, 5 }, result);
	}

	@Test
	public void inputLongArrayLongScalarOutputLongArray() {
		long[] result = model.in("input1", new long[] { 1L, 2L }).in("input2", 3L).out("output").run()
				.getLongArray("output");
		Assert.assertArrayEquals(new long[] { 4, 5 }, result);
	}

	@Test
	public void inputFloatArrayFloatScalarOutputFloatArray() {
		float[] result = model.in("input1", new float[] { 1.0f, 2.0f }).in("input2", 3.0f).out("output").run()
				.getFloatArray("output");
		Assert.assertArrayEquals(new float[] { 4.0f, 5.0f }, result, 0.0f);
	}

	@Test
	public void inputDoubleArrayDoubleScalarOutputDoubleArray() {
		double[] result = model.in("input1", new double[] { 1.0d, 2.0d }).in("input2", 3.0d).out("output").run()
				.getDoubleArray("output");
		Assert.assertArrayEquals(new double[] { 4.0d, 5.0d }, result, 0.0d);
	}

	@Test
	public void inputStringArrayStringScalarOutputStringArray() {
		String[] result = model.in("input1", new String[] { "1", "2" }).in("input2", "3").out("output").run()
				.getStringArray("output");
		Assert.assertArrayEquals(new String[] { "4.0", "5.0" }, result);
	}

	@Test
	public void inputDoubleArraysOutputInt() {
		int result = model.in("input1", new double[] { 1.0d, 2.0d }).in("input2", new double[] { 3.0d, 4.0d })
				.out("output").run().getInt("output");
		Assert.assertTrue(4 == result);
	}

	@Test
	public void inputDoubleArraysOutputLong() {
		long result = model.in("input1", new double[] { 1.0d, 2.0d }).in("input2", new double[] { 3.0d, 4.0d })
				.out("output").run().getLong("output");
		Assert.assertTrue(4L == result);
	}

	@Test
	public void inputDoubleArraysOutputFloat() {
		float result = model.in("input1", new double[] { 1.0d, 2.0d }).in("input2", new double[] { 3.0d, 4.0d })
				.out("output").run().getFloat("output");
		Assert.assertTrue(4.0f == result);
	}

	@Test
	public void inputDoubleArraysOutputDouble() {
		double result = model.in("input1", new double[] { 1.0d, 2.0d }).in("input2", new double[] { 3.0d, 4.0d })
				.out("output").run().getDouble("output");
		Assert.assertTrue(4.0d == result);
	}

	@Test
	public void inputDoubleArraysOutputString() {
		String result = model.in("input1", new double[] { 1.0d, 2.0d }).in("input2", new double[] { 3.0d, 4.0d })
				.out("output").run().getString("output");
		Assert.assertTrue("4.0".equals(result));
	}

	@Test
	public void inputMultiDoubleArraysOutputInt() {
		double[][] input1 = new double[][] { { 1.0d, 2.0d }, { 3.0d, 4.0d } };
		double[][] input2 = new double[][] { { 1.0d, 2.0d }, { 3.0d, 4.0d } };
		int result = model.in("input1", input1).in("input2", input2).out("output").run().getInt("output");
		Assert.assertTrue(2 == result);
	}

	@Test
	public void inputMultiDoubleArraysOutputLong() {
		double[][] input1 = new double[][] { { 1.0d, 2.0d }, { 3.0d, 4.0d } };
		double[][] input2 = new double[][] { { 1.0d, 2.0d }, { 3.0d, 4.0d } };
		long result = model.in("input1", input1).in("input2", input2).out("output").run().getLong("output");
		Assert.assertTrue(2L == result);
	}

	@Test
	public void inputMultiDoubleArraysOutputFloat() {
		double[][] input1 = new double[][] { { 1.0d, 2.0d }, { 3.0d, 4.0d } };
		double[][] input2 = new double[][] { { 1.0d, 2.0d }, { 3.0d, 4.0d } };
		float result = model.in("input1", input1).in("input2", input2).out("output").run().getFloat("output");
		Assert.assertTrue(2.0f == result);
	}

	@Test
	public void inputMultiDoubleArraysOutputDouble() {
		double[][] input1 = new double[][] { { 1.0d, 2.0d }, { 3.0d, 4.0d } };
		double[][] input2 = new double[][] { { 1.0d, 2.0d }, { 3.0d, 4.0d } };
		double result = model.in("input1", input1).in("input2", input2).out("output").run().getDouble("output");
		Assert.assertTrue(2.0d == result);
	}

	@Test
	public void inputMultiDoubleArraysOutputString() {
		double[][] input1 = new double[][] { { 1.0d, 2.0d }, { 3.0d, 4.0d } };
		double[][] input2 = new double[][] { { 1.0d, 2.0d }, { 3.0d, 4.0d } };
		String result = model.in("input1", input1).in("input2", input2).out("output").run().getString("output");
		Assert.assertTrue("2.0".equals(result));
	}

	@Test
	public void inputBytesOutputByte() {
		byte result = model.in("input1", (byte) 1).in("input2", (byte) 2).out("output").run().getByte("output");
		Assert.assertTrue((byte) 3 == result);
	}

	@Test
	public void inputByteArraysOutputByteArray() {
		byte[] result = model.in("input1", new byte[] { (byte) 1, (byte) 2 })
				.in("input2", new byte[] { (byte) 3, (byte) 4 }).out("output").run().getByteArray("output");
		Assert.assertArrayEquals(new byte[] { (byte) 4, (byte) 6 }, result);
	}

	@Test
	public void inputMultiByteArraysOutputMultiByteArray() {
		byte[][] input1 = new byte[][] { { (byte) 1, (byte) 2 }, { (byte) 3, (byte) 4 } };
		byte[][] input2 = new byte[][] { { (byte) 1, (byte) 2 }, { (byte) 3, (byte) 4 } };
		byte[][] expected = new byte[][] { { (byte) 2, (byte) 4 }, { (byte) 6, (byte) 8 } };
		byte[][] result = (byte[][]) model.in("input1", input1).in("input2", input2).out("output").run()
				.getByteArrayMultidimensional("output");
		for (int i = 0; i < expected.length; i++) {
			Assert.assertArrayEquals(expected[i], result[i]);
		}
	}

	@Test
	public void inputByteArraysOutputByte() {
		byte result = model.in("input1", new byte[] { (byte) 1, (byte) 2 })
				.in("input2", new byte[] { (byte) 3, (byte) 4 }).out("output").run().getByte("output");
		Assert.assertEquals((byte) 4, result);
	}

	@Test
	public void inputMultiByteArraysOutputMultiByte() {
		byte[][] input1 = new byte[][] { { (byte) 1, (byte) 2 }, { (byte) 3, (byte) 4 } };
		byte[][] input2 = new byte[][] { { (byte) 1, (byte) 2 }, { (byte) 3, (byte) 4 } };
		byte expected = (byte) 2;
		byte result = model.in("input1", input1).in("input2", input2).out("output").run().getByte("output");
		Assert.assertTrue(expected == result);
	}

	// 1 + 0 = 1
	@Test
	public void inputBooleanTrueBooleanFalseOutputBooleanTrue() {
		boolean result = model.in("input1", true).in("input2", false).out("output").run().getBoolean("output");
		Assert.assertEquals(true, result);
	}

	// 0 + 0 = 0
	@Test
	public void inputBooleanFalseBooleanFalseOutputBooleanFalse() {
		boolean result = model.in("input1", false).in("input2", false).out("output").run().getBoolean("output");
		Assert.assertEquals(false, result);
	}

	// 1 + 0 = 1, 0 + 1 = 1
	@Test
	public void inputBooleanArraysOutputBooleanArray() {
		boolean[] result = model.in("input1", new boolean[] { true, false }).in("input2", new boolean[] { false, true })
				.out("output").run().getBooleanArray("output");
		BooleanLogicTest.assertArrayEquals(new boolean[] { true, true }, result);
	}

	// 1 + 0 = 1, 1 + 0 = 1, 0 + 1 = 1, 0 + 0 = 0
	@Test
	public void inputMultiBooleanArraysOutputMultiBooleanArray() {
		boolean[][] input1 = new boolean[][] { { true, true }, { false, false } };
		boolean[][] input2 = new boolean[][] { { false, false }, { true, false } };
		boolean[][] expected = new boolean[][] { { true, true }, { true, false } };
		boolean[][] result = (boolean[][]) model.in("input1", input1).in("input2", input2).out("output").run()
				.getBooleanArrayMultidimensional("output");
		BooleanLogicTest.assertArrayEquals(expected, result);
	}

	// 1 + 0 = 1
	@Test
	public void inputBooleanArraysOutputBoolean() {
		boolean result = model.in("input1", new boolean[] { true, false }).in("input2", new boolean[] { false, true })
				.out("output").run().getBoolean("output");
		Assert.assertEquals(true, result);
	}

	// 1 + 0 = 1
	@Test
	public void inputMultiBooleanArraysOutputMultiBoolean() {
		boolean[][] input1 = new boolean[][] { { true, true }, { false, false } };
		boolean[][] input2 = new boolean[][] { { false, false }, { true, false } };
		boolean expected = true;
		boolean result = model.in("input1", input1).in("input2", input2).out("output").run().getBoolean("output");
		Assert.assertEquals(expected, result);
	}
	
	@Test
	public void inputMultiDoubleObjectArraysOutputMultiDoubleArray() {
		Double[][] input1 = new Double[][] { { 1.0d, 2.0d }, { 3.0d, 4.0d } };
		Double[][] input2 = new Double[][] { { 1.0d, 2.0d }, { 3.0d, 4.0d } };
		double[][] expected = new double[][] { { 2.0d, 4.0d }, { 6.0d, 8.0d } };
		double[][] result = (double[][]) model.in("input1", input1).in("input2", input2).out("output").run()
				.getDoubleArrayMultidimensional("output");
		for (int i = 0; i < expected.length; i++) {
			Assert.assertArrayEquals(expected[i], result[i], 0.0d);
		}
	}
}
