import java.util.Scanner;
public class Fib{
    public static void main(String[] a){
        Scanner sc = new Scanner(System.in);
        int n;
        System.out.println("Enter the Number: ");
        n=sc.nextInt();

        int v1=0,v2=1;
        //System.out.print(v1 + " " + v2 + " ");
        for(int i=0; i<n; i++){
            System.out.print((v2) + " ");
            int temp=v2;
            v2=v1+v2;
            v1=temp;
        }
        sc.close();
    }
}