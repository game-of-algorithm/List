/**
 * 单向链表的操作（增加节点、查找节点、删除节点）
 * 头插尾插
 */
class SingleLink{
    class Node{
        private String data;
        private Node next;
        public Node(String data){
            this.data = data;
        }

        public void add(Node newNode){
            if(this.next == null){
                this.next = newNode;
            } else {
                this.next.add(newNode);
            }
        }

        public void print(){
            System.out.println(this.data + "\t");
            if(this.next != null){
                this.next.print();
            }
        }

        public boolean search(String data){
            if(data.equals(this.data)){
                return true;
            } else {
                if(this.next != null){
                    return this.next.search(data);
                } else {
                    return false;
                }
            }
        }

        public void delete(Node previous, String data){
            if(data.equals(this.data)){
                previous.next = this.next;
            } else {
                if(this.next != null){
                    this.next.delete(this, data);
                }
            }
        }
    }

    //==============================
    private Node root;
    public void addNode(String data){
        Node newNode = new Node(data);
        if(root == null){
            root = newNode;
        } else {
            root.add(newNode);
        }
    }

    public void printNode(){
        if(root != null){
            root.print();
        }
    }

    public boolean contains(String name){
        return this.root.search(name);
    }

    public void delete(String data){
        if(this.contains(data)){
            if(this.root.data.equals(data)){
                this.root = this.root.next;
            } else {
                this.root.next.delete(root, data);
            }
        }
    }
}