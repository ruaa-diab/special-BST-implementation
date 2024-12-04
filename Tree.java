
public class Tree<T extends Comparable<T>> {

	private TNode root;

	public void traverseInOrder() {
		traverseInOrder(root);
	}

	private void traverseInOrder(TNode node) {
		if (node != null) {
			if (node.left != null)
				traverseInOrder(node.left);
			System.out.print(node + " ");
			if (node.right != null)
				traverseInOrder(node.right);
		}
	}

	public TNode getRoot() {
		return root;
	}

	public void setRoot(TNode root) {
		this.root = root;
	}

	public void traversePreOrder() {
		traversePreOrder(root);
	}

	private void traversePreOrder(TNode node) {
		if (node == null)
			return;
		System.out.print(node + " ");
		traversePreOrder(node.getLeft());
		traversePreOrder(node.getRight());
	}

	public void traversePostOrder() {
		traversePostOrder(root);
	}

	private void traversePostOrder(TNode node) {
		if (node == null)
			return;
		traversePreOrder(node.getLeft());
		traversePreOrder(node.getRight());
		System.out.print(node + " ");
	}

	public TNode find(T data) {
		return find(data, root);
	}

	public TNode find(T data, TNode node) {
		if (node != null) {
			int comp = node.data.compareTo((MyType) data);
			if (comp == 0)
				return node;
			else if (comp > 0 && node.hasLeft())
				return find(data, node.left);
			else if (comp < 0 && node.hasRight())
				return find(data, node.right);
		}
		return null;
	}

	public TNode largest() {
		return largest(root);
	}

	public TNode largest(TNode node) {
		if (node != null) {
			if (!node.hasRight())
				return (node);
			return largest(node.right);
		}
		return null;
	}

	public TNode smallest() {
		return smallest(root);
	}

	public TNode smallest(TNode node) {
		if (node != null) {
			if (!node.hasLeft())
				return (node);
			return smallest(node.left);
		}
		return null;
	}

	public int height() {
		return height(root);
	}

	public int height(TNode node) {
		if (node == null)
			return 0;
		if (node.isLeaf())
			return 1;
		int left = 0;
		int right = 0;
		if (node.hasLeft())
			left = height(node.left);
		if (node.hasRight())
			right = height(node.right);
		return (left > right) ? (left + 1) : (right + 1);
	}

	public int size() {
		return size(root);
	}

	private int size(TNode<T> curr) {
		if (curr == null)
			return 0;
		return 1 + size(curr.getLeft()) + size(curr.getRight());
	}

	public void insert(T data) {
		if (isEmpty())
			root = new TNode(data);
		else
			insert(data, root);
	}

	public void insert(T data, TNode node) {
		if (data.compareTo((T) node.getData().getData()) == 0) {
			node.getData().insert(data);
		}else
		
		if (data.compareTo((T) node.getData().getData()) > 0) { // insert into right subtree
			if (!node.hasRight())
				node.right = new TNode(data);
			else
				insert(data, node.right);
		} else { // insert into left subtree
			if (!node.hasLeft())
				node.left = new TNode(data);
			else
				insert(data, node.left);
		}
	}

	private boolean isEmpty() {

		return root == null;
	}

	public TNode<Character> expression_tree(String p) {
	    LinkedStack<TNode<Character>> k = new LinkedStack<>();
	    TNode<Character> node, l, r;

	    for (int i = 0; i < p.length(); i++) {
	        char c = p.charAt(i);

	        // If it's not an operator, create a new node and push it onto the stack
	        if (c != '*' && c != '/' && c != '+' && c != '-') {
	            node = new TNode<>(c); 
	              k.push(node);
	        	
	        } else {
	            
	            r = k.pop(); 
	            l = k.pop(); 

	            // Create a new node with the operator as data
	            node = new TNode<>(c);
	            node.setLeft(l);  // Set the left subtree
	            node.setRight(r); // Set the right subtree

	            // Push the new subtree back onto the stack
	            k.push(node);
	        }
	    }

	   
	    return k.pop(); 
	}
	
	
	
	
	private TNode getSuccessor(TNode node) {
		
		
		TNode parent=node;
		TNode successor=node;
		TNode curr=node.getRight();
		
		
		
		while(curr!=null) { 
		parent=successor;
		node=curr;
		curr=curr.getLeft();
			
		}
		
		if(successor !=node.getRight()) {
			parent.setLeft(successor.getRight());
			
			successor.setRight(node.getRight());
			
		}
		
		return successor;
		
		
		
		
		
	}
	
	
	
	
	
	public TNode delete(T data) {
		TNode curr=root;
		TNode parent=root;
		boolean isLeftChild=false;
		if(isEmpty()) {return null;}
		while(curr!=null&&data.compareTo((T)curr.getData())!=0) {
			parent=curr;
			if(data.compareTo((T)curr.getData())<0) {
				curr=curr.getLeft();
				isLeftChild=true;
			}else {
				curr=curr.getRight();
				isLeftChild=false;
			}
		}
		
		
		
		if(curr==null) {return null;}
		if(!curr.hasLeft()&&!curr.hasRight()) {
			if(curr==root) {
				root=null;
			}else if(isLeftChild) {
				parent.setLeft(null);
			}else {
				parent.setRight(null);
			}
			
		}
		else if(curr.hasLeft()&&!curr.hasRight()) {
			if(curr==root) {
				root=curr.getLeft();
			}else if(isLeftChild) {
				parent.setLeft(curr.getLeft());
			}else {
				parent.setRight(curr.getLeft());
			}
		}
		
		else if(!curr.hasLeft()&&curr.hasRight()) {
			
				if(curr==root) {
					root=curr.getRight();
				}else if(isLeftChild) {
					parent.setLeft(curr.getRight());
				}else {
					parent.setRight(curr.getRight());
				}
			}
		
		
		else {
			TNode successor=getSuccessor(curr);
			
			
			if(curr==root) {
				root=successor;
			}else if(isLeftChild) {
				parent.setLeft(successor);
			}else {
				parent.setRight(successor);
			}
			
			
			successor.setLeft(curr.getLeft());
		}
			
		
		
		
		
		
		
		
		return curr;
	}
	
	
	
	
	
	
	public TNode search(T data) {
	    return search(data, root);
	}

	private TNode search(T data, TNode node) {
	    if (node == null) {
	        return null;
	    }

	    // Compare data with the current node's data
	    if (data.compareTo((T) node.getData()) == 0) {  // Assuming getData() is the correct method
	        return node;
	    } else if (data.compareTo((T) node.getData()) < 0) {
	        return search(data, node.getLeft());
	    } else {
	        return search(data, node.getRight());
	    }
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
