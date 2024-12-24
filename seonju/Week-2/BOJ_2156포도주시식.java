import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
* 6 10 13 9 8 1
* o o x  dp[i] = dp[i-1]
* x o o  dp[i] = dp[i-3] + cups[i-1] + cups[i]
* o x o  dp[i] = dp[i-2] + cups[i]
* 세 경우 중 가장 큰 값을 dp[i]에 저장
* */
public class BOJ_2156포도주시식 {
    static int n;   // 포도주 잔의 개수
    static int[] cups, dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        cups = new int[n + 1];
        dp = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            cups[i] = Integer.parseInt(br.readLine());
        }

        dp[1] = cups[1];
        if (n > 1) {   // 잔이 두개 이상일 경우
            dp[2] = cups[1] + cups[2];
        }

        for (int i = 3; i < n + 1; i++) {
            dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 2] + cups[i], dp[i - 3] + cups[i - 1] + cups[i]));
        }

        System.out.println(dp[n]);
    }
}
