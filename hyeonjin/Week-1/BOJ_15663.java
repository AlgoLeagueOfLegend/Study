import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

public class BOJ_15663 {

	static int N, M;
	static int[] arr, record;
	static boolean[] used;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);

		used = new boolean[N];
		record = new int[M];
		dfs(0);
		System.out.println(sb);
	}

	static void dfs(int depth) {
		if (depth == M) {
			for (int r : record) {
				sb.append(r).append(" ");
			}
            sb.append("\n");
			return;
		}

        int before = -1;
		for (int i = 0; i < N; i++) {
			if (used[i]) continue;

            if (before != arr[i]) {
                used[i] = true;
            	before = arr[i];
			    record[depth] = arr[i];
			    dfs(depth + 1);
			    used[i] = false;
            }
		}
	}
}
