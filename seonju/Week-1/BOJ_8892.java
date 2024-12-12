import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//BOJ_8892 팰린드롬
public class BOJ_8892 {
    static int k;
    static String[] words;
    static boolean[] visited;
    static boolean isPossible;
    static String palindrome;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            k = Integer.parseInt(br.readLine());    // 단어의 수
            words = new String[k];
            visited = new boolean[k];
            palindrome = null;
            isPossible = false;

            for (int i = 0; i < k; i++) {
                words[i] = br.readLine();
            }

            perm(0, new StringBuilder());

            System.out.println(isPossible ? palindrome : 0);
        }
    }

    public static void perm(int depth, StringBuilder sb) {
        if (depth == 2) {
            check(sb);
            return;
        }

        for (int i = 0; i < k; i++) {
            if (!visited[i]) {
                visited[i] = true;
                int end = sb.length();
                perm(depth + 1, sb.append(words[i]));
                visited[i] = false;
                sb.delete(end, sb.length());    // 다시 삭제
            }
        }
    }

    public static boolean check(StringBuilder sb) {
        String s = sb.toString();
        int len = s.length();
        for (int i = 0; i < len / 2; i++) {
            if (s.charAt(i) != s.charAt(len - 1 - i)) {
                return false;
            }
        }
        palindrome = s;
        isPossible = true;
        return true;
    }
}
