import java.io.*;
import java.util.*;
import java.util.stream.*;
public class Main {
    static int N, M;
    static StringBuilder answer = new StringBuilder();
    public static void recur(int[] arr, List<Integer> picked) {
        if (picked.size() == M) {
            String str = picked.stream().map(i -> i.toString()).collect(Collectors.joining(" "));
            answer.append(str);
            answer.append("\n");
            return;
        }
        for (int i = 0; i < N; i++) {
            picked.add(arr[i]);
            recur(arr, picked);
            picked.remove(picked.size() - 1);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr);
        recur(arr, new ArrayList<>());
        System.out.println(answer);
    }
}