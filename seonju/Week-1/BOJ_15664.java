import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// BOJ_15664 N과 M (10)
public class BOJ_15664 {
    static int N, M;
    static int[] numbers;
    static int[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine(), " ");
        numbers = new int[N];
        result = new int[M];
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(numbers);
        comb(0,0);
    }

    public static void comb(int depth, int start) {
        if (depth == M) {
            for (int num : result) {
                System.out.print(num + " ");
            }
            System.out.println();
            return;
        }

        int prev = -1;
        for (int i = start; i < N; i++) {
            if (numbers[i] != prev) {   // 이전 값과 같지 않을 때만
                result[depth] = numbers[i];
                prev = numbers[i];
                comb(depth + 1, i + 1);
            }
        }
    }
}
