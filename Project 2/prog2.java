//Sean Lee
//Project 2
//Due:2/17/2016 Turned In:2/22/2016
//The purpose of this program is to construct,compare, increment, add, and multiply Big Integers. 

class BigInt 
{
   private int digit[];         // represent the integer as an array of digits
   private int size;            // number of digits in the integer
   private final int max = 50;  // maximum number of digits in the integer
   
   public BigInt() 
   {
    size =1;
    digit= new int[max];
    digit[0]=0;
    
         // default constructor
   }
   public BigInt(String num) 
   {  // constructor with initial String value
      size = num.length();
      digit = new int[max];
      for (int ct = size - 1; ct >= 0; ct --) 
      {
         digit[ct] = Integer.parseInt(num.substring(size - ct - 1, size - ct));
      }
   }
     
     
   public int NumberOfDigits(int num) //Determines the number of digits in the integer passed as a parameter
   {
      int testDigit= num;
      int numberOfDigits = 1;
      while (testDigit > 9) 
      {
         testDigit = testDigit/10;
         numberOfDigits++;
      }
      return numberOfDigits;
   }
   
   public BigInt(int num) 
   {  // constructor with initial integer value
      int testDigit = num;
      size = NumberOfDigits(testDigit);
      digit = new int[max];
      int victim = num;
       
      
      for (int i =0; i < size; i++)
      {
         if (victim > 9)
         {
            int choppedOff = victim % 10;
            digit[i] = choppedOff;  
            victim = victim/10;
         }
         else
         {
            digit[i]=victim;
         }
      }
   }
    
 
   public BigInt(BigInt num) // copy constructor
   {
    size = num.size;
    digit = new int[max];
    
    for (int i = 0;i<size; i++)
     {
      digit[i] = num.digit[i];
     }         
   }


   public String toString()
   { // override Object’s version
      String intString = "";
      for (int ct = size - 1; ct >= 0; ct --) {
         intString = intString + String.valueOf(digit[ct]);
      }
      return intString;
   }
      
  public int compareTo(BigInt other) //Compares the length of two BigInts and determines the longer. 
       { 
        int marker=0;
        
        if( size > other.size)
           marker = 1;
           
        else if( size < other.size)
           marker = -1;
           
        for (int i =other.size-1; i>=0 && marker == 0;i--)
          {
           if (digit[i] < other.digit[i])
               marker = -1;
           else if (digit[i] > other.digit[i])
                marker = 1;
           }
         return marker;        
          }  
 
   public BigInt plus(BigInt arg) // add two BigInt’s
      {
       int carryOver = 0;
       BigInt answer;
            answer = new BigInt(this);
       
       if (this.size > arg.size) //Determines the longer of the two BigInts. 
         { 
          answer.size = this.size;
          }
              
       else
         {
          answer.size = arg.size;
          }
            
       for (int i = 0; i <= answer.size-1; i++) //Adds the numbers
          { 
           answer.digit[i] += (arg.digit[i] + carryOver);
           carryOver = answer.digit[i] / 10;
           answer.digit[i] = answer.digit[i] % 10;
           }
         if(carryOver > 0) {
            answer.digit[answer.size] = carryOver;
            answer.size++;
             }           
        return answer;
      }
           
 public BigInt times(BigInt other) 
      { // multiply two BigInts
       
        BigInt result = new BigInt();
        BigInt product = new BigInt();
        int carryOver = 0;
      
        result.size = 0;
        product.size = 0; 
        
         for(int i = 0; i < other.size; i++) 
          {
            carryOver = 0; //makes sure the carry is 0 before it enters the loop for the second time
            if(i > 0) 
             {
               for(int d = 0; d <= i; d++) 
                  result.digit[i-d] = 0;
              }
              result.size =i+(this.size);
              
            for(int x = 0; x < this.size; x++) 
             {               
               if(i > 0) 
                {
                  result.digit[i+x] = ((other.digit[i] * this.digit[x]) + carryOver) % 10; //mulitply operation
                  carryOver = (other.digit[i] * this.digit[x]+carryOver)/ 10;
                   
                   
                     
                 } 
               else 
                { 
                  result.digit[x] = ((other.digit[i] * this.digit[x]) + carryOver) % 10; //mulitply operation
                  carryOver = ((other.digit[i] * this.digit[x])+carryOver) / 10;  
                 }         
            }
            if( carryOver > 0) //if a carry remains and all the mulitplication has been done
                {  
                  result.digit[result.size] = carryOver; //set the last digit to the carry
                  result.size++;                                
                  
              } 
            
            product.size =result.size;
            product = product.plus(result);                
         } 
      return product;
      }
            
         
         
      public void inc()//Increments the array by one. 
         {
          boolean carry = false;
          digit[0] += 1;
          if (digit[0] >=10)
           {
            digit[0] -=10;
            carry = true;
            for (int i = 0; i<size && carry; i++)
              {
               digit[i+1] += 1;
               if (digit[i+1] >= 10)
                  {
                   digit[i+1] -=10;
                  }
               else 
                {
                carry = false;
          } 
         } 
        } 
       }

    
   static String myName() 
    {
     String myName = "Sean Lee";
     return myName;  
     }


           }  
       
     
  
      

    
         
  
   
     
     


