package DP23.Action.Iterator;
/**
 * Created by litianye on 2019-07-12
 */


/**
 * @program: spark
 *
 * @description:
 *
 * @author: litianye
 *
 * @create: 2019-07-12
 **/

public class BookShelf implements Aggregate {
    private Book[] books;
    private int cursor = 0;

    private BookShelf(int maxSize) {
        this.books = new Book[maxSize];
    }

    public Book getBook(int index) {
        return books[index];
    }

    public void appendBook(Book book) {
        this.books[cursor] = book;
        cursor ++;
    }

    public int getLength() {
        return books.length;
    }

    @Override
    public Iterator iterator() {
        return new BookShelfIterator(this);
    }
}
