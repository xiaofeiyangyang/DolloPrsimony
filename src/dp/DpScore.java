package dp;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;



public class DpScore {
	public static int getDp(Node root , int[]ancA, int[] ancB){
		//public static List<Node> getDp(Node root){
			List<Node> Lst = new ArrayList<Node>();
			Set<Node> set = new HashSet<Node>();
			List<Node> result = new ArrayList<Node>();
			int dp = 0 ;
			Lst.add(root);
			int sumLeft = 0;
			int sumRight = 0;
			while(true){
				if(Lst.isEmpty()) break;
				
				Node node = Lst.get(0);
//				System.out.print(node.data + ",");
				result.add(node);
				set.add(node);
				Lst.remove(0);
				if(node.leftChild != null && set.contains(node.leftChild) == false){
					
					int sumA = ancA[node.data]-ancA[node.leftChild.data];
					int sumB = ancB[node.data]-ancB[node.leftChild.data];
					sumLeft = sumLeft + Math.abs(sumA-sumB);
					Lst.add(node.leftChild);
				}
				
				if(node.rightChild != null && set.contains(node.rightChild) == false){
					
					int sumA2 = ancA[node.data]-ancA[node.rightChild.data];
					int sumB2 = ancB[node.data]-ancB[node.rightChild.data];
					sumRight = sumRight + Math.abs(sumA2-sumB2);
					Lst.add(node.rightChild);
				}
				dp = sumLeft +sumRight;		
			}
			return dp;	
		 } 
		}

