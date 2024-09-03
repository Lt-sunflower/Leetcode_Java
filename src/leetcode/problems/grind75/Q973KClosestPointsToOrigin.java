package leetcode.problems.grind75;

import java.util.Arrays;
import leetcode.problems.Problem;

public class Q973KClosestPointsToOrigin implements Problem {

		/**
		 * Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane and an integer k,
		 * return the k closest points to the origin (0, 0).
		 **/

		private int[][] points;
		private int k;

		public Q973KClosestPointsToOrigin(){
				this.points = new int[][] {{1,3},{-2,2}};
				this.k = 2;
		}

		private int[][] solve(){

				// sort by x^2+y^2, return first k items
				// p1-p2 = ascending order(small to big)
				// p2-p1 = descending order
				Arrays.sort(points, (p1, p2) -> p1[0] * p1[0] + p1[1] * p1[1] - p2[0] * p2[0] - p2[1] * p2[1]);
				return Arrays.copyOfRange(points, 0, k);
		}

		@Override
		public void printAnswer() {
				System.out.println("Inputs: points="+ Arrays.deepToString(points) +", k="+k);
				System.out.println("Answer: " + Arrays.deepToString(solve()));
		}
}
