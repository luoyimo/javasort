package quicksort;

/**
 * @Author huqi
 * @Description:
 * @Date Create In 10:15 2018/5/24 0024
 */
public class HeapSort {
    public static void main(String[] args) {
        int[] a = {4, 6, 8, 5, 9};
        heapSort(a);
    }


    /**
     * 堆排序
     * <p>
     * 数组：{4, 6, 8, 5, 9}
     * 下标： 0  1  2  3  4
     * 见图：堆.png
     * <p>
     * 排序规则
     * 1、从第一个非叶子结点开始(i=a.length/2-1,即a[1])，从左至右，从下至上进行调整
     * 2、从i的子节点开始(即k=2*i+1)，a[k]<a[k+1]即左叶节点小于右叶节点，将k只想指向右节点
     * 3、如果子节点的值大于父节点的值(即a[k]>a[i]),将子节点(a[k])的值赋给父节点(a[i])
     * 4、结束循环，将非叶子节点的值放到最终的位置
     * 5、交换堆顶元素和末尾元素、继续循环
     *
     * @param a
     */
    public static void heapSort(int[] a) {
        // 从第一个非叶子结点开始(i=a.length/2-1,即a[1])，从左至右，从下至上进行调整
        for (int i = a.length / 2 - 1; i >= 0; i--) {
            //从左至右
            adjust(a, i, a.length);
        }


        //交换堆顶元素和末尾元素、继续循环
        for (int j = a.length - 1; j > 0; j--) {
            int t1 = a[0];
            a[0] = a[j];
            a[j] = t1;
            adjust(a, 0, j);

        }


    }

    public static void adjust(int[] a, int i, int length) {

        //先取出当前元素i
        int temp = a[i];
        //从i结点的左子结点开始，也就是2i+1处开始
        for (int k = 2 * i + 1; k < length; k = 2 * k + 1) {
            //如果左子结点小于右子结点，k指向右子结点
            if (k + 1 < length && a[k] < a[k + 1]) {
                k++;
            }

            //如果子节点大于父节点，将子节点值赋给父节点（不用进行交换）
            if (a[k] > temp) {
                a[i] = a[k];
                i = k;
            } else {
                break;
            }
        }
        //将temp值放到最终的位置
        a[i] = temp;
    }


}
