package string;

import java.util.ArrayList;
import java.util.List;

//LC-438
public class FindAllAnagramsinaString {

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList();
        if(s.length() == 0 || p.length() == 0){
            return list;
        }
        for(int i=0 ; i<=s.length()-p.length(); i++){
            String sub = s.substring(i, i+p.length());
            if(isAnagram(sub, p)){
                list.add(i);
            }
        }
        return list;
    }

    public boolean isAnagram(String str1, String str2){
        int[] result = new int[26];
        for(int i=0; i<str1.length(); i++){
            result[str1.charAt(i) - 'a']++;
            result[str2.charAt(i) - 'a']--;
        }
        for(int i : result){
            if(i != 0){
                return false;
            }
        }
        return true;
    }
}
