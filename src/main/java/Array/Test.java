package Array;

import Array.util.Array;

public class Test {
    public static void main(String[] args) {
        // 使用自定义数组
        Array arr = new Array(20);
        // 添加10个元素
        for(int i = 0; i < 10; i++){
            arr.addLast(i);
        }

        System.out.println(arr);

        arr.add(1, 100);
        System.out.println(arr);

        arr.addFirst(-1);
        System.out.println(arr);
    }
}
