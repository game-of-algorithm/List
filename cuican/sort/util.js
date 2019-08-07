module.exports = exchange = (array, left, right) => {
    const tmp = array[left]
    array[left] = array[right]
    array[right] = tmp
}
