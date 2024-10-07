import java.util.*;
import java.util.stream.*;
class Solution {
    static int ROW = 0;
    static int COL = 0;
    static Map<Integer, Integer> map = new HashMap<>();
    public int[][] dirs = { {0, 1}, {0, -1}, {1, 0}, {-1, 0} };
    public boolean inRange(int row, int col) {
        return 0 <= row && row < ROW && 0 <= col && col < COL;
    }
    public int bfs(int[][] land, int[][] visited, int row, int col, int index) {
        Queue<int[]> q = new ArrayDeque<>();
        int oilCount = 1;
        q.add(new int[]{ row, col });
        visited[row][col] = index;
        while(!q.isEmpty()) {
            int t[] = q.poll();
            int r = t[0];
            int c = t[1];
            for (int[] dir : dirs) {
                int nr = r + dir[0];
                int nc = c + dir[1];
                if (!inRange(nr, nc)) continue;
                if (visited[nr][nc] == 0 && land[nr][nc] == 1) {
                    visited[nr][nc] = index;
                    oilCount++;
                    q.add(new int[] { nr, nc });
                }
            }
        }
        return oilCount;
    }
    public int solution(int[][] land) {
        int answer = 0;
        ROW = land.length;
        COL = land[0].length;
        int[][] visited = new int[ROW][COL];
        int index = 1;
        for (int i = 0; i < ROW; i++) Arrays.fill(visited[i], 0);
        map.put(0, 0);
        for (int i = 0; i < ROW; i++){ 
            for (int j = 0; j < COL; j++) {
                if (visited[i][j] == 0 && land[i][j] == 1) {
                    int oilCount = bfs(land, visited, i, j, index);
                    map.put(index, oilCount);
                    index++;
                }
            }
        }
        for (int c = 0; c < COL; c++) {
            Set<Integer> set = new HashSet<>();
            int sum = 0;
            for (int r = 0; r < ROW; r++) {
                set.add(visited[r][c]);
            }
            for (Integer item: set) {
                sum += map.get(item);
            }
            answer = Math.max(answer, sum);
        }
        return answer;
    }
}