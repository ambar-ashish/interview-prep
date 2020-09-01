package binarysearch;

//LC-278
public class FirstBadVersion {

    //Time Complexity - O(logn)
    //Space Complexity - O(1)
    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;//can return either right or left as both will eventually meet and it is the terminating condition
    }

    public boolean isBadVersion(int i){
        return true;
    }
}
