class Solution {
    int[][] dirs = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    int H = 0;
    int W = 0;
    boolean inRange(int row, int col) {
        return 0 <= row && row < H && 0 <= col && col < W;
    }
    public int solution(String[][] board, int h, int w) {
        H = board.length;
        W = board[0].length;
        int answer = 0;
        String color = board[h][w];
        for (int[] dir: dirs) {
            int dr = dir[0];
            int dc = dir[1];

            int nr = h + dr;
            int nc = w + dc;
            if (!inRange(nr, nc)) continue;
            if (board[nr][nc].equals(color)) {
                answer++;
            }
        }
        return answer;
    }
}