package com.myproject.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.myproject.dao.myBoardDao;
import com.myproject.domain.myBoard;
import com.myproject.service.myBoardService;

@Service
public class DefaultmyBoardService implements myBoardService{

  @Autowired
  myBoardDao myboardDao;

  @Override
  @Transactional
  public int add(myBoard myboard) {
    return myboardDao.insert(myboard);
  }

  @Override
  public List<myBoard> list() {
    return myboardDao.findAll();
  }

  @Override
  public myBoard get(int no) {
    myBoard myboard = myboardDao.findByNo(no);
    if (myboard != null) {
      myboardDao.increaseViewCount(no);
    }
    return myboard;
  }

  @Override
  @Transactional
  public int update(myBoard myboard) {
    return myboardDao.update(myboard);
  }

  @Override
  @Transactional
  public int delete(myBoard myboard) {
    return myboardDao.delete(myboard);
  }
}
