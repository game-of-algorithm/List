const sort = (array) => {
    for(let i = 0; i < array.length; i++) {
        let minIndex = i
        for (let j = i + 1; j < array.length; j++) {
            if (array[j] < array[minIndex]) {
                minIndex = j
            }
        }
        const tmp = array[i]
        array[i] = array[minIndex]
        array[minIndex] = tmp
    }
    return array
}
console.log(sort([3,2,8,1,5,9]))
