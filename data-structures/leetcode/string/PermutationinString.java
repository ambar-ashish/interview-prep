package string;

//LC-567
public class PermutationinString {

    public boolean checkInclusionMySolution(String s1, String s2) {
        if(s1.length() == 0  || s2.length() == 0){
            return false;
        }
        int l1 = s1.length()-1;
        int l2 = s2.length()-1;
        for(int i=0; i<=l2-l1; i++){
            String sub = s2.substring(i, i+l1+1);
            if(isValid(s1, sub)){
                return true;
            }
        }
        return false;
    }

    public boolean isValid(String s1, String s2){
        int[] res = new int[26];
        for(int i=0; i<s1.length();i++){
            res[s1.charAt(i) - 'a']++;
            res[s2.charAt(i) - 'a']--;
        }
        for(int i : res){
            if(i!=0){
                return false;
            }
        }
        return true;
    }

    //Time Complexity - O(n1 + 26 * n1 * (n2-n1))
    //Space Complexity - O(1)
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length())
            return false;
        int[] s1map = new int[26];
        for (int i = 0; i < s1.length(); i++)
            s1map[s1.charAt(i) - 'a']++;
        for (int i = 0; i <= s2.length() - s1.length(); i++) {
            int[] s2map = new int[26];
            for (int j = 0; j < s1.length(); j++) {
                s2map[s2.charAt(i + j) - 'a']++;
            }
            if (matches(s1map, s2map))
                return true;
        }
        return false;
    }

    public boolean matches(int[] s1map, int[] s2map) {
        for (int i = 0; i < 26; i++) {
            if (s1map[i] != s2map[i])
                return false;
        }
        return true;
    }
}
