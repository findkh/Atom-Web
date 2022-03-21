package com.review.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.support.TransactionTemplate;
import com.review.dao.ContactDao;
import com.review.domain.Contact;
import com.review.domain.ContactTel;

//@Service
public class TransactionTemplateContactService {
  @Autowired
  ContactDao contactDao;

  @Autowired
  TransactionTemplate transactionTemplate;

  public int add(Contact contact) {

    /* 원본
     class ContactAddTransaction implements TransactionCallback<Integer>{
      @Override
      public Integer doInTransaction(TransactionStatus status) {
        contactDao.insert(contact);
        for(ContactTel tel : contact.getTels()) {
          tel.setContactNo(contact.getNo()); //전화번호 입력 전에 자동 생성된 연락처 번호를 설정한다.
          contactDao.insertTel(tel);
        }
        return 1;
      }
    }
    return transactionTemplate.execute(new ContactAddTransaction());*/

    /*익명클래스로 만들기
    TransactionCallback<Integer> contactAddTransaction = new TransactionCallback<>() {
      @Override
      public Integer doInTransaction(TransactionStatus status) {
        contactDao.insert(contact);
        for(ContactTel tel : contact.getTels()) {
          tel.setContactNo(contact.getNo()); //전화번호 입력 전에 자동 생성된 연락처 번호를 설정한다.
          contactDao.insertTel(tel);
        }
        return 1;
      }
    };
    return transactionTemplate.execute(contactAddTransaction);*/


    /* 더 줄여쓰기
    return transactionTemplate.execute(new TransactionCallback<>() {
      @Override
      public Integer doInTransaction(TransactionStatus status) {
        contactDao.insert(contact);
        for(ContactTel tel : contact.getTels()) {
          tel.setContactNo(contact.getNo()); //전화번호 입력 전에 자동 생성된 연락처 번호를 설정한다.
          contactDao.insertTel(tel);
        }
        return 1;
      }
    });*/

    //람다 문법 적용
    return transactionTemplate.execute(status -> { 
      contactDao.insert(contact);
      for(ContactTel tel : contact.getTels()) {
        tel.setContactNo(contact.getNo()); //전화번호 입력 전에 자동 생성된 연락처 번호를 설정한다.
        contactDao.insertTel(tel);
      }
      return 1;
    });

  }

  public List<Contact> list() {
    List<Contact> contacts = contactDao.findAll();
    for (Contact contact : contacts) {
      contact.setTels(contactDao.findTelByContactNo(contact.getNo())); 
    }
    return contacts;
  }

  public Contact get(int no) {
    Contact contact = contactDao.findByNo(no);
    if (contact != null) {
      contact.setTels(contactDao.findTelByContactNo(no));
    }
    return contact;
  }

  public int update(Contact contact) {
    /* 원본 
    1. 트랜잭션으로 묶어서 실행할 작업을 스프링 규칙에 따라 정의한다.
    class ContactUpdateTransaction implements TransactionCallback<Integer> {
      @Override
      public Integer doInTransaction(TransactionStatus status) {
        int count =  contactDao.update(contact);
        if (count > 0) {
          contactDao.deleteTelByContactNo(contact.getNo()); //전화번호 변경 전에 기존 전화번호를 모두 삭제한다.
          for(ContactTel tel : contact.getTels()) {
            contactDao.insertTel(tel); //전화번호 객체 안에 이미 연락처 번호가 저장되어 있다.
          }
        }
        return count;
      }
    }

    //2. 트랜잭션을 실행시킨다.
    return transactionTemplate.execute(new ContactUpdateTransaction());*/

    /*익명클래스로 전환 
     1. 트랜잭션으로 묶어서 실행할 작업을 스프링 규칙에 따라 정의한다.
    TransactionCallback<Integer> contactUpdateTransaction = new TransactionCallback<>() {
      @Override
      public Integer doInTransaction(TransactionStatus status) {
        int count =  contactDao.update(contact);
        if (count > 0) {
          contactDao.deleteTelByContactNo(contact.getNo()); //전화번호 변경 전에 기존 전화번호를 모두 삭제한다.
          for(ContactTel tel : contact.getTels()) {
            contactDao.insertTel(tel); //전화번호 객체 안에 이미 연락처 번호가 저장되어 있다.
          }
        }
        return count;
      }
    };

    //2. 트랜잭션을 실행시킨다.
    return transactionTemplate.execute(contactUpdateTransaction); */

    /*익명 클래스를 파라미터에 바로 주기
    return transactionTemplate.execute(new TransactionCallback<>() { //1. 트랜잭션으로 묶어서 실행할 작업을 스프링 규칙에 따라 정의한다.
      @Override
      public Integer doInTransaction(TransactionStatus status) {
        int count =  contactDao.update(contact);
        if (count > 0) {
          contactDao.deleteTelByContactNo(contact.getNo()); //전화번호 변경 전에 기존 전화번호를 모두 삭제한다.
          for(ContactTel tel : contact.getTels()) {
            contactDao.insertTel(tel); //전화번호 객체 안에 이미 연락처 번호가 저장되어 있다.
          }
        }
        return count;
      }
    });*/

    //람다 문법 적용
    return transactionTemplate.execute( status  -> {
      int count =  contactDao.update(contact);
      if (count > 0) {
        contactDao.deleteTelByContactNo(contact.getNo()); //전화번호 변경 전에 기존 전화번호를 모두 삭제한다.
        for(ContactTel tel : contact.getTels()) {
          contactDao.insertTel(tel); //전화번호 객체 안에 이미 연락처 번호가 저장되어 있다.
        }
      }
      return count;
    });
  }

  public int delete(int no) {
    return transactionTemplate.execute(status -> {
      contactDao.deleteTelByContactNo(no);
      return contactDao.delete(no);
    });
  }
}
