public class FindPeakOfMountain {
    static int findPeakOfMountain(int arr[]) {
        int start = 0;
        int end = arr.length - 1;
        int mid = start + (end - start)/2;
        while (start <= end) {
            if(mid == arr.length-1) {
                return arr[mid];
            } else if(mid == 0) {
                return arr[mid];
            } else if(arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) {
                return arr[mid];
            } else if(arr[mid] > arr[mid+1]) {
                end = mid;
            } else {
                start = mid+1;
            }
            mid = start + (end - start)/2;
        }
        return 0;
    }

    public static void main(String[] args) {
        // int arr[] = {2,16,17,19,45,23};
        int arr[] = {1,2,3};
        // int arr[] = {45, 23, 19, 17, 16, 2};
        System.out.println(findPeakOfMountain(arr));
    }
}
