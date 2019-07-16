const print = require('./print')
const sortList = function(head) {
    if (!head || !head.next) {
        return head
    }
    let slow = head
    let fast = head.next
    while (fast !== null && fast.next !== null) {
        slow = slow.next
        fast = fast.next.next
    }
    console.log(slow)
    const right = sortList(slow.next)
    slow.next = null
    const left = sortList(head)
    return mergeBetter(left, right)

};
const merge = (first, second, result) => {
    if(!first || !second) {
        return first || second
    }
    if (first.val >= second.val) {
        result.next = second
        if (!second.next) {
            result.next.next = first
            return result
        }
        merge(first, second.next, result.next)
    } else {
        result.next = first
        if (!first.next) {
            result.next.next = second
            return result
        }
        merge(second, first.next, result.next)
    }
    return result
}
const mergeBetter = (first, second) => {
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
const head = {
    val: 9,
    next: {
        val: 3,
        next: {
            val: 2,
            next: {
                val: 8,
                next: {
                    val: 1,
                    next: {
                        val: 10,
                        next: {
                            val: 11,
                            next: null
                        }
                    }
                }
            }
        }
    }
}
const head1 = {
    val: 2,
    next: {
        val: 4,
        next: {
            val: 7,
            next: {
                val: 9,
                next: {
                    val: 10,
                    next: {
                        val: 12,
                        next: {
                            val: 14,
                            next: null
                        }
                    }
                }
            }
        }
    }
}
// console.log(print(mergeBetter(head, head1)))
console.log(print(sortList(head)))
