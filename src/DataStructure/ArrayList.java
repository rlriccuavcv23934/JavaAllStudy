package DataStructure;

public class ArrayList<E> {   //泛型E，因为表中要存的具体数据类型待定
    int capacity = 10;   //当前顺序表的容量
    int size = 0;   //当前已经存放的元素数量
    private Object[] arr = new Object[capacity];   //底层存放数据的数组


    //插入
    /* public void add(E element, int index) {   //插入方法需要支持在指定下标位置插入
       for (int i = size; i > index; i--)   //从后往前，一个一个搬运元素
           arr[i] = arr[i - 1];
       arr[index] = element;   //腾出位置之后，直接插入元素放到对应位置上
       size++;   //插入完成之后，记得将size自增
   }
    

   public void add(E element, int index) {
       if (index < 0 || index > size)    //插入之前先判断插入位置是否合法
           throw new IndexOutOfBoundsException("插入位置非法，合法的插入位置为：0 ~ " + size);
       for (int i = size; i > index; i--)
           arr[i] = arr[i - 1];
       arr[index] = element;
       size++;
   }
   */
    public void add(E element, int index) {
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException("插入位置非法，合法的插入位置为：0 ~ " + size);

        if (capacity == size) {
            int newCapacity = capacity + (capacity >> 1);   //扩容规则就按照原本容量的1.5倍来吧 右移1位==除2
            Object[] newArray = new Object[newCapacity];    //创建一个新的数组来存放更多的元素
            System.arraycopy(arr, 0, newArray, 0, size);   //使用arraycopy快速拷贝原数组内容到新的数组
            arr = newArray;   //更换为新的数组
            capacity = newCapacity;   //容量变成扩容之后的
        }

        for (int i = size; i > index; i--)
            arr[i] = arr[i - 1];
        arr[index] = element;
        size++;
    }


    //删除
    /*
    @SuppressWarnings("unchecked")   //屏蔽未经检查警告
    public E remove(int index){   //删除对应位置上的元素，注意需要返回被删除的元素
        E e = (E) array[index];   //因为存放的是Object类型，这里需要强制类型转换为E
        for (int i = index; i < size; i++)   //从前往后，挨个往前搬一位
            array[i] = array[i + 1];
        size--;    //删完记得将size--
        return e;
    }*/
    @SuppressWarnings("unchecked")
    public E remove(int index) {
        if (index < 0 || index > size - 1)
            throw new IndexOutOfBoundsException("删除位置非法，合法的插入位置为：0 ~ " + (size - 1));

        E e = (E) arr[index];
        for (int i = index; i < size; i++)
            arr[i] = arr[i + 1];
        size--;
        return e;
    }


    //更新
    public void setarray(int index, E element) {
        if (index < 0 || index > size )
            throw new IndexOutOfBoundsException("更新位置非法，合法的插入位置为：0 ~ " + (size));
        arr[index] = element;
    }


    //查找
    @SuppressWarnings("unchecked")
    public E getElement(int index) {
        if (index < 0 || index > size)   //在查找之前同样要进行范围检查
            throw new IndexOutOfBoundsException("非法的位置，合法的位置为：0 ~ " + (size));
        return (E) arr[index];   //直接返回就完事
    }

    public int size() {   //获取当前存放的元素数量
        return size;
    }

    public int getCapacity() {   //获取当前存放的元素数量
        return capacity;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("当前顺序表元素长度: ").append(size()).append(" ").append("\n");
        builder.append("当前顺序表全部长度: ").append(getCapacity()).append(" ").append("\n");
        builder.append('[');
        for (int i = 0; i < size; i++) builder.append(' ').append(arr[i]).append(" ");
        builder.append(']');
        return builder.toString();
    }
}

/*
import ClassStudy.ArrayList;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        //list.add(10, 1);    一上来只能在第一个位置插入，第二个位置肯定是非法的
        System.out.print("输入顺序表的长度: ");
        int lengthOflist = input.nextInt();
        System.out.println("输入元素(以空格隔开元素): ");
        for (int i = 0; i < lengthOflist; i++) {
            list.add(input.nextInt(), i);
            if (i == lengthOflist - 1) System.out.println("已输入完毕");
        }
        System.out.println(list);
        System.out.println("===================================================");
        System.out.print("选择是否删除顺序表中的元素(Yy/Nn): ");
        Scanner scanner = new Scanner(System.in);
        String Choice = scanner.nextLine();
        if (Choice.equals("Y") || Choice.equals("y")) {
            System.out.print("输入需要删除的索引位置(以0号开始): ");
            list.remove(scanner.nextInt());
        }
        System.out.println(list);
        System.out.println("===================================================");
        System.out.print("选择是否更新顺序表中的元素(Yy/Nn): ");
        Scanner choice_Put = new Scanner(System.in);
        String choicePut = choice_Put.nextLine();
        if (choicePut.equals("Y") || choicePut.equals("y")) {
            System.out.print("输入需要更新的索引位置(以0号开始)和元素: ");
            list.setarray(choice_Put.nextInt(), choice_Put.nextInt());
        }
        System.out.println("===================================================");
        System.out.print("选择是否查询顺序表中的元素(Yy/Nn): ");
        Scanner choice_1 = new Scanner(System.in);
        String choice_2OB = choice_1.nextLine();
        if (choice_2OB.equals("Y") || choice_2OB.equals("y")) {
            System.out.print("输入需要查询的索引位置(以0号开始): ");
            System.out.println(list.getElement(choice_1.nextInt()));
        }
    }
}
 */