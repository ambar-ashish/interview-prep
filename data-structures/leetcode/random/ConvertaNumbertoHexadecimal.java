package random;

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
        if(num == 0) return "0";
        String result = "";
        while(num != 0){
            result = map[(num & 15)] + result;//extract last 4 bits at a time////to get hex for last 4 bits of num, use mask 15, which is '1111' in bits
            num = (num >>> 4);//right shift along with sign bit
        }
        return result;
    }

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
