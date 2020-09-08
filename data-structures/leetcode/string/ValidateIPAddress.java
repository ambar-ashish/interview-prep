package string;

//LC-468
public class ValidateIPAddress {

    // When n is the length of IP
    public String validIPAddress(String IP) {
        // O(n)
        if (isIPv4(IP)) return "IPv4";
        // impressive toUpperCase(): O(n)
        if (isIPv6(IP.toUpperCase())) return "IPv6";

        return "Neither";
    }

    private boolean isIPv4(String IP) {
        // 1. dot num
        int dotNum = 0;
        for (int i = 0; i < IP.length(); i++) {
            if (IP.charAt(i) == '.') dotNum++;
        }
        if (dotNum != 3) return false;

        // 2. number of fields
        // . is special character in regular expression,
        // so we need "\\." because ...
        // \\ -> will be interpreted as \ escape character
        // \. -> will be interpreted as .
        String[] fields = IP.split("\\.");
        if (fields.length != 4) return false;

        // 3. each field
        for (String field : fields) {
            // 3.1 length of each field
            if (field.isEmpty() || field.length() > 3) {
                return false;
            }

            // 3.2 each character of each field should contain only digit!!
            int fieldLen = field.length();
            for (int i = 0; i < fieldLen; ++i) {
                if (!Character.isDigit(field.charAt(i))) {
                    return false;
                }
            }

            // 3.3 check digit is within range [0, 255]
            // After we have confirmed that each character of each field is digit
            // we can now convert String into Integer
            // Integer.valueOf(String) -> Integer vs Integer.setInt(String) -> int
            int num = Integer.valueOf(field);
            // 01.01.01.01 String.valueOf(num).equals(field) is for the cases like 0001
            // Any number that has in front.
            if (!String.valueOf(num).equals(field) || num < 0 || num > 255) {
                return false;
            }
        }

        return true;
    }

    private boolean isIPv6(String IP) {
        // 1. colon num
        int colonNum = 0;
        for (int i = 0; i < IP.length(); i++) {
            if (IP.charAt(i) == ':') colonNum++;
        }
        if (colonNum != 7) return false;

        // 2. number of fields
        String[] fields = IP.split(":");
        if (fields.length != 8) return false;

        // 3. each field
        for (String field : fields) {
            // 3.1 length of field
            if (field.isEmpty() || field.length() > 4) {
                return false;
            }

            // 3.2 check whether it is digit as well as character range from 'A' to 'F'(Hex).
            int fieldLen = field.length();
            for (int i = 0; i < fieldLen; ++i) {
                if (!Character.isDigit(field.charAt(i)) && (field.charAt(i) < 'A' || field.charAt(i) > 'F')) {
                    return false;
                }
            }
        }

        return true;
    }
}
