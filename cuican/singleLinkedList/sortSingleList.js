
var sortList = function(head) {
    if (!head || !head.next) {
        return head
    }
    const list = []
    let i = 0
    while(head) {
        head = res(head, head.next, head)
        list[i] = head
        if (i > 0) {
            list[i - 1].next = head
        }
        i++
        head = head.next
    }
    return list[0]

};
var res = function(head, currentNode, preNode) {
    if (currentNode === null) {
        return head
    }
    if (head.val < currentNode.val) {
        return res(head, currentNode.next, currentNode)
    }
    var stopNode = currentNode.next
    preNode.next = currentNode.next
    currentNode.next = head
    return res(currentNode, stopNode, preNode)
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
    while (head) {
        console.log(head.val)
        head = head.next
    }
}
console.log(print(sortList(head)))
