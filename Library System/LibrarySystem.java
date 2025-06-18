class Book {
    String title;
    String author;
    String isbn;

    Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

    void showInfo() {
        System.out.println("Book: " + title + " by " + author + " (ISBN: " + isbn + ")");
    }
}

class Member {
    String name;
    String memberId;

    Member(String name, String memberId) {
        this.name = name;
        this.memberId = memberId;
    }

    void showInfo() {
        System.out.println("Member: " + name + " (ID: " + memberId + ")");
    }
}

class Loan {
    Book book;
    Member member;

    Loan(Book book, Member member) {
        this.book = book;
        this.member = member;
    }

    void showLoanInfo() {
        System.out.println("--- Loan Info ---");
        book.showInfo();
        member.showInfo();
    }
}

public class LibrarySystem {
    public static void main(String[] args) {
        Book b1 = new Book("Java Basics", "James Gosling", "123456");
        Member m1 = new Member("Rizwan", "M001");

        Loan loan1 = new Loan(b1, m1);

        loan1.showLoanInfo();  // Show association info
    }
}
