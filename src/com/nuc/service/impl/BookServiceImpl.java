package com.nuc.service.impl;

import com.nuc.dao.BookDao;
import com.nuc.dao.impl.BookDaoImpl;
import com.nuc.entiy.Book;
import com.nuc.service.BookService;
import com.nuc.util.BaseDao;
import com.nuc.util.DatabaseUtil;
import com.nuc.util.Page;

import java.util.ArrayList;
import java.util.List;

public class BookServiceImpl implements BookService {

    //查看所有图书
    @Override
    public List<Book> listBook(Page page) {
        List<Book> booklist = new ArrayList<Book>();
        BookDao bookDao = new BookDaoImpl();
        booklist = bookDao.listBook(page);
        return booklist;
    }

    //修改图书
    @Override
    public boolean updateBook(Book book) {
        boolean result = false;
        BookDao bookDao = new BookDaoImpl();
        result = bookDao.updateBook(book);
        return false;
    }

    //删除图书
    @Override
    public boolean deleteBook(Book book) {
        boolean result = false;
        BookDao bookDao = new BookDaoImpl();
        result = bookDao.deleteBook(book);
        return result;
    }

    //添加图书
    @Override
    public boolean addBook(Book book) {
        boolean result = false;
        BookDao bookDao = new BookDaoImpl();
        result = bookDao.addBook(book);
        return result;
    }

    //按条件查询图书
    @Override
    public List<Book> listBookKey(Book book, Page page) {
        List<Book> bookList = new ArrayList<Book>();
        BookDao bookDao = new BookDaoImpl();
        bookList = bookDao.listBookKey(book,page);
        return bookList;
    }

    @Override
    public int sumBook(Book book) {
        BookDao bookDao = new BookDaoImpl();
        return bookDao.sumBook(book);
    }

    @Override
    public int sumBook() {
        int result = 0;
        BookDao bookDao = new BookDaoImpl();
        result = bookDao.sumBook();
        return result;
    }
}
