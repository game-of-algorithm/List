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

test('sort null linkedList', () => {
  let testLinkedList = new LinkedList()

  testLinkedList.sort()

  expect(testLinkedList.head).toBeNull()
})

test('remove one node from end when linkedList is null', () => {
  let linkedList = new LinkedList()

  linkedList.removeNthFromEnd(3)

  expect(linkedList.head).toBeNull()
})

test('remove first node from end when linkedList has one node', () => {
  let linkedList = new LinkedList()
  linkedList.addToTail(1)

  linkedList.removeNthFromEnd(1)
  linkedList.addToTail(2)

  expect(linkedList.head.value).toBe(2)
  expect(linkedList.head.next).toBeNull()
})

test('remove first node from end when linkedList has two node', () => {
  let linkedList = new LinkedList()
  linkedList.addToTail(1)
  linkedList.addToTail(2)

  linkedList.removeNthFromEnd(1)
  linkedList.addToTail(3)

  expect(linkedList.head.value).toBe(1)
  expect(linkedList.head.next.value).toBe(3)
  expect(linkedList.head.next.next).toBeNull()
})

test('remove third node from end when linkedList has three node', () => {
  let linkedList = new LinkedList()
  linkedList.addToTail(1)
  linkedList.addToTail(2)
  linkedList.addToTail(3)

  linkedList.removeNthFromEnd(3)
  linkedList.addToTail(4)

  expect(linkedList.head.value).toBe(2)
  expect(linkedList.head.next.value).toBe(3)
  expect(linkedList.head.next.next.value).toBe(4)
  expect(linkedList.head.next.next.next).toBeNull()
})

