import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
	    ArrayList<String> cities = new ArrayList<>();
	    cities.add("Bangalore");
	    cities.add("Chennai");
	    cities.add("Hyderabad");
	    cities.add("Mumbai");
	    Graph g = new Graph(cities);
	    g.addNbrs("Bangalore", "Chennai");
	    g.addNbrs("Bangalore", "Hyderabad");
	    g.addNbrs("Mumbai", "Hyderabad");
	    g.print();
	}
}
class Graph{
    HashMap<String, ArrayList<String>> map = new HashMap<>();
    Graph(ArrayList<String> cities){
        for(String city : cities)
            map.put(city, new ArrayList<>());
    }
    public void addNbrs(String src, String desti){
        map.get(src).add(desti);
    }
    public void print(){
        for(Map.Entry<String, ArrayList<String>> entry : map.entrySet()){
            System.out.print(entry.getKey()+"->");
            for(String nbh : entry.getValue())
                System.out.print(nbh+", ");
            System.out.println();
        }
        System.out.println();
    }
}
