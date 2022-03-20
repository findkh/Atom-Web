package com.review.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.review.dao.ContactDao;
import com.review.domain.Contact;
import com.review.domain.ContactTel;

@RestController 
public class ContactController {

  @Autowired
  ContactDao contactDao;

  @RequestMapping("/contact/list")
  public Object list() {
    //    List<Contact> contacts = contactDao.findAll(); //연락처 목록을 가져온다.
    //    for (Contact contact : contacts) { //연락처 목록에서 연락처 하나씩 꺼낸다.
    //      int contactNo = contact.getNo(); //연락처에서 연락처 번호를 꺼낸다.
    //      List<ContactTel> tels = contactDao.findByContactNo(contactNo); //연락처 번호에서 전화번호 목록을 꺼낸다.
    //      contact.setTels(tels); //꺼낸 전화번호 목록을 전화번호에 담는다.
    //    }
    //    return contacts;

    List<Contact> contacts = contactDao.findAll();
    for (Contact contact : contacts) {
      contact.setTels(contactDao.findTelByContactNo(contact.getNo())); 
    }
    return contacts;
  }

  @RequestMapping("/contact/add")
  public Object add(Contact contact, String[] tel) throws Exception {

    /*파라미터 값을 제대로 받았는지 확인
    System.out.println(contact);
    System.out.println(tel);
    for(String t : tel) {
      System.out.print(t + ",");
    }
    System.out.println();
    return 0;
     */

    contactDao.insert(contact);

    /* 줄여쓰기
    for(String t : tel) {
      ContactTel contactTel = new ContactTel();
      contactTel.setTel(t);
      contactDao.insertTel(contactTel);
    } */

    for(int i = 0; i < tel.length; i++) {
      String[] value = tel[i].split(",");
      if(value[1].length() == 0) {
        continue;
      }
      contactDao.insertTel(new ContactTel(contact.getNo(), Integer.parseInt(value[0]), value[1]));
    }

    return 1;

  }

  @RequestMapping("/contact/get")
  public Object get(int no) {
    Contact contact = contactDao.findByNo(no);
    if (contact == null) {
      return "";
    }
    contact.setTels(contactDao.findTelByContactNo(no));
    return contact;
  }

  @RequestMapping("/contact/update")
  public Object update(Contact contact, String[] tel) throws Exception {
    int count =  contactDao.update(contact); //넘어온 연락처 정보를 저장한다.
    if (count > 0) { // 변경된 것이 있다면 
      contactDao.deleteTelByContactNo(contact.getNo()); //그 넘어온 연락처의 모든 전화번호를 지운다.
      for(int i = 0; i < tel.length; i++) {
        String[] value = tel[i].split(",");
        if(value[1].length() == 0) { //전화번호를 입력 안했으면 다음 데이터를 가져온다.
          continue;
        }
        contactDao.insertTel(new ContactTel(contact.getNo(), Integer.parseInt(value[0]), value[1])); //새로 등록한다.
      }
    }
    return count;
  }

  @RequestMapping("/contact/delete")
  public Object delete(int no) throws Exception {
    contactDao.deleteTelByContactNo(no);
    return contactDao.delete(no);
  }

}
