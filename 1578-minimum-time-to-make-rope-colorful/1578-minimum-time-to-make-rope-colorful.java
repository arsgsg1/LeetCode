class Solution {
    public int minCost(String colors, int[] neededTime) {
        int i = 0, j = 0, ans = 0;
        while (i < neededTime.length && j < neededTime.length) {
            int curMax = 0, groupSum = 0;
            // j가 범위 안에 있고, colors[i] == colors[j]이라면
            while (j < neededTime.length && colors.charAt(i) == colors.charAt(j)) {
                // 그룹 내의 최댓값을 구한다
                curMax = Math.max(curMax, neededTime[j]);
                // 그룹의 누적합을 구한다
                groupSum += neededTime[j];
                j++;
            }
            i = j;
            // 가장 비싼걸 제외하고 나머지를 제외시킨다
            ans += groupSum - curMax;
        }

        return ans;
    }
}