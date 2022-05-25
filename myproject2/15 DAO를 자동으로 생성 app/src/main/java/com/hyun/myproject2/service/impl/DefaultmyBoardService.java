package com.hyun.myproject2.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.hyun.myproject2.dao.myBoardDao;
import com.hyun.myproject2.domain.myBoard;
import com.hyun.myproject2.service.myBoardService;

@Service
public class DefaultmyBoardService implements myBoardService{

  myBoardDao myboardDao;

  public DefaultmyBoardService(myBoardDao myboardDao) {
    this.myboardDao = myboardDao;
  }

  @Transactional
  @Override
  public int add(myBoard myboard) {
    return myboardDao.insert(myboard);
  }

  @Override
  public List<myBoard> list(int pageSize, int pageNo) {
    return myboardDao.findAll(pageSize, ((pageNo - 1) * pageSize));
  }

  @Transactional
  @Override
  public myBoard get(int no) {
    myBoard myboard = myboardDao.findByNo(no);
    if (myboard != null) {
      myboardDao.increaseViewCount(no);
    }
    return myboard;
  }

  @Transactional
  @Override 
  public int update(myBoard myboard) {
    return myboardDao.update(myboard);
  }

  @Transactional
  @Override
  public int delete(myBoard myboard) {
    return myboardDao.delete(myboard);
  }

  @Override
  public int size() {
    return myboardDao.countAll();
  }

}