import java.util.Scanner;
public class Prime{
    public static void main(String[] a){
       Scanner sc = new Scanner(System.in);

       System.out.println("Enter value: ");
       int n=sc.nextInt();
       boolean flag=true;
       if(n<=1) System.out.println("Not Prime");
       else{
         for(int i=2; i<=(int)Math.sqrt(n); i++){
            if(n%i==0){
                flag=false;
                break;
            }
         }
         if(flag) System.out.println("Prime");
         else System.out.println("Not Prime");
       }
       sc.close();
    }
}