public class Main {

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 4, 6, 7, 0, 2, 6, 4,2,7,3,1,1,2,4,6,7};
        heapsort(arr);
        for(int i : arr) System.out.print(i + " ");
        
    }
    
    public static void heapsort(int[] arr){
        arrToMaxheap(arr);
        int n = arr.length;
        for(int i = n-1; i>0; i--){
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapifydown(arr, 0, i);
        }

        
    }


    public static void arrToMaxheap(int[] arr){
        for(int i = arr.length-1; i>=0; i--){
            heapifydown(arr, i, arr.length);
        }
    }

    public static void heapifydown(int[] arr, int i, int max){
            int min = i;
            int l = (2*i) + 1;
            int r = (2*i) + 2;

            if(l<max && arr[min] < arr[l]){
                min = l;
            }
            if(r<max && arr[min] < arr[r]){
                min = r;
            }

            if(i != min){
                int temp = arr[min];
                arr[min] = arr[i];
                arr[i] = temp;
                heapifydown(arr, min, max);
            }
    }


}





