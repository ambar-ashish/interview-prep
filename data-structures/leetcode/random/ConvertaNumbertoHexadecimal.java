package random;

//LC-405
public class ConvertaNumbertoHexadecimal {

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
        System.out.println(convert.toHex(26));//1a
        //System.out.println(convert.toHex(-1));//ffffffff
    }
}
