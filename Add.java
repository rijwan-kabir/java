import java.util.Scanner;
public class Add{
    private int x;
    public Add(int x){
        this.x=x;
    }
    public Add Addition(Add a){
        return new Add(x+a.x);
    }
    public void display(){
        System.out.println("X: "+x);
    }
    public static void main(String[] a){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter x:");
        Add c=new Add(sc.nextInt());

        System.out.println("Enter x:");
        Add d=new Add(sc.nextInt());
        Add Final=c.Addition(d);
        c.display();
        d.display();
        Final.display();
        sc.close();
    }
}