import java.util.Arrays;

class Shell_sort{
    public static void main(String[] args) {
        int num[] = {11, 2, 43, 44, 25, 16, 97, 8};
        int temp;
        int step = num.length;

        System.out.println(Arrays.toString(num));
        while(true){
            step = step / 2;
            for(int i = 0; i < step; i ++){
                //对分组进行插入排序
                for(int j = i + step; j < num.length; j = j + step){
                    temp = num[j];
                    int k;
                    for(k = j - step; k >= 0; k = k-step){
                        if(num[k] > temp){
                            num[k + step] = num[k];
                        } else {
                            break;
                        }
                    }
                    num[k + step] = temp;
                }
            }
            if(step == 1){
                break;
            }
        }

        System.out.println(Arrays.toString(num));
    }
}