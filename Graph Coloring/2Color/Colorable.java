import java.util.Arrays;
import java.util.Stack;

public class Colorable {
	int[] parents;
	boolean[] visited;
	boolean[] color;
	boolean bipartite;
	
	
	Graph startingGraph;
	
	public Colorable(Graph g){
		startingGraph = g;
		parents = new int[g.get_count()];
		Arrays.fill(parents, -1);
		visited = new boolean[g.get_count()];
		color = new boolean[g.get_count()];
		bipartite = true;
		
		for (int source = 0; source < g.get_count(); source ++){
			if(!visited[source])
				dfs(g,source);
		}
	}

	private Stack<Integer> cycle;
	boolean cycleFound = false;
	
	public boolean checkBipartite(){
		if (bipartite) {
			for(int u = 0; u < startingGraph.get_count(); u ++) {
				for(int v : startingGraph.getList().get(u))
					if (color[v] == color[u])
						return false;
			}
		}
		else {
			int first_node = -1;
			int last_node = -1;
			
			System.out.print("cycle : ");
			
			for (int n : cycle) {
				if (first_node == -1) first_node = n;
				last_node = n;
				System.out.print(n + " ");
			}
			
			System.out.println();
			
			if (first_node != last_node)
				return false;
		}
		
		return true;
	}
	
	private void dfs(Graph g, int u){
		visited[u] = true;
		for(int v : g.getList().get(u)){
			
			if(cycleFound) return;
			
			if(!visited[v]){
				parents[v] = u;
				color[v] = !color[u];
				dfs(g, v);
			}
			else if (color[v] == color[u]) {
				cycleFound = true;
				bipartite = false;
				cycle = new Stack<Integer>();
				cycle.push(v);
				for(int x = u; x != v && x != -1; x = parents[x]){
					cycle.push(x);
				}
				cycle.push(v);
			}
		}
		
		
	}
}
