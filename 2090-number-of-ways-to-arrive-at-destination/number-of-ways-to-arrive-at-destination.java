class Pair {
    int node;
    long weight;  // use long
    public Pair(long weight, int node) {
        this.node = node;
        this.weight = weight;
    }
}

class Solution {
    static final int MOD = 1_000_000_007;

    public int countPaths(int n, int[][] roads) {
        ArrayList<ArrayList<Pair>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) adjList.add(new ArrayList<>());

        // build graph
        for (int[] row : roads) {
            int u = row[0], v = row[1], w = row[2];
            adjList.get(u).add(new Pair(w, v));
            adjList.get(v).add(new Pair(w, u));
        }

        long[] dis = new long[n];
        int[] ways = new int[n];
        Arrays.fill(dis, Long.MAX_VALUE);
        Arrays.fill(ways, 0);

        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> Long.compare(x.weight, y.weight));

        dis[0] = 0;
        ways[0] = 1;
        pq.add(new Pair(0, 0)); // (distance, node)

        while (!pq.isEmpty()) {
            Pair p = pq.poll();
            int node = p.node;
            long currDist = p.weight;

            if (currDist > dis[node]) continue; // skip stale

            for (Pair nei : adjList.get(node)) {
                int adjNode = nei.node;
                long newDist = currDist + nei.weight;

                if (newDist < dis[adjNode]) {
                    dis[adjNode] = newDist;
                    ways[adjNode] = ways[node];
                    pq.add(new Pair(newDist, adjNode));
                } 
                else if (newDist == dis[adjNode]) {
                    ways[adjNode] = (ways[adjNode] + ways[node]) % MOD;
                }
            }
        }

        return ways[n - 1];
    }
}
