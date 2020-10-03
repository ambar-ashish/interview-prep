package string;

import java.util.HashMap;

//LC-953
public class VerifyinganAlienDictionary {

    //Time Complexity - O(C) where C is the total content of words
    //Space Complexity - O(1)
    public boolean isAlienSorted(String[] words, String order) {
        if(words.length == 0 || order.length() == 0){
            return false;
        }
        for(int i=0; i<words.length-1; i++){
            if(!isSorted(words[i], words[i+1], order)){
                return false;
            }
        }
        return true;
    }

    public boolean isSorted(String word1, String word2, String order){
        int length = Math.min(word1.length(), word2.length());
        for(int i=0; i<length; i++){
            if(order.indexOf(word1.charAt(i)) < order.indexOf(word2.charAt(i))){
                return true;
            }else if(order.indexOf(word1.charAt(i)) > order.indexOf(word2.charAt(i))){
                return false;
            }
        }
        return word1.length() <= word2.length();
    }

    public static void main(String[] args) {
        VerifyinganAlienDictionary dictionary = new VerifyinganAlienDictionary();
        String[] words = {"word","world","row"};
        String order = "worldabcefghijkmnpqstuvxyz";
        System.out.println(dictionary.isAlienSorted(words, order));
    }
}

//We could have used HashMap to store the order of each character with index but indexOf will be much faster
