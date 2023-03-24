package examples;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}

public class Tree {
    
	public static void main (String[] args) throws Exception{
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        
	        int t=Integer.parseInt(br.readLine());
	        while(t > 0){
	            int n=Integer.parseInt(br.readLine().trim());
	            String s[] = br.readLine().trim().split(" ");

	            int target=Integer.parseInt(br.readLine().trim());
    	    	Node root = null;
                for(int i=0;i<n;i++){
                    root=insert(root,Integer.parseInt(s[i]));
                }
        	    Solution g = new Solution();
        	    System.out.println(g.maxDifferenceBST(root,target));
                t--;
            
        }
    }

    public static Node insert(Node tree, int val) {
        Node temp = null;
        if (tree == null) return new Node(val);
    
        if (val < tree.data) {
            tree.left = insert(tree.left, val);
        } else if (val > tree.data) {
            tree.right = insert(tree.right, val);
        }
    
        return tree;
    }
  
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public static int maxDifferenceBST(Node root,int target)
    {
        //Please code here
        Node temp=root;
        int sum1=0;
        int sum2=0;
        while(target==temp.data || target<temp.data && temp.left!=null || target>temp.data && temp.left!=null){
            if(temp.data==target){
                if(root.data<target){
                while(true){
                    if(temp.left!=null){
                        temp=temp.left;
                        sum2+=temp.data;
                        System.out.println(sum2);
                    }else if(temp.right!=null){
                        temp=temp.right;
                        sum2+=temp.data;
                    }else{
                        return (sum1-sum2);
                    }
                }
                }else{
                    while(true){
                        if(temp.right!=null){
                        temp=temp.right;
                        sum2+=temp.data;
                    }else if(temp.left!=null){
                        temp=temp.left;
                        sum2+=temp.data;
                    }else{
                        return (sum1-sum2);
                    }
                }
                }
        }
        if(target<temp.data){
            sum1+=temp.data;
            System.out.println(sum1);
            temp=temp.left;
        }
        if(target>temp.data){
            sum1+=temp.data;
            temp=temp.right;
        }
        
        }
        return -1;
        
        
    }
}