package array;

import java.util.Arrays;

//LC-621
public class TaskScheduler {

    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        // frequencies of the tasks
        for(char task : tasks){
            freq[task - 'A']++;
        }
        Arrays.sort(freq);

        //Max frequency
        int fmax = freq[25];

        int idleTime = (fmax-1) * n;

        for(int i=freq.length - 2; i>=0; i--){
            idleTime =  idleTime - Math.min(fmax-1, freq[i]);
        }

        if(idleTime > 0){
            return idleTime + tasks.length;
        }else{
            return tasks.length;
        }
    }
}
