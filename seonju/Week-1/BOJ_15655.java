import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// BOJ_15655 N과 M (6)
public class BOJ_15655 {

    static StringBuilder sb;
    static int N, M;
    static int[] arr;
    static int[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        result = new int[M];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i=0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        perm(0, 0);
        System.out.println(sb);
    }

    public static void perm(int idx, int start) {
        if (idx >= M) {
            for (int i = 0 ; i<M; i++) {
                sb.append(result[i] + " ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i<N; i++) {
            result[idx] = arr[i];
            perm(idx+1, i+1);
        }
    }
}