class Solution {
    var answer = 0
    fun find(curNode: TreeNode?): Pair<Int, Int> {
        curNode ?: return 0 to 0
        var curVal = curNode.`val`
        val (leftSum, leftTotalCount) = find(curNode.left)
        val (rightSum, rightTotalCount) = find(curNode.right)
        val curAvg: Int = (curVal + leftSum + rightSum) / (leftTotalCount + rightTotalCount + 1)
        if (curAvg == curVal) {
            answer++
        }
        return curVal + leftSum + rightSum to leftTotalCount + rightTotalCount + 1
    }
    fun averageOfSubtree(root: TreeNode?): Int {
        find(root)
        return answer
    }
}