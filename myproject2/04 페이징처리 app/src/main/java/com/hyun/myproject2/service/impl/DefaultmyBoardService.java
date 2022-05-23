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
    try (SqlSession session = sqlSessionFactory.openSession();) {
      myBoardDao myboardDao = session.getMapper(myBoardDao.class);
      int count = myboardDao.insert(myboard);
      session.commit();
      return count;

    } catch (RuntimeException e) {
      throw e;
    }
  }

  @Override
  public List<myBoard> list(int pageSize, int pageNo) {
    try (SqlSession session = sqlSessionFactory.openSession();) {
      myBoardDao myboardDao = session.getMapper(myBoardDao.class);
      return myboardDao.findAll(pageSize, ((pageNo - 1) * pageSize));
    } catch (RuntimeException e) {
      throw e;
    }
  }

  @Override
  public myBoard get(int no) {
    try (SqlSession session = sqlSessionFactory.openSession();) {
      myBoardDao myboardDao = session.getMapper(myBoardDao.class);
      myBoard myboard = myboardDao.findByNo(no);
      if (myboard != null) {
        myboardDao.increaseViewCount(no);
      }
      session.commit();
      return myboard;

    } catch (RuntimeException e) {
      throw e;
    }
  }


  @Override 
  public int update(myBoard myboard) {
    try (SqlSession session = sqlSessionFactory.openSession();) {
      myBoardDao myboardDao = session.getMapper(myBoardDao.class);
      System.out.println("update()메서드 : " + myboardDao);
      int count = myboardDao.update(myboard);
      System.out.println("update()메서드 : " + count);
      session.commit();
      return count;

    } catch (RuntimeException e) {
      throw e;
    }
  }

  @Override
  public int delete(myBoard myboard) {
    try (SqlSession session = sqlSessionFactory.openSession();) {
      myBoardDao myboardDao = session.getMapper(myBoardDao.class);
      int count = myboardDao.delete(myboard);
      session.commit();
      return count;

    } catch (RuntimeException e) {
      throw e;
    }
  }

  @Override
  public int size() {
    try (SqlSession session = sqlSessionFactory.openSession();) {
      myBoardDao myboardDao = session.getMapper(myBoardDao.class);
      return myboardDao.countAll();
    } catch (RuntimeException e) {
      throw e;
    }
  }
}