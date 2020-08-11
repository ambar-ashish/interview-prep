package string;

//LC-344
public class ReverseString {

    //Time Complexity - O(N) where N is the number of characters
    //Space Complexity - O(1)
    public void reverseString(char[] s) {
        int low = 0;
        int high = s.length - 1;
        while(low < high){
            char temp = s[low];
            s[low] = s[high];
            s[high] = temp;
            low++;
            high--;
        }
    }
}
