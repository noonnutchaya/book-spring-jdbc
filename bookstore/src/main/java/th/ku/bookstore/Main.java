package th.ku.bookstore;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        BookDao bookDao = context.getBean("bookDaoImp", BookDao.class);

//        // ---- insert book ----
//        Book newBook = new Book("c",20,5);
//        bookDao.save(newBook);
//
//        // ---- select book ----
//        Book spring = bookDao.findById(1);
//        System.out.println("---getOne: " + spring);
//
//        List<Book> bookList = bookDao.findAll();
//        for (Book book : bookList) {
//            System.out.println(book);
//        }
//
//        // ---- update book ----
//        newBook.setPrice(600);
//        bookDao.update(4, newBook);
//
//        spring = bookDao.findById(1);
//        System.out.println("---fineById: " + spring);

        // ---- delete book ----
//        bookDao.deleteById(5);

        List<Book> bookList = bookDao.findAll();
        for (Book book : bookList) {
            System.out.println(book);
        }

    }
}
