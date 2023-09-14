import java.util.Iterator;
import java.util.*;

public class SetIterator<E> implements Iterator<E> {
	//remove all comments once it can work
	private E max;
	private TreeNode<E> index;
	private TreeNode<E> root;
	private int size;
	private TreeDisplay<E> display;
	
	
	public SetIterator(TreeNode<E> r, int s, TreeDisplay<E> d) {
		root = r;
		size = s;
		display = d;
		TreeNode<E> temp = root;
		while(temp.getLeft()!=null) {
			temp=temp.getLeft();
		}
		index = temp;
		//max = MyTreeSet.peekMax();
		
		
	}
	public boolean hasNext() {
		//if(index.getValue().compareTo(max)<0)return true;
		return false;
	}

	public E next() {
		if(index.getRight()!=null) {
			index= index.getRight();
			return index.getValue();
		}
		 TreeNode<E> temp = root;
		  while(temp!=null) {
			  /*if(index.getValue().compareTo(temp.getValue())<0) {
				  if(index.getValue().compareTo(peekMax(temp.getLeft()))==0){
					  index = temp;
					  return index.getValue();
				  }
				  temp = temp.getLeft();
			  }else if(index == root){
				  temp = temp.getRight();
				  while(temp.getLeft()!=null) {
					  temp = temp.getLeft();
				  }index = temp;
				  return index.getValue();
			  }else {
				  temp = temp.getLeft();
			  }*/
		  }
		  return null;
	}
	  
  }