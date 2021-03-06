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

package org.codait.stf4j.util;

/**
 * Utility class for consolidating type conversions.
 *
 */
public class TypeUtil {

	/**
	 * Primitive boolean to primitive byte.
	 * 
	 * @param b
	 *            boolean value
	 * @return byte value
	 */
	public static byte boolean_to_byte(boolean b) {
		return b ? (byte) 1 : (byte) 0;
	}

	/**
	 * Primitive boolean to primitive double.
	 * 
	 * @param b
	 *            boolean value
	 * @return double value
	 */
	public static double boolean_to_double(boolean b) {
		return b ? 1.0d : 0.0d;
	}

	/**
	 * Primitive boolean to primitive float.
	 * 
	 * @param b
	 *            boolean value
	 * @return float value
	 */
	public static float boolean_to_float(boolean b) {
		return b ? 1.0f : 0.0f;
	}

	/**
	 * Primitive boolean to primitive int.
	 * 
	 * @param b
	 *            boolean value
	 * @return int value
	 */
	public static int boolean_to_int(boolean b) {
		return b ? 1 : 0;
	}

	/**
	 * Primitive boolean to primitive long.
	 * 
	 * @param b
	 *            boolean value
	 * @return long value
	 */
	public static long boolean_to_long(boolean b) {
		return b ? 1L : 0L;
	}

	/**
	 * Primitive boolean to String.
	 * 
	 * @param b
	 *            boolean value
	 * @return String value
	 */
	public static String boolean_to_String(boolean b) {
		return Boolean.toString(b);
	}

	/**
	 * Primitive boolean to String primitive byte array.
	 * 
	 * @param b
	 *            boolean value
	 * @return String primitive byte array
	 */
	public static byte[] boolean_to_String_bytes(boolean b) {
		return Boolean.toString(b).getBytes();
	}

	/**
	 * Primitive byte to primitive boolean. True will be returned for any non-zero byte.
	 * 
	 * @param b
	 *            byte value
	 * @return boolean value
	 */
	public static boolean byte_to_boolean(byte b) {
		return b == 0 ? false : true;
	}

	/**
	 * Primitive unsigned byte to primitive double.
	 * 
	 * @param b
	 *            unsigned byte value
	 * @return double value
	 */
	public static double byte_unsigned_to_double(byte b) {
		int i = b & 0xFF; // unsigned
		return (double) i;
	}

	/**
	 * Primitive unsigned byte to primitive float.
	 * 
	 * @param b
	 *            unsigned byte value
	 * @return float value
	 */
	public static float byte_unsigned_to_float(byte b) {
		int i = b & 0xFF; // unsigned
		return (float) i;
	}

	/**
	 * Primitive unsigned byte to primitive int.
	 * 
	 * @param b
	 *            unsigned byte value
	 * @return int value
	 */
	public static int byte_unsigned_to_int(byte b) {
		return b & 0xFF; // unsigned
	}

	/**
	 * Primitive unsigned byte to primitive long.
	 * 
	 * @param b
	 *            unsigned byte value
	 * @return long value
	 */
	public static long byte_unsigned_to_long(byte b) {
		return (long) b & 0xFF; // unsigned
	}

	/**
	 * Primitive unsigned byte to String.
	 * 
	 * @param b
	 *            unsigned byte value
	 * @return String value
	 */
	public static String byte_unsigned_to_String(byte b) {
		return Integer.toString((int) b & 0xFF); // unsigned
	}

	/**
	 * Primitive double to primitive boolean. True will be returned for any non-zero double.
	 * 
	 * @param d
	 *            double value
	 * @return boolean value
	 */
	public static boolean double_to_boolean(double d) {
		return d == 0.0d ? false : true;
	}

	/**
	 * Primitive double to primitive byte.
	 * 
	 * @param d
	 *            double value
	 * @return byte value
	 */
	public static byte double_to_byte(double d) {
		return ((Double) d).byteValue();
	}

	/**
	 * Primitive double to primitive float.
	 * 
	 * @param d
	 *            double value
	 * @return float value
	 */
	public static float double_to_float(double d) {
		return (float) d;
	}

