import java.lang.StringBuilder

fun main(args: Array<String>) {

    val head = ListNode(1).apply {
        next = ListNode(1).apply {
            next = ListNode(4).apply {
                next = ListNode(2).apply {
                    next = ListNode(-1).apply {
                        next = ListNode(-3).apply {
                            next = ListNode(4).apply {
                                next = ListNode(2)
                            }
                        }
                    }
                }
            }
        }
    }
    var sortHead:ListNode? = SortNodeList().sortList(head)

    printNode(sortHead)
}

fun printNode(sortHead: ListNode?) {
    var sortHead1 = sortHead
    val builder = StringBuilder()
    while (sortHead1 != null) {
        builder.append(sortHead1.`val`).append("  ")
        sortHead1 = sortHead1.next
    }

    print(builder.toString())
}

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

class SortNodeList {

    fun sortList(head: ListNode?):ListNode?{

        if(head?.next == null)return head
            var oneStepNode = head!!
            var twoStepNode = head.next!!.next
            while (twoStepNode != null) {
                oneStepNode = oneStepNode.next!!
                twoStepNode = twoStepNode.next?.next
            }
            var rightNode:ListNode? = oneStepNode.next
            oneStepNode.next = null
            var leftNode = sortList(head)
            rightNode = sortList(rightNode!!)
            var currentNode:ListNode? = if(leftNode!!.`val` > rightNode!!.`val`){
                val tempNode = rightNode
                rightNode = leftNode
                leftNode = tempNode
                tempNode
            }else{
                leftNode
            }
            while (currentNode != null && rightNode != null){
                if(rightNode.`val` >= currentNode.`val` && (currentNode.next != null && rightNode.`val` < currentNode.next!!.`val`)){
                    val tempNode = currentNode.next
                    currentNode.next = rightNode
                    rightNode = rightNode.next
                    currentNode.next!!.next = tempNode
                }
                if(currentNode.next == null){
                    currentNode.next = rightNode
                    rightNode = null
                }else{
                    currentNode = currentNode.next
                }
            }

            return leftNode
    }
}

