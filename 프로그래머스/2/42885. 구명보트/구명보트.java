import java.util.Arrays;

class Solution {
    public int solution(int[] people, int limit) {
        Arrays.sort(people);
        int answer = 0;
        int l = 0;
        int r = people.length - 1;
        
        while (l <= r) {
            int p1 = people[l];
            int p2 = people[r];
            
            if (p1 + p2 <= limit) {
                l++;
                r--;
            } else {
                r--;
            }
            answer++;
        }
        
        return answer;
    }
}