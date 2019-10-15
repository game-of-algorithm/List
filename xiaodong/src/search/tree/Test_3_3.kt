package src.search.tree

//3.3.3  S E A C H X M 构建高度1的2-3树
//          A C E H M S X  -> H M C A X S E
//              C  S
//          A E  H   M X

/**
 *红黑数
 */
class RedBlackBST{
    private var rootNode:Node<Any>? = null


    private fun rotateLeft(n:Node<Any>):Node<Any>{
        val x = n.rightNode
        n.rightNode = x?.rightNode
        x?.leftNode = n
        x?.color = n.color
        n.color = RED
        x?.N = n.N
        n.N = 1 + size(n.leftNode) + size(n.rightNode)
        return n
    }

    private fun rotateRight(n: Node<Any>):Node<Any>{
        val x = n.leftNode
        n.leftNode = x?.leftNode
        x?.leftNode = n
        x?.color = n.color
        x?.N = n.N
        n.N = 1 + size(n.leftNode) + size(n.rightNode)
        return n
    }

    private fun flipColors(n: Node<Any>){
        n.color = RED
        n.leftNode?.color = BLACK
        n.rightNode?.color = BLACK
    }

    private fun isRed(n: Node<Any>?):Boolean{
        n?.let {
            return it.color == RED
        }
        return false
    }

    private fun size(node:Node<Any>?):Int{
        return rootNode?.N?:0
    }

    fun put(key:Int,value:Any){
        rootNode = put(rootNode,key,value)
    }

    private fun put(node: Node<Any>?,key: Int,value: Any):Node<Any>{
        if(node == null)return Node<Any>().apply {
            this.key = key
            this.value = value
        }

        if(key < node.key){
            put(node.leftNode,key,value)
        }else{
            put(node.rightNode,key,value)
        }
        var n :Node<Any> = node
        if(isRed(n.rightNode) && !isRed(n.leftNode))n = rotateLeft(node)
        if(isRed(n.leftNode) && isRed(n.leftNode?.leftNode)) n = rotateRight(node)
        if(isRed(n.leftNode) && isRed(n.rightNode))flipColors(n)
        n.N = size(n.leftNode) + size(n.rightNode) + 1
        return n
    }
}


class Node<T>{
    var key:Int = 0
    var value:T? = null
    var N:Int = 0
    var color:Boolean = false
    var leftNode:Node<T>? = null
    var rightNode:Node<T>? = null

}

const val RED = true
const val BLACK = true