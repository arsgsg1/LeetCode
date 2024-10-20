import java.io.*;
import java.util.*;
import java.util.stream.*;
public class Main {
    static int N, M;
    static int answer = Integer.MAX_VALUE;
    public static boolean inRange(int row, int col) {
        return 0 <= row && row < N && 0 <= col && col < M;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int [][] dirs = new int[][]{ {1, -1, 0}, {1, 0, 1}, {1, 1, 2} };
        int[][] arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[][][] board = new int[N][M][3];
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                for (int d = 0; d < 3; d++) {
                    board[r][c][d] = 10_0000;
                }
            }
        }

        Queue<int[]> q = new ArrayDeque<>();
        for (int c = 0; c < M; c++) {
            for (int d = 0; d < 3; d++) {
                board[0][c][d] = arr[0][c];
                q.add(new int[] { 0, c, d });
            }
        }

        while (!q.isEmpty()) {
            int[] t = q.poll();
            int r = t[0];
            int c = t[1];
            int d = t[2];

            for (int[] dir: dirs) {
                int nr = r + dir[0];
                int nc = c + dir[1];
                int nd = dir[2];
                if (!inRange(nr, nc)) continue;
                if (d == nd) continue;
                board[nr][nc][nd] = Math.min(board[r][c][d] + arr[nr][nc], board[nr][nc][nd]);
                q.add(new int[] {nr, nc, nd});
            }
        }
        for (int c = 0; c < M; c++) {
            for (int d = 0; d < 3; d++) {
                answer = Math.min(answer, board[N - 1][c][d]);
            }
        }
        System.out.println(answer);
    }
}