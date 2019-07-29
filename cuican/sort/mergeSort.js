const sort = (array) => {
    for (let i = 1; i < array.length; i = i + i) {
        for (let j = 0; j < array.length - i; j += i + i) {
            merge(array, j, i+j-1, j+i+i-1)
        }
    }
}
const copyArray = []
const merge = (array, lo, mid, hi) => {
    for (let k = lo; k <= hi; k++) {
        copyArray[k] = array[k]
    }
    let j = mid + 1
    let i = lo
    for (let k = lo; k <=hi; k++) {
        if (i > mid) {
            array[k] = copyArray[j]
            j++
            continue
        }
        if (j > hi) {
            array[k] = copyArray[i]
            i++
            continue
        }
        if (copyArray[j] < copyArray[i]) {
            array[k] = copyArray[j]
            j++
        } else {
            array[k] = copyArray[i]
            i++
        }
    }
}
