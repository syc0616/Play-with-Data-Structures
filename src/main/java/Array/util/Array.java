package Array.util;


/*
    泛型：
    让数据结构中可放置任何数据类型；
    不能是基本数据类型，只能是类对象

 */
public class Array<E> {
    // 数组数据
    private E[] data;
    // 数组实际数据大小
    private int size;

    // 构造函数，传入数组的容量capacity构造Array
    public Array(int capacity){
        data = (E[])new Object[capacity];
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

    // 获取数组中的元素个数
    public int getSize(){
        return size;
    }

    // 返回数组是否为空
    public boolean isEmpty(){
        return size == 0;
    }

    // 向所有元素后添加一个新元素
    public void addLast(E e){
        add(size, e);
    }

    // 在所有元素前添加一个新元素
    public void addFirst(E e){
        add(0, e);
    }

    // 在index索引的位置插入一个新元素e
    public void add(int index, E e){
        if(index < 0 || index > size){
            throw new IllegalArgumentException("Add failed. Require index >= 0 and index <= size.");
        }

        // 数组已满，重新分配
        if(size == data.length){
            resize(2 * data.length);
        }

        // 从最后一个元素开始向后移动，空出index位置，供插入
        for(int i = size - 1; i >= index; i--){
            data[i + 1] = data[i];
        }

        data[index] = e;
        //数组元素个数
        size++;
    }

    // 获取index索引位置的元素
    public E get(int index){
        if (index < 0 || index >= size){
            throw new IllegalArgumentException("Get failed. Index is illegal.");
        }
        return data[index];
    }

    // 修改index索引位置的元素为e
    public void set(int index, E e){
        if (index < 0 || index >= size){
            throw new IllegalArgumentException("Get failed. Index is illegal.");
        }

        data[index] = e;
    }

    // 查找数组中是否有元素e
    public boolean contains(E e){
        for(int i = 0; i < data.length; i++){
            if (data[i] == e){
                return true;
            }
        }
        return false;
    }

    // 查找数组中元素e所在的索引，若不存在元素e，则返回-1
    public int find(E e){
        for (int i = 0; i < data.length; i++){
            if (data[i] == e){
                return i;
            }
        }
        return -1;
    }

    // 从数组中删除index位置的元素，返回删除的元素
    public E remove(int index){
        if (index < 0 || index >= size){
            throw new IllegalArgumentException("Remove failed. Index is illegal.");
        }

        // 将元素后移
        E ret = data[index];
        for (int i = index + 1; i < size; i++){
            data[i - 1] = data[i];
        }

        size--;

        // loitering objects != memory leak
        data[size] = null;

        // 数组大小为原理的1/4；将数组大小调整为原来的1/2
        if (size == data.length / 4 && data.length / 2 != 0){
            resize(data.length / 2);
        }

        return ret;
    }

    // 从数组中删除第一个元素
    public E removeFirst(){
        return remove(0);
    }

    // 从数组中删除最后一个元素
    public E removeLast(){
        return remove(size - 1);
    }

    // 从数组中删除元素e
    public void removeElement(E e){
        int index = find(e);
        if (index != -1){
            remove(index);
        }
    }

    private void resize(int newCapacity){
        E[] newData = (E[])new Object[newCapacity];
        // 将旧值拷贝新的数组
        for (int i = 0; i < size; i++){
            newData[i] = data[i];
        }
        data = newData;

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
