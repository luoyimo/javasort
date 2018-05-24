package quicksort;

import java.util.Arrays;

/**
 * @Author huqi
 * @Description:
 * @Date Create In 17:33 2018/5/23 0023
 */
public class QuickSort {


    /**
     * 快速排序
     * <p>
     * 排序规则：
     * 数组：{6, 1, 7, 3, 4, 5, 8, 2, 9, 10}
     * 下标： 0  1  2  3  4  5  6  7  8  9
     * <p>
     * 1、选定第一个数作为基数base(a[0]=6)
     * 2、设定i和j分别为数组的左右下标
     * 3、当i<j时，从右至左进行筛选，找到第一个比基数小的数(a[7]=2)，j--。
     * 4、当i<j时，从左至右进行下一轮筛选，找到第一个比基数大的数(a[2]=7),i++。
     * 5、交换a[i]和a[j]的值(a[2]=2,a[2]=7)。
     * 6、再从a[j](a[6]=8)位置往左，找到比基数小的数（a[5]=5）。
     * 7、继续从a[i](a[3]=3)位置往右，找到比基数大的数(无)
     * 8、将基数和a[i](a[5])交换
     * 9、以i为中心，左右分别递归排序
     *
     * @param a
     * @param left
     * @param rigth
     */
    public static void quickSort(int[] a, int left, int rigth) {

        if (left > rigth) {
            return;
        }
        int base = a[left];
        int i = left;
        int j = rigth;
        int temp;

        while (i != j) {
            //当i<j时，从右至左进行筛选，找到第一个比基数小的数(a[7]=2)，j--。
            while (i < j && a[j] >= base) {
                j--;
            }
            //当i<j时，从左至右进行下一轮筛选，找到第一个比基数大的数(a[2]=7),i++。
            while (i < j && a[i] <= base) {
                i++;
            }

            //交换a[i]和a[j]的值(a[2]=2,a[2]=7)。
            if (i < j) {
                temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }

        }
        //将基数和a[i](a[5])交换
        a[left] = a[i];
        a[i] = base;

        quickSort(a, left, i - 1);
        quickSort(a, i + 1, rigth);

    }

    public static void main(String[] args) {
        int[] a = {6, 1, 7, 3, 4, 5, 8, 2, 9, 10};
        quickSort(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));
    }

}
