//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        BookShelf shelf = new BookShelf();

        shelf.add(new Book("Java"));
        shelf.add(new Book("Spring"));
        shelf.add(new Book("Kafka"));

        Iterator<Book> iterator = shelf.createIterator();

        while(iterator.hasNext()) {
            Book book = iterator.next();
            System.out.println(book.getName());
        }


//        List<Book> list = new ArrayList<>();
//        list.add(new Book("Java"));
//        list.add(new Book("Spring"));
//        list.add(new Book("Kafka"));
//
//        Iterator<Book> iterator = list.stream().iterator();
//
//        while(iterator.hasNext()) {
//            Book data = iterator.next();
//            System.out.println(data.getName());
//        }
    }
}