package binarysearch;

public class BinarySearch {

    //Classic Binary search
    public int search(int[] a, int element){
        int low = 0;
        int high = a.length;
        while(low <= high){
            int mid = low + (high-low)/2;//to prevent integer overflow
            if(a[mid] == element){
                return mid;
            }else if(a[mid] > element){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] a = {1,2,3,4,5};
        int element = 2;
        BinarySearch binarySearch = new BinarySearch();
        System.out.println("Index of element "+binarySearch.search(a, element));
    }
}
