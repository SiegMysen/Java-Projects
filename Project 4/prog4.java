//Sean Lee
//Project 4
//Due:4/4/2016 Turned In:4/11/2016
//The purpose of the this program is to create,manage,
//and modify linked lists and thier nodes. It also 
//gives me a headache and makes me lose sleep.

class Node {

//instance variables for the 
//usual linked list object
private char letter;
private Node next;

// constructor
public Node(char ch, Node link) 
 {
  this.letter = ch;
  this.next = link;
  }

// getters and setters
public void setLetter(char letter) 
 {
  this.letter = letter;
  }
  
public char getLetter() 
 {
  return letter;
  }
 
public void setNext(Node next) 
 {
  this.next = next;
  }
 
public Node getNext() 
 {
  return next;
  }
    
}

class Word 
 {
 
//instance variable pointing to the 
//head of the linked list
private Node head;

// default constructor
public Word() 
 {
  head = null;
  }

// copy constructor 
public Word( Word word ) 
 {
  Node n = word.head;
  while( n != null)
    {
     addTail(n.getLetter());
     n = n.getNext();
  }
 }

//constructor from a String
public Word( String s ) 
 {
  for( int i = 0; i< s.length(); i++)
   {
    addTail(s.charAt(i)); 
     }
   }
         

public String toString() 
 { 
  return toString(head);
  }
  
//for output purposes -- override Object version
//no spaces between the characters, 
//no linefeeds/returns
public String toString(Node N) 
 {
  String result = "";
  if(N == null)
   {
    result = "";
    }
  else
   {
    result = N.getLetter() + toString(N.getNext());
    }
    return result;
    }


// how long is this Word
public int length() 
{
 return length(head);
 }

public int length(Node N)
 {
  int result=0;
  if( N != null)
   {
    result = length(N.getNext())+ 1;
    }
    return result;
   }

//append ch to the head of this Word
public void addHead( char ch ) 
 {
 Node temp = new Node(ch, head);
 if(head == null)
 { 
  head = temp;
  }
 else
 {
  temp.setNext(head);
  head = temp;
  }
 }
 
//append ch to the tail of this Word
//driver method
public void addTail (char ch)
 {
  head = addTail(ch,this.head);
  }

//Recursive method
private static Node addTail(char ch, Node L) 
 {
  if(L == null)
   {
    L = new Node(ch, null);
    }
  else
   {
    L.setNext(addTail(ch, L.getNext()));
    }
   return L;
  }
  
      

//modify this Word so it is reversed
//driver method
public void reverse() 
 {
  if ( head != null && head.getNext() != null)
  {
   reverse(head, head.getNext());
  }
 }
  
public Node reverse(Node previous, Node current) 
   {
    Node Result = null;
    if(previous == null)
        Result = null;
        
    if(previous.equals(head))//Puts the initial 
        previous.setNext(null);//head at the tail.
        
    if(current == null) //end of list, initial tail
    {                   //becomes the new head.
     head = previous;
     Result = head;
     } 
     
    else //reverses the remaining list
     {
      Node temp = current.getNext();
      current.setNext(previous);
      reverse(current, temp);
    }
    
    return Result;
}  

  

//remove all occurrences of ch 
//from this Word
public void removeChar( char ch ) 
 {
  if( head != null)
   {
     head = removeChar(ch, head);
     }
   }

//Recursive method  
private Node removeChar(char ch, Node n)
 {
  if( n == null)
   {
   //empty array, easiest case
    }
  else
   {
    n.setNext(removeChar(ch, n.getNext()));
    if(n.getLetter() == ch)
     {                     
       n = n.getNext();
       }
     }   
  return n;  
 }
           
//remove the first occurrence of the Word w 
//from this Word
public void removeWord(Word w) 
   {
   if(head != null)
     {
      removeWord(w, head);
      }
    }

private Node removeWord(Word w, Node n) 
   {
    Node o = w.head; // Node o tracks what letter of the
    boolean match = true;//pattern that we are searching for.
    if(n == null || n.getNext()== null || o == null) 
     {
     //easiest cases, empty lists
       }
       
    else if(this.head.getLetter() == o.getLetter())
      {//First letter of word found at start of list.
       Node z = n.getNext();
       o = o.getNext();
       while( o != null && match)
         {
          if( z == null && o != null)
           {
            match = false;
            }
          else
          {  
          if (z.getLetter() != o.getLetter())
           {
            match = false;
            }
          else
            {
             z = z.getNext();
             o = o.getNext();
             }           
            }
           }
          if(match)
            {
             this.head = z;
             }
             
           else
            {  
             removeWord(w, n.getNext());
             } 
            }        
       
    else if(n.getNext().getLetter() == o.getLetter()) 
      {//First letter of word found anywhere else.
       Node z = n.getNext();
       while( o != null && match)
         {
         if( z == null && o != null)
           {
            match = false;
            }
         else
          {  

          if (z.getLetter() != o.getLetter())
           {
            match = false;
            }
          else
            {
             z = z.getNext();
             o = o.getNext();
             }           
            }
           }
        if(match)
         {
          
          n.setNext(z);
          }
        else
         {  
          removeWord(w, n.getNext());
          }   
       }
       else if (n.getNext()!= null)
        {
         removeWord(w, n.getNext());
         }
             
      return n;    
      }  
         
 

// concatenate a copy of s to the end of this Word
// (Why do I want to use a copy?)
public void concatenate(Word s ) 
 {
  Word copy = new Word(s);//create a copy of the parameter
  concatenate(copy.head);
  } 
  
public void concatenate(Node pointer)
 {
  if ( pointer == null)
   {
    //empty list,easiest case
     }
  else
   {//Attach a letter of the word we are adding.
    addTail(pointer.getLetter()); 
    concatenate(pointer.getNext());//Move to the next letter. 
    }
   }
   

// reverse the first occurrence of w in this word
// for example, if this word is “helloworld” and w is “low” then
// this word should end up being “helwolorld”

// I'm sorry professor, I couldn't figure out how to do this
// recursively.
public void flipWord( Word w ) 
 {
  Word targetReversed = new Word(w);//Create a copy of the word we are looking for.
  targetReversed.reverse();//Reverse that word for concatenation and insertion.
  boolean valid = true;
  
  if(w.head != null)// If there is something to search for.
   {
    Word field = new Word();
    Word target = new Word();
    
    field.head = this.head;//creating copies to play with.
    target.head = w.head;
    
    Word marker = new Word();//creating a marker for where to cut apart
    marker.head = null;//the search field.
    
    while(w.head != null && valid) 
    {
     if(target.head == null)
     {
      if(marker.head == null)
       {
        this.head = targetReversed.head;
        this.concatenate(field);
        }
       else
        {
         marker.head.setNext(targetReversed.head);
         this.concatenate(field);
         }
       valid = false;
      }
     
     if(field.head == null)
       {
        valid = false;
        }
     if(target.head == null)
       {
        valid = false;
        } 
       
     if(valid && field.head.getLetter() == target.head.getLetter())
       {
        field.head = field.head.getNext();
        target.head = target.head.getNext();
        }
      else
       {
        if(marker.length()- field.length()> 1)
         {
          marker.head = marker.head.getNext();
          field.head = marker.head.getNext();
          }
        else if(valid)
         {
          marker.head = field.head;
          field.head=field.head.getNext();
          }
          
         target.head = w.head;
        }
       }
      }
     }

public static String myName() 
    {
     String myName = "Sean Lee";
     return myName;  
     }
    }