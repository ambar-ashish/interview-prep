package graphs;

import java.util.*;

//LC-332
public class ReconstructItinerary {

    //Need to confirm on time and space complexity
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> flights = new HashMap<>();
        // build graph
        for (List<String> ticket : tickets) {
            flights.putIfAbsent(ticket.get(0), new PriorityQueue<>());
            flights.get(ticket.get(0)).add(ticket.get(1));
        }

        LinkedList<String> path = new LinkedList<>();
        Stack<String> stack = new Stack<>();
        stack.push("JFK");
        while (!stack.empty()) {
            while (flights.containsKey(stack.peek()) && !flights.get(stack.peek()).isEmpty())
                stack.push(flights.get(stack.peek()).poll());
            path.addFirst(stack.pop());
        }
        return path;
    }
}
