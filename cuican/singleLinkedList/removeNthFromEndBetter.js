var removeNthFromEnd = function(head, n) {
    if (!head) {
        return head
    }
    if (!head.next) {
        return null
    }
    let i = 0
    let firstIndex = head
    let secondIndex = head
    while(i < n) {
        firstIndex = firstIndex.next
        i++
    }
    if (!firstIndex) {
        return head.next
    }
    while (firstIndex.next) {
        firstIndex = firstIndex.next
        secondIndex = secondIndex.next
    }
    secondIndex.next = secondIndex.next.next
    return head
};
