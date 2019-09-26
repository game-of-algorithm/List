package src.bst;

import java.util.LinkedList;
import java.util.Queue;

public class BSTPrint {
    public static void main(String[] args) {
        int[] arr = new int[]{48, 46, 54, 97, 83, 69, 76, 25, 10, 5, 87, 12, 21, 99, 61, 33, 30, 47, 57, 4, 36, 42, 98, 66, 100, 17, 94, 81, 11, 77, 24, 89, 73, 53, 38, 7, 29, 8, 27, 23, 56, 70, 60, 85, 39, 65, 9, 75, 15, 67, 64, 22, 51, 82, 43, 3, 37, 91, 45, 13, 34, 63, 74, 71, 95, 55, 80, 92, 2, 19, 62, 40, 84, 41, 50, 88, 86, 59, 28, 44, 72, 68, 14, 35, 93, 26, 18, 78, 31, 58, 96, 6, 1, 90, 49, 16, 52, 79, 32, 20};
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
            while (tempNodeIndex <= levelNodeCount){
                Node node = queue.poll();
                if(node !=null && node.value != null){
                    if(tempNodeIndex > 1){
                        printSpace((int) Math.pow(2,bstLevel+1)-1 -
                                (node.value.toString().length()-1));//减去字体长度减1
                    }else{
                        printSpace(startLeft -(node.value.toString().length()-1));
                    }
                    System.out.print(node.value.toString());
                    queue.add(node.left);
                    queue.add(node.right);
                }else{
                    if(tempNodeIndex > 1){
                        printSpace((int) Math.pow(2,bstLevel+1));
                    }else{
                        printSpace(startLeft +1);
                    }
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
