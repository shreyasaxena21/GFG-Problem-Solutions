class Solution {
    public boolean isCycle(int V, int[][] edges) {
        // Code here
        List<List<Integer>> graph  = new ArrayList<>();
        for(int i = 0; i<V; i++){
            graph.add(new ArrayList<>());
        }
        
        for(int [] edge : edges){
            int u = edge[0];
            int v = edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
            
        }
        
        boolean visited[] = new boolean[V];
        for(int i = 0; i<V; i++){
            if(!visited[i]){
               if (dfs(i,-1,graph, visited)){
                   return true;
               }
            }
        }
        
        return false;
        
    }
    
    boolean dfs(int currentNode, int parent, List<List<Integer>> graph, boolean visited[]){
        visited[currentNode] = true;
        for(int neighbour : graph.get(currentNode)){
            if(!visited[neighbour]){
                if(dfs(neighbour, currentNode, graph, visited)){
                    return true;
                }
            }
            else if(neighbour!=parent){
                return true;
            }
        }
        
        return false;
    }
}