import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class BOJ_11048이동하기 {
    static int N, M;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N + 1][M + 1];

        for (int i = 1; i < N + 1; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j < M + 1; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < M + 1; j++) {
                // 대각선은 가로 이동 + 세로 이동과 같으므로 패스
                map[i][j] = Math.max(map[i][j] + map[i - 1][j], map[i][j] + map[i][j - 1]);
            }
        }

        System.out.println(map[N][M]);
    }
}


//public class BOJ_11048이동하기 {
//    static int N, M;
//    static int[][] map, candies;
//    static int[] dx = {1, 0, 1};
//    static int[] dy = {0, 1, 1};
//
//    public static class Info implements Comparable<Info> {
//        int x;
//        int y;
//        int candy;
//
//        public Info(int x, int y, int candy) {
//            this.x = x;
//            this.y = y;
//            this.candy = candy;
//        }
//
//        @Override
//        public int compareTo(Info o) {
//            return o.candy - this.candy;
//        }
//    }
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
//        N = Integer.parseInt(st.nextToken());
//        M = Integer.parseInt(st.nextToken());
//        map = new int[N + 1][M + 1];    // 1,1 부터 이동
//        candies = new int[N + 1][M + 1];    // 사탕 수 저장
//
//        // 입력
//        for (int i = 1; i < N + 1; i++) {
//            st = new StringTokenizer(br.readLine(), " ");
//            for (int j = 1; j < M + 1; j++) {
//                map[i][j] = Integer.parseInt(st.nextToken());
//            }
//        }
//
//        candies[1][1] = map[1][1];
//        bfs();
//
//        System.out.println(candies[N][M]);
//    }
//
//    public static void bfs() {
//        PriorityQueue<Info> pq = new PriorityQueue<>();
//        pq.add(new Info(1, 1, candies[1][1]));
//
//        while (!pq.isEmpty()) {
//            Info info = pq.poll();
//            int x = info.x;
//            int y = info.y;
//            int c = info.candy;
//
//            for (int i = 0; i < 3; i++) {
//                int nx = x + dx[i];
//                int ny = y + dy[i];
//                if (nx < N + 1 && ny < M + 1) {
//                    int nc = c + map[nx][ny];
//                    if (candies[nx][ny] < nc) { // 더 많은 사탕을 가지고 이동할 수 있을 때
//                        candies[nx][ny] = nc;
//
//                        pq.add(new Info(nx, ny, nc));
//                    }
//                }
//            }
//        }
//    }
//}
