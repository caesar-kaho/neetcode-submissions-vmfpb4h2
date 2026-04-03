class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        // Use a PriorityQueue to automatically handle lexicographical order.
        // Polling from it will always give the smallest airport name.
        Map<String, PriorityQueue<String>> adj = new HashMap<>();

        for (List<String> ticket : tickets) {
            adj.computeIfAbsent(ticket.get(0), k -> new PriorityQueue<>()).add(ticket.get(1));
        }

        // The result list, which will be built in reverse.
        LinkedList<String> route = new LinkedList<>();

        dfs("JFK", adj, route);
        
        return route;
    }

    private void dfs(String airport, Map<String, PriorityQueue<String>> adj, LinkedList<String> route) {
        // Get the priority queue of destinations for the current airport.
        PriorityQueue<String> destinations = adj.get(airport);

        // While there are destinations to visit from the current airport...
        while (destinations != null && !destinations.isEmpty()) {
            // Poll the next smallest destination and recursively travel there.
            // Polling also "uses up" the ticket.
            String nextAirport = destinations.poll();
            dfs(nextAirport, adj, route);
        }
        
        // POST-ORDER STEP: After visiting all reachable nodes from the current 'airport',
        // add the 'airport' to the front of our result list. This builds the path backwards.
        route.addFirst(airport);
    }
}