package string;

//LC-161
public class OneEditDistance {

    //https://leetcode.com/problems/one-edit-distance/discuss/50107/Accepted-clean-Java-solution-with-explanation-(two-pointers)
    public boolean isOneEditDistance(String s, String t) {
        if (s == null || t == null)
            return false;

        if (s.length() > t.length())
            return isOneEditDistance(t, s);

        int i = 0;
        while (i < s.length()) {
            if (s.charAt(i) != t.charAt(i)) {
                // we try to replace s[i] with s[j] or insert s[j] to s[i]
                // then compare the rest and see if they are the same
                return s.substring(i + 1).equals(t.substring(i + 1)) ||
                        s.substring(i).equals(t.substring(i + 1));
            }
            i++;
        }
        return t.length() - i == 1;
    }
}
