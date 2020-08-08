package backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//LC-17
public class LetterCombinationsofaPhoneNumber {

    HashMap<String, String> phone = new HashMap<String, String>() {{
        put("2", "abc");
        put("3", "def");
        put("4", "ghi");
        put("5", "jkl");
        put("6", "mno");
        put("7", "pqrs");
        put("8", "tuv");
        put("9", "wxyz");
    }};

    List<String> output = new ArrayList<String>();

    public List<String> letterCombinations(String digits) {
        if (digits.length() != 0)
            backtrack("", digits);
        return output;
    }

    public void backtrack(String combination, String next_digits) {
        // if there is no more digits to check
        if (next_digits.length() == 0) {
            // the combination is done
            output.add(combination);
        }
        // if there are still digits to check
        else {
            // iterate over all letters which map
            // the next available digit
            String digit = next_digits.substring(0, 1);
            String letters = phone.get(digit);
            for (int i = 0; i < letters.length(); i++) {
                String letter = phone.get(digit).substring(i, i + 1);
                // append the current letter to the combination
                // and proceed to the next digits
                backtrack(combination + letter, next_digits.substring(1));
            }
        }
    }

    public static void main(String[] args) {
        LetterCombinationsofaPhoneNumber solution = new LetterCombinationsofaPhoneNumber();
        String digits = "23";
        List<String> outputList = solution.letterCombinations(digits);
        for(String out : outputList){
            System.out.println(out);
        }
    }
}

//Time Complexity - O(3^N * 4^M) where N is the number of digits in the input that maps to 3 letters(eg. 2,3,4,5,6,8)
//and M is the number of digits in the input that maps to 4 letters (eg. 7,9) and N+M is the total number of digits
//Space Complexity - O(3^N * 4^M) Since one has to keep 3^N * 4^M solutions