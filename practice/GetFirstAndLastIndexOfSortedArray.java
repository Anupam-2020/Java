public class GetFirstAndLastIndexOfSortedArray {
    static int getFirstPosition(int arr[], int key) {
        int start = 0;
        int end = arr.length - 1;
        int mid = end - (end - start)/2;
        int result = -1;
        if(arr[0] == key) return 0;
        while (start <= end) {
            if(arr[mid] > key) {
                end = mid - 1;
            } else if(arr[mid] < key) {
                start = mid + 1;
            } else {
                result = mid;
                end = mid - 1;
            }
            mid = end - (end - start) / 2;
        }
        return result;
    }

    static int getLastPosition(int arr[], int key) {
        int start = 0;
        int end = arr.length - 1;
        int mid = end - (end - start) / 2;
        int result = -1;
        while (start < end) {
            if(arr[mid] > key) {
                end = mid - 1;
            } else if(arr[mid] < key) {
                start = mid + 1;
            } else {
                result = mid;
                start = mid + 1;
            }
            mid = end - (end - start) / 2;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] first = {3,3,3,3,3,3,4,5,5,5,5,5,5};
        System.out.println(getFirstPosition(first, 3));
        System.out.println(getLastPosition(first, 3));
    }
}