class Solution {
    public int minimumTeachings(int n, int[][] languages, int[][] friendships) {
        int m=languages.length;

        boolean[][] know=new boolean[m+1][n+1];

        for(int i=1;i<=m;i++){
            for(int lang : languages[i-1]){
                know[i][lang]=true;
            }
        }

        Set<Integer> problemusers=new HashSet<>();
        for(int []f :friendships){
            int u=f[0]; int v=f[1];
            boolean check=false;
            for(int i=1;i<=n;i++){
                if(know[u][i] && know[v][i]){
                    check=true;
                    break;
                }
            }
            if(!check){
                problemusers.add(u);
                problemusers.add(v);
            }
        }
        if(problemusers.size()==0)return 0;
        int count[]=new int[n+1];

        for(int users: problemusers){
            for(int i=1;i<=n;i++){
                if(know[users][i]){
                    count[i]++;
                }
            }
        }
        int total=problemusers.size();

        int maxcount=0;
        for(int i=1;i<=n;i++){
            maxcount=Math.max(maxcount,count[i]);
        }
        return total-maxcount;
    }
}