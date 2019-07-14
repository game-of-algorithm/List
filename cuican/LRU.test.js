import LRUCache from './LRUCache'
const print = (list) => {
    let i = 0
    let head = list.head
    console.log(head.value)
    while (i < list.size - 1) {
        head = head.nextNode
        console.log(head.value)
        i++
    }
    return head.value.id
}
test('cache add', () => {
    const cache = new LRUCache(3)
    cache.add({ id: 1, value: 'apple'})
    const item = cache.get(1)
    expect(cache.maxLength).toBe(3)
    expect(item.value).toBe('apple')
})
test('cache add max', () => {
    const cache = new LRUCache(3)
    cache.add({ id: 1, value: 'apple'})
    cache.add({ id: 2, value: 'grape'})
    cache.add({ id: 3, value: 'peach'})
    cache.add({ id: 4, value: 'banana'})
    expect(cache.list.size).toBe(3)
    expect(print(cache.list)).toBe(2)
})
