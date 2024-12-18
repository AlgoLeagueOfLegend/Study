import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15649 {

	static int N, M;
	static int[] nums;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();

	// 중복없이 M개 & 1 2 != 2 1 순서 중요 > 순열
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		nums = new int[M]; // 순열 기록
		visited = new boolean[N + 1];
		dfs(0);
		System.out.println(sb);
	}

	static void dfs(int depth) {
		if (depth == M) {
			for (int num : nums) {
				sb.append(num).append(" ");
			}
			sb.append("\n");
			return;
		}

		for (int i = 1; i <= N; i++) {
			if (visited[i])
				continue;

			visited[i] = true;
			nums[depth] = i;
			dfs(depth + 1);
			visited[i] = false;
		}
	}
}
