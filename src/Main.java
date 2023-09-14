
public class Main(String[] args){

	public static void main(String[] args) {
		TreeDisplay d = new TreeDisplay();
		MyTreeSet<String> tree = new MyTreeSet<String>(true);
		//modify the elements of the list to change the values of the tree. Can also add
		//items individually by calling tree.add(...). Inputs can be of any type but
		//must be of the same type. Change the type in line 6 to set type. The tree.iterator
		//method does not work, do not uncomment. When you press run, it will create a visual display
		//of the tree and it's elements
		String[] list = new String[]{"m","b","f","g","x","y","h","w","w"};
		tree.add(list);
		//System.out.println(tree.add("w"));
		//SetIterator<String> it = tree.iterator();
		/*tree.add(3);
		tree.add(19);
		tree.add(1);
		tree.add(22);*/
		System.out.println(tree.peekMin());
		System.out.println(tree.peekMax());
		//System.out.println(tree.contains(5));
		//System.out.println(tree.contains(6));
		System.out.println(tree.depth());
		System.out.println(tree.size());
		
	}

}
