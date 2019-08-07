const sort = (head) => {
    if (!head || !head.next) {
        return head
    }

    while(head) {
        merge(head, head.next.next)
        head = head.next.next.next
    }
    while(head) {
        merge(head, head.next.next.next.next)
        head = head.next.next.next.next.next
    }
}
const merge = (first, second) => {
    const result = {}
    let cur = result
    while(first !== null && second !== null) {
        if (first.val >= second.val) {
            cur.next = second
            second = second.next
        } else {
            cur.next = first
            first = first.next
        }
        cur = cur.next
    }
    cur.next = first === null ? second : first
    return result.next

}
