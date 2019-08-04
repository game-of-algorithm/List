const sort = (array) => {
    if (array.length <= 1 ) {
        return array
    }
    let i = 0
    while (i < array.length - 2) {
        if (array[0] < array[1]) {
            console.log('====', array[0], array[1])
            exchange(array, 0, 1)
        }
        pushTail(array)
        i++
    }
    console.log('----', array)
    insert(array)
    return array
} // 15 1....5 14....5 1....54 10...54 0....541
const exchange = (array, left, right) => {
    const tmp = array[left]
    array[left] = array[right]
    array[right] = tmp
}
const pushTail = (array) => {
    const tmp = array[0]
    for (let i = 0; i < array.length - 1; i++) {
        array[i] = array[i + 1]
    }
    array[array.length - 1] = tmp
}
const insert = (array) => {
    for(let i = 1; i < array.length; i++) {
        for(let j = i; j > 0; j--) {
            if (array[j] < array[j - 1]) {
                const small = array[j]
                array[j] = array[j - 1]
                array[j - 1] = small
            }
        }
    }
    return array
}
console.log(sort([3,2,1,6,7,8]))
