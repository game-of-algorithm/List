fun main() {
    val head = ListNode(1).apply {
        next = ListNode(2).apply {
            next = ListNode(3).apply {
                next = ListNode(4).apply {
                    next = ListNode(5).apply {
                        next = ListNode(6).apply {
                            next = ListNode(7).apply {
                                next = ListNode(8)
                            }
                        }
                    }
                }
            }
        }
    }
    val reverseList = Solution1().reverseKGroup(head,3)
    printNode(reverseList)
}

class Solution1 {
    fun reverseKGroup(head: ListNode?, k: Int): ListNode? {
        var tempNode = head
        var count = 1
        while (tempNode?.next != null && count < k){
            count++
            tempNode = tempNode.next
        }
        return if(count == k && k > 1){
            val kGroup = reverseKGroup(tempNode?.next, k)
            tempNode?.next = null
            val reverseNode = reverseList(head)
            head?.next = kGroup
            reverseNode
        }else{
            head
        }
    }

    private fun reverseList(head: ListNode?): ListNode? {
        if(head?.next == null)return head
        val node = reverseList(head.next)
        head.next = null
        var tempNode = node
        while (tempNode!!.next != null){
            tempNode = tempNode.next
        }
        tempNode.next = head

        return node
    }
}