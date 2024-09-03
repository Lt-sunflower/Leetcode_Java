package leetcode.problems.grind75;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import leetcode.problems.Problem;

public class Q542_01Matrix implements Problem {

		/**
		 * Given an m x n binary matrix mat, return the distance of the nearest 0 for each cell.
		 * The distance between two adjacent cells is 1.
		 **/

		private int[][] mat;

		public Q542_01Matrix(){
				this.mat = new int[][] {{0,0,0},{0,1,0},{1,1,1}};
		}

		Queue<int[]> queue = new LinkedList<>();
		private int[][] solve(){

				// BFS, so assign -1 to all non-zero spots
				// set 4dir of 0 to 1, push into queue
				// set 4dir of 1 to 2, and so one...

				for (int i=0; i<mat.length; i++)
				{
						for (int j=0; j<mat[0].length; j++)
						{
								if (mat[i][j] == 0) queue.add(new int[] {i,j});
								else mat[i][j] = -1;
						}
				}


				while(queue.peek() != null){
						int[] spot = queue.poll();
						int n = spot[0];
						int m = spot[1];
						int val = mat[n][m]+1;

						updateVal(mat, n-1, m, val);
						updateVal(mat, n+1, m, val);
						updateVal(mat, n, m-1, val);
						updateVal(mat, n, m+1, val);
				}

				return mat;
		}

		private void updateVal(int[][] mat, int n, int m, int val){
				if (n<0 || m<0 || n>=mat.length || m>=mat[0].length || mat[n][m] == 0) return;
				// dont need "|| val < mat[n][m]" cos BFS
				if (mat[n][m] == -1 || val < mat[n][m]) {
						mat[n][m] = val;
						queue.add(new int[] {n,m});
				}
		}

		private int findDist(int[][] mat, int i, int j){
				if (i<0 || j<0 || i>= mat.length || j>= mat[0].length) return -1;
				if (mat[i][j] == 0) return 0;

				// this will cause infinite loop, since exit condition is value==0
				int up = findDist(mat, i-1, j);
				int down = findDist(mat, i+1, j);
				int left = findDist(mat, i, j-1);
				int right = findDist(mat, i, j+1);

				int[] array = new int[] {up,down,left,right};
				int smallest = Integer.MAX_VALUE; // max dist is m+n
				for (int a:array){
						if (a == -1) continue;
						else if (a<smallest) smallest = a;
				}
				return smallest+1;
		}

		private int[][] solve(boolean t) {
				// iterate twice, top left, then btm right

				for (int n=0; n<mat.length; n++)
				{
						for (int m=0; m<mat[0].length; m++)
						{
								if (mat[n][m] == 0) continue;
								else {
										int top = Integer.MAX_VALUE -1000;
										int left = Integer.MAX_VALUE -1000;
										if (n-1>=0) top = mat[n-1][m];
										if (m-1>=0) left = mat[n][m-1];

										mat[n][m] = Math.min(top,left)+1;
								}
						}
				}
				for (int n= mat.length-1; n>=0;n--)
				{
						for (int m=mat[0].length-1; m>=0; m--)
						{
								if (mat[n][m] == 0) continue;
								else {
										int btm = Integer.MAX_VALUE -1000;
										int right = Integer.MAX_VALUE -1000;
										if (n+1<mat.length) btm = mat[n+1][m];
										if (m+1<mat[0].length) right = mat[n][m+1];

										mat[n][m] = Math.min(mat[n][m], Math.min(btm,right)+1);
								}
						}
				}
				return mat;
		}

		@Override
		public void printAnswer() {
				System.out.println("Inputs: " + Arrays.deepToString(mat));
				System.out.println("Answer: " + Arrays.deepToString(solve(true)));
		}
}
