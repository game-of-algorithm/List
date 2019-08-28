const exchange = require('./util')

const sort = (array, lo, hi) => {
    let i = lo
    for (let j = lo; j <= hi; j++) {
        if (array[j] < array[hi]) {
            exchange(array, i, j)
            i++
        }
    }
    exchange(array, i, hi)
    return i
}
const quick = (array, lo, hi) => {
    if (lo < hi) {
        const i = sort(array, lo, hi)
        quick(array, lo, i - 1)
        quick(array, i+1, hi)
    }
}
const quickSort = (array) => {
    if (!array || array.length === 0) return
    quick(array, 0, array.length - 1)
    return array
}

console.log(quickSort([3,6,8,2,1]))
