package com.hyun.myproject2.service.impl;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import com.hyun.myproject2.dao.myBoardDao;
import com.hyun.myproject2.domain.myBoard;
import com.hyun.myproject2.service.myBoardService;

public class DefaultmyBoardService implements myBoardService{

  SqlSessionFactory sqlSessionFactory;

  public DefaultmyBoardService(SqlSessionFactory sqlSessionFactory) {
    this.sqlSessionFactory = sqlSessionFactory;
  }

  @Override
  public int add(myBoard myboard) {
    //스레드 마다 SqlSession이 구분되어야 한다. 즉 클라이언트 간의 트랜잭션이 분리되어야 한다.
    // 따라서 스레드가 서비스 메서드를 호출하는 시점에서 SqlSession을 얻어 DAO를 준비해야 한다.
    SqlSession session = sqlSessionFactory.openSession();
    myBoardDao myboardDao = session.getMapper(myBoardDao.class);
    return myboardDao.insert(myboard);
  }

  @Override
  public List<myBoard> list() {
    SqlSession session = sqlSessionFactory.openSession();
    myBoardDao myboardDao = session.getMapper(myBoardDao.class);
    return myboardDao.findAll();
  }

  @Override
  public myBoard get(int no) {
    SqlSession session = sqlSessionFactory.openSession();
    myBoardDao myboardDao = session.getMapper(myBoardDao.class);
    myBoard myboard = myboardDao.findByNo(no);
    System.out.println("get()" + myboard);
    if (myboard != null) {
      System.out.println("get()" + myboardDao.increaseViewCount(no));
      myboardDao.increaseViewCount(no);
    }
    return myboard;
  }

  @Override 
  public int update(myBoard myboard) {
    SqlSession session = sqlSessionFactory.openSession();
    myBoardDao myboardDao = session.getMapper(myBoardDao.class);
    return myboardDao.update(myboard);
  }

  @Override
  public int delete(myBoard myboard) {
    SqlSession session = sqlSessionFactory.openSession();
    myBoardDao myboardDao = session.getMapper(myBoardDao.class);
    return myboardDao.delete(myboard);
  }

  @Override
  public int size() {
    SqlSession session = sqlSessionFactory.openSession();
    myBoardDao myboardDao = session.getMapper(myBoardDao.class);
    return myboardDao.countAll();
  }
}
