public class Participant {
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