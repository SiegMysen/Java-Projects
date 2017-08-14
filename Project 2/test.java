public class test
{

   public static void main(String[]args)
      {
       BigInt A = new BigInt("123456789");
       BigInt B = new BigInt (123456789);
       BigInt C = new BigInt (123456789);
       BigInt D = new BigInt (B);
       BigInt F = B.times(C);
      
       
       System.out.println("Answer: " +F);
       
       
       
       
       
       
       
       }
  
 }