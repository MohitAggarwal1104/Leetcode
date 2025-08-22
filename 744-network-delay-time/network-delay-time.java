import java.util.*;

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        // Step 1: Build adjacency list -> u -> (v, w)
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) adj.add(new ArrayList<>());

        for (int[] row : times) {
            int u = row[0], v = row[1], w = row[2];
            adj.get(u).add(new int[]{v, w});
        }

        // Step 2: Distance array
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;

        // Step 3: MinHeap (time, node)
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.offer(new int[]{0, k});

        // Step 4: Dijkstra’s Algorithm
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int time = curr[0], node = curr[1];

            if (time > dist[node]) continue;

            for (int[] nei : adj.get(node)) {
                int next = nei[0], w = nei[1];
                if (dist[node] + w < dist[next]) {
                    dist[next] = dist[node] + w;
                    pq.offer(new int[]{dist[next], next});
                }
            }
        }

        // Step 5: Find max distance
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == Integer.MAX_VALUE) return -1; // unreachable node
            ans = Math.max(ans, dist[i]);
        }

        return ans;
    }
}
