/**
 * 
 * Some explanation.
 * The key difference with the classic Dijkstra algo is, we don't maintain the
 * global optimal distance to each node, i.e. ignore below optimization:
 * alt ← dist[u] + length(u, v)
 * if alt < dist[v]:
 * Because there could be routes which their length is shorter but pass more
 * stops, and those routes don't necessarily constitute the best route in the
 * end. To deal with this, rather than maintain the optimal routes with 0..K
 * stops for each node, the solution simply put all possible routes into the
 * priority queue, so that all of them has a chance to be processed. IMO, this
 * is the most brilliant part.
 * And the solution simply returns the first qualified route, it's easy to prove
 * this must be the best route.
 * Complexity Analysis
 * Time Complexity: O(E+nlogn), where E is the total number of flights.?
 * Space Complexity: O(n), the size of the heap.?
 * 
 */

class prob33_grph {

  class Flight {
    int src;
    int dst;
    int price;

    Flight(int src, int dst, int price) {
      this.src = src;
      this.dst = dst;
      this.price = price;
    }
  }

  class Stop {
    int id, cost, count;

    Stop(int id, int cost, int count) {
      this.id = id;
      this.cost = cost;
      this.count = count;
    }
  }

  public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
    HashMap<Integer, ArrayList<Flight>> map = new HashMap<>();

    for (int[] flight : flights) {
      if (!map.containsKey(flight[0])) {
        map.put(flight[0], new ArrayList<Flight>());
      }
      map.get(flight[0]).add(new Flight(flight[0], flight[1], flight[2]));
    }

    Comparator<Stop> cmp = new Comparator<Stop>() {
      public int compare(Stop s1, Stop s2) {
        return s1.cost - s2.cost;
      }
    };
    PriorityQueue<Stop> q = new PriorityQueue<Stop>(cmp);

    q.offer(new Stop(src, 0, K));
    while (q != null && !q.isEmpty()) {
      Stop cur = q.poll();
      if (cur.id == dst) {
        return cur.cost;
      }

      if (cur.count >= 0) {
        List<Flight> list = map.get(cur.id);
        if (list == null) {
          continue;
        }
        for (Flight f : list) {
          q.offer(new Stop(f.dst, f.price + cur.cost, cur.count - 1));
        }
      }
    }

    return -1;
  }

}