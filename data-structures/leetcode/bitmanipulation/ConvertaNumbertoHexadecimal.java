package bitmanipulation;

//LC-405
public class ConvertaNumbertoHexadecimal {

        /*
        Basic idea: each time we take a look at the last four digits of
        binary verion of the input, and maps that to a hex char
        shift the input to the right by 4 bits, do it again
        until input becomes 0.
        */
        //if use bit operation >>> other than >>, you don't have to worry about the sign
    char[] map = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};

    public String toHexUsingBitOperation(int num) {
        if(num == 0)
            return "0";
        String result = "";
        while(num != 0){
            result = map[(num & 15)] + result;//extract last 4 bits at a time////to get hex for last 4 bits of num, use mask 15, which is '1111' in bits
            num = (num >>> 4);//right shift along with sign bit
        }
        return result;
    }

    //15 decimal is 1111 in binary. By anding (&) 1111 and the input number, you basically get the
    // last 4 binary digits of the input number.
    //
    //e.g. input number is decimal 33. In binary 33 is 0010 0001. So, 0010 0001 & 0000 1111 = 0000 0001.
    // See how we got only the last 4 digits of the input number? Hope this explains.
    // The solution has already taken negative input into consideration by using the unsigned shift ">>>" as opposed to ">>"

    //Approach: Shifting and Masking
    //
    //Number is masked against binary of 1111 each time to get the component value which is then mapped to
    // corresponding character. >>> is used to right-shifted `4` bit positions with zero-extension. The zero-extension will naturally deal with negative number.
    //
    //StringBuilder is used due to its efficiently in inserting character to existing StringBuilder object.
    // If normal String is used then each insertion by + operation will have to copy over the immutable String object which is highly inefficient.
    //
    //For Integer.MAX_VALUE or Integer.MIN_VALUE or any input with 8 Hexadecimal characters
    // where the iterations would last the longest. For Integer.MAX_VALUE the algorithm will run for at most `ceil(log_16 (2^31 - 1) + 1) = 8` times.

    public String toHex(int num) {
        StringBuilder sb = new StringBuilder();
        if (num == 0) return sb.append(0).toString();
        int sign = 1;
        int bitNum = 8;
        if (num < 0) {
            num = -num - 1;
            sign = -1;
        }

        while (sign == 1 && num != 0) {  // num is positive
            int rest = num % 16;
            if (rest < 10) {
                sb.insert(0, rest);
            } else {
                sb.insert(0, (char)('a' + rest - 10));
            }
            num /= 16;
        }

        while (sign == -1 && bitNum > 0) {  // num is negative
            int rest = num % 16;
            if (rest < 6) {
                sb.insert(0, (char)('f' - rest));
            } else {
                sb.insert(0, 15 - rest);
            }
            num /= 16;
            bitNum--;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        ConvertaNumbertoHexadecimal convert = new ConvertaNumbertoHexadecimal();
        System.out.println(convert.toHexUsingBitOperation(26));//1a
        //System.out.println(convert.toHex(-1));//ffffffff
    }
}
