class Solution {
    public int numberOfBeams(String[] bank) {
        List<Integer> list = new LinkedList<>();
        for (String str : bank) { // n
            int cnt = 0;
            for (int i = 0; i < str.length(); i++) { // n
                if (str.charAt(i) == '1') {
                    cnt++;
                }
            }
            if (cnt > 0) {
                list.add(cnt);
            }
        }
        int ans = 0;
        for (int i = 0; i < list.size() - 1; i++){
            ans += list.get(i) * list.get(i + 1);
        }
        return ans;
    }
}