package bitmanipulation;

//LC-476
public class NumberComplement {

    //Time Complexity - O(1), since we're doing not more than 32 iterations here.
    //Space Complexity - O(1)
    public int findComplement(int num) {
        int todo = num, bit = 1;
        while (todo != 0) {
            // flip current bit
            num = num ^ bit;
            // prepare for the next run
            bit = bit << 1;
            todo = todo >> 1;
        }
        return num;
    }
}
