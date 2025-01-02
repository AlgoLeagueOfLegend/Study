import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BOJ_1796 {
    static int ans;
    static ArrayList<Integer>[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        ans = Integer.MAX_VALUE;
        list = new ArrayList[26];   // 알파벳 별 저장
        for (int i = 0; i < 26; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            list[c - 'a'].add(i);   // 위치 추가
        }

        dfs(0, 0, 0);
        System.out.println(ans + s.length());   // 결과 + 엔터 횟수
    }

    public static void dfs(int alphabet, int cursor, int count) {
        if (alphabet == 26) {
            if (ans > count) ans = count;
            return;
        }

        if (list[alphabet].isEmpty()) {   // 알파벳 없을 때
            dfs(alphabet + 1, cursor, count);  // 다음으로 이동
        } else {
            int first_loc = list[alphabet].get(0);  // 처음 위치
            int last_loc = list[alphabet].get(list[alphabet].size() - 1);   // 마지막 위치

            if (first_loc != last_loc) {    // 처음과 마지막 위치 다를 때(두개 이상 들어있음)
                int first = Math.abs(cursor - first_loc);
                int last = Math.abs(cursor - last_loc);

                if (cursor > first_loc && cursor < last_loc) {    // cursor가 first와 last 사이에 있음
                    int c = count + first * 2 + last;   // first부터 -> first 갔다가 돌아옴
                    dfs(alphabet + 1, last_loc, c);

                    c = count + first + last * 2;   // last부터 -> last 갔다가 돌아옴
                    dfs(alphabet + 1, first_loc, c);
                } else {  // 범위 벗어나 있을 때
                    if (first < last) { // 첫 번째 위치가 더 가까울 때
                        count += last;
                        cursor = last_loc;

                    } else {    // 마지막 위치가 더 가까울 때
                        count += first;
                        cursor = first_loc;
                    }

                    dfs(alphabet + 1, cursor, count);
                }
            } else {  // 하나만 들어있음
                count += Math.abs(cursor - first_loc);
                cursor = first_loc;
                dfs(alphabet + 1, cursor, count);
            }
        }
    }
}