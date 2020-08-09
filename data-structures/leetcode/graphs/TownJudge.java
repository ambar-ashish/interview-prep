package graphs;

//LC-997
public class TownJudge {

    public int findJudge(int N, int[][] trust) {
        if (trust.length < N - 1) {
            return -1;
        }

        int[] indegrees = new int[N + 1];
        int[] outdegrees = new int[N + 1];

        for (int[] relation : trust) {
            outdegrees[relation[0]]++;
            indegrees[relation[1]]++;
        }

        for (int i = 1; i <= N; i++) {
            if (indegrees[i] == N - 1 && outdegrees[i] == 0) {
                return i;
            }
        }
        return -1;
    }
}
// Let N be the no of people and E be the no of edges(trust relationships)
//Time Complexity - O(E), since we loop over the trust list once. The cost of doing this is O(E)
//Space Complexity - O(N), 2 arrays with same length
