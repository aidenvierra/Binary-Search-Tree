import java.util.*;

public class MyTreeSet<E extends Comparable<E>> /*implements Iterable<E>*/
{
  private TreeNode<E> root;
  private int size;
  private TreeDisplay<E> display;
  
  public MyTreeSet(boolean useDisplay)
  {
    root = null;
    size = 0;
    if (useDisplay)
      display = new TreeDisplay<E>();
    else
      display = null;
    updateDisplay();
  }
  
  /*public Iterator<E> iterator(){
	  return new SetIterator<E>(root, size, display);
  }*/
  
  //returns number of elements in set
  public int size()
  {
    return size;
  }
  
  //precondition: set is not empty
  //returns minimum value in set
  public E peekMin()
  {
	TreeNode<E> temp = root;
	while(temp.getLeft()!=null) 
		temp = temp.getLeft();
	return temp.getValue();
  }
  
  //precondition: set is not empty
  //returns max value in set
  public E peekMax()
  {
	  TreeNode<E> temp = root;
	  while(temp.getRight()!=null)
		  temp = temp.getRight();
	  return temp.getValue();
  }
  
  //returns max value child of a given node.
  public E peekMax(TreeNode<E> start) {
	  TreeNode<E> temp = start;
	  while(temp.getRight()!=null)
		  temp = temp.getRight();
	  return temp.getValue();
  }
  
  //returns depth of tree
  public int depth()
  {
	  TreeNode<E> temp = root;
	  return depthHelp(temp);
  }
  public int depthHelp(TreeNode<E> temp)
  {
	  if(temp == null)return 0;
	  return 1+Math.max(depthHelp(temp.getLeft()), depthHelp(temp.getRight())); 
  }
  
  //returns true or false depending if given value is in tree
  public boolean contains(E obj)
  {
	  TreeNode<E> temp = root;
	  while(temp!=null) {
		  if(obj.compareTo(temp.getValue())<0) {temp = temp.getLeft();}
		  else if(obj.compareTo(temp.getValue())>0) {temp = temp.getRight();}
		  else return true;
	  }
	  return false;
  }
  
  //adds value to tree. Returns true or false if it successfully adds value
  public boolean add(E obj)
  {
	  if(contains(obj)) {
		  return false;
	  }
	  if(root==null) {
		  root = new TreeNode<E>(obj);
		  updateDisplay();
		  size = 1;
		  return true;
	  }
	  TreeNode<E> temp = root;
	  while(temp!=null) {
		  	if(obj.compareTo(temp.getValue())<0) {
		  		if(temp.getLeft()==null) {
		  			temp.setLeft(new TreeNode<E>(obj));
		  			updateDisplay();
		  			size++;
		  			return true;
		  		}
		  		temp = temp.getLeft();
		  	}
		  	else {
		  		if(temp.getRight()==null) {
		  			temp.setRight(new TreeNode<E>(obj));
		  			updateDisplay();
		  			size++;
		  			return true;
		  		}
		  		temp = temp.getRight();
		  	
		  	}
	  }updateDisplay();
	  return false;
  }
  
  //allows adding multiple objects at one time using a list of said objects. Will return a 
  //list of objects that were not added, or null if all were added.
public Object[] add(E[] objects) {
	ArrayList<E> failed = new ArrayList<E>();
	for(int i = 0; i<objects.length; i++){
		if(!add(objects[i])) {
			failed.add(objects[i]);
		}
	}Object[] failedToAdd = failed.toArray();
	return failedToAdd;
}
  
//removes element from tree
//returns true or false if successfully removed the element
public boolean remove(E obj)
  {
	size--;
    TreeNode<E> r = root;
    TreeNode<E> parent = null;
    while(r!=null) {
    	if(obj.compareTo(r.getValue())<0) {
    		parent = r;
    		r = r.getLeft();
    	}
    	else if(obj.compareTo(r.getValue())>0) {
    		parent = r;
    		r = r.getRight();
    	}
    	else {
    		//case 1
    		if(r.getLeft()==null) {
    			if(parent!=null) {
    				if(parent.getLeft()==r) {
    					parent.setLeft(r.getRight());
    				}else {
    					parent.setRight(r.getRight());
    				}updateDisplay();
					return true;
    			}
    			root=r.getRight();
    			updateDisplay();
    			return true;
    		//case 2
    		}else if(r.getLeft().getRight()==null) {
    			r.getLeft().setRight(r.getRight());
    			if(parent!=null) {
    				if(parent.getLeft()==r) {
    					parent.setLeft(r.getLeft());
    				}else {
    					parent.setRight(r.getLeft());
    				}
    			}else{root=r.getLeft();}
    			updateDisplay();
    			return true;
    		//case 3
    		}else {
    			TreeNode<E> pre = r;
    			TreeNode<E> preParent = r.getLeft();
    			pre=pre.getLeft().getRight();
    			while(pre.getRight()!=null) {
    				preParent = preParent.getRight();
    				pre=pre.getRight();
    			}
    			preParent.setRight(pre.getLeft());
    			pre.setRight(r.getRight());
    			pre.setLeft(r.getLeft());
    			if(parent!=null) {
    				if(parent.getLeft()==r) {
    					parent.setLeft(pre);
    				}else {
    					parent.setRight(pre);
    				}
    			}else {
    				root=pre;
    			}updateDisplay();
    			return true;
    		}
    	}
    }
    size++;
	return false;
  }
  public Object[] remove(E[] objects) {
	ArrayList<E> failed = new ArrayList<E>();
	for(int i = 0; i<objects.length; i++){
		if(!remove(objects[i])) {
			failed.add(objects[i]);
		}
	}Object[] failedToAdd = failed.toArray();
	return failedToAdd;
}
  
  private void updateDisplay()
  {
    if (display != null)
    {
      display.setTitle("size:  " + size);
      display.setRoot(root);
    }
  }
  
  //returns a 
  public String toString()
  {
    return toString(root);
  }
//returns a string representation of the contents of the tree
//uses preorder tree traversal
  private String toString(TreeNode<E> t)
  {
    if (t == null)
      return ".";
    else
      return t.getValue() + toString(t.getLeft()) + toString(t.getRight());
  }
  
  /*public class SetIterator<E> implements Iterator<E> {
	  
	private E max;
	private TreeNode<E> index;
	
	
	public SetIterator() {
		TreeNode<E> temp = root;
		while(temp.getLeft()!=null) {
			temp=temp.getLeft();
		}
		index = temp;
		max = peekMax();
		
	}
	public boolean hasNext() {
		if(index.getValue().compareTo(max)<0)return true;
		return false;
	}

	public E next() {
		if(index.getRight()!=null) {
			index= index.getRight();
			return index.getValue();
		}
		 TreeNode<E> temp = root;
		  while(temp!=null) {
			  if(index.getValue().compareTo(temp.getValue())<0) {
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
			  }
		  }
		  return null;
	}
	  
  }*/
}