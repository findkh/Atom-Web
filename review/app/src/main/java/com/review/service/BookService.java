package com.review.service;

import java.util.List;
import com.review.domain.Book;

public interface BookService {

  int add(Book book);

  List<Book> list();

  Book get(int no);

  int update(Book book);

  int delete(int no);
}