//Sean Lee
//Project 1
//Due:2/3/2016 Submitted:2/3/2016
//This program implements several methods onto a passed number in order to
//find the most signifigant digit, number of divisors, wheter the number
//is abundant, the number of abundant numbers less than or equal to the
//number, and the next largest square abundant number. 



class Utilities 
 {
// return the most significant digit of num
static int mostSignificantDigit( int num ) 
 {
  int firstDigit = num;
  // Each loop iteration cuts a number off the end until you are left with just the first. 
  while (firstDigit > 9) 
    {
     firstDigit = firstDigit/10; 
     }
   
  return firstDigit;
   
 }
   
// return the number of divisors of num
static int numberOfDivisors( int num ) 
 {

   int count = 0;
   //Each loop determines wheter an integer (i) is a divisor of num.
   for (int i =1; i <= num; i++)
     {
      if (num % i == 0) 
        {
         count ++;
         }
  }
  int numberOfDivisors = count;
  return numberOfDivisors;
 }
   
// return true if num is abundant, that is, the sum of its divisors is >= 2 * num
// e.g., 20, 28, and 30 are abundant numbers
static boolean abundant( int num ) 
 {
  int abundantPool = 0;
  boolean abundantCheck = false;
  int addToPool = 0;
 //Each loop checks wheter a number is a factor of num, and if it is that number is
 //added into a pool of factors.Factors are only added to the pool once, numbers are only 
 //checked up until the square root of the given number.
 //
  for (int i =1; i*i <= num; i++)
     {
      if (num % i == 0) 
        {
         int dividend = num/i;
         if (dividend == i)
           {
            addToPool = i;
           }
         else
         {  
         addToPool = i + dividend;
         }
         abundantPool += addToPool;
         }
      }
  if (abundantPool >= 2 * num)
    abundantCheck = true;
    
   
  return abundantCheck;
 }
      


// return the number of abundant numbers <= num
// be sure this is not too slow when num is large
static int abundantCount( int num ) 
 {
  int abundantCountNumber = 0;
  
  //Each loop determines wheter a given number is abundant, 
  //and if it is, the occurence is logged. 
  for (int externalIndex = 1; externalIndex <= num; externalIndex++)
   {
   
      if(abundant(externalIndex))
       {
        abundantCountNumber++;
       }
 
  }
  return abundantCountNumber;
 }

// return the smallest int >= num that is both abundant and a square
static int nextSquareAbundant ( int num ) 
 {
 
   boolean is_abundant;
   int square = 0;
   int ladderStep = 0; 
   int limit = num / 2;
  
   //ladderStep sequentially increments to form square, 
   //which is then compared to num to see if the number is
   //equal or greater. ladderStep has a limiter in order to
   //ensure that even if the square variable exceeds num,
   //that square will be the next square number after num.
   
     while(square < num && ladderStep <= limit)
     {
      ladderStep++;
      square = ladderStep * ladderStep;
     }
   //Square numbers are checked to see if they are abundant.
   is_abundant = abundant(square);
   //If the square number is not abundant, this determines the
   //next square. 
   if(!is_abundant)
     {
      while(!is_abundant)
       {
         ladderStep++;
         square = ladderStep * ladderStep;
         is_abundant = abundant(square);
       }
     }
   return square;
   }
   
// returns your name
static String myName() 
 {
   String myName = "Sean Lee";
   return myName;  
     }
     
}
    
    
  
 

