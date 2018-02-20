import java.util.Arrays;
import java.util.Stack;

public class Colorable {
	int[] parent;
	boolean[] visited;
	boolean[] color;
	boolean bipartite;
	
	
	Graph startingGraph;
	
	public Colorable(Graph g){
		startingGraph = g;
		parent = new int[g.get_count()];
		Arrays.fill(parent, -1);
		visited = new boolean[g.get_count()];
		Arrays.fill(visited, false);
		color = new boolean[g.get_count()];
		Arrays.fill(color, false);
		bipartite = true;
		
		for (int source = 0; source < g.get_count(); source ++){
			if(!visited[source])
			{
				color[source] = true;
				
				dfs(g,source); //perform dfs's to see colorability
			}
		}
	}

	private Stack<Integer> cycle;
	boolean cycleFound = false;
	
	public boolean[] coloring(){
		return this.color;
	}
	
	/***
	 * 
	 * @return true if two colorable, false if not
	 */
	public boolean is_two_colorable(){
		if (bipartite) {
			for(int u = 0; u < startingGraph.get_count(); u ++) {
				for(int v : startingGraph.getList().get(u))
					if (color[v] == color[u])
						return false; //validate two colorability
			}
		}
		else {
			
			System.out.print("cycle : ");
			
			int cycleLength = -1;
			
			for (int n : cycle) { //print cycle, find cycle length
				System.out.print((n + 1) + " ");
				cycleLength ++;
			}
			
			System.out.println();
			
			if (cycleLength % 2 == 1)
				return false;
		}
		
		return true;
	}
	
	private void dfs(Graph g, int u){
		visited[u] = true;
		for(int v : g.getList().get(u)){
			
			if(cycleFound) return; //return on the first cycle found
			
			if(!visited[v]){
				parent[v] = u;
				color[v] = !color[u];
				dfs(g, v);
			}
			else if (color[v] == color[u]) { //odd cycle found
				cycleFound = true;
				bipartite = false;
				cycle = new Stack<Integer>();
				cycle.push(v);
				for(int x = u; x != v && x != -1; x = parent[x]){
					cycle.push(x); //unwind cycle
				}
				cycle.push(v);
			}
		}
	}
}
