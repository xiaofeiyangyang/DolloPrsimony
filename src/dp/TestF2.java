package dp;

import java.util.ArrayList;
import java.util.List;

public class TestF2 {
	
		 public static void main(String[] args) {
		        Node h = new Node(null,null,8);
		        Node i = new Node(null,null,9);
		        Node j = new Node(null,null,10);
		        Node k = new Node(null,null,11);
		        Node l = new Node(null,null,12);
		        Node m = new Node(null,null,13);
		        Node n = new Node(null,null,14);
		        Node o = new Node(null,null,15);
		        Node f = new Node(j,k,6);
		        Node e = new Node(h,i,5);
		        Node g = new Node(n,o,7); 
		        Node c = new Node(e,f,3);
		        Node d = new Node(m,g,4);
		        Node b = new Node(c,l,2);
		        Node a = new Node(b,d,1);

//		        int[] A = {1,1,1,1,1,0,0,1};
//		        int[] B = {0,0,0,0,1,0,0,1};
		        int[] allNodeA = {0,0,0,0,0,0,0,0,1,1,1,1,1,0,0,1};
		        int[] allNodeB = {0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,1};
		        
		        List<Node> nameA = new ArrayList<Node>();
		        nameA.add(n);
		        nameA.add(i);
		        nameA.add(j);
		        nameA.add(k);
		        nameA.add(l);
		        nameA.add(o);
		        
		        List<Node> nameB = new ArrayList<Node>();
		        nameB.add(l);
		        nameB.add(o);
		        
		        int[] ancA = DolloP.getDolloP(a, nameA, allNodeA);
		        System.out.print("ancestral of A:");
		        for(int value: ancA){
		        	System.out.print(value +",");
		        	}
		        System.out.print("\n");
		        
		        System.out.print("ancestral of B:");
		        int[] ancB = DolloP.getDolloP(a, nameB, allNodeB);
		        for(int value: ancB){
		        	System.out.print(value +",");
		        	}       
		        System.out.print("\n");
		        
		        int Dp = DpScore.getDp(a, ancA, ancB);
		        System.out.println("Dp is :" + Dp);
		        
		        
		        
  }
}
