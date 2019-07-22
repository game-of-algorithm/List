package sort

class SortUtil {

    companion object {
        fun swap(array: Array<Int>,a:Int,b:Int){
            val temp = array[a]
            array[a] = array[b]
            array[b] = temp
        }

        fun less(array: Array<Int>,a:Int, b:Int):Boolean{
            return array[a] < array[b]
        }

        fun printArray(array: Array<Int>){
            for (element in array.withIndex()){
                print("${element.value}  ")
            }
            println()
        }
    }
}