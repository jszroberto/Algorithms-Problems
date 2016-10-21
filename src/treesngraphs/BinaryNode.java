package treesngraphs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Stack;

public class BinaryNode {

	public BinaryNode left = null;
	public BinaryNode right = null;
	public int value;

	public BinaryNode(int value) {
		this.value = value;
	}

	public void add(int value) {
		BinaryNode next = this;
		while (next != null) {
			BinaryNode parent = next;
			if (value == next.value) {
				return;
			} else if (value > next.value) {
				next = next.right;
				if (next == null)
					parent.right = new BinaryNode(value);
			} else {
				next = next.left;
				if (next == null)
					parent.left = new BinaryNode(value);

			}
		}

	}

	public boolean remove(int value, BinaryNode parent) {
		if (value < this.value) {
			if (left != null)
				return left.remove(value, this);
			else
				return false;
		} else if (value > this.value) {
			if (right != null)
				return right.remove(value, this);
			else
				return false;
		} else {
			if (left != null && right != null) {
				this.value = right.minValue();
				right.remove(this.value, this);
			} else if (parent.left == this) {
				parent.left = (left != null) ? left : right;
			} else if (parent.right == this) {
				parent.right = (left != null) ? left : right;
			}
			return true;
		}
	}
	
	private void visit(){
		System.out.print(value +" ");
	}
	
	public void postTrasversalIterative(){
		
		Stack<BinaryNode> stack = new Stack<BinaryNode>();
		HashSet<BinaryNode> visited = new HashSet<BinaryNode>();
		
		stack.push(this);
		
		while(!stack.isEmpty()){
			BinaryNode node = stack.peek();
			
			if(node.left != null && !visited.contains(node.left)){
				stack.push(node.left);
			}
			else if(node.right != null && !visited.contains(node.right)){
				stack.push(node.right);
			}else{
				BinaryNode n = stack.pop();
				visited.add(n);
				n.visit();
			}
		}
	}
	

	public void postTrasversalRecursive(){
		
		if(left != null){
			left.postTrasversalRecursive();
		}
		if(right != null){
			right.postTrasversalRecursive();
		}
		
		visit();
	}

	public int minValue() {
		if (left == null)
			return value;
		else
			return left.minValue();

	}
}
