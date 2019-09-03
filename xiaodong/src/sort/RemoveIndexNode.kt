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
    val reverseList = Solution().removeNthFromEnd2(head,8)
    printNode(reverseList)
}


class Solution {
    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        val pair = innerRemove(head, n)
        return pair.first
    }

    private fun innerRemove(head: ListNode?,n: Int):Pair<ListNode?,Int>{
        if(head == null)return Pair(head,1)
        val pair = innerRemove(head.next,n)
        return if(n == pair.second){
            Pair(pair.first,pair.second+1)
        }else{
            head.next = pair.first
            Pair(head,pair.second+1)
        }
    }

    fun removeNthFromEnd1(head: ListNode?, n: Int): ListNode? {
        if(head == null)return null

        var step = n

        var firstNode:ListNode? = head
        var secondNode:ListNode? = head
        while (step > 0){
            step--
            firstNode = firstNode!!.next
        }

        while (firstNode?.next != null){
            firstNode = firstNode.next
            secondNode = secondNode!!.next
        }
        return if(head == secondNode && firstNode == null){
            secondNode.next
        }else{
            secondNode!!.next = secondNode.next!!.next
            head
        }

    }
    fun removeNthFromEnd2(head: ListNode?, n: Int): ListNode? {
        val tempHead = ListNode(-1)
        tempHead.next = head
        var step = n
        var firstNode:ListNode? = tempHead
        var secondNode:ListNode? = tempHead
        while (step > 0){
            step--
            firstNode = firstNode!!.next
        }

        while (firstNode?.next != null){
            firstNode = firstNode.next
            secondNode = secondNode!!.next
        }

        secondNode?.next = secondNode?.next?.next
        return tempHead.next

    }

}