import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine().trim());
        int[] arr = Arrays.stream(br.readLine().trim().split(" "))
                .mapToInt(Integer::parseInt)
                .sorted()
                .toArray();
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num: arr) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        long answer = 0;

        // 투 포인터를 이용하기 위해 두 개는 제외한다
        for (int i = 0; i < n - 2; i++) {
            int st = i + 1, en = arr.length - 1;
            while (st < en) {
                int sum = arr[i] + arr[st] + arr[en];
                if (sum > 0) {
                    en--; // 합계를 줄이기 위해 오른쪽 포인터 이동
                } else if (sum < 0) {
                    st++; // 합계를 늘리기 위해 왼쪽 포인터 이동
                } else {
                    if (arr[st] == arr[en]) {
                        answer += en - st;
                    } else {
                        answer += freq.get(arr[en]);
                    }
                    st++;
                }
            }
        }

        System.out.println(answer);
    }
}