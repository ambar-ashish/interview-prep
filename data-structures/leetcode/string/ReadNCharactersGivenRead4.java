package string;

//LC-157
public class ReadNCharactersGivenRead4 {

    public int read(char[] buf, int n) {

        char[] temp = new char[4];  //Store our read chars from Read4
        int total = 0;

        while(total < n){
            /*Read and store characters in Temp. Count will store total chars read from Read4*/
            int count = read4(temp);

            /*Even if we read 4 chars from Read4,
            we don't want to exceed N and only want to read chars till N.*/
            count = Math.min(count, n-total);

            //Transfer all the characters read from Read4 to our buffer
            for(int i = 0;  i < count; i++){
                buf[total] = temp[i];
                total++;
            }

            //done. We can't read more characters.
            if(count < 4) break;
        }

        return total;
    }

    public int read4(char[] buf){
        return 0;
    }
}
