package bitmanipulation;

//LC-191
public class Numberof1Bits {

    //Time Complexity - O(1) since the run time depends on number of bits in n. And is a 32 bit integer
    //Space Complexity - O(1)
    //you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int bits = 0;
        int mask = 1;
        for (int i = 0; i < 32; i++) {
            if ((n & mask) != 0) {
                bits++;
            }
            mask <<= 1;
        }
        return bits;
    }
}
