const swap = (array, i, j) => {
  let temp = array[i]
  array[i] = array[j]
  array[j] = temp
}

export default class ArraySortHelper {
  static selectionSort (array) {
    if (array === null || array === undefined || array.length <= 1) {
      return
    }
    for (let i = 0; i < array.length; i++) {
      let minIndex = i
      for (let j = i + 1; j < array.length; j++) {
        if (array[minIndex] > array[j]) {
          minIndex = j
        }
      }
      swap(array, i, minIndex)
    }
  }

  static insertionSort (array) {
    if (array === null || array === undefined || array.length <= 1) {
      return
    }
    for (let i = 1; i < array.length; i++) {
      let current = array[i]
      let j = i - 1
      while (j >= 0 && array[j] > current) {
        array[j + 1] = array[j]
        j--
      }
      array[j + 1] = current
    }
  }

  static shellSort (array) {
    if (array === null || array === undefined || array.length <= 1) {
      return
    }
    for (let gap = array.length >> 1; gap > 0; gap = gap >> 1 ) {
      for (let i = gap; i < array.length; i++) {
        let current = array[i]
        let j = i - gap
        while (j >= 0 && array[j] > current) {
          array[j + gap] = array[j]
          j -= gap
        }
        array[j + gap] = current
      }
    }
  }
}


