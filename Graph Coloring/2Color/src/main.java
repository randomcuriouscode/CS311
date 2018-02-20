import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class main {

	public static void main(String[] args) {
		try(Scanner s = new Scanner(new File(args[0]))) {
			int vCount = Integer.valueOf(s.nextLine().trim());
			Graph g = new Graph(vCount);
			
			while(s.hasNext()){ //keep reading while we have words to read
				String readString = s.nextLine().trim(); //read a value, make sure there isnt any whitespace
				String[] rs = readString.split(" ");
				
				g.addEdge(Integer.valueOf(rs[0]) - 1, Integer.valueOf(rs[1]) - 1);
			}
			Colorable c = new Colorable(g);
			boolean isTwoColorable = c.is_two_colorable();
			System.out.println("Colorable t/f: " + isTwoColorable);
			if(isTwoColorable)
			{
				for(int i = 0; i < c.coloring().length; i ++){
					System.out.printf("%d %s\n", i + 1, c.coloring()[i] ? "Blue" : "Red");
				}
				System.out.println();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
