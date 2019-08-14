import _ from 'lodash'

const swap = (array, i, j) => {
  let temp = array[i]
  array[i] = array[j]
  array[j] = temp
}

const mergeSortMerge = (array, low, mid, high, tempArray) => {
  let i = low, j = mid + 1, k = 0
  while (i <= mid && j <= high) {
    if (array[i] <= array[j]) {
      tempArray[k++] = array[i++]
    } else {
      tempArray[k++] = array[j++]
    }
  }
  while (i <= mid) {
    tempArray[k++] = array[i++]
  }
  while (j <= high) {
    tempArray[k++] = array[j++]
  }
  while(--k >= 0) {
    array[k+low] = tempArray[k]
  }
}
const mergeSortSort = (array, low, high, tempArray) => {
  if (low < high) {
    let mid = _.floor((low + high) / 2)
    mergeSortSort(array, low, mid, tempArray)
    mergeSortSort(array, mid + 1, high, tempArray)
    mergeSortMerge(array, low, mid, high, tempArray)
  }
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

  static mergeSort (array) {
    if (array === null || array === undefined || array.length <= 1) {
      return
    }
    let tempArray = new Array(array.length)
    mergeSortSort(array, 0, array.length - 1, tempArray)
  }
}


