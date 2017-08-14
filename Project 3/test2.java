public static void main(String[] args) {
      int[] arr = new int[] {-4, -5, -3, -4, -1, -4, -5, -2, 3, -4, -1};
     
      System.out.println("Printing array using out1:");
      out1(arr, arr.length);
      System.out.println();
     
      System.out.println("Printing array using out2:");
      out2(arr, arr.length);
      System.out.println();
      
      System.out.println("Printing array using out3:");
      out3(arr, arr.length);
      System.out.println();
     
      System.out.println("The index of the largest number in the array is: " + largest(arr, arr.length));
      System.out.println();
      
      System.out.println("The sum of the max block of this array is: " + maxBlock(arr, arr.length));
      System.out.println();

      System.out.println("Array reversed:");
      reverse(arr, arr.length);
      out1(arr, arr.length);
      System.out.println();
     
         }
