package string;

//LC-151
public class ReverseWordsinaString {

    //Time Complexity - O(N) where N is the number of characters in the string
    //Space Complexity - O(N)
    public String reverseWords(String s) {
        String[] x = s.split("\\s+");
        StringBuffer sb = new StringBuffer();
        for(int i=x.length-1; i>=0;i--){
            sb.append(x[i]);
            sb.append(" ");
        }
        return sb.toString().trim();
    }
}
