
public class StackTest {
    public static void main(String[] args) {
        MStack<Integer> s = new MStack<Integer>();
        s.push(1);
        s.push(2);
        s.push(3);
        System.out.println(s.toString());
        s.pop();
        System.out.println(s.toString());
        System.out.println(s.peek());
        System.out.println(s.toString());
        while (s.pop()!= null){}
        System.out.println(s.toString());

    }

    interface IStack<T>{

        T push(T t);
    
        T peek();
    
        T pop();
    
        boolean empty();
    }

    static class MStack<T> implements IStack<T>{

        private  Node head;
    
        @Override
        public T push(T t) {
            Node tempNode = head;
            head = new Node<T>(t);
            head.nextNode = tempNode;
            return t;
        }
    
        @Override
        public T peek() {
            return head == null? null : (T)head.data;
        }
    
        @Override
        public T pop() {
           Node tempNode = null;
           if(head != null){
                tempNode = head;
                head = head.nextNode;
           }
           return tempNode ==null?null : (T)tempNode.data;
        }
    
        @Override
        public boolean empty() {
            return head == null;
        }

        @Override
        public String toString() {
            if(empty()){
                return "{ }";
            }
            StringBuilder builder = new StringBuilder("{");
            Node tempHead = head;
            while(tempHead != null){
                builder.append(tempHead.data);
                tempHead = tempHead.nextNode;
                builder.append(",");
                
            }
            builder.delete(builder.length()-1, builder.length());
            builder.append("}");
            return builder.toString();
        }
        
        private class Node<T>{
            Node preNode;
            Node nextNode;
            T data;
        
            Node(T data){
                this.data = data;
            }
        }
    }
}

 


