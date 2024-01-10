import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        System.out.println("###############################################");

        Book book1 = new Book("Kuşlar Uçuyor", 150, "Kemalettin Badettin", 2014);
        Book book2 = new Book("Beni Okuma", 214, "Ayşe Fatma", 1978);
        Book book3 = new Book("Dünden Bugüne", 174, "Kel Mahmut", 2011);
        Book book4 = new Book("Şafak Operası", 500, "Canan Günaydın", 2018);
        Book book5 = new Book("Gaziantep Yemekleri", 345, "Emre Çakar", 1920);
        Set<Book> sortedBook = new TreeSet<>();
        sortedBook.add(book1);
        sortedBook.add(book2);
        sortedBook.add(book3);
        sortedBook.add(book4);
        sortedBook.add(book5);

        for (Book nameSortedBook : sortedBook) {
            System.out.println(nameSortedBook.getName());
        }
        System.out.println("###############################################");
        Set<Book> sortedPageNumber = new TreeSet<>(Book.PageCountComparator);
        sortedPageNumber.add(book1);
        sortedPageNumber.add(book2);
        sortedPageNumber.add(book3);
        sortedPageNumber.add(book4);
        sortedPageNumber.add(book5);

        for(Book pageNumberSorted : sortedPageNumber){
            System.out.println(pageNumberSorted.getName() + " isimli kitabın sayfa numarası : " + pageNumberSorted.getPageNumber());
        }
        System.out.println("###############################################");


    }
}