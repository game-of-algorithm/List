import minPriorityQueue from './minPriorityQueue'

test('minPriorityQueue is empty', () => {
    let minPQ = new minPriorityQueue()
    expect(minPQ.isEmpty()).toBeTruthy()
})

test('minPriorityQueue size is zero', () => {
    let minPQ = new minPriorityQueue()
    expect(minPQ.size()).toBe(0)
})

test('minPriorityQueue size is zero', () => {
    let minPQ = new minPriorityQueue()
    minPQ.insert(1)
    minPQ.insert(5)
    minPQ.insert(2)
    minPQ.insert(3)
    minPQ.insert(4)
    expect(minPQ.size()).toBe(5)
    expect(minPQ.isEmpty()).toBeFalsy()

    let min = minPQ.delMin()
    expect(min).toBe(1)

    min = minPQ.delMin()
    expect(min).toBe(2)

    min = minPQ.delMin()
    expect(min).toBe(3)

    min = minPQ.delMin()
    expect(min).toBe(4)

    min = minPQ.delMin()
    expect(min).toBe(5)

    expect(minPQ.isEmpty()).toBeTruthy()
})

