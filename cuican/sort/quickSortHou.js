const exchange = require('./util')
const _ = require('lodash')

const findTheIndex = (array, low, high) => {
    let i = low
    let j = high
    const z = _.toInteger((high + low) / 2)
    const p = array[z]
    while(true) {
        while(array[i] < p) {
            i++
        }
        while(array[j] > p) {
            j--
        }
        if (i >= j) return j
        exchange(array, i++, j--)
    }
}
const sort = (array, low, high) => {
    if (low < high) {
        const j = findTheIndex(array, low, high)
        sort(array, low, j)
        sort(array, j + 1, high)
    }
}
const quickSort = (array) => {
    if (!array || array.length === 0) return
    sort(array, 0, array.length - 1)
    return array
}
console.log(quickSort([3,6,8,2,1]))
