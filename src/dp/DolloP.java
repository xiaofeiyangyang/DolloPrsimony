package dp;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DolloP {
	public static int[] getDolloP(Node root, List<Node> name, int[] allNode){
	      List<Node> listAll = new ArrayList<Node>();
	      Set<Node> lastSet = new HashSet<Node>();
	      Set<Node> allSet = new HashSet<Node>();
	     for(Node nam : name){
	      	Node temp = Node.getParentLate(root, nam);
	      	lastSet.add(temp);
	      	listAll.add(temp);
	      	
	      	
	      }
//	      System.out.println(lastSet);
//	      System.out.println(listAll);
//	      for(Node all: listAll){
//	      	System.out.println(all.data);
//	      }
	      for(Node all1 : lastSet){
	      	for(Node all2: lastSet){
	      		Node tem = Node.getCommonRoot(root, all1, all2);
	      		allSet.add(tem);
	      	}
	      }
	      
//	      for(Node allS: allSet){
//	      	System.out.println("[" + allS.data + "]");
//	      }
	      /**allSet.addAll(name);
	      for(Node allS: allSet){
	      	System.out.println("[{" + allS.data + "}]");
	      } **/
	      
	      for(Node value: allSet){
	      	allNode[value.data] = 1;
	      	
	      }
//	      for(int in : allNode){
//	      System.out.print(in+",");
//	      }
		 return allNode;
	 }
	
	public static int[] getDolloP2(Node root, List<Node> name, int[] allNode){
	      List<Node> pathA = new ArrayList<Node>();
	      List<Node> pathB = new ArrayList<Node>();
	      Set<Node> pathSet = new HashSet<Node>();
	      if(name.isEmpty())
		  return allNode;
	      Node first = name.get(0);
		  name.remove(0);

	      while(!name.isEmpty()){
		  Node temp = name.get(0);
		  name.remove(0);
		  Node comm = Node.getCommonRoot(root, first, temp);
		  first.getPath(comm, first, pathA);
		  temp.getPath(comm, temp, pathB);
		  for(Node A: pathA)
		      pathSet.add(A);
		  for(Node B: pathB)
		      pathSet.add(B);
		  first = comm;
		  
		  
		  
	      }
	      for(Node value: pathSet)
		  allNode[value.data] = 1;
	      
	      return allNode;
	}
	
	
	
	
	
	
	
	
	
	
}
