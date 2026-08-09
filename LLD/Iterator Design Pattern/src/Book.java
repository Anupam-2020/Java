import java.util.ArrayList;
import java.util.List;

class Book {
    private String name;

    public Book(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

interface Iterator<T> {
    boolean hasNext();

    T next();
}

interface Aggregate<T> {
    Iterator<T> createIterator();
}

class BookShelf implements Aggregate<Book> {
    private List<Book> books = new ArrayList<>();

    public void add(Book book) {
        books.add(book);
    }

    public List<Book> getBooks() {
        return books;
    }

    @Override
    public Iterator<Book> createIterator() {
        return new BookIterator(this);
    }
}

class BookIterator implements Iterator<Book> {

    private BookShelf shelf;

    private int index = 0;

    public BookIterator(BookShelf shelf) {
        this.shelf = shelf;
    }

    @Override
    public boolean hasNext() {
        return index < shelf.getBooks().size();
    }

    @Override
    public Book next() {
        return shelf.getBooks().get(index++);
    }
}