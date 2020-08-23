package array;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//LC-339
public class NestedListWeightSum {

    //DFS
    public int depthSum(List<NestedInteger> nestedList) {
        return depthSum(nestedList, 1);
    }

    public int depthSum(List<NestedInteger> list, int depth) {
        int sum = 0;
        for (NestedInteger n : list) {
            if (n.isInteger()) {
                sum += n.getInteger() * depth;
            } else {
                sum += depthSum(n.getList(), depth + 1);
            }
        }
        return sum;
    }

    //BFS
    public int depthSumUsingBFS(List<NestedInteger> nestedList) {
        Queue<NestedInteger> q = new LinkedList<>();
        for(NestedInteger n : nestedList){
            q.add(n);
        }
        int deep = 1;
        int ans = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                NestedInteger temp = q.poll();
                if(temp.isInteger()){
                    ans += deep * temp.getInteger();
                }else{
                    for(NestedInteger n : temp.getList()){
                        q.add(n);
                    }
                }
            }
            deep++;
        }
        return ans;
    }

    //Test Code to remove compilation errors
    class NestedInteger{
        public NestedInteger(){};
        public NestedInteger(int value){};
        public boolean isInteger(){return true;};
        public Integer getInteger(){return Integer.getInteger("1");};
        public List<NestedInteger> getList(){return Collections.emptyList();};
    }
}
