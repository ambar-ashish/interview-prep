package string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;


//LC-49
public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap();
        for(String s : strs){
            char[] c = s.toCharArray();
            Arrays.sort(c);
            String ordered = String.valueOf(c);
            if(!map.containsKey(ordered)){
                map.put(ordered, new ArrayList());
            }
            List<String> temp = map.get(ordered);
            temp.add(s);
            map.put(ordered, temp);
        }
        List<List<String>> out = new ArrayList();
        for(List<String> list : map.values()){
            out.add(list);
        }
        return out;
    }
}
