class Pair{
    int node;
    int dist;
    Pair(int node, int dist){
        this.node = node;
        this.dist = dist;
    }
}

class Solution {
    public int[] dijkstra(int V, int[][] edges, int src) {
        // code here
        
        // step 1 - create an array - AdjList for graph
        
        ArrayList<ArrayList<Pair>> graph = new ArrayList<>();
        //adding vertex
        for(int i =0; i<V; i++){
            graph.add(new ArrayList<>());
        }
        
        // adding edges
        for(int [] edge : edges){
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            graph.get(u).add(new Pair(v,w)); // u --> v directed
            graph.get(v).add(new Pair(u,w));
        }
        
        int dist[] = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        
        PriorityQueue<Pair> pqueue = new PriorityQueue<>((a,b)->a.dist-b.dist);
        pqueue.add(new Pair(src,0)); // add the source vertex
        
        while(!pqueue.isEmpty()){
            Pair current = pqueue.poll();
            int u = current.node;
            for(Pair neighbour : graph.get(u)){
                int v = neighbour.node;
                int w = neighbour.dist;
                if(dist[u] + w < dist[v]){
                    dist[v] = dist[u] + w;
                    pqueue.add(new Pair(v,dist[v]));
                }
            }
        }
        
        return dist;
            
    }
}