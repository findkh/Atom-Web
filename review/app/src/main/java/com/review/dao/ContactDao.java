package com.review.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.review.domain.Contact;
import com.review.domain.ContactTel;

@Mapper
public interface ContactDao {

  int countAll(); // ==> <select id="com.eomcs.mylist.dao.ContactDao.countAll">...</select> 

  List<Contact> findAll();

  int insert(Contact contact);

  Contact findByNo(int no);

  Contact findByEmail(String email);

  List<Contact> findByName(String name);

  int update(Contact contact);

  int delete(int no);

  List<ContactTel> findTelByContactNo(int contactNo);

  int insertTel(ContactTel tel);

  int updateTel(ContactTel tel);

  int deleteTel(int telNo);

  int deleteTelByContactNo(int contactNo);
}