	/**
	 * Primitive double to primitive int.
	 * 
	 * @param d
	 *            double value
	 * @return int value
	 */
	public static int double_to_int(double d) {
		return (int) d;
	}

	/**
	 * Primitive double to primitive long.
	 * 
	 * @param d
	 *            double value
	 * @return long value
	 */
	public static long double_to_long(double d) {
		return (long) d;
	}

	/**
	 * Primitive double to String.
	 * 
	 * @param d
	 *            double value
	 * @return String value
	 */
	public static String double_to_String(double d) {
		return Double.toString(d);
	}

	/**
	 * Primitive double to String primitive byte array.
	 * 
	 * @param d
	 *            double value
	 * @return String primitive byte array
	 */
	public static byte[] double_to_String_bytes(double d) {
		return Double.toString(d).getBytes();
	}

	/**
	 * Primitive float to primitive boolean.
	 * 
	 * @param f
	 *            float value
	 * @return boolean value
	 */
	public static boolean float_to_boolean(float f) {
		return f == 0.0f ? false : true;
	}

	/**
	 * Primitive float to primitive byte.
	 * 
	 * @param f
	 *            float value
	 * @return byte value
	 */
	public static byte float_to_byte(float f) {
		return ((Float) f).byteValue();
	}

	/**
	 * Primitive float to primitive double.
	 * 
	 * @param f
	 *            float value
	 * @return double value
	 */
	public static double float_to_double(float f) {
		return (double) f;
	}

	/**
	 * Primitive float to primitive int.
	 * 
	 * @param f
	 *            float value
	 * @return int value
	 */
	public static int float_to_int(float f) {
		return (int) f;
	}

	/**
	 * Primitive float to primitive long.
	 * 
	 * @param f
	 *            float value
	 * @return long value
	 */
	public static long float_to_long(float f) {
		return (long) f;
	}

	/**
	 * Primitive float to String.
	 * 
	 * @param f
	 *            float value
	 * @return String value
	 */
	public static String float_to_String(float f) {
		return Float.toString(f);
	}

	/**
	 * Primitive float to String primitive byte array.
	 * 
	 * @param f
	 *            float value
	 * @return String primitive byte array
	 */
	public static byte[] float_to_String_bytes(float f) {
		return Float.toString(f).getBytes();
	}

	/**
	 * Primitive int to primitive boolean.
	 * 
	 * @param i
	 *            int value
	 * @return boolean value
	 */
	public static boolean int_to_boolean(int i) {
		return i == 0 ? false : true;
	}

	/**
	 * Primitive int to primitive byte.
	 * 
	 * @param i
	 *            int value
	 * @return byte value
	 */
	public static byte int_to_byte(int i) {
		return ((Integer) i).byteValue();
	}

	/**
	 * Primitive int to primitive double.
	 * 
	 * @param i
	 *            int value
	 * @return double value
	 */
	public static double int_to_double(int i) {
		return (double) i;
	}

	/**
	 * Primitive int to primitive float.
	 * 
	 * @param i
	 *            int value
	 * @return float value
	 */
	public static float int_to_float(int i) {
		return (float) i;
	}

	/**
	 * Primitive int to primitive long.
	 * 
	 * @param i
	 *            int value
	 * @return long value
	 */
	public static long int_to_long(int i) {
		return (long) i;
	}

	/**
	 * Primitive int to String.
	 * 
	 * @param i
	 *            int value
	 * @return String value
	 */
	public static String int_to_String(int i) {
		return Integer.toString(i);
	}

	/**
	 * Primitive int to String primitive byte array.
	 * 
	 * @param i
	 *            int value
	 * @return String primitive byte array
	 */
	public static byte[] int_to_String_bytes(int i) {
		return Integer.toString(i).getBytes();
	}

	/**
	 * Primitive long to primitive boolean.
	 * 
	 * @param l
	 *            long value
	 * @return boolean value
	 */
	public static boolean long_to_boolean(long l) {
		return l == 0L ? false : true;
	}

	/**
	 * Primitive long to primitive byte.
	 * 
	 * @param l
	 *            long value
	 * @return byte value
	 */
	public static byte long_to_byte(long l) {
		return ((Long) l).byteValue();
	}

