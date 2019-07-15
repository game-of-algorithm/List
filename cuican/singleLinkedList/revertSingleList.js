var reverseList = function(head) {
    if (!head || !head.next) {
        return head
    }
    const result = changePosition(head, head.next)
    head.next = null
    return result
};
var changePosition = function(leftNode, rightNode) {
    const nextRightNode = rightNode.next
    rightNode.next = leftNode
    if (!nextRightNode) {
        return rightNode
    }
    return changePosition(rightNode, nextRightNode)
}
const head = {
    val: 4,
    next: {
        val: 2,
        next: {
            val: 1,
            next: {
                val: 3,
                next: {
                    val: 9,
                    next: {
                        val: 5,
                        next: {
                            val: 1,
                            next: null
                        }
                    }
                }
            }
        }
    }
}
const print = (head) => {
    const array = []
    while (head) {
        array.push(head.val)
        head = head.next
    }
    return array
}
console.log(print(reverseList(head)))
