package bitmanipulation;

//LC-136
public class SingleNumber {

    public int singleNumber(int[] nums) {
        int a = 0;
        for (int i : nums) {
            a ^= i;
        }
        return a;
    }
}

// a^0 = a
// a^a = 0
//hence, a^b^a = (a^a)^b = 0^b = b
