package leetcode.utils;

public class ArrayUtils {

		public static void print2DArray(int[][] array) {
				for (int i = 0; i < array.length; i++) {
						System.out.print("[");
						for (int j = 0; j < array[i].length; j++) {
								System.out.print(array[i][j]);
								if (j < array[i].length - 1) {
										System.out.print(", ");
								}
						}
						System.out.print("]");
						if (i < array.length - 1) {
								System.out.println();
						}
				}
				System.out.println();
		}

}
