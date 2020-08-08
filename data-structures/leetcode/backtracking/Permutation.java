package backtracking;

public class Permutation {

    public void permute(String s){
        recursivePermute(s, "");
    }

    public void recursivePermute(String str, String ans){
        if(str.length() == 0){
            System.out.println(ans);
            return;
        }
        for(int i=0; i<str.length(); i++){
            String x = String.valueOf(str.charAt(i));
            String ros = str.substring(0, i) + str.substring(i+1);
            recursivePermute(ros, ans+x);
        }
    }

    public static void main(String[] args) {
        String s = "abc";
        Permutation permutation = new Permutation();
        permutation.permute(s);
    }
}

//Time Complexity: O(n * n!)
//There are n! permutations and it takes O(n) time to add each one to our result array

//Space Complexity : O(n)
//We are not returning an array here so linear space because our recursion will go at maximum n elements deep
//since we make n choices of placement at maximum
//If we did store and return an array our space complexity would be O(n * n!)
// since we would have n! permutations and each permutation would be of length n.
// If we consider the returned array of all permutation strings as NOT part of space,
// the call stack dominates space. We are back to O(n).


