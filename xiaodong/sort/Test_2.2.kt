package sort

//2.2.4 当且仅当原地归并输入的两个子数组有序时才能得出正确结果
//2.2.7
/*
         * 因为当 N 是 2的幂次方时， 比较次数 C(N) = N * log(N)
         *
         * 因此 C(N + 1) - C(N) = (N + 1) *log(N + 1) - N * log(N)
         *
         * 因为 N 和 log(N) 都是单调递增函数，而单调递增函数之积仍然是单调递增函数
         *
         * 所以 C(N) 是单调递增的
         */

//2.2.17 链表的归并排序
//2.2.20
fun main() {
    val array = arrayOf(3,5,6,2,-1,6,9,15,7)
    var  arrayIndex = Array<Int>(array.size) {0}
    for (index in 0 until array.size){
        arrayIndex[index]= index
    }
    indexSort(array,Array(array.size){-1},arrayIndex,0,array.size-1)
    SortUtil.printArray(arrayIndex)
    SortUtil.printArray(array)
    Sort().mergingSort(array)
    SortUtil.printArray(array)
}

fun indexSort(arr: Array<Int>,arrTemp:Array<Int>,indexArr:Array<Int>,l:Int,r:Int){
    if(l >= r)return
    val mid = (l+r)/2
    indexSort(arr,arrTemp,indexArr,l,mid)
    indexSort(arr,arrTemp,indexArr,mid+1,r)

    var l1 = l
    var r1 = mid+1
    for (index in l..r){
        if(l1 <= mid && r1 <= r){
            if(arr[indexArr[l1]] < arr[indexArr[r1]]){
                arrTemp[index] = indexArr[l1]
                l1++
            }else{
                arrTemp[index] = indexArr[r1]
                r1++
            }
        }else if(l1 > mid){
            arrTemp[index] = indexArr[r1]
            r1++
        }else{
            arrTemp[index] = indexArr[l1]
            l1++
        }
    }

    for (index1 in l..r){
        indexArr[index1] = arrTemp[index1]
    }
}
