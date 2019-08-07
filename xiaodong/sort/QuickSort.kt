package sort

fun main() {
    val arr = arrayOf(48, 46, 54, 97, 83, 69, 76, 25, 10, 5, 87, 12, 21, 99, 61, 33, 30, 47, 57, 4, 36, 42, 98, 66, 100, 17, 94, 81, 11, 77, 24, 89, 73, 53, 38, 7, 29, 8, 27, 23, 56, 70, 60, 85, 39, 65, 9, 75, 15, 67, 64, 22, 51, 82, 43, 3, 37, 91, 45, 13, 34, 63, 74, 71, 95, 55, 80, 92, 2, 19, 62, 40, 84, 41, 50, 88, 86, 59, 28, 44, 72, 68, 14, 35, 93, 26, 18, 78, 31, 58, 96, 6, 1, 90, 49, 16, 52, 79, 32, 20)
    val arr1 = arrayOf(1,5,3,0,2,4)
    QuickSort().quickSort(arr1)
    SortUtil.printArray(arr)
}

class QuickSort{
    companion object {
        var count:Int = 0
        var count1:Int = 0
    }

    fun quickSort(arr:Array<Int>){
        innerRecursiveQuickSort(arr,0,arr.size-1)
        //innerLoopQuickSort(arr,0,arr.size-1)
    }

    private fun innerRecursiveQuickSort(arr: Array<Int>, lo:Int, hi:Int){
        if(lo >= hi) return
        val pivotIndex = partition(arr,lo,hi)
        innerRecursiveQuickSort(arr,lo,pivotIndex-1)
        innerRecursiveQuickSort(arr,pivotIndex+1,hi)
    }

    private fun innerLoopQuickSort(arr: Array<Int>, lo: Int, hi: Int){
        if(lo >= hi) return
        var low = lo
        while (low < hi){
            val pivotIndex = partition(arr,low, hi)
            innerLoopQuickSort(arr,low,pivotIndex-1)
            low = pivotIndex+1
        }


    }

    private fun partition(arr: Array<Int>, lo:Int,hi:Int):Int{
        count1++
        val pivot = arr[lo]
        var low = lo
        var high = hi
        while (low < high){
            while (low < high && arr[high] >= pivot)
                high--
            arr[low] = arr[high]

            while (low < high && arr[low] <= pivot)
                low++
            arr[high] = arr[low]
        }
        arr[low] = pivot
        return low
    }
}

//2.3.3 最大的元素最多可以被交换n/2
//2.2.9 2种主键时
//所以假如一开始选择了小的值作为枢轴，那么一次分割后，枢轴左侧的值全部都相同，并且都等于枢轴
// 假如一开始选择了大的值作为枢轴，那么一次分割后，枢轴右侧的值全部都相同，并且都等于枢轴