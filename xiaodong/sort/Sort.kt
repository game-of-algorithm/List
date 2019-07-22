package sort

fun main() {
    val arr = arrayOf(9,4,3,-1,1,0,5,6,7)
    Sort().mergingSort(arr)
    SortUtil.printArray(arr)
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
        do {
            increment = increment /3 +1
            for (i in increment until arr.size){
                var j = i - increment
                while (j >= 0 && arr[j] > arr[j+increment]){
                    SortUtil.swap(arr,j,j+increment)
                    j-=increment
                }
            }
        }while (increment > 1)
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