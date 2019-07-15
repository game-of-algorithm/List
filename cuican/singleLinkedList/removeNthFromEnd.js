var removeNthFromEnd = function(head, n) {
    if (!head) {
        return head
    }
    if (!head.next) {
        return null
    }
    let i = 1
    const a = []
    let currentNode = head
    a.push(currentNode)
    while(currentNode.next) {
        currentNode = currentNode.next
        a.push(currentNode)
        i++
    }
    const deleteNode = a[i - n]
    if (i-n-1 >= 0) {
        a[i-n-1].next = deleteNode.next
        deleteNode.next = null
        return head
    } else {
        const result = head.next
        head.next = null
        return result
    }
};

