const sort = (array) => {
    let h = 1
    while(h < array.length/3) {
        h = 3*h + 1
    }
    while(h >= 1) {
        for(let i = h; i < array.length; i++) {
            for(let j = i; j >= h && array[j] < array[j -  h]; j -= h) {
                exchange(array, j, j - h)
            }
            h = h / 3
        }
    }
}
const exchange = (array, left, right) => {
    const tmp = array[left]
    array[left] = array[right]
    array[right] = tmp
}
