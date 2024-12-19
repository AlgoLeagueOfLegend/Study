import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BOJ_2294 {

	static final int INF = 1_000_000_000;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		// 중복된 동전 거르기
		HashSet<Integer> coinSet = new HashSet<>();
		for (int i = 0; i < n; i++) {
			coinSet.add(Integer.parseInt(br.readLine()));
		}
		
		int idx = 0;
		int[] coins = new int[coinSet.size()];
		for (int coin : coinSet) {
			coins[idx++] = coin;
		}
		Arrays.sort(coins);
		
		int[] dp = new int[k + 1];
		Arrays.fill(dp, INF);

		idx = 0;
		// 최소 금액의 동전 이전 금액은 만들 수 없으므로 coins[0]부터 시작
		for (int i = coins[0]; i <= k; i++) {
			// 현재 금액의 동전을 가지고 있는 경우
			if (idx < coins.length && i == coins[idx]) {
				dp[i] = 1;
				idx++;
			} 
			// 가능한 동전들로 필요한 최소 동전의 개수 구하기
			else {
				for (int j = 0; j < idx; j++) {
					dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
				}
			}
		}
		System.out.println(dp[k] == INF? -1 : dp[k]);
	}
}