	/**
	 * Primitive long to primitive double.
	 * 
	 * @param l
	 *            long value
	 * @return double value
	 */
	public static double long_to_double(long l) {
		return (double) l;
	}

	/**
	 * Primitive long to primitive float.
	 * 
	 * @param l
	 *            long value
	 * @return float value
	 */
	public static float long_to_float(long l) {
		return (float) l;
	}

	/**
	 * Primitive long to primitive int.
	 * 
	 * @param l
	 *            long value
	 * @return int value
	 */
	public static int long_to_int(long l) {
		return (int) l;
	}

	/**
	 * Primitive long to String.
	 * 
	 * @param l
	 *            long value
	 * @return String value
	 */
	public static String long_to_String(long l) {
		return Long.toString(l);
	}

	/**
	 * Primitive long to String primitive byte array.
	 * 
	 * @param l
	 *            long value
	 * @return String primitive byte array
	 */
	public static byte[] long_to_String_bytes(long l) {
		return Long.toString(l).getBytes();
	}

	/**
	 * String primitive byte array to primitive boolean.
	 * 
	 * @param b
	 *            String primitive byte array
	 * @return boolean value
	 */
	public static boolean String_bytes_to_boolean(byte[] b) {
		return "true".equals(new String(b)) ? true : false;
	}

	/**
	 * String primitive byte array to primitive byte. Note that this method utilizes the Integer byteValue rather than
	 * the Byte byteValue so as to handle values greater than 127 (greater than Byte.MAX_VALUE).
	 * 
	 * @param b
	 *            String primitive byte array
	 * @return byte value
	 */
	public static byte String_bytes_to_byte(byte[] b) {
		return new Integer(new String(b)).byteValue();
	}

	/**
	 * String primitive byte array to primitive double.
	 * 
	 * @param b
	 *            String primitive byte array
	 * @return double value
	 */
	public static double String_bytes_to_double(byte[] b) {
		return Double.parseDouble(new String(b));
	}

	/**
	 * String primitive byte array to primitive float.
	 * 
	 * @param b
	 *            String primitive byte array
	 * @return float value
	 */
	public static float String_bytes_to_float(byte[] b) {
		return Float.parseFloat(new String(b));
	}

	/**
	 * String primitive byte array to primitive int.
	 * 
	 * @param b
	 *            String primitive byte array
	 * @return int value
	 */
	public static int String_bytes_to_int(byte[] b) {
		return Integer.parseInt(new String(b));
	}

	/**
	 * String primitive byte array to primitive long.
	 * 
	 * @param b
	 *            String primitive byte array
	 * @return long value
	 */
	public static long String_bytes_to_long(byte[] b) {
		return Long.parseLong(new String(b));
	}

	/**
	 * String primitive byte array to String.
	 * 
	 * @param b
	 *            String primitive byte array
	 * @return String value
	 */
	public static String String_bytes_to_String(byte[] b) {
		return new String(b);
	}

	/**
	 * String to primitive boolean.
	 * 
	 * @param s
	 *            String value
	 * @return boolean value
	 */
	public static boolean String_to_boolean(String s) {
		return "true".equals(s) ? true : false;
	}

	/**
	 * String to primitive byte. Note that this method utilizes the Integer byteValue rather than the Byte byteValue so
	 * as to handle values greater than 127 (greater than Byte.MAX_VALUE).
	 * 
	 * @param s
	 *            String value
	 * @return byte value
	 */
	public static byte String_to_byte(String s) {
		return new Integer(s).byteValue();
	}

	/**
	 * String to primitive double.
	 * 
	 * @param s
	 *            String value
	 * @return double value
	 */
	public static double String_to_double(String s) {
		return Double.parseDouble(s);
	}

	/**
	 * String to primitive float.
	 * 
	 * @param s
	 *            String value
	 * @return float value
	 */
	public static float String_to_float(String s) {
		return Float.parseFloat(s);
	}

	/**
	 * String to primitive int.
	 * 
	 * @param s
	 *            String value
	 * @return int value
	 */
	public static int String_to_int(String s) {
		return Integer.parseInt(s);
	}

	/**
	 * String to primitive long.
	 * 
	 * @param s
	 *            String value
	 * @return long value
	 */
	public static long String_to_long(String s) {
		return Long.parseLong(s);
	}
}
