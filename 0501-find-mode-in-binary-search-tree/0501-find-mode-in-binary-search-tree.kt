/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
class Solution {
    var map: MutableMap<Int, Int> = mutableMapOf()
    fun find(curNode: TreeNode?) {
        curNode ?: return
        curNode.let { node -> map[node.`val`] = map[node.`val`]?.let { it + 1 } ?: 0 }
        find(curNode.left)
        find(curNode.right)
    }
    fun findMode(root: TreeNode?): IntArray {
        find(root)
        val maxMode = map.values.max()
        val result: List<Int> = map.filter { entry -> entry.value >= maxMode }.map { it.key }
        return result.toIntArray()
    }
}