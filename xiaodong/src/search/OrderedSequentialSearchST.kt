package src.search

/**
 * 有序链表实现有序的符号表
 */
class OrderedSequentialSearchST<K : Comparable<K>,V:Any> {

    private val headNode = Node<K,V>()

    private var max:K? = null
    private var min:K? = null

    private var size = 0

    fun put(key:K,value:V){
        //更新最大值
        if(max == null){
            max = key
        }else if(key > max!!){
            max = key
        }

        //更新最小值
        if(min == null){
            min = key
        }else if(key < min!!){
            min = key
        }
        var cur = headNode.next
        var pre = headNode
        while (cur != null && cur.key < key){
            pre = cur
            cur = cur.next
        }

        if(cur != null && cur.key == key){
            cur.value = value
        }else{
            ++size
            pre.next = Node(key,value,cur)
        }
    }

    fun get(key: K):V?{
        var cur = headNode.next
        while (cur != null && cur.key != key){
            cur = cur.next
        }
        return cur?.value
    }

    fun delete(key: K){
        var cur = headNode.next
        var pre = headNode
        while (cur != null && cur.key != key){
            pre = cur
            cur = cur.next
        }

        if(cur == null)return
        size--

        if(cur.key == min){
            min = cur.next?.key
        }

        if(cur.key == max){
            max = if(pre == headNode){
                null
            }else{
                pre.key
            }
        }

        cur.key
        pre.next = cur.next
    }

    private inner class Node <K : Comparable<K>,V : Any>{
        internal lateinit var key: K
        internal lateinit var value: V
        internal var next: Node<K,V>? = null

        internal constructor() {}
        internal constructor(key: K, value: V, next: Node<K,V>?) {
            this.key = key
            this.value = value
            this.next = next
        }

        override fun toString(): String {
            return String.format("{%s  %s}", key, value)
        }
    }
}