import java.util.Random;
public class SortingAlgorthim
{
    public static void main(String[]args){
        int[] array = randArray(50);
        mergeSort(array,50);
        printArray(array); 
    }

    public static int[] randArray(int length){
        int[] array = new int[length];
        Random random=new Random();
        int last = random.nextInt(10);
        array[0]=last;
        for (int i=1;i<array.length;i++){
            array[i]=random.nextInt(100);
        }
        return array;  
    }

    public static void printArray(int[]array){
        for(int i=0;i<array.length;i++){
            System.out.println(array[i]);
        }
    }

    public static int[] nonDecrecing(int length){
        int[] array = new int[length];
        Random random=new Random();
        int last = random.nextInt(10);
        array[0]=last;
        for (int i=1;i<array.length;i++){
            array[i]=last+random.nextInt(10);
            last = array[i];
        }
        return array;

    }

    public static int binarySearch(int[]array,int num){
        int highIndex=array.length-1;
        int lowIndex=0;
        int index;
        while (highIndex>=lowIndex){
            index = (highIndex+lowIndex)/2;
            if (array[index]==num){
                return index;
            }
            else if (array[index]<num){
                lowIndex=index+1;
            }
            else if (array[index]>num){
                highIndex=index-1;
            }
        }
        return-1;
    }

    public static int[] bubbleSort(int[]array){
        int n=array.length;
        int temp;
        int counter=0;
        for (int i =1;i<n;i++){
            for (int j=1;j<=n-i;j++){//n-1 can reduce the time by 1/2 SO DON'T REMOVE IT 
                if(array[j]<array[j-1]){
                    temp = array[j];
                    array[j]=array[j-1];
                    array[j-1]=temp;
                    counter++;
                }
            }
            if (counter==0){
                break;
            }
            counter=0; 
        }
        return array;
    }

    public static int[] selectionSort(int[]array){
        for (int i = 0; i < array.length - 1; i++)
        {
            int index = i;
            for (int j = i + 1; j < array.length; j++){
                if (array[j] < array[index]){ 
                    index = j;
                    int smallerNumber = array[index];  
                    array[index] = array[i];
                    array[i] = smallerNumber;
                }
            }
        }
        return array;
    }

    public static int[] insertionSort(int[]array){
        int temp;
        for (int i = 1; i < array.length; i++) {
            for(int j = i ; j > 0 ; j--){
                if(array[j] < array[j-1]){
                    temp = array[j];
                    array[j] = array[j-1];
                    array[j-1] = temp;
                }
            }
        }    
        return array;
    }

    public static void mergeSort(int[] a, int n) {
        if (n < 2) {
            return;
        }
        int mid = n / 2;
        int[] l = new int[mid];
        int[] r = new int[n - mid];

        for (int i = 0; i < mid; i++) {
            l[i] = a[i];
        }
        for (int i = mid; i < n; i++) {
            r[i - mid] = a[i];
        }
        mergeSort(l, mid);
        mergeSort(r, n - mid);
        
        merge(a, l, r, mid, n - mid);
    }

    public static void merge(int[] a, int[] l, int[] r, int left, int right) {

        int i = 0, j = 0, k = 0;
        while (i < left && j < right) {
            if (l[i] <= r[j]) {
                a[k++] = l[i++];
            }
            else {
                a[k++] = r[j++];
            }
        }
        while (i < left) {
            a[k++] = l[i++];
        }
        while (j < right) {
            a[k++] = r[j++];
        }
    }
}
