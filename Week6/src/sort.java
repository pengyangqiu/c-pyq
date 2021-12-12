//没时间了  这块是借鉴的网上

public class sort {
    public static  void main(String args[]){
       int a[]={12,54,2,1,3,1,5,4,1,3,5};
        bubble_sort(a);
        randomnum(a);
        insert_sort(a);
        randomnum(a);

        quick_sort(a,0,a.length-1);
        System.out.println("快速排序结果为:");
        for(int k=0;k<a.length;k++){
            System.out.print(a[k]+" ");
        }
        System.out.println();
        merge_sort(a,0,(0+a.length)/2,a.length-1);
        System.out.println("归并排序结果为:");
        for(int k=0;k<a.length;k++){
            System.out.print(a[k]+" ");
        }
        System.out.println();
        heap_sort(a);
        System.out.println("堆排序结果为:");
        for(int k=0;k<a.length;k++){
            System.out.print(a[k]+" ");
        }

    }
    public static  void bubble_sort(int numbers[]){
        for(int i=0;i<numbers.length-1;i++)
        {
            for(int j=0;j<numbers.length-1-i;j++)
            {
                if(numbers[j]>numbers[j+1])
                {
                    int temp=numbers[j];
                    numbers[j]=numbers[j+1];
                    numbers[j+1]=temp;
                }
            }
        }
        System.out.println("冒泡排序结果为:");
        for(int i=0;i<numbers.length;i++){
            System.out.print(numbers[i]+" ");
        }
        System.out.println();
    }
    public static void insert_sort(int numbers[]){
        int i, j;
        int n = numbers.length;
        int target;
        for (i = 1; i < n; i++)
        {
            j = i;
            target = numbers[i];

            while (j > 0 && target < numbers[j - 1])
            {
                numbers[j] = numbers[j - 1];
                j--;
            }

            numbers[j] = target;
        }
        System.out.println("插入排序结果为:");
        for(int k=0;k<numbers.length;k++){
            System.out.print(numbers[k]+" ");
        }
        System.out.println();
    }

    public  static  void quick_sort(int numbers[],int left,int right){

        int i,j,temp,t;
        if(left>right){
            return;
        }
        i=left;
        j=right;
        temp = numbers[left];
        while (i<j) {
            while (temp<=numbers[j]&&i<j) {
                j--;
            }
            while (temp>=numbers[i]&&i<j) {
                i++;
            }
            if (i<j) {
                t = numbers[j];
                numbers[j] = numbers[i];
                numbers[i] = t;
            }

        }
        numbers[left] = numbers[i];
        numbers[i] = temp;
        quick_sort(numbers, left, j-1);
        quick_sort(numbers, j+1, right);



    }

    public  static  void merge_sort(int[] a, int low, int mid, int high){
        int[] temp = new int[high-low+1];
        int i= low;
        int j = mid+1;
        int k=0;
        while(i<=mid && j<=high){
            if(a[i]<a[j]){
                temp[k++] = a[i++];
            }else{
                temp[k++] = a[j++];
            }
        }
        while(i<=mid){
            temp[k++] = a[i++];
        }
        while(j<=high){
            temp[k++] = a[j++];
        }
        for(int x=0;x<temp.length;x++){
            a[x+low] = temp[x];
        }
    }


    public static int[] sort(int[] a,int low,int high){
        int mid = (low+high)/2;
        if(low<high){
            sort(a,low,mid);
            sort(a,mid+1,high);
            merge_sort(a,low,mid,high);
        }
        return a;
    }

    public static void heap_sort(int[] arr){
        if (arr ==null ||arr.length<=1) {
            return;
        }
        CreateHead(arr);
        for (int i = arr.length-1; i >=1; i--) {
            swap(arr, 0, i);
            MaxHead(arr,i,0);
        }

    }
    public static void swap(int[] arr,int x,int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }
    public static void CreateHead(int[] arr) {
        int parent =arr.length/2-1;//找到最后一个有孩子的节点
        for(int i =parent;i>=0;i--) {
            MaxHead(arr,arr.length,i);//调用交换节点数据的方法，将最大的数移到顶端节点
        }
    }
    public static void MaxHead(int[] arr,int length,int index) {
        int left =2*index+1;//左孩子
        int right =2*index+2;//右孩子
        int maxindex =index;//最大数

        if (left<length && arr[left] < arr[maxindex]) {
            maxindex = left;
        }if (right<length && arr[right] < arr[maxindex]) {
            maxindex = right;
        }if (maxindex!=index) {
            swap(arr,index,maxindex);
            MaxHead(arr,length, maxindex);
        }

    }
    public static void randomnum(int a[]){
        for(int i=0;i<a.length;i++){
            a[i]= (int) (Math.random()*10);
        }

    }


}
