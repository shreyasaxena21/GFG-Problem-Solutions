// User function template for JAVA

class Solution {
    public void floydWarshall(int[][] dist) {
        // Code here
        int V = dist.length;
        
        for(int k = 0; k<V; k++){
            for(int i = 0; i<V; i++){
                for(int j = 0; j<V; j++){
                    if(dist[i][k]!=100000000 && dist[k][j]!=100000000){
                        int newDistance = dist[i][k]+dist[k][j];
                        if(newDistance<dist[i][j]){
                            dist[i][j] = newDistance;
                        }
                    }
                }
            }
        }
    }
}