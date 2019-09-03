import java.util.*

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
    val reverseList = ReverseNodeList().reverseList3(head)
    printNode(reverseList)
}

class ReverseNodeList{

    fun reverseList(head: ListNode?): ListNode? {
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

    fun reverseList1(head: ListNode?): ListNode? {
        if(head?.next == null)return head
        var oldNode = head.next
        head.next = null
        var newNode = head
        while (oldNode != null){
            val tempNode = oldNode.next
            oldNode.next = newNode
            newNode = oldNode
            oldNode =tempNode
        }
        return newNode
    }

    fun reverseList2(head: ListNode?): ListNode? {
        if(head?.next == null)return head
        val stack = Stack<ListNode>()
        var tempNode = head.next
        head.next = null
        stack.push(head)
        var lastNode:ListNode? = null
        while (tempNode != null){
            lastNode = tempNode
            tempNode = tempNode.next
            lastNode.next = stack.peek()
            stack.push(lastNode)
        }

        return stack.pop()
    }

    fun reverseList3(head: ListNode?): ListNode? {
        if(head?.next == null)return head
        val pair = innerReverseList(head)
        head.next = null
        return pair.first
    }

    private fun innerReverseList(head: ListNode):Pair<ListNode,ListNode>{
        if(head.next == null)return Pair(head,head)
        val pair = innerReverseList(head.next!!)
        pair.second.next = head
        return Pair(pair.first,head)
    }
}