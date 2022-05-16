package interview.Dijkstra.medium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class NetworkDelayTime743 {
	class Solution {
	    private Map<Integer, List<Pair<Integer, Integer>>> adj = new HashMap<>();
	    public int networkDelayTime(int[][] times, int n, int k) {
	        builAdjList(times);
	        Queue<Pair<Integer, Integer>> queue = new PriorityQueue<>(n, Comparator.comparing(Pair::getValue));
	        queue.add(new Pair(k, 0));
	        int [] cost = new int[n+1];
	        Arrays.fill(cost, -1);
	        cost[k] = 0;
	        
	        while(!queue.isEmpty()) {
	            Pair<Integer, Integer> newPing = queue.remove();
	            int node = newPing.getKey();
	            int costToThisNode = newPing.getValue();
	            if(cost[node] != -1 && cost[node] < costToThisNode) continue;
	            
	            for(Pair<Integer, Integer> a : adj.getOrDefault(node, new LinkedList<>())) {
	                 int previousCost = cost[a.getKey()];
	                 int potentialCost = costToThisNode + a.getValue();
	                 if(previousCost == -1 || potentialCost < previousCost) {
	                    cost[a.getKey()] = potentialCost;
	                    queue.add(new Pair(a.getKey(), potentialCost));     
	                 }
	            }
	        }
	        int maxCost = -1;
	        
	        for(int i = 1 ; i < n+1 ; i++) {
	            int seenCost = cost[i];
	            if(seenCost == -1){
	                maxCost = -1;
	                break;
	            } else if( seenCost > maxCost) {
	                maxCost = seenCost;
	            }
	        }
	        
	        return maxCost;
	    }
	    
	    private void builAdjList(int [][] times) {
	        for(int[] ping : times) {
	            List<Pair<Integer, Integer>> vals = adj.getOrDefault(ping[0], new LinkedList<>());    
	            vals.add(new Pair(ping[1], ping[2]));
	            adj.put(ping[0], vals);
	        }
	    }
	}
}
