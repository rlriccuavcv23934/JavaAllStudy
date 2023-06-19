package DataStructure;

import java.util.Arrays;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        int[] arr = new int[]{12, 6, 33, 90, 561, 97, 108, 87};
        //Arrays.sort(arr);数组工具的排序

        System.out.println("原本未排序的数组: " + Arrays.toString(arr));
        //冒泡排序
        Test.bubbleSort(arr);
        System.out.println("==================================================");
        //二分查找
        System.out.print("二分查找数值(返回下标): " + Test.binSearch(arr, 108));
        System.out.println();
        System.out.println("循环查找108所在位置：" + Test.binSearch(arr, 108, 0, arr.length - 1));
        System.out.println("==================================================");
        //跳台问题
        //当n>=2时，n个台阶，设有F（n）种跳法
        //
        //      （1）若第一次选择跳1个台阶，那么剩下的n-1个台阶有F(n-1)种跳法
        //
        //      （2）若第一次选中跳2个台阶，那么剩下的n-2个台阶有F(n-2)种跳法
        System.out.println("输入台阶数(返回跳台方法): " + Test.jumpFloor(5));
        System.out.println("输入台阶数(返回跳台方法): " + Test.jumpFloor_1(5));
        System.out.println("==================================================");
        //回文字符串
        Test.isPalindrome();
        Test.isHuiWen();
        System.out.println("==================================================");
        //汉诺塔
        int Pan = 3;
        char a = 'A', b = 'B', c = 'C';
        Test.hanio(Pan, a, b, c);


    }

    public static void bubbleSort(int[] arr) {
        int len = arr.length;
        boolean swapped = true;
        for (int i = 0; i < len - 1 && swapped; i++) {//外层循环控制排序趟数
            swapped = false;
            int lastSwappedIndex = len - 1;
            //内层循环控制每一趟排序多少次
            for (int j = 0; j < lastSwappedIndex; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                    lastSwappedIndex = j;
                }
            }
        }
        System.out.println();
        System.out.println("冒泡排序后的数组: " + Arrays.toString(arr));
    }


    public static int binSearch(int[] arr, int x) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int middle = (low + high) / 2;
            if (x == arr[middle]) return middle;
            else if (x < arr[middle]) high = middle - 1;
            else low = middle + 1;
        }
        return -1;
    }

    public static int binSearch(int[] nums, int target, int left, int right) {  //left代表左边界，right代表右边界
        if (left > right) return -1;   //如果左边大于右边，那么肯定就找完了或者没有找到，所以直接返回
        int mid = (left + right) / 2;   //这里计算出中间位置
        if (nums[mid] == target) return mid;   //直接比较，如果相等就返回下标
        if (nums[mid] > target)    //这里就是大于或小于的情况了，这里mid+1和mid-1很多人不理解，实际上就是在下一次寻找中不算上当前的mid，因为这里已经比较过了，所以说左边就-1，右边就+1
            return Test.binSearch(nums, target, left, mid - 1);   //如果大于，那么说明肯定不在右边，直接去左边找
        else
            return Test.binSearch(nums, target, mid + 1, right);  //如果小于，那么说明肯定不在左边，直接去右边找
    }

    public static int jumpFloor(int num) {//num台阶数
        if (num == 1 || num == 2) return num;
        else return Test.jumpFloor(num - 1) + Test.jumpFloor(num - 2);
    }

    private static int jumpFloor_1(int num_1) {
        int[] arr = new int[num_1 + 1];//加1是考虑到有0阶因素
        arr[0] = 0;//存放0阶的方案数
        arr[1] = 1;//存放1阶的方案数
        arr[2] = 2;//存放2阶的方案数
        for (int i = 3; i <= num_1; i++) arr[i] = arr[i - 1] + arr[i - 2];
        System.out.println("输出台阶数组: " + Arrays.toString(arr));
        return arr[num_1];
    }

    public static void isPalindrome() {
        System.out.print("输入一个字符串: ");
        Scanner input = new Scanner(System.in);
        String str = input.nextLine();
        StringBuilder sb = new StringBuilder(str);
        sb.reverse();//反转字符串
        String newStr = new String(sb);
        if (str.equals(newStr)) System.out.println(str + " 是回文字符串");
        else
            System.out.println(str + " 不是回文字符串");
    }

    private static void isHuiWen() {
        System.out.print("输入一个字符串: ");
        Scanner input = new Scanner(System.in);
        String str = input.nextLine();
        StringBuilder sb = new StringBuilder(str);
        sb.reverse();//反转字符串
        int count = 0;
        for (int i = 0; i < str.length(); i++)//字符串长度
            if (str.charAt(i) == sb.charAt(i)) count++;//逐个提取字符

        if (count == str.length())//如上述对应长度和输入的字符串相等就是回文字符串
            System.out.println(str + " 是回文字符串");
        else
            System.out.println(str + " 不是回文字符串");
    }

    /**
     * @param n 一共需要移动的盘子
     * @param a 盘子移动的起始柱子
     * @param b 借助的柱子
     * @param c 盘子需要移动到的目标柱子
     *          在每一步盘子移动的过程中，总会有一步，是下边最大的盘子，从 A 移到 C 的。
     *          如，两个盘子，就是第 2 个盘子从 A移到 C，三个盘子，就是第 3 个盘子从 A 移到 C。
     *          仔细观察，以三个盘子为例，把第 3 个盘子从 A 移动到 C 这一步，其实，第 1 个和第 2 个盘子是已经按顺序摆放好了的，即一起放在中间的 B 柱子。
     */
    public static void hanio(int n, char a, char b, char c) {
        //只有一个盘子的时候，就直接从A移到C
        if (n == 1) Test.move(n, a, c);
        else {
            //三步曲，注意观察，a,b,c三个的位置变化
            //1.把 n-1 个盘子看成一个整体，借助 C 从 A 移动到 B
            Test.hanio(n - 1, a, c, b);
            //2.把第 n 个盘子从 A 移动到 C
            Test.move(n, a, c);
            //3.再把 n-1 盘子整体，借助 A 从 B 移动到 C
            Test.hanio(n - 1, b, a, c);
        }
    }

    public static void move(int n, char a, char b) {
        System.out.println("把第" + n + "个盘子从" + a + "移到" + b);
    }
}