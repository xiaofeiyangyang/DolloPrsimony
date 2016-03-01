package dp;

import java.util.ArrayList;
import java.util.List;



public class Node {
    Node leftChild;
    Node rightChild;
    int data;
    
    public Node(Node leftChild,Node rightChild,int data){
        this.leftChild = leftChild;
        this.rightChild = rightChild;
        this.data = data;
    }
    
    public boolean getPath(Node root,Node decNode,List<Node> array){
        boolean findResult = false;
        if(null != root){
            if(root == decNode){
            	
                array.add(root);
                findResult = true;
            }
            if(!findResult&& root.leftChild!=null){
                findResult = this.getPath(root.leftChild, decNode, array);
                
                if(findResult){
                	
                    array.add(root);
                    
                }
            }
            if(!findResult&& root.rightChild!=null){
                findResult = this.getPath(root.rightChild, decNode, array);
                if(findResult){
                    array.add(root);
                    
                }
            }
        }
        
        return findResult;
    }
    
    public static Node getCommonRoot(Node root,Node a,Node b){
        Node common = null;
        List<Node> pathA = new ArrayList<Node>();
        List<Node> pahtB = new ArrayList<Node>();
        a.getPath(root, a, pathA);
        b.getPath(root, b, pahtB);
       
        for(Node NodeA:pathA){
            for(Node NodeB:pahtB){
                if(NodeA == NodeB){
                    common = NodeA;
                    break;
                }
            }
            if(null!=common){
                break;
            }
        }
        return common;
    }
 
    
    
public static List<Node> getParent(Node root, Node desc){
	 
	 List<Node> path = new ArrayList<Node>();
	 desc.getPath(root, desc, path);
	
	 //parent = path.get(path.size()-1);
	return path;
    	
    }
 
 public static Node getParentLate(Node root, Node desc){
	 List<Node> path = new ArrayList<Node>();
	 desc.getPath(root, desc, path);
	 Node late;
	 
	 late = path.get(1);
	  
	 return late;
  
    }
 
 public static List<Node> getLongList(List<Node> list1, List<Node> list2){
	if(list1.size()>list2.size()){
		return list1;
	}else{
		return list2;
	}
 }
 
 public static int getMinRetain(List<Node> list1, List<Node> list2){
	 
	 list1.retainAll(list2);
	 int min = list1.size();
	 return min;
 }
 

}
