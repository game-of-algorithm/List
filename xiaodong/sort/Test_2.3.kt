package sort

import java.util.*

fun main() {
    val arrSS = arrayOf(-5 , -7,-3, -6, -2, -1, -4,-8)
    val arrLL = arrayOf(3 ,4 ,2, 7,6 ,5 , 1,8)
//    SSLLSort().sort(arrSS,arrLL,0,arrLL.size-1)
//    SortUtil.printArray(arrSS)
//    SortUtil.printArray(arrLL)

    //NoInnerSentinelSort().sortNormal(arrSS,0,arrSS.size-1)
    NoInnerSentinelSort().sort(arrSS)
    SortUtil.printArray(arrSS)
}
//2.3.15 螺丝找螺母
class SSLLSort{

    fun sort(arrSS:Array<Int>,arrLL:Array<Int>,lo:Int,hi:Int){
        if(lo >= hi)return
        val pivotIndex = partition(arrSS,arrLL,lo,hi)
        sort(arrSS,arrLL,lo,pivotIndex-1)
        sort(arrSS,arrLL,pivotIndex+1,hi)
    }

    private fun partition(arrSS:Array<Int>,arrLL:Array<Int>,lo:Int,hi:Int):Int{
        val pivotLL = arrLL[lo]
        var lowSS = lo
        var highSS = hi
        var pivotSSIndex = -1
        var pivotSSValue = -11111
        while (lowSS < highSS){
            while(lowSS < highSS && pivotSSIndex != lowSS && pivotLL + arrSS[lowSS] > 0){
                lowSS++
            }

            while (lowSS < highSS && pivotSSIndex != highSS && pivotLL + arrSS[highSS] <0 ){
                highSS--
            }

            if(lowSS < highSS){
                if(pivotSSIndex >= 0){
                    if(pivotSSIndex == lowSS){
                        pivotSSIndex = highSS
                        arrSS[lowSS] = arrSS[highSS]
                    }else{
                        pivotSSIndex = lowSS
                        arrSS[highSS] = arrSS[lowSS]
                    }
                }else if(pivotLL + arrSS[lowSS] == 0){
                    pivotSSValue = arrSS[lowSS]
                    pivotSSIndex = highSS
                    arrSS[lowSS] = arrSS[highSS]
                }else if(pivotLL + arrSS[highSS] == 0){
                    pivotSSValue = arrSS[highSS]
                    pivotSSIndex = lowSS
                    arrSS[highSS] = arrSS[lowSS]
                }else{
                    SortUtil.swap(arrSS,lowSS,highSS)
                }
            }
        }
        if(pivotSSIndex >-1)
        arrSS[lowSS] = pivotSSValue

        val pivotSS = arrSS[lowSS]
        var lowLL = lo
        var highLL = hi
        var pivotLLIndex = -1
        var pivotLLValue = -11111
        while (lowLL < highLL){
            while(lowLL < highLL && pivotLLIndex != lowLL && pivotSS + arrLL[lowLL] < 0){
                lowLL++
            }

            while (lowLL < highLL && pivotLLIndex != highLL && pivotSS + arrLL[highLL] > 0 ){
                highLL--
            }

            if(lowLL < highLL){
                if(pivotLLIndex >= 0){
                    if(pivotLLIndex == lowLL){
                        pivotLLIndex = highLL
                        arrLL[lowLL] = arrLL[highLL]
                    }else{
                        pivotLLIndex = lowLL
                        arrLL[highLL] = arrLL[lowLL]
                    }
                }else if(pivotSS + arrLL[lowLL] == 0){
                    pivotLLValue = arrLL[lowLL]
                    pivotLLIndex = highLL
                    arrLL[lowLL] = arrLL[highLL]
                }else if(pivotSS + arrLL[highLL] == 0){
                    pivotLLValue = arrLL[highLL]
                    pivotLLIndex = lowLL
                    arrLL[highLL] = arrLL[lowLL]
                }else{
                    SortUtil.swap(arrLL,lowLL,highLL)
                }
            }
        }
        if(pivotLLIndex > -1)
        arrLL[pivotLLIndex] = pivotLLValue
        return lowLL
    }
}

//2.3.20 非递归排序
class NotRecursiveQuickSort{

    fun sort(arr:Array<Int>){
        val stack = Stack<Int>()
        stack.push(arr.size-1)
        stack.push(0)

        while (!stack.empty()){
            val l = stack.pop()
            val r = stack.pop()
            val pivotIndex = partition(arr,l,r)
            if(l < pivotIndex -1){
                stack.push(pivotIndex-1)
                stack.push(l)
            }
            if(r > pivotIndex +1){
                stack.push(r)
                stack.push(pivotIndex+1)
            }
        }
    }

    private fun partition(arr: Array<Int>, lo:Int,hi:Int):Int{
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


//2.3.17 去掉内循环哨兵
@Suppress("UNREACHABLE_CODE")
class NoInnerSentinelSort{
    fun sortNormal(arr: Array<Int>,lo: Int,hi: Int){
        if(lo >= hi)return
        val pivotIndex = normalPartition(arr,lo,hi)
        sortNormal(arr,lo,pivotIndex-1)
        sortNormal(arr,pivotIndex+1,hi)
    }

    private fun normalPartition(arr: Array<Int>, lo:Int,hi:Int):Int{
        val pivot = arr[lo]
        var i = lo
        var j = hi+1
        while (true){
            while (arr[++i] < pivot)if(i == hi)break

            while (arr[--j] > pivot)if(j == lo)break

            if(i >= j)break
            SortUtil.swap(arr,i,j)
        }
        SortUtil.swap(arr,lo,j)
        return j
    }

    fun sort(arr: Array<Int>){
        var max = 0
        for (index in 1 until arr.size){
            if(arr[index] > arr[max]){
                max = index
            }
        }
        SortUtil.swap(arr,max,arr.size-1)
        _sort(arr,0,arr.size-1)
    }

    private fun _sort(arr: Array<Int>,lo: Int,hi: Int){
        if(lo >= hi)return
        val pivotIndex = partition(arr,lo,hi)
        _sort(arr,lo,pivotIndex-1)
        _sort(arr,pivotIndex+1,hi)
    }

    private fun partition(arr: Array<Int>, lo:Int,hi:Int):Int{
        val pivot = arr[lo]
        var i = lo
        var j = hi+1
        while (true){
            while (arr[++i] < pivot){

            }

            while (arr[--j] > pivot){

            }

            if(i >= j)break

            SortUtil.swap(arr,i,j)
        }

        SortUtil.swap(arr,lo,j)

        return j
    }

}

