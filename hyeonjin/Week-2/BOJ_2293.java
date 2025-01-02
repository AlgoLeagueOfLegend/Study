import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2293 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int[] dp = new int[k + 1];
		for (int i = 0; i < n; i++) {
			int coin = Integer.parseInt(br.readLine());
			// 각 금액을 만들 수 있는 경우의 수 누적
			for (int j = coin; j <= k; j++) {
				if (coin == j) {
					dp[j]++;
				} else {
					dp[j] += dp[j - coin];
				}
			}
		}
		System.out.println(dp[k]);
	}
}
