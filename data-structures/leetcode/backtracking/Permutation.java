
public class Permutation {

    public static void permute(String s){
        recursivePermute(s, "");
    }

    public static void recursivePermute(String str, String ans){
        if(str.length() == 0){
            System.out.println(ans);
            return;
        }
        for(int i=0; i<str.length(); i++){
            String x = String.valueOf(str.charAt(i));
            String ros = str.substring(0, i) + str.substring(i+1);
            recursivePermute(ros, ans+x);
        }
    }

    public static void main(String[] args) {
        String s = "abc";
        permute(s);
    }
}
