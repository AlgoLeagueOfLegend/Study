import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2294동전2 {
    static int n, k;
    static int[] value, dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        value = new int[n];
        dp = new int[k + 1];
        for (int i = 0; i < n; i++) {
            value[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(value);
        Arrays.fill(dp, Integer.MAX_VALUE - 1); // 최대로 초기화
        // 그냥 Integer.MAX_VALUE로 설정 시 틀림 -> dp 계산하면서 오버플로우 나는 경우 있는 것 같음

        dp[0] = 0;  // 가치 0을 만드는 경우는 없음
        for (int i = 0; i < n; i++) {
            int v = value[i];    // 동전의 가치
            for (int j = 1; j < k + 1; j++) {   // 1 ~ k까지 확인
                if (j >= v) {   // j가 v보다 클 경우 갱신 가능
                    dp[j] = Math.min(dp[j], dp[j - v] + 1); // 현재 dp값과 새로 업데이트할 수 있는 값 비교해서 최소로 갱신
                }
            }
        }

        int result = dp[k] == Integer.MAX_VALUE - 1 ? -1 : dp[k];
        System.out.println(result);
    }
}

