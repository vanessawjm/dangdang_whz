package com.baizhi.util;

import java.io.IOException;
import java.io.Reader;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisUtils
{
  private static SqlSessionFactory sqlSessionFactory = null;
  private static final ThreadLocal<SqlSession> tol = new ThreadLocal<SqlSession>();
  
  static
  {
    try
    {
      Reader resourceAsReader = Resources.getResourceAsReader("mybatis-config.xml");
      sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsReader);
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }
  
  public static SqlSession getSqlSession()
  {
    SqlSession sqlSession = (SqlSession)tol.get();
    if (sqlSession == null)
    {
      sqlSession = sqlSessionFactory.openSession();
      tol.set(sqlSession);
    }
    return sqlSession;
  }
  
  public static void close()
  {
    SqlSession sqlSession = (SqlSession)tol.get();
    if (sqlSession != null)
    {
      sqlSession.close();
      tol.remove();
    }
  }
  
  public static void commit()
  {
    getSqlSession().commit();
    close();
  }
  
  public static void rollback()
  {
    getSqlSession().rollback();
    close();
  }
}
