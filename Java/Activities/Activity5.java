package Activities;

public class Activity5 {

    public static void main(String args[]){
        String bookTitle = "The Alchemsit";
        Book b = new Book.myBook();
        b.setTitle(bookTitle);
        System.out.println("The title of the book is: " + b.getTitle());

    }
}
