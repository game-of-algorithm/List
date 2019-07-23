package sort

fun main() {
    val arr = arrayOf(48, 46, 54, 97, 83, 69, 76, 25, 10, 5, 87, 12, 21, 99, 61, 33, 30, 47, 57, 4, 36, 42, 98, 66, 100, 17, 94, 81, 11, 77, 24, 89, 73, 53, 38, 7, 29, 8, 27, 23, 56, 70, 60, 85, 39, 65, 9, 75, 15, 67, 64, 22, 51, 82, 43, 3, 37, 91, 45, 13, 34, 63, 74, 71, 95, 55, 80, 92, 2, 19, 62, 40, 84, 41, 50, 88, 86, 59, 28, 44, 72, 68, 14, 35, 93, 26, 18, 78, 31, 58, 96, 6, 1, 90, 49, 16, 52, 79, 32, 20)
    val arr1 = arrayOf(0,1,2,3,4,5,6,7)
    Sort().shellSort(arr1)
    SortUtil.printArray(arr1)
}

class Sort {

    fun selectionSort(arr:Array<Int>){
        var minIndex:Int
        for (i in 0 until arr.size){
            minIndex = i
            for (j in i until arr.size){
                if(arr[j] < arr[minIndex]){
                    minIndex = j
                }
            }
            if(i != minIndex)
            SortUtil.swap(arr,i,minIndex)
        }
    }

    fun insertSort(arr: Array<Int>){
        for (i in 1 until arr.size){
            var j = i-1
            while (j >= 0 && arr[j] > arr[j+1]){
                SortUtil.swap(arr,j,j+1)
                j--
            }
        }
    }

    fun shellSort(arr: Array<Int>){
        var increment = arr.size
        var countCompare = 0
        var countSwap = 0
        do {
            increment = increment/3+1
            for (i in increment until arr.size){
                var j = i - increment
                while (j >= 0 && ++countCompare > 0 && arr[j] > arr[j+increment] ){
                    SortUtil.swap(arr,j,j+increment)
                    j-=increment
                    countSwap++
                }
            }
        }while (increment > 1)

        println(countCompare)
        println(countSwap)
    }

    fun shellSort1(arr: Array<Int>){
        var increment = 121
        var count = 0
        do {
            increment = (increment-1) /3
            for (i in increment until arr.size){
                var j = i - increment
                while (j >= 0 && ++count > 0 && arr[j] > arr[j+increment] ){
                    SortUtil.swap(arr,j,j+increment)
                    j-=increment
                }
            }
        }while (increment > 1)

        println(count)
    }

    fun mergingSort(arr: Array<Int>){
        innerMergingSort(arr, Array(arr.size) {0},0,arr.size-1)
    }

    private fun innerMergingSort(arr:Array<Int>,arrTemp:Array<Int>,l:Int,r:Int){
        if(l >= r)return
        val mid = (l+r)/2
        innerMergingSort(arr,arrTemp,l,mid)
        innerMergingSort(arr,arrTemp,mid+1,r)

        var l1 = l
        var r1 = mid+1
        for (index in l..r){
            if(l1 <= mid && r1 <= r){
                if(arr[l1] < arr[r1]){
                    arrTemp[index] = arr[l1]
                    l1++
                }else{
                    arrTemp[index] = arr[r1]
                    r1++
                }
            }else if(l1 > mid){
                arrTemp[index] = arr[r1]
                r1++
            }else{
                arrTemp[index] = arr[l1]
                l1++
            }
        }

        for (index1 in l..r){
            arr[index1] = arrTemp[index1]
        }
    }
}