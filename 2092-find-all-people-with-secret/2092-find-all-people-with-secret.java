class Solution {
    class DSU{
        int[] parent;
        int[] rank;
        DSU(int n){
            parent = new int[n];
            rank = new int[n];
            for(int i = 0; i < n; i++){
                parent[i] = i;
            }
        }
        int find(int x){
            if(parent[x]!=x){
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }
        void union(int a, int b){
            int pa = find(a);
            int pb = find(b);
            if(pa == pb) return;
            if(rank[pa]>rank[pb]){
                parent[pb] = pa;
            }
            else if(rank[pb] > rank[pa]){
                parent[pa] = pb;
            }
            else{
                parent[pb] = pa;
                rank[pa]++;
            }
        }
        void reset(int x){
            parent[x] = x;
        }
    }
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        DSU ans = new DSU(n);
        ans.union(0,firstPerson);
        Arrays.sort(meetings,(a,b)-> a[2]-b[2]);

        int i = 0;
        while(i<meetings.length){
            List<Integer> p = new ArrayList<>();
            int time = meetings[i][2];
            int j = i;
            while(j < meetings.length && meetings[j][2] == time){
                int u = meetings[j][0];
                int v = meetings[j][1];

                ans.union(u,v);
                p.add(u);
                p.add(v);

                j++;
            }
            for(int h : p){
                if(ans.find(h)!= ans.find(0)){
                    ans.reset(h);
                }
            }
            i=j;
        }
        List<Integer> obj = new ArrayList<>();
        for(int k = 0; k < n; k++){
            if(ans.find(k) == ans.find(0)){
                obj.add(k);
            }
        }
        return obj;
    }
}