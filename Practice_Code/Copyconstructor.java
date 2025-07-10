class Student{
     String nm;
     String id;
     public void printInfo(){
         System.out.println("Name:"+this.nm);
          System.out.println("Id:"+this.id);
     }
     Student(Student s2){
         this.nm=s2.nm;
         this.id=s2.id;
     }
   Student(){
       
   }
}

public class Copyconstructor {
    public static void main(String[] args) {
        Student s=new Student();
        s.nm="Rijwan";
        s.printInfo();
        Student s2=new Student(s);
        s2.printInfo();
    
    }
}