import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

class Node {
    int row;
    int col;
    public Node(int row, int col) {
        this.row = row;
        this.col = col;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return row == node.row && col == node.col;
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, col);
    }
}
public class Solution {

    public boolean isPathCrossing(String path) {
        int curRow = 0;
        int curCol = 0;
        Set<Node> set = new HashSet<>();
        set.add(new Node(curRow, curCol));
        for(char dir: path.toCharArray()) {
            switch (dir) {
                case 'N':
                    curRow--;
                    break;
                case 'S':
                    curRow++;
                    break;
                case 'E':
                    curCol++;
                    break;
                case 'W':
                    curCol--;
                    break;
            }
            Node newNode = new Node(curRow, curCol);
            if (set.contains(newNode)) {
                return true;
            }
            set.add(newNode);
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isPathCrossing("NESWW"));
    }
}