import ArraySortHelper from './ArraySortHelper'

let testArray = []
beforeEach(() => {
  testArray = [2, 1, 8, 4, 0]
})

test('Selection sort', () => {
  ArraySortHelper.selectionSort(testArray)

  expect(testArray[0]).toBe(0)
  expect(testArray[1]).toBe(1)
  expect(testArray[2]).toBe(2)
  expect(testArray[3]).toBe(4)
  expect(testArray[4]).toBe(8)
})

test('Insertion Sort', () => {
  ArraySortHelper.insertionSort(testArray)

  expect(testArray[0]).toBe(0)
  expect(testArray[1]).toBe(1)
  expect(testArray[2]).toBe(2)
  expect(testArray[3]).toBe(4)
  expect(testArray[4]).toBe(8)
})

test('Shell Sort', () => {
  ArraySortHelper.shellSort(testArray)

  expect(testArray[0]).toBe(0)
  expect(testArray[1]).toBe(1)
  expect(testArray[2]).toBe(2)
  expect(testArray[3]).toBe(4)
  expect(testArray[4]).toBe(8)
})
