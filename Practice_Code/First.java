import java.util.Scanner;

public class First{
    public static void main(String[] args){
         System.out.println("Assalamu Alaikum");
         Scanner sc = new Scanner(System.in);
         
         System.out.println("Enput Name:");
         String string = sc.nextLine();
         System.out.println(string);

         System.out.println("Enter your age:");
         int n=sc.nextInt();
         System.out.println("Age "+n);

         System.out.println("Enput fraction:");
         double d=sc.nextDouble();
         System.out.println("Value "+d);

         System.out.println("Give single word");
         String word=sc.next();
         char ch=word.charAt(0);
         System.out.println("Word is "+"\""+word+"\""+ "\n"+ "First char is: " + "\""+ ch + "\"");

         System.out.print("Enter a boolean value (t/f): ");
        boolean bool = sc.nextBoolean();
        System.out.println("You entered boolean value: " + bool);

         System.out.println("\n" + "Now, check for array");
         System.out.println("Enter size of the Array:");
         int N=sc.nextInt();
         int[] a=new int[N];
         System.out.println("Enter the Element(size " + N + "): ");
         for(int i=0; i<N; i++){
            a[i]=sc.nextInt();
         }

         System.out.println("Array is:");
         for(int i=0; i<N; i++){
            System.out.print(a[i]+" ");
         }
         
         System.out.println("");
         sc.close();
    }
}   