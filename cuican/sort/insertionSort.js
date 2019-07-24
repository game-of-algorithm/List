const sort = (array) => {
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
console.log(sort([3,2,8,1,5,9]))
