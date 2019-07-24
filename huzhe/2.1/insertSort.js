// 插入排序算法
function insertSort(arr) {
    for(let i = 1; i < arr.length; i++){
        let temp = arr[i];
        let j = i - 1;
        for(; j >= 0 && temp < arr[j]; j--){
            arr[j + 1] = arr[j];
        }
        arr[j + 1] = temp;
    }
    return arr;
}

console.log(insertSort([2,6,3,9,7,0,1,5,4]))