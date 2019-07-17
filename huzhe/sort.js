//节点
function Node(element) {
    this.element = element;
    this.next = null;
}

//链表类
function LinkedList () {
    this.head = new Node( 'head' );     //头节点
    this.find = find;                   //查找节点
    this.insert = insert;               //插入节点
    this.display = display;             //显示链表
    this.toarr = toarr
}

//查找给定节点
function find ( item ) {
    let currNode = this.head;
    while ( currNode.element != item ){
        currNode = currNode.next;
    }
    return currNode;
}

//插入节点
function insert ( newElement , item ) {
    let newNode = new Node( newElement );
    let currNode = this.find( item );
    newNode.next = currNode.next;
    currNode.next = newNode;
}

//显示链表元素
function display () {
    let currNode = this.head;
    while ( !(currNode.next == null) ){
        console.log( currNode.next.element );
        currNode = currNode.next;
    }
}

// 链表排序
function toarr () {
    let arr = [];
    let currNode = this.head;
    while ( !(currNode.next == null) ){
        arr.push(currNode.next.element)
        // console.log( currNode.next.element );
        currNode = currNode.next;
    }
    return arr 
}
let sort = new LinkedList()
sort.insert(4,'head')
sort.insert(2,4)
sort.insert(1,2)
sort.insert(3,1)
sort.insert(-1,1)
sort.insert(0,-1)
sort.display()
console.log(`-------------------------`)
let sortedArr = sort.toarr().sort()
let sorted = new LinkedList()
sortedArr.forEach((value,index)=>{
    if(index == 0){
        sorted.insert(value,'head')
    }else{
        sorted.insert(value,sortedArr[index-1])
    }
})
console.log(sorted.display())


