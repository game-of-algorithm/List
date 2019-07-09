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
