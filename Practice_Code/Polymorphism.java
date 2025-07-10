//Polymorphism--> same function using different way
class Student{
     String nm;
     int id;
     public void printInfo(String nm){
        System.out.println("1st Function");
         System.out.println("Name:"+this.nm);
     }
      public void printInfo(int id){
        System.out.println("2nd Function");
         System.out.println("ID:"+this.id);
     }
      public void printInfo(String nm, int id){
        System.out.println("3rd Function");
         System.out.println("Name:"+this.nm+"--"+"ID::"+id);
     }
    
}

public class Polymorphism {
    public static void main(String[] args) {
        Student s=new Student();
        s.nm="Rijwan";
        s.id=840;
        s.printInfo(s.nm);
        s.printInfo(s.id);
        s.printInfo(s.nm,s.id);
    } 
    
}
