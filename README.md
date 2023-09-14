# Binary-Search-Tree
Implementation of a binary search tree with list nodes as the substructure.

Code located under src. Code for the BST under MyTreeSet.java
Run program under Main.java, explaination for how to run it is under there.
BSTBeast.java is a test program for MyTreeSet.java

Constructor:
Takes in one parameter, a boolean useDisplay which if true will create a display of the tree

Methods:  
size() --> returns number of elements in tree  
peekMin() --> Preconditions: set is not empty  
              returns minimum value in set  
peekMax() --> Preconditions: set is not empty  
              returns maximum value in set  
peekMax(TreeNode<E>) --> returns the maximum value child of a given node  
depth() --> returns depth of tree  
contains(E) --> returns true or false depending if given value is in tree  
add(E) --> adds value to tree  
          returns true or false if successfully adds value  
add(E[]) --> adds all values in the list to tree  
            returns a list of objects it failed to add  
remove(E) --> remove value from tree  
              returns true or false if successfully removes value  
remove(E[]) --> removes all values in the list from tree  
                returns a list of objects it failed to remove  
toString() --> returns a string representation of the contents of the tree  
              uses preorder tree traversal  