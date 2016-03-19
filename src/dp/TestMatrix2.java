package dp;

import java.util.ArrayList;
import java.util.List;
import java.io.*;

public class TestMatrix2 {
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

        try{
            BufferedReader file1 = new BufferedReader(new FileReader("/home/yangfang/dollo_parsimony/gainMat1.csv"));
            BufferedReader file2 = new BufferedReader(new FileReader("/home/yangfang/dollo_parsimony/gainMat2.csv"));
            BufferedWriter fileWrite = new BufferedWriter(new FileWriter("/home/yangfang/dollo_parsimony/outresult.csv"));
            String str1 = null;
            String str2 = null;
            while((str1 = file1.readLine()) !=null && (str2 = file2.readLine()) !=null){
                int[] arrnode1 = new int[16];
                int[] arrnode2 = new int[16];
                String[] arr1;
                String[] arr2;
                int[] arrint1;
                int[] arrint2;
        	arr1 = str1.split(",");
        	arr2 = str2.split(",");
        	arrint1 = new int[arr1.length];
        	arrint2 = new int[arr2.length];
        	for(int q = 0; q< arr1.length ;q++){
        	    
        	    arrint1[q] = Integer.parseInt(arr1[q]);
        	    arrint2[q] = Integer.parseInt(arr2[q]);
        	}
        	for(int no = 8; no< arrnode1.length ;no++){
        	    arrnode1[no] = arrint1[no-8];
        	    arrnode2[no] = arrint2[no-8];
        	}
                List<Node> nameA = new ArrayList<Node>();
                List<Node> nameB = new ArrayList<Node>();

		for(int xx=0; xx < arrnode1.length;xx++){
			if(arrnode1[xx]==1){
				nameA.add(nodeList.get(xx-1));
			}
			if(arrnode2[xx]==1){
			    nameB.add(nodeList.get(xx-1));
			}
		}
        	
		int[] ancA = DolloP.getDolloP2(a, nameA, arrnode1);
	        System.out.print("ancestral of A:");
	        for(int value: ancA){
	        	System.out.print(value +",");
	        	}
	        System.out.print("\n");
	        
	        System.out.print("ancestral of B:");
	        int[] ancB = DolloP.getDolloP2(a, nameB, arrnode2);
	        for(int value: ancB){
	        	System.out.print(value +",");
	        	}       
	        System.out.print("\n");
	        
	        int Dp = DpScore.getDp(a, ancA, ancB);
	        System.out.println("Dp is :" + Dp);
	      
//	        fileWrite.write(String.valueOf(Dp));
//	        fileWrite.newLine();
//        	
        	
		
		
		
        	for(Node na :nameA){
        	    System.out.println(na.data);
        	}
	        
//        	for(int w=0;w <arrnode1.length; w++)
//        	    System.out.print(arrnode1[w]+",");
//        	
//        	System.out.println("");
//        	for(int w = 0; w<arrnode2.length ;w++)
//        	    System.out.print(arrnode2[w]+";");
//        	System.out.println("");
        	
            }
            file1.close();
            file2.close();
            fileWrite.close();
            
            
            
        }
        catch(IOException err){
            err.printStackTrace();
            
        }
       long endTime =System.currentTimeMillis();
       System.out.println("Time:" + (endTime-startTime)/1000);
}
}
