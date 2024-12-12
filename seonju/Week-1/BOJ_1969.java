import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

// BOJ_1969 DNA
public class BOJ_1969 {
    static int N, M;
    static ArrayList<String> list;
    static int[] cal;
    static String result;
    static int max_count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        list = new ArrayList<>();
        cal = new int[N];
        result = "";

        for (int i = 0; i < N; i++) {
            list.add(br.readLine());
        }

        calculate();
        System.out.println(result);

        calCount();
        System.out.println(max_count);

    }

    public static void calculate() {
        for (int i = 0; i < M; i++) {   // 길이만큼 비교
            int[] alphabets = new int[4];
            for (int j = 0; j < N; j++) {   // 문자 수 비교
                String s = list.get(j);
                char c = s.charAt(i);
                switch (c) {
                    case 'A':
                        alphabets[0]++;
                        break;
                    case 'C':
                        alphabets[1]++;
                        break;
                    case 'G':
                        alphabets[2]++;
                        break;
                    case 'T':
                        alphabets[3]++;
                        break;
                }
            }
            findMax(alphabets);
        }
    }

    public static void findMax(int[] alphabets) {
        int max = alphabets[0];
        int max_idx = 0;
        for (int i = 1; i < 4; i++) {
            if (alphabets[i] > max) {
                max = alphabets[i];
                max_idx = i;
            }
        }
        switch (max_idx) {
            case 0:
                result += 'A';
                break;
            case 1:
                result += 'C';
                break;
            case 2:
                result += 'G';
                break;
            case 3:
                result += 'T';
                break;
        }
    }
    public static void calCount() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                String s = list.get(i);
                if (s.charAt(j) != result.charAt(j)) {
                    max_count++;
                }
            }
        }
    }
}
