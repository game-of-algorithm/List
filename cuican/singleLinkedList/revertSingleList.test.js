import revert from './revertSingleList'
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
test('revert single list', () => {
    const result = revert(head)
    expect(print(result)).toBe([1,5,9,3,1,2,4])
})
