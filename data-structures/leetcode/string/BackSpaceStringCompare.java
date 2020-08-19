package string;

//LC-844
public class BackSpaceStringCompare {

    public boolean backspaceCompare(String S, String T) {
        String S1 = getString(S);
        String T1 = getString(T);
        return S1.equals(T1);
    }

    public String getString(String s){
        StringBuffer sb = new StringBuffer();
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '#' && sb.length() != 0){
                sb.deleteCharAt(sb.length()-1);
            }else if(s.charAt(i) != '#'){
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}
