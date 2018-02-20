import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


public class Graph {
	private Map<Integer, List<Integer>> adj_list;
	private int vertex_count;
	
	public int get_count() {
		return vertex_count;
	}
	
	public Graph(int vertex_count){
		this.vertex_count = vertex_count;
		adj_list = new HashMap<>(vertex_count);
		for(int i = 0; i < vertex_count; i ++)
			adj_list.put(i, new LinkedList<Integer>());
	}
	
	public void addEdge(int from, int to){
		//add edge (u,v) as well as (v,u) because undirected
		adj_list.get(from).add(to);
		adj_list.get(to).add(from);
	}
	
	public List<Integer> adj(int v){
		return adj_list.get(v);
	}
	
	public int V(){
		return vertex_count;
	}
	
	public Map<Integer, List<Integer>> getList(){
		return adj_list;
	}
}
