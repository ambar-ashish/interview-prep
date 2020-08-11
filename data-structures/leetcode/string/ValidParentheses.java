package string;

import java.util.Stack;

//LC-20
public class ValidParentheses {

    public boolean isValid(String s) {
        char open1 = '(';
        char close1 = ')';
        char open2 = '{';
        char close2 = '}';
        char open3 = '[';
        char close3 = ']';

        Stack<Character> st = new Stack();
        for(int i=0 ; i<s.length(); i++){
            if(s.charAt(i) == open1 || s.charAt(i) == open2 || s.charAt(i) == open3){
                st.push(s.charAt(i));
            }else if(s.charAt(i) == close1){
                if(st.isEmpty()){
                    return false;
                }else{
                    char c = st.pop();
                    if(c != open1){
                        return false;
                    }
                }
            }else if(s.charAt(i) == close2){
                if(st.isEmpty()){
                    return false;
                }else{
                    char c = st.pop();
                    if(c != open2){
                        return false;
                    }
                }
            }else if(s.charAt(i) == close3){
                if(st.isEmpty()){
                    return false;
                }else{
                    char c = st.pop();
                    if(c != open3){
                        return false;
                    }
                }
            }
        }
        if(st.isEmpty()){
            return true;
        }else{
            return false;
        }
    }
}
