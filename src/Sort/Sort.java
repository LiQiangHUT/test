package Sort;

public class Sort {
    static int count = 0;
    public static void main(String[] args) {
        //int[] numbers={1,5,6,1,2,1,8,9,6,7,4,8,9,4,3,5,2,1,3,2};
        //int[] numbers={5,0,6,5,5,3,5,2,5,9,8,5,1,7,4};
        int[] numbers={5,5,5,5,5,5,5,5,5,5,5,5,5,5};
        for (int a:numbers) {
            System.out.print(a);
        }

        System.out.println("lenght:"+numbers.length);
        //bubbleSort01(numbers);
        //bubbleSort(numbers);
        //quickSort(numbers,0,9);
        quickSort01(numbers,0,numbers.length-1);
        //insertSort(numbers);
        System.out.print("end:");
        for (int a:numbers) {
            System.out.print(a);
        }
        System.out.println();
        System.out.println("lenght:"+numbers.length+"  count:"+count);

    }

    /**
     *  冒泡法排序 时间复杂度O(n)
     *  比较相邻的元素。如果第一个比第二个小，就交换他们两个。
     *  对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对。在这一点，最后的元素应该会是最小的数。
     *  针对所有的元素重复以上的步骤，除了最后一个。
     *  持续每次对越来越少的元素重复上面的步骤，直到没有任何一对数字需要比较。

     *
     * @param numbers
     *            需要排序的整型数组
     */
    public static void bubbleSort01(int[] numbers) {
        int temp; // 记录临时中间值
        int size = numbers.length; // 数组大小

        for (int i = 0; i < size - 1; i++) {
            for (int j = i + 1; j < size; j++) {
                //System.out.println("i:"+i+" n[i]: "+numbers[i]);
                //System.out.println("j:"+j+" n[j]: "+numbers[j]);
                count++;
                if (numbers[i] < numbers[j]) { // 交换两数的位置
                    temp = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = temp;
                    for (int n:numbers) {
                        System.out.print(n);
                    }
                    System.out.println();
                }
            }
        }
    }

    /**
     * 以上不知是什么排序，将基准位置的元素和后面的元素进行比较，如果基准位置值比后面元素小，则交换位置，交换后的元素为新的基准元素。以下才是真正的冒泡排序。
     * @param a
     */
    public static void bubbleSort(int[] a) {
        int temp;
        int size = a.length;
        for(int i=1; i<size; i++) {
            //System.out.print("num:"+i+"   ");
            for(int j=0; j<size-i; j++) {
                //System.out.println("  j: "+j+"  n[j]: "+a[j]);
                //System.out.println("j+1: "+(j+1)+"  n[j+1]: "+a[j+1]);
                count++;
                if(a[j] < a[j+1]) {
                    temp = a[j];
                    a[j]=a[j+1];
                    a[j+1]=temp;
                }
                for(int aa : a)
                    System.out.print(aa+",");
                System.out.println();
            }
        }
    }
    /**
     * 快速排序
     *
     *  从数列中挑出一个元素，称为“基准”
     *  重新排序数列，所有元素比基准值小的摆放在基准前面，所有元素比基准值大的摆在基准的后面（相同的数可以到任一边）。在这个分割之后，
     *  该基准是它的最后位置。这个称为分割（partition）操作。
     *  递归地把小于基准值元素的子数列和大于基准值元素的子数列排序。
     *
     * @param numbers
     * @param start
     * @param end
     */
    public static void quickSort(int[] numbers, int start, int end) {
        if (start < end) {
            int base = numbers[start]; // 选定的基准值（第一个数值作为基准值）
            System.out.println("base:  "+base);
            int temp; // 记录临时中间值


            int i = start, j = end;
            do {
                while ((numbers[i] < base) && (i < end))
                    i++;
                while ((numbers[j] > base) && (j > start))
                    j--;
                System.out.println("i:"+i+" j:"+j);
                if (i <= j) {
                    temp = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = temp;
                    i++;
                    j--;
                }
                count++;
/*                for (int n:numbers){
                    System.out.print(n);
                }*/
                //System.out.println();
            } while (i <= j);
            System.out.println("break");
            if (start < j)
                quickSort(numbers, start, j);
            if (end > i)
                quickSort(numbers, i, end);
        }
    }

