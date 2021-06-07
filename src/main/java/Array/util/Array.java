package Array.util;

public class Array {
    // 数组数据
    private int[] data;
    // 数组实际数据大小
    private int size;

    // 构造函数，传入数组的容量capacity构造Array
    public Array(int capacity){
        data = new int[capacity];
        size = 0;
    }

    // 无参数的构造函数，默认数组的容量capacity=10
    public Array(){
        this(10);
    }

    // 获取数组的容量
    public int getCapacity(){
        return data.length;
    }

    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void addLast(int e){
        add(size, e);
    }

    public void addFirst(int e){
        add(0, e);
    }

    public void add(int index, int e){
        // 数组已满
        if(size == data.length){
            throw new IllegalArgumentException("Add failed. Array is full.");
        }

        if(index < 0 || index > size){
            throw new IllegalArgumentException("Add failed. Require index >= 0 and index <= size.");
        }

        // 从最后一个元素开始向后移动，空出index位置，供插入
        for(int i = size - 1; i >= index; i--){
            data[i + 1] = data[i];
        }

        data[index] = e;
        //数组元素个数
        size++;
    }

    public int get(int index){
        if (index < 0 || index >= size){
            throw new IllegalArgumentException("Get failed. Index is illegal.");
        }
        return data[index];
    }

    public void set(int index, int e){
        if (index < 0 || index >= size){
            throw new IllegalArgumentException("Get failed. Index is illegal.");
        }

        data[index] = e;
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size = %d , capacity = %d\n", size, data.length));
        res.append('[');

        for(int i = 0; i < size; i++){
            res.append(data[i]);
            //不是最后一个元素
            if (i != size -1){
                res.append(",");
            }
        }

        res.append(']');
        return res.toString();
    }

}
