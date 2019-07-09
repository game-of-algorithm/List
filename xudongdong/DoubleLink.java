class DoubleLink<T>{
    private class Node<T>{
        public Node<T> pre;
        public Node<T> next;
        public T data;

        public Node(T data, Node<T> pre, Node<T> next){
            this.data = data;
            this.pre = pre;
            this.next = next;
        }

        public Node(){
            this.data = null;
            this.pre = null;
            this.next = null;
        }
    }

    private int theSize;
    private Node<T> Header;
    private Node<T> Tail;

    public DoubleLink(){
        theSize = 0;
        Header = new Node<T>(null, null, null);
        Tail = new Node<T>(null, Header, null);

        Header.next = Tail;
    }

    public void add(T item){
        Node<T> aNode = new Node<T>(item, null, null);
        Tail.pre.next = aNode;
        aNode.pre = Tail.pre;
        aNode.next = Tail;
        Tail.pre = aNode;

        theSize++;
    }

    public boolean isEmpty(){
        return this.theSize == 0;
    }

    public int size(){
        return this.theSize;
    }

    public T getInt(int index){
        if(index > this.size -1 || index < 0){
            throw new IndexOutOfBoundsException();
        }

        Node<T> current = Header.next;
        for(int i = 0; i < index; i++){
            current = current.next;
        }

        return current.data;
    }

    public void print(){
        Node<T> current = Header.next;
        while(current.next != null){
            System.out.println(current.data.toString());
            current = current.next;
        }
    }
}