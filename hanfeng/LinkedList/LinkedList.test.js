import LinkedList from './LinkedList'

test('init LinkedList', () => {
  let testLinkedList = new LinkedList()
  expect(testLinkedList.head).toBe(null)
})

test('LinkedList add one node', () => {
  let testLinkedList = new LinkedList()
  testLinkedList.add(1)

  expect(testLinkedList.head.value).toBe(1)
  expect(testLinkedList.head.next).toBe(null)
})

test('LinkedList add two node', () => {
  let testLinkedList = new LinkedList()

  testLinkedList.add(1)
  testLinkedList.add(2)

  expect(testLinkedList.head.value).toBe(1)
  expect(testLinkedList.head.next).not.toBeNull()

  expect(testLinkedList.head.next.value).toBe(2)
  expect(testLinkedList.head.next.next).toBeNull()
})

test('reversal null linkedList', () => {
  let testLinkedList = new LinkedList()

  let reversalLinkedList = LinkedList.reversal(testLinkedList)

  expect(reversalLinkedList.head).toBeNull()
})

test('reversal two node linkedList', () => {
  let testLinkedList = new LinkedList()

  testLinkedList.add(1)
  testLinkedList.add(2)

  let reversalLinkedList = LinkedList.reversal(testLinkedList)

  expect(reversalLinkedList.head.value).toBe(2)
  expect(reversalLinkedList.head.next.value).toBe(1)
  expect(reversalLinkedList.head.next.next).toBeNull()
})

test('reversal three node linkedList', () => {
  let testLinkedList = new LinkedList()

  testLinkedList.add(1)
  testLinkedList.add(2)
  testLinkedList.add(3)

  let reversalLinkedList = LinkedList.reversal(testLinkedList)

  expect(reversalLinkedList.head.value).toBe(3)
  expect(reversalLinkedList.head.next.value).toBe(2)
  expect(reversalLinkedList.head.next.next.value).toBe(1)
  expect(reversalLinkedList.head.next.next.next).toBeNull()
})
