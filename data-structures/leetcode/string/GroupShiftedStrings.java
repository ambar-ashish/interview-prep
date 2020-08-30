package string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//LC-249
public class GroupShiftedStrings {

    public List<List<String>> groupStrings(String[] strings) {
        Map<String, List<String>> map = new HashMap<>();

        for(String s : strings) {
            String key = getKey(s);
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(s);
            map.put(key, list);
        }
        return new ArrayList<>(map.values());
    }

    private String getKey(String s) {
        char[] chars = s.toCharArray();
        String key = "";
        for(int i = 1; i < chars.length; i++) {
            int diff = chars[i] - chars[i-1];
            key += diff < 0 ? diff + 26 : diff;
            key += ",";
        }
        return key;
    }
}

//Basically we need to form some sort of key for each word to group them. (Remember the idea of group all anagrams?)
//Consider acf and pru. Now notice the difference between each characters.
//acf = 0->2->3, and pru = 0->2->3. So these two form same group. So in this case, you can simply use
// integers ASCII difference to form key.
