package sample;

public class Sorts {

    public static <T extends Comparable<? super T>> void heapSort(T[] array) {
        int n = array.length;
        //Turn the array into a heap
        for(int i = n /2 - 1; i >= 0; i--){
            heapify(array,n,i);
        }
        // Remove top items from the heap and switch the top w/ next item in list
        for(int i = n-1; i>= 0; i--){
            T swap = array[0];
            array[0] = array[i];
            array[i] = swap;
            //resort the tree minus the items that have already been sorted
            heapify(array, i, 0);
        }
    }
    //n is the size of heap and i is the index of the node being checked
    private static <T extends Comparable<? super T>> void heapify(T[] arr, int n, int i){
        int largest = i;
        int left = 2*i +1;
        int right = 2*i + 2;
        //check the children of the node to see if they're larger
        //if any of the children are larger then swap them with the parent
        if (left < n && arr[left].compareTo(arr[largest])>0){
            largest = left;
        }
        if (right < n && arr[right].compareTo(arr[largest])>0){
            largest = right;
        }
        //if the root is not the largest then swap the node with the largest and resort the heap
        if(largest != i){
            T swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            heapify(arr, n, largest);
        }
    }
}