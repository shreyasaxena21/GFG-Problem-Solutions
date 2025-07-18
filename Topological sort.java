class Solution {
    public static ArrayList<Integer> topoSort(int V, int[][] edges) {
        // code here
        
        // 4 steps 
        ArrayList<Integer> result = new ArrayList<>();
        // step 1 matrix - convert into adjaceny list
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        //adding vertex
        for(int i =0; i<V; i++){
            graph.add(new ArrayList<>());
        }
        
        // adding edges
        for(int [] edge : edges){
            int u = edge[0];
            int v = edge[1];
            graph.get(u).add(v); // u --> v directed
            
        }
        
        // step 2 - visited array
        boolean [] visited = new boolean[V];
        
        // step 3 - stack
        Stack<Integer> stack = new Stack<>();
        
        // step 4 - DFS of all nodes pop and store in arraylist for output
        for(int i = 0; i<V; i++){
            if(!visited[i]){
                dfs(i, visited, graph, stack);
            }
        }
        
        while(!stack.isEmpty()){
            result.add(stack.pop());
        }
        
        return result;
        
        
    }
    
    static void dfs(int currentNode, boolean[] visited, ArrayList<ArrayList<Integer>> graph, Stack<Integer> stack ){
        visited[currentNode] = true;
        
        for(int neighbour : graph.get(currentNode)){
            if(!visited[neighbour]){
                dfs(neighbour, visited, graph, stack);
            }
        }
        
        stack.push(currentNode);
    }

     //Kahn's Algorithm
        // 4 steps 
        ArrayList<Integer> result = new ArrayList<>();
        // step 1 matrix - convert into adjaceny list
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        //adding vertex
        for(int i =0; i<V; i++){
            graph.add(new ArrayList<>());
        }
        
        // adding edges
        for(int [] edge : edges){
            int u = edge[0];
            int v = edge[1];
            graph.get(u).add(v); // u --> v directed
            
        }
        
        //step 2= indegree array
        int [] indegree = new int[V];
        for(int u = 0; u<V; u++){
            for(int v : graph.get(u)){
                indegree[v]++;
            }
        }
        
        // [process the vertex whixh has 0 indegree]
        Queue<Integer> queue = new LinkedList<>();
        
        for(int i = 0; i<V; i++){
            if(indegree[i] == 0){
                queue.add(i); //add these vertices which has 0 indegree
            }
        }
        
        while(!queue.isEmpty()){
            int current = queue.poll();
            result.add(current);
            for(int neighbour : graph.get(current)){
                indegree[neighbour]--;
                if(indegree[neighbour] == 0){
                    queue.add(neighbour);
                }
            }
        }
        
        return result;
        
        
    }
    
    static void dfs(int currentNode, boolean[] visited, ArrayList<ArrayList<Integer>> graph, Stack<Integer> stack ){
        visited[currentNode] = true;
        
        for(int neighbour : graph.get(currentNode)){
            if(!visited[neighbour]){
                dfs(neighbour, visited, graph, stack);
            }
        }
        
        stack.push(currentNode);
    }
}