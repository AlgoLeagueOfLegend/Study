import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

//BOJ_2503 숫자야구
/*
1. 숫자야구에서 나올 수 있는 모든 경우의 수 생성
2. 질문으로 받은 숫자와 비교해서 스트라이크, 볼 개수 만족하는 경우 답이 될 가능성이 있음
*/
public class BOJ_2503 {
    static class answer {
        String num;
        int strike;
        int ball;

        public answer(String num, int strike, int ball) {
            this.num = num;
            this.strike = strike;
            this.ball = ball;
        }
    }

    static int N;
    static int count;   // 답의 총 개수
    static boolean[] visited;

    static ArrayList<answer> questions; // 민혁의 질문에 대한 결과

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        visited = new boolean[10];  // 1~9
        questions = new ArrayList<>();
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            String num = st.nextToken();
            int strike = Integer.parseInt(st.nextToken());
            int ball = Integer.parseInt(st.nextToken());
            questions.add(new answer(num, strike, ball));
        }

        perm(0, "");
        System.out.println(count);
    }

    public static void perm(int depth, String num) {
        if (depth == 3) {
            check(num);
            return;
        }

        for (int i = 1; i < 10; i++) {
            if (!visited[i]) {
                visited[i] = true;
                perm(depth + 1, num + i);
                visited[i] = false;
            }
        }
    }

    public static void check(String num) {
        for (answer ans : questions) {
            int s = 0, b = 0;    // 스트라이크, 볼 개수
            String compare = ans.num;   // 비교대상
            for (int i = 0; i < 3; i++) {
                if (compare.charAt(i) == num.charAt(i)) {   // 같은 자리에 있을 때
                    s++;
                }
            }
            if (s != ans.strike)   // 스트라이크 개수 다를 때 -> 바로 리턴
                return;

            for (int i = 0; i < 3; i++) {
                int idx = (i + 1) % 3;
                if (num.charAt(i) == compare.charAt(idx)) {
                    b++;
                }
                idx = (i + 2) % 3;
                if (num.charAt(i) == compare.charAt(idx)) {
                    b++;
                }
            }
            if (b != ans.ball) return;
        }
        count++;
    }
}
