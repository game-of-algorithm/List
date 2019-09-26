package src.bst;

import java.util.LinkedList;
import java.util.Queue;

public class BSTPrint {
    public static void main(String[] args) {
        BSTPrint bstPrint = new BSTPrint();
        Node node = bstPrint.getBST(7);
        bstPrint.printBST(node);
    }

    public Node getBST(int level){
        if(level == 1)return new Node(1);
        Node node = new Node(1);
        node.left = getBST(level-1);
        node.right = getBST(level-1);
        return node;
    }

    public void printBST(Node root){
        if(root == null)return;
        int bstLevel = getBSTLevel(root);
        int levelNodeCount;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (bstLevel > 0){
            levelNodeCount = queue.size();
            int startLeft = getStartLeft(bstLevel);
            int tempNodeIndex = 1;
            printSpace(startLeft);
            while (tempNodeIndex <= levelNodeCount){
                Node node = queue.poll();
                if(node !=null && node.value != null){
                    if(tempNodeIndex > 1){
                        printSpace((int) Math.pow(2,bstLevel+1)-1);
                    }
                    System.out.print(node.value.toString());
                    queue.add(node.left);
                    queue.add(node.right);
                }else{
                    queue.add(null);
                    queue.add(null);
                }
                tempNodeIndex++;
            }
            System.out.println();
            bstLevel --;
        }

    }

    private int getStartLeft(int level){
        int start = 0;
        if(level > 2){
            start = (int) (Math.pow(2,level)-2);
        }else if(level == 2){
            start = 2;
        }
        return start;
    }


    public int getBSTLevel(Node node){
        if(node == null)return 0;
        int left = getBSTLevel(node.left);
        int right = getBSTLevel(node.right);
        return Math.max(left,right)+1;
    }

    private void printSpace(int count){
        while (count > 0){
            count--;
            System.out.print(" ");
        }
    }
}
