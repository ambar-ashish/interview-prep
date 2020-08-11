package string;

//LC-186
public class ReverseWordsinaStringII {

    //Time Complexity - O(N) where N is the number of characters
    //Space Complexity - O(N)
    public void reverseWords(char[] s) {
        String word = String.valueOf(s);
        String[] array = word.split(" ");
        StringBuffer sb = new StringBuffer();
        for(int i=array.length - 1; i >=0 ; i--){
            sb.append(array[i]);
            sb.append(" ");
        }
        String out = sb.toString().trim();
        for(int i=0; i<s.length; i++){
            s[i] = out.charAt(i);
        }
    }
}
