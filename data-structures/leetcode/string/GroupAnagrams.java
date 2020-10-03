package string;

import java.util.*;


//LC-49
public class GroupAnagrams {

    //Time Complexity: O(NKlogK) where N is the length of strs, and K is the maximum length of a string in strs.
    // The outer loop has complexity O(N) as we iterate through each string. Then, we sort each string in
    //O(KlogK) time.
    //Space Complexity - Space Complexity: O(NK), the total information content stored in ans
    public List<List<String>> groupAnagramsSubOptimal(String[] strs) {
        HashMap<String, List<String>> map = new HashMap();
        for(String s : strs){
            char[] c = s.toCharArray();
            Arrays.sort(c);
            String ordered = String.valueOf(c);
            if(!map.containsKey(ordered)){
                map.put(ordered, new ArrayList());
            }
            map.get(ordered).add(s);
        }
        return new ArrayList<>(map.values());
    }

    //Time Complexity - O(N*K)
    //Space Complexity - O(N*K)
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0)
            return new ArrayList();
        Map<String, List<String>> ans = new HashMap();
        int[] count = new int[26];
        for (String s : strs) {
            Arrays.fill(count, 0);
            for (char c : s.toCharArray())
                count[c - 'a']++;

            StringBuilder sb = new StringBuilder("");
            for (int i = 0; i < 26; i++) {
                sb.append('#');
                sb.append(count[i]);
            }
            String key = sb.toString();
            if (!ans.containsKey(key)) {
                ans.put(key, new ArrayList());
            }
            ans.get(key).add(s);
        }
        return new ArrayList(ans.values());
    }
}
