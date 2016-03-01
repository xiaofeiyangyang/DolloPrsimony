package dp;


import java.util.ArrayList;
import java.util.List;

public class TestMatrix {
	
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
		        List<Node> nodeList = new ArrayList<Node>();
		        nodeList.add(a);
		        nodeList.add(b);
		        nodeList.add(c);
		        nodeList.add(d);
		        nodeList.add(e);
		        nodeList.add(f);
		        nodeList.add(g);
		        nodeList.add(h);
		        nodeList.add(i);
		        nodeList.add(j);
		        nodeList.add(k);
		        nodeList.add(l);
		        nodeList.add(m);
		        nodeList.add(n);
		        nodeList.add(o);
		        
		        
		        long startTime = System.currentTimeMillis();
		        int[][] ary = new int[10000][16];
		        for (int x = 0; x<ary.length; x++){
		        	for(int y =0; y<8; y++){
		        		ary[x][y] = 0; 
		        	}
		        }
		        for (int x = 0; x<ary.length; x++){
		        	for(int y =8; y<ary[x].length; y++){
		        		ary[x][y] = (int)(Math.random()*2); 
		        	}
		        }
		        
//		        for (int x = 0; x<ary.length; x++){
//		        	for(int y =0; y<ary[x].length; y++){
//		        		System.out.print(ary[x][y]); 
//		        	}
//		        	System.out.println();
//		        }
//		       
		        List<Node> nameA = new ArrayList<Node>();
		        List<Node> nameB = new ArrayList<Node>();
		        
		    	for(int xx=0; xx < ary[1].length;xx++){
					if(ary[1][xx]==1){
						nameA.add(nodeList.get(xx-1));
					}
				}
		    	
		    	
		    	
		        int x=1;
				while( x < ary.length){
					int[] allNodeA = ary[1];
					int[] allNodeB = ary[x];
					
				
					for(int yy =0; yy < ary[x].length;yy++){
						if(ary[x][yy]==1){
							nameB.add(nodeList.get(yy-1));
						}
						
					}
					
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
		        	
		        	
		        	
		        	x++;
		        }
		        
		       long endTime =System.currentTimeMillis();
		       System.out.println("Time:" + (endTime-startTime)/1000);
		        
		        
		        
		 }
}      
		        
		        