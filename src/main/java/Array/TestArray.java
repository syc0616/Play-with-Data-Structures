package Array;

public class TestArray {
    public static void main(String[] args) {
        int [] arr = new int[10];
        for (int i = 0; i < arr.length; i++){
            arr[i] = i;
        }

        int[] scores = new int[] {100,99,66};
        for(int i = 0; i < scores.length; i++){
            System.out.println(scores[i]);
        }

        //foreach遍历
        for (int score : scores){
            System.out.println(score);
        }

        // 修改元素值
        scores[0] = 96;
        for (int score : scores){
            System.out.println(score);
        }
    }
}
