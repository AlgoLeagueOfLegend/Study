import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_2992 {
    static int[] arr, result;
    static boolean[] visited;
    static boolean flag;
    static String ans, s;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        s = br.readLine();

        arr = new int[s.length()];
        result = new int[s.length()];
        visited = new boolean[s.length()];
        flag = false;

        for (int i = 0; i < s.length(); i++) {  // 숫자로 변환해서 저장
            arr[i] = s.charAt(i) - '0';
        }

        Arrays.sort(arr);   // 정렬

        search(0);  // 순열

        if (!flag)  // 못찾은 경우
            System.out.println(0);
    }

    private static void search(int idx) {
        if (idx == result.length) { // 순열 완성
            ans = "";
            for (int i = 0; i < result.length; i++) {
                ans += Integer.toString(result[i]);
            }

            if (!flag && Integer.parseInt(ans) > Integer.parseInt(s)) { // 더 큰 수를 찾았을 때
                flag = true;
                System.out.println(ans);
            }
            return;
        }
        // 순열 생성
        for (int i = 0; i < arr.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                result[idx] = arr[i];
                search(idx + 1);
                visited[i] = false;
                if (flag)
                    return;
            }
        }
    }
}
 