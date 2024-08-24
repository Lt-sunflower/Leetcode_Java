package leetcode.problems;

import java.util.Arrays;
import leetcode.utils.ArrayUtils;

public class Q733FloodFill implements Problem{

		/**
		 * To perform a flood fill,
		 * consider the starting pixel, plus any pixels connected 4-directionally to the starting pixel
		 * of the same color as the starting pixel, plus any pixels connected 4-directionally to those pixels
		 * (also with the same color), and so on.
		 * Replace the color of all of the aforementioned pixels with color.
		 **/

		private int[][] image;
		private int sr;
		private int sc;
		private int color;

		public Q733FloodFill(){
				this.image = new int[][] { {1,1,1}, {1,1,0}, {1,0,1}};
				this.sr = 1;
				this.sc = 1;
				this.color = 2;
		}

		public Q733FloodFill(int[][] image, int sr, int sc, int color){
				this.image = image;
				this.sr = sr;
				this.sc = sc;
				this.color = color;
		}

		private int[][] solve(){

				fill(image, sr, sc, color, image[sr][sc]);
				return image;
		}

		private void fill(int[][] image, int sr, int sc, int color, int i) {

				if (sr < 0 || sr >= image.length) return;
				if (sc < 0 || sc >= image[0].length) return;
				if (image[sr][sc] != i) return;
				else {
						image[sr][sc] = color;
						fill(image, sr - 1, sc, color, i);
						fill(image, sr + 1, sc, color, i);
						fill(image, sr, sc - 1, color, i);
						fill(image, sr, sc + 1, color, i);
				}
		}

		@Override
		public void printAnswer() {
				System.out.println("Inputs: ");
				ArrayUtils.print2DArray(image);
				System.out.println("Answer: ");
				ArrayUtils.print2DArray(solve());
		}
}
