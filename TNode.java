

	public class TNode<T extends Comparable<T>> implements Comparable<TNode<T>> { 
		MyType data; 
		TNode left; 
		TNode right; 
		public TNode(T data) {  
			this.data = new MyType(data); 
			} 
		
		public MyType getData() {
			return data;
		}

		public void setData(MyType data) {
			this.data = data;
		}

		public TNode getLeft() { 
			return left; 
			} 
		public void setLeft(TNode left) { 
			this.left = left;
			} 
		public TNode getRight() {  
			return right;
			} 
		public void setRight(TNode right) {
			this.right = right;
			} 
		public boolean isLeaf(){   
			return (left==null && right==null);   
			} 
		public boolean hasLeft(){ 
			return left!=null;  } 
		public boolean hasRight(){  
			return right!=null; 
			} 
		public String toString() {        
		return   this.getData()+" " ;    }
		@Override
		public int compareTo(TNode<T> o) {
		    return this.data.compareTo(o.data);
		}
		} 

