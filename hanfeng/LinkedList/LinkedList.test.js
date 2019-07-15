import LinkedList from './LinkedList'

test('init LinkedList', () => {
  let testLinkedList = new LinkedList()
  expect(testLinkedList.head).toBe(null)
})

test('LinkedList addToTail one node', () => {
  let testLinkedList = new LinkedList()
  testLinkedList.addToTail(1)

  expect(testLinkedList.head.value).toBe(1)
  expect(testLinkedList.head.next).toBe(null)
})

test('LinkedList addToTail two node', () => {
  let testLinkedList = new LinkedList()

  testLinkedList.addToTail(1)
  testLinkedList.addToTail(2)

  expect(testLinkedList.head.value).toBe(1)
  expect(testLinkedList.head.next).not.toBeNull()

  expect(testLinkedList.head.next.value).toBe(2)
  expect(testLinkedList.head.next.next).toBeNull()
})

test('reversal null linkedList', () => {
  let testLinkedList = new LinkedList()

  testLinkedList.reversal()

  expect(testLinkedList.head).toBeNull()
})

test('reversal one node linkedList', () => {
  let testLinkedList = new LinkedList()

  testLinkedList.addToTail(1)

  testLinkedList.reversal()

  expect(testLinkedList.head.value).toBe(1)
  expect(testLinkedList.head.next).toBeNull()
})

test('reversal two node linkedList', () => {
  let testLinkedList = new LinkedList()

  testLinkedList.addToTail(1)
  testLinkedList.addToTail(2)

  testLinkedList.reversal()

  expect(testLinkedList.head.value).toBe(2)
  expect(testLinkedList.head.next.value).toBe(1)
  expect(testLinkedList.head.next.next).toBeNull()
})

test('reversal three node linkedList', () => {
  let testLinkedList = new LinkedList()

  testLinkedList.addToTail(1)
  testLinkedList.addToTail(2)
  testLinkedList.addToTail(3)

  testLinkedList.reversal()

  expect(testLinkedList.head.value).toBe(3)
  expect(testLinkedList.head.next.value).toBe(2)
  expect(testLinkedList.head.next.next.value).toBe(1)
  expect(testLinkedList.head.next.next.next).toBeNull()
})

test('add one node to tail after reversal two node linkedList', () => {
  let testLinkedList = new LinkedList()

  testLinkedList.addToTail(1)
  testLinkedList.addToTail(2)

  testLinkedList.reversal()

  testLinkedList.addToTail(3)

  expect(testLinkedList.head.value).toBe(2)
  expect(testLinkedList.head.next.value).toBe(1)
  expect(testLinkedList.head.next.next.value).toBe(3)
  expect(testLinkedList.head.next.next.next).toBeNull()
})
