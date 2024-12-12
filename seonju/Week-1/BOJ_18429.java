import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

//BOJ_18429 근손실
public class BOJ_18429 {
    // N: 키트 수, K: 감소하는 중량
    static int N, K;
    static int[] weight;
    static boolean[] visited;
    static ArrayList<Integer> order;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        weight = new int[N];
        visited = new boolean[N];
        count = 0;
        order = new ArrayList<>();

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            weight[i] = Integer.parseInt(st.nextToken());
        }

        perm(0);
        System.out.println(count);
    }

    public static void perm(int depth) {
        if (depth == N) {
            check();
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                order.add(i);
                perm(depth + 1);
                visited[i] = false;
                order.remove(order.size() - 1);
            }
        }
    }

    public static void check() {
        int loss = 500; // 처음 중량
        for (int o : order) {
            loss = loss - K + weight[o];
            if (loss < 500) return;
        }
        count++;
    }
}
