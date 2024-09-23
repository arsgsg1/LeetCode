class Solution {
    public int answer = Integer.MAX_VALUE;
    public int walletHeight;
    public int walletWidth;
    public void recur(int height, int width, int count) {
        // 그냥 넣을 수 있다면 넣어본다
        if (height <= walletHeight && width <= walletWidth) {
            answer = Math.min(answer, count);
            return;
        }
        if (width <= walletHeight && height <= walletWidth) {
            answer = Math.min(answer, count);
            return;
        }
        // 길이가 긴 쪽을 반으로 접는다
        if (height > width) {
            recur(height / 2, width, count + 1);
        } else {
            recur(height, width / 2, count + 1);
        }
    }
    public int solution(int[] wallet, int[] bill) {
        walletWidth = wallet[0];
        walletHeight = wallet[1];
        recur(bill[1], bill[0], 0);
        return answer;
    }
}