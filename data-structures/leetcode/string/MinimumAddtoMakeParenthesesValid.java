package string;

//LC-921
public class MinimumAddtoMakeParenthesesValid {

    public int minAddToMakeValid(String S) {
        int unmatchedOpen = 0;
        int unmatchedClose = 0;

        for (char c : S.toCharArray()) {
            if (c == '(') {
                unmatchedOpen++;
            } else if (c == ')' && unmatchedOpen > 0){
                unmatchedOpen--;
            } else if (c == ')' && unmatchedOpen == 0){
                // This is a closed paren and there
                // isn't an open one to balance it out
                unmatchedClose++;
            }
        }
        return unmatchedClose + unmatchedOpen;
    }
}

//Intuition:

//To make a string valid,
//we can add some ( on the left,
//and add some ) on the right.
//We need to find the number of each.


//Explanation:

//left records the number of ( we need to add on the left of S.
//right records the number of ) we need to add on the right of S,
//which equals to the number of current opened parentheses.


//Loop char c in the string S:
//if (c == '('), we increment right,
//if (c == ')'), we decrement right.
//When right is already 0, we increment left
//Return left + right in the end


//Time Complexity:

//Time O(N)
//Space O(1)
