public class Solution {
	public int splitArray(int[] nums, int m) {
		if (nums == null || nums.length == 0)
			return 0;
		int[] sums = new int[nums.length + 1];
		sums[0] = 0;
		for (int i = 1; i <= nums.length; i++) {
			sums[i] = sums[i - 1] + nums[i - 1];
		}
		int[] dp = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			dp[i] = sums[nums.length] - sums[i];
		}

		// dp[0..n-1,1..n-1,2...n-1,3...n-1,..........,n-1]
		// idea: dp[j,s] is the the result that the subarray from index j to n-1
		// with s splits.
		// thus , dp[i,s+1] = Math.max(dp[j,s],nums[i]+...+nums[j-1])

		for (int level = 1; level < m; level++) {
			for (int i = 0; i < nums.length - level; i++) {
				dp[i] = Integer.MAX_VALUE;
				for (int j = i + 1; j < nums.length; j++) {
					int t = Math.max(sums[j] - sums[i], dp[j]);
					if (t <= dp[i])
						dp[i] = t;
					else
						break;
					// why break? we run until we find the smaller t, and if we
					// continue looping, every int after will be bigger
				}
			}
		}
		return dp[0];
	}
}

//----------------a 2D solution----------// TLE

public class Solution {
	public int splitArray(int[] nums, int m) {
		if (nums == null || nums.length == 0)
			return 0;
		int[][] dp = new int[m][nums.length];
		dp[0][0] = nums[0];
		for (int i = 1; i < nums.length; i++) {
			dp[0][i] = dp[0][i - 1] + nums[i];
		}
		for (int i = 1; i < m; i++) {
			Arrays.fill(dp[i], Integer.MAX_VALUE);
		}

		for (int level = 1; level < m; level++) {

			for (int i = level - 1; i < nums.length - 1; i++) {
				for (int j = i + 1; j < nums.length; j++) {
					// System.out.println("level is" + level);
					// System.out.println("i is " + i + " , j is " + j);
					int t = Math.max(dp[0][j] - dp[0][i], dp[level - 1][i]);
					// System.out.println("dp["+level+"]["+j+"] is
					// "+dp[level][j]+", t is " + t);
					if (t <= dp[level][j])
						dp[level][j] = t;
				}
			}
		}
		return dp[m - 1][nums.length - 1];
	}
}