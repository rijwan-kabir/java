import java.util.ArrayList;

class Book{
    private String isbn;
    private String title;
    private String author;
    public Book(String isbn,String title,String author){
        this.isbn=isbn;
        this.title=title;
        this.author=author;
    }
    public void display(){
        System.out.println("ISBN:"+isbn+" Title:"+title+" Author:"+author);
    }
    public String toString(){
      return (isbn+" "+title+" "+author);
    }
}
public class Library {
    private String LibraryId;
    private String location;
    ArrayList<Book>bk=new ArrayList<Book>();
    public Library(String LibraryId,String location){
        this.LibraryId=LibraryId;
        this.location=location;
    }
    public void addBook(Book b){
        bk.add(b);
    }
    public void listBook(){
        for(Book b : bk){
            System.out.println("Library ID:"+LibraryId+" Location:"+location);
         // System.out.println(b);
          b.display();
          System.out.println("------------------------------------------------");
        }
    }
    public void display(){
        System.out.println("Library ID:"+LibraryId+" Location:"+location);
    }
    public static void main(String[] a){
       Library l=new Library("101","DIU LIB");
       l.display();

       Book b1=new Book("111","cp1","mam");
       Book b2=new Book("112","cp2","mam1");
       Book b3=new Book("113","cp3","mam1");

       l.addBook(b1);
       l.addBook(b2);
       l.addBook(b3);

       l.listBook();

    }
}
