import java.util.Comparator;

public class Book implements Comparable <Book>{
    private String name;
    private int pageNumber;

    private String authorName;
    private int date;


    public Book(String name, int pageNumber, String authorName, int date) {
        this.name = name;
        this.pageNumber = pageNumber;
        this.authorName = authorName;
        this.date = date;
    }

    @Override
    public int compareTo(Book otherBook) {
        return this.getName().compareTo(otherBook.getName());
    }

    public static Comparator<Book> PageCountComparator = new Comparator<Book>() {
        @Override
        public int compare(Book book1, Book book2) {
            return book1.getPageNumber() - book2.getPageNumber();
        }
    };
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }
}
