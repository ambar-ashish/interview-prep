import java.util.HashMap;

public class Solution1 {

    public int calculate(char[][] k, String s, int n, int m){

        HashMap<Character, int[]> map = new HashMap();
        for(int i=0; i<k.length; i++){
            for(int j=0; j<k[0].length; j++){
                map.put(k[i][j], new int[]{i,j});
            }
        }

        if(!map.containsKey(s.charAt(0))){
            return -1;
        }
        int[] prevCoordinates = map.get(s.charAt(0));
        int result = 0;
        for(int i=1; i<s.length(); i++)
        {
            if(!map.containsKey(s.charAt(i))){
               return -1;
            }
            result = getResult(prevCoordinates, map.get(s.charAt(i)));
            prevCoordinates = map.get(s.charAt(i));
        }
        return result;
    }

    int getResult(int[] i, int[] j){
        return Math.abs(i[0] - j[0]) + Math.abs(i[1] - j[1]);
    }

    public static void main(String[] args) {

    }
}