    /**
     * 如下为完全符合快速排序定义的算法：
     * @param a
     * @param start
     * @param end
     */
    public static void quickSort01(int[] a, int start, int end) {
        if(start >= end)
            return;
        int i = start;
        int j = end;
        int base = a[start];
        while(i != j) {
            while(a[j] >= base && j > i)
                j--;//找到右边第一个比基数小的a[j]
            while(a[i] <= base && i < j)
                i++;//找到左边第一个比基数大的a[i]
            System.out.println("i j "+i+" "+j);
            if(i < j) {
                //左边比基数大的和右边比基数小的互换
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
            //i不小于j 则此时所有比基数小的都换到了i左边,所有比基数大的都换到了i右边 a[i]<=基数
            //互换之后a[i]为比基数小的
        }
        //i及i左侧的数都<=基数  将a[i]与基数互换 则基数左边都是比基数小的数 基数右边都是比基数大的数
        a[start] = a[i];
        a[i] = base;
        quickSort01(a, start, i - 1);//对左边再进行快速排序
        quickSort01(a, i + 1, end);//对右边再进行快速排序
    }
    /**
     * 选择排序
     * 在未排序序列中找到最小元素，存放到排序序列的起始位置
     * 再从剩余未排序元素中继续寻找最小元素，然后放到排序序列起始位置。
     * 以此类推，直到所有元素均排序完毕。
     *
     * @param numbers
     */
    public static void selectSort(int[] numbers) {
        int size = numbers.length;
        int temp;
        for (int i = 0; i < size; i++) {
            int k = i;
            for (int j = size - 1; j >i; j--)  {
                if (numbers[j] < numbers[k]) {
                k = j;
                }
            }
            temp = numbers[i];
            numbers[i] = numbers[k];
            numbers[k] = temp;
        }
    }
    /**
     * 插入排序
     *
     *  从第一个元素开始，该元素可以认为已经被排序
     *  取出下一个元素，在已经排序的元素序列中从后向前扫描
     *  如果该元素（已排序）大于新元素，将该元素移到下一位置
     *  重复步骤3，直到找到已排序的元素小于或者等于新元素的位置
     *  将新元素插入到该位置中
     *  重复步骤2
     * @param numbers
     */
    public static void insertSort(int[] numbers) {
        int size = numbers.length, temp, j;
        for(int i=1; i<size; i++) {
            temp = numbers[i];
            for(j = i; j > 0 && temp < numbers[j-1]; j--)
                numbers[j] = numbers[j-1];
            numbers[j] = temp;
        }
    }
    /**
     * 归并排序
     *
     *  申请空间，使其大小为两个已经排序序列之和，该空间用来存放合并后的序列
     *  设定两个指针，最初位置分别为两个已经排序序列的起始位置
     *  比较两个指针所指向的元素，选择相对小的元素放入到合并空间，并移动指针到下一位置
     *  重复步骤3直到某一指针达到序列尾
     *  将另一序列剩下的所有元素直接复制到合并序列尾
     *
     * @param numbers
     */
    public static void mergeSort(int[] numbers, int left, int right) {
        int t = 1;// 每组元素个数
        int size = right - left + 1;
        while (t < size) {
            int s = t;// 本次循环每组元素个数
            t = 2 * s;
            int i = left;
            while (i + (t - 1) < size) {
                merge(numbers, i, i + (s - 1), i + (t - 1));
                i += t;
            }
            if (i + (s - 1) < right)
                merge(numbers, i, i + (s - 1), right);
        }
    }
    /**
     * 归并算法实现
     *
     * @param data
     * @param p
     * @param q
     * @param r
     */
    private static void merge(int[] data, int p, int q, int r) {
        int[] B = new int[data.length];
        int s = p;
        int t = q + 1;
        int k = p;
        while (s <= q && t <= r) {
            if (data[s] <= data[t]) {
                B[k] = data[s];
                s++;
            } else {
                B[k] = data[t];
                t++;
            }
            k++;
        }
        if (s == q + 1)
            B[k++] = data[t++];
        else
            B[k++] = data[s++];
        for (int i = p; i <= r; i++)
            data[i] = B[i];
    }
}
