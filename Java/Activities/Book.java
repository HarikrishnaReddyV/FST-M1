package Activities;

abstract class Book {
    String title;

     abstract void setTitle(String S);
    String getTitle(){
        return title;
    }
     static class myBook extends Book {
        //Define abstract method
        public void setTitle(String bookName) {
            title = bookName;
        }
    }

}
