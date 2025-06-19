import java.util.*;
class Participant {
    private String Name;
    private String handle;
    public Participant(String Name, String handle){
        this.Name=Name;
        this.handle=handle;
    }
    public void display(){
        System.out.println(Name+","+handle);
    }
}

class Contest{
    private String title;
    private String date;
    public Contest(String title, String date){
        this.title=title;
        this.date=date;
    }
    public void display(){
        System.out.println(title);
        System.out.println(date);
    }
}

class Registration{
    private Participant p;
    private Contest c;
    private int solve;
    private static int count=0;
    public Registration(Participant par, Contest cont, int solve){
        p=par;
        c=cont;
        this.solve=solve;
        count++;
    }

    public static int getCount(){
        return count;
    }

    public void display(){
        c.display();
        p.display();
        System.out.println("Solved: "+solve);
        System.out.println("Total Participant: "+ count);
    }
}
public class CP_Platform_System {
    public static void main(String[] a){
        Scanner sc = new Scanner(System.in);
        String title,date,name,handle;
        int n,no;
        ArrayList<Registration>pr=new ArrayList<Registration>();
        no=sc.nextInt(); sc.nextLine();
        for(int i=0;i<no;i++){
            title=sc.nextLine(); 
            date=sc.nextLine();
            Contest c = new Contest(title, date);

            name=sc.nextLine(); 
            handle=sc.nextLine();
            Participant p = new Participant(name, handle);

            n=sc.nextInt();
            sc.nextLine();
            Registration r = new Registration(p, c, n);
            pr.add(r);
        }

        for(int i=0; i<pr.size(); i++){
            pr.get(i).display();
        }
      sc.close();
    }
}
