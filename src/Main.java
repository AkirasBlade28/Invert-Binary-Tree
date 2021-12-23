/*
 * Given the root 
 * of a binary tree, 
 * invert the tree, 
 * and return its root.
 * Input: root = [4,2,7,1,3,6,9]
   Output: [4,7,2,9,6,3,1]
		in:	4 				
		  /   \
		 2	   7
		/ \   / \
	   1   3 6   9
	   
	   out: 4
		  /   \
		 7	   2
		/ \   / \
	   9   6 3   1
 */
public class Main {
		
	public static void main(String[] args) {
		System.out.println("Input root:\n");
		
		var a = new TreeNode(4); // root//null,null
		
		var b = new TreeNode(4, a, null);
		var c = new TreeNode(7, null, a);
		var d = new TreeNode(1, b, null);
		var e = new TreeNode(3, null, b);
		var f = new TreeNode(6, c, null);
		var g = new TreeNode(9, null, c);
		
	    TreeNode[] solution = {a,b,c,d,e,f,g};
	    for(var element : solution)	
	    	System.out.println(element.getVal()+" - node value| " +
	    			element.getLeft()+" - left parent node| "+
	    			element.getRight()+" -right parent node|\n");
	   
	    for(var element : solution) {
	    	element.invertTreeSolution(element);
	    }
	    System.out.println("\nAfter inverting - tree looks:\n");
	    for(var element : solution)	// print/stream
	    	System.out.println(element.getVal()+" - node value| " +
	    			element.getLeft()+" - left parent node| "+
	    			element.getRight()+" -right parent node|\n");
	    System.out.println("\nValues of nodes:");
	    System.out.println(a.getVal()+"\n"+
	    		f.getRight().getVal()+"\n"+
	    		d.getRight().getVal()+"\n"+
	    		g.getVal()+"\n"+
	    		f.getVal()+"\n"+
	    		e.getVal()+"\n"+ // if swapping had not occurred
	    		d.getVal());    // this would yield a mistake for node 
	    					   // of parent null ???
	}		    			

}
	
	 class TreeNode extends Main {
		private int val;
		private	TreeNode left = null;
		private TreeNode right = null;
		// constructors
		TreeNode() {} // for empty root
		
		TreeNode(int val) { this.val = val; } // if only root
		
		TreeNode(int val, TreeNode left, TreeNode right)
		{
			this.val = val;
			this.left = left;
			this.right = right;
		}	
		
		public int getVal ()
		{
			return val;
		}
		public TreeNode getLeft ()
		{
			return left;
		}
		public TreeNode getRight()
		{
			return right;
		}
		
		public TreeNode invertTreeSolution(TreeNode root) {
			
			if( root == null) { // if root 0 return nothing
				return root;
			}
			
			TreeNode left = invertTreeSolution(root.getLeft());
			TreeNode right = invertTreeSolution(root.getRight());
			
			//Swapping
			root.left = right;
			root.right = left;
			
			return root;
		}
	}
	



