package com.review.service;

import java.util.List;
import com.review.domain.Contact;


public interface ContactService {

  int add(Contact contact);

  List<Contact> list();

  Contact get(int no);

  int update(Contact contact);

  int delete(int no);

}
