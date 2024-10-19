import java.io.*;
import java.util.*;
import java.util.stream.*;
public class Main {
    static int N, M;
    // picked에 prevNum과 다른 수를 길이 M까지 넣는다
    public static void recur(LinkedHashSet<Integer> picked) {
        if (picked.size() == M) {
            System.out.println(picked.stream().map(i -> i.toString()).collect(Collectors.joining(" ")));
            return;
        }
        for (int i = 1; i <= N; i++) {
            if (picked.contains(i)) continue;
            picked.add(i);
            recur(picked);
            picked.remove(i);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        recur(new LinkedHashSet<>());
    }
}