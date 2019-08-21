package sort

//2.1.2 选择排序中一个元素最多可能会被交换n-1次，最少0次，平均(n-1)/2
//2.1.6 主键都相同的情况下，插入排序快于选择排序
//2.1.7 逆序数组，选择排序比插入排序更快

//2.1.14

//2.1.19 474 （792）
//2.1.20 希尔排序最好的情况是本来就有序

fun main() {
    var  array = Array<Int>(100) {0}
    for (index in 0..99){
        array[index]= 99 - index
    }
    Sort().shellSort(array)
    SortUtil.printArray(array)
}
