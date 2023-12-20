class Solution {
    fun lengthOfLongestSubstring(s: String): Int {
        var start = 0
        var maxLen = 0
        val set = mutableSetOf<Char>()
        for (end in s.indices) {
            while (set.contains(s[end])) {
                set.remove(s[start])
                start++
            }
            set.add(s[end])
            val len = end - start + 1
            if (maxLen < len) {
                maxLen = len
            }
        }
        return maxLen
    }
}