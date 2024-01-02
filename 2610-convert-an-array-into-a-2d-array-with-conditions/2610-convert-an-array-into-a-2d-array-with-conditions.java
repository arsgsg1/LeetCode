import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        Arrays.stream(nums).forEach(item -> map.put(item, map.getOrDefault(item, 0) + 1)); // n
        List<List<Integer>> ans = new LinkedList<>();
        while (map.size() > 0) { // n
            List<Integer> list = new LinkedList<>();
            list.addAll(map.keySet()); // n
            for (Integer key : list) { // n
                map.put(key, map.get(key) - 1);
                if (map.get(key) == 0) {
                    map.remove(key);
                }
            }
            ans.add(list);
        }
        return ans;
    }
}