//Sean Lee
//Project 5
//Due:5/4/2016 Turned In:5/4/2016
//The purpose of the this program is to create,manage,
//and modify binary search trees and thier nodes. It 
//contains methods to return data regarding the tree
//such as height, and the depth of the closest leaf.

class IntNode 
 {
   private int num;
   private IntNode left, right;
  
   public IntNode(int num) 
   {
    this.num = num;
    this.left = null;
    this.right = null;
    }
   
   public IntNode(int num, IntNode lf, IntNode rt) 
    {
     this.num = num;
     this.left = lf;
     this.right = rt;;
     }
    
   public int getNum() 
    {
     return num;
     }
    
   public void setLeft(IntNode pt) 
    {
     left = pt;
     }
    
   public void setRight(IntNode pt) 
    {
     right = pt;
     }
    
   public IntNode getLeft() 
    {
      return left;
     }
    
   public IntNode getRight() 
   {
     return right;
    }
   
}

class IntBST 
 {

   // member variable pointing to the root of the BST
   private IntNode root;
   
       // default constructor
   public IntBST() 
    {
     root = null;
     }
    
   // Copy Constructor
   // Driver Method
   public IntBST(IntBST t) 
    {
    if (t.root == null)
     {
      root = null;
      }
     else
      {
       root = copyTree(t.root);
       }
     }
     
    private IntNode copyTree(IntNode n)
      {
       IntNode left = n.getLeft();
       IntNode right = n.getRight();
       
       if (left != null) {
         left = copyTree(left);
         }
       if (right != null) {
         right = copyTree(right);
         }
       return new IntNode(n.getNum(), left, right);
      }
    
   // for output purposes -- override Object version
   public String toString() {
     return toString(root, 1);
     }
     
   private static String toString(IntNode l, int depth) {
      String s = "";
      if (l == null)
         ; // nothing to output
      else {
      if (l.getLeft() != null) // don't output empty subtrees
      s = '(' + toString(l.getLeft(), depth + 1) + ')';
      s = s + l.getNum() + "-" + depth;
      if (l.getRight() != null) // don't output empty subtrees
      s = s + '(' + toString(l.getRight(), depth + 1) + ')';
      }
      return s;
     }     
     
   //Is num in this tree
   //Driver Method
   public boolean search(int num) 
    {
     return search(root, num);
     }
   
   private boolean search(IntNode t, int num)
    {
     boolean result = false;
     
      if (t == null)
         result = false;
      else
       {
         if (num == t.getNum())
         	result = true;
         else
          {
            if (num < t.getNum())
               result = search(t.getLeft(),num);
            else
               result = search(t.getRight(), num);
            }
         }
       return result;
      }

   
   // Insert num into this tree
   // Driver Method
   public void insert(int num) 
    {
     root = insert(root,num);
     }
     
    private IntNode insert(IntNode t,int num) 
    {
     if (t == null)
      {
       t = new IntNode(num,null,null);
       }
     else if( t.getNum() == num)
       {
        //Already in list, do nothing
        }
     else if (num < t.getNum())
      {
       if (t.getLeft() != null)
        {
            insert(t.getLeft(),num);
        } 
        else
        {     
            t.setLeft(new IntNode(num));
        }
       }
     else if (num > t.getNum())
      {
       if (t.getRight() != null)
        {
            insert(t.getRight(),num);
        } 
        else
        {     
            t.setRight(new IntNode(num));
        }
       }
      return t;
     }
     
    
   // Returns the height of the tree
   // Driver Method
   public int height() 
    {
    int height = 0;
    if(this.root == null){
     height = 0;
     }
    else
    {
     height = height(root);
     }
     return height;
     }
     
   private int height(IntNode t)
    {
     int result = 0;
     int hLeft = 0;
     int hRight = 0;
    
    if(t.getLeft() != null)
       {
        hLeft = height(t.getLeft());
        }
    if(t.getRight() != null)
      {
       hRight = height(t.getRight());
       }
       
    if(hLeft > hRight)
      {
       result = hLeft+1;
       }
    else
     {
      result = hRight+1;
      }
    return result;
    }
    
    
   // The depth of the leaf closest to the root
   // Driver Method
   public int closeLeaf()
     {
         return closeLeaf(root); 
     }    
     
     
   private int closeLeaf(IntNode root)
    {
     int result = 0;
     
     //Base case:Empty tree. This accounts for height = 0.
     if (root == null)
        result = 0;
 
    // Base case : Leaf Node. This accounts for height = 1.
   else if (root.getLeft() == null && root.getRight() == null)
       result = 1;
 
    // If left subtree is NULL, recur for right subtree
    else if (root.getLeft() == null)
       result = closeLeaf(root.getRight())+ 1;
 
    // If right subtree is NULL, recur for right subtree
    else if (root.getRight() == null)
       result = closeLeaf(root.getLeft())+ 1;
       
    else
     {
      if(closeLeaf(root.getLeft()) <= closeLeaf(root.getRight())) 
       result = closeLeaf(root.getLeft())+1; 
      else
       result =  closeLeaf(root.getRight()) + 1;
      }  

    return result;
    }  
    
   // Return the median value of the nodes contained in the BST.
   // The median of an empty BST is -182182182.
   // Driver Method
   public int median() 
    {
    int result = 0;//shutting up the compiler.
    
    if (this.root == null)
     {
      result = -182182182;
      }
    else
     {
       int nodeCount= this.NumberOfNodes();
       int medianIndex = nodeCount/2;
       
       if(medianIndex*2 != nodeCount)
        {
         medianIndex = medianIndex+1;
         }
         
       result = median(root,medianIndex,nodeCount);
      }
      return result;
     }
     
   private static int median(IntNode t, int select, int size)
    {
     
     int result = 0;//shutting up the compiler.
     int leftCT = 0;//shutting up the compiler.
     int rightCT = 0;//shutting up the compiler.
        
   
        if(t.getLeft() !=null)
          {//count nodes in left subtree
           leftCT =NumberOfNodes(t.getLeft());
           }
           
        if(t.getRight() !=null)
          {//count nodes in right subtree
           rightCT =NumberOfNodes(t.getRight());
           }
         
        if (leftCT+1 == select)//check if the current node
         result = t.getNum(); //is the median.
        
        else if (leftCT >= select)
         { //check if median falls on left subtree
          result = median(t.getLeft(),select,leftCT);
          }
        
        else
         {//the median falls on right subtree
          int marker = select -(leftCT+1);
          result = median(t.getRight(),marker,rightCT);
          }
                                  
        return result;
        }

    
   // Replace with the “inorder successor”, i.e.,
   // the smallest in the right subtree.
   // Driver Method
   public void delete(int num) 
    {
     root = delete(num,root);
     }
    
     private IntNode delete( int val, IntNode t )
        {
         if( t == null )
           {//Item not found or empty tree,         
            }//so nothing to do.
         else
          {   
            if( val < t.getNum() )
             {//value in my left subtree
              if (t.getLeft() != null)
                t.setLeft(delete(val,t.getLeft()));
                }
            else if( val > t.getNum())
              {//value in my right subtree
               if (t.getRight() != null)
                t.setRight(delete(val,t.getRight()));
                }
            else
             { // t.getNum() == val;  
              if( t.getLeft() == null && t.getRight() == null )
               {//leaf, replace with null.
                t=null;
                }
              else if (t.getRight() == null)
               {//only a left child,replace with left child.
                t = t.getLeft();
                }
              else if (t.getLeft() == null)
               {//only a right child//replace with right child.
                t = t.getRight();
                }
              else
               {//both children, replace with "inorder successor".
                IntNode min = getMin(t.getRight());
                t.setRight(delete(min.getNum(),t.getRight()));
                min.setRight(t.getRight());
                min.setLeft(t.getLeft());
                t = min;
                }
               }
              }      
       return t;
      }

   //Rotate the node containing num to the left. 
   //Do nothing if not possible or if num is not 
   //in the tree.
   //Driver Method
   public void rotateLeft(int num) 
      {
       root=rotateLeft(root,num);
        }
    
    private static IntNode rotateLeft(IntNode T,int num){

      //easiest case
      if(T==null)
       {
        }           
      else if(num==T.getNum())
        {//rotation part
         IntNode oldRight=T.getRight();
         
         if(T.getRight()!=null)
          {
           T.setRight(oldRight.getLeft());
           oldRight.setLeft(T);
           T=oldRight;
           }
         else 
          {
           }
       }
       
       else if(num>T.getNum())
         {
          T.setRight(rotateLeft(T.getRight(),num));
          }
      else
        {
         T.setLeft(rotateLeft(T.getLeft(),num));
         }
      return  T;
     }    
     
   //Rotate the node containing num to the right. 
   //Do nothing if not possible or if num is not 
   //in the tree.
   //Driver Method
   public void rotateRight(int num)
     {
      root=rotateRight(root,num);
      }
      
   private static IntNode rotateRight(IntNode T,int num)
    {
      //easiest case
      if(T==null)
       {
        }
      else if(num==T.getNum())
       {//rotation part
        IntNode oldLeft=T.getLeft();
        
        if(T.getLeft()!=null)
        {
         T.setLeft(oldLeft.getRight());
         oldLeft.setRight(T);
         T=oldLeft;
         }  
        else 
         {
          }
         }
         
       else if(num>T.getNum())
         {
          T.setRight(rotateRight(T.getRight(),num));
          }
       else
         {
          T.setLeft(rotateRight(T.getLeft(),num));
          }
     return T;
    }   

               
   // Remove the largest leaf
   // Driver Method
   public void removeBigLeaf() 
    {
     if(this.root != null){
      removeBigLeaf(root);
      }
     }
  
   private void removeBigLeaf(IntNode t) 
    {
     if(t.getLeft() == null && t.getRight() == null)
      {
       delete(t.getNum());
       }
     else
      {
       if( t.getRight() == null && t.getLeft() != null)
        {
         removeBigLeaf(t.getLeft());
         }
       else
        {
         removeBigLeaf(t.getRight());
         }
        }
         
     }

    
   public static String myName() 
    {
     String myName = "Sean Lee";
     return myName;  
     }
     
//Utility Methods
    
    // Helper to return the smallest value 
    // in the given part of the tree.
    private IntNode getMin(IntNode start) {
        if (start.getLeft() == null) {
            // no left child, so this must be the
            // leftmost (min) node
            return start;
        } else {
            // I have a left child, so he must be 
            // smaller than me; go to the left
            return getMin(start.getLeft());
        }
    }
    
    // Helper to return the number of nodes
    // in a given tree or subtree.
    // Driver Method 
    public int NumberOfNodes()
     {
      return NumberOfNodes(root);
      }
      
    private static int NumberOfNodes(IntNode node)
     {
      int result = 0;//shutting up the compiler
      if(node == null)
       {
        }//do nothing
      else 
       {
        result +=1;
        result += NumberOfNodes(node.getLeft());
        result += NumberOfNodes(node.getRight());
        }
        return result;
       }
       
      
 
}