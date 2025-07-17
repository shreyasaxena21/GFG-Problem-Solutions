// User function Template for Java
class DSU{
    int[] parent;
    int[] rank;
    DSU(int n){
        parent = new int[n];
        rank = new int[n];
        for(int i =0; i<n; i++){
            parent[i] = i;
        }
        
    }
    
    int find(int  x){
        if(parent[x]!=x){
            // in this case x is not the own leader go up and find the leader
            
            parent[x] = find(parent[x]);
        }
        
        return parent[x];  //return the leader
    }
    
    void union(int x, int y){
        int parentOfX = find(x);
        int parentOfY = find(y);
        
        if(parentOfX == parentOfY){
            return;
        }
        
        if(rank[parentOfX] < rank[parentOfY]){
            parent[parentOfX] = parentOfY; //make the y as a leader
        }
        
        else if(rank[parentOfX] > rank[parentOfY]){
             parent[parentOfY] = parentOfX; //make x as leader 
        }
        
        else{
            parent[parentOfY] = parentOfX;
            rank[parentOfX]++;
        }
    }
}

class Solution {
    static int kruskalsMST(int V, int[][] edges) {
        // code here
        // step 1 Sort all the edges Ascending order 
        Arrays.sort(edges, (a,b)->a[2]-b[2]);
        DSU dsu = new DSU(V);
        int totalWeight = 0; //total weight in MST
        int count = 0; // number of edges in MST
        
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            
            if(dsu.find(u) != dsu.find(v)){
                dsu.union(u,v);
                totalWeight = totalWeight + w;
                count++;
                if(count==V-1){
                    break;
                    
                }
            }
            
        }
        
        return totalWeight;
    }
}
