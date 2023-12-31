class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int answer = 0;
        int curGas = 0, totalGas = 0;
        for (int i = 0; i < gas.length; i++){
            totalGas += gas[i] - cost[i];
            curGas += gas[i] - cost[i];
            if (curGas < 0) {
                curGas = 0;
                answer = i + 1;
            }
        }
        return (totalGas < 0) ? -1 : answer;
    }
}