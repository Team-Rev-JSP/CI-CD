package db;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.sql.*;

public class DbBridge {

  static Connection con = null;

  public static Connection getConnection() {

    if (con == null) {
      try {
        Context initCtx = new InitialContext();
        Context envCtx = (Context) initCtx.lookup("java:comp/env");
        DataSource ds = (DataSource) envCtx.lookup("jdbc/MysqlDB");
        con = ds.getConnection();
        con.setAutoCommit(false);
        System.out.println("DB 연결");
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
    return con;
  }
    /*
    public static void close(Connection con, PreparedStatement pstmt) {
        if(con != null) {
            try {
                con.close();
            } catch(Exception e) {
                e.printStackTrace();
            }
        }
        if(pstmt != null) {
            try {
                pstmt.close();
            } catch(Exception e) {
                e.printStackTrace();
            }
        }
    }*/

  public static void close(Connection con) {
    try {
      con.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static void close(Statement ps) {
    try {
      ps.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static void close(ResultSet rs) {
    try {
      rs.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  // 수동 커밋 ( commit-저장되지 않은 모든 데이터를 데이터베이스에 저장하고 현재의 트랜잭션을 종료하라는 명령
  public static void commit(Connection con) {
    try {
      con.commit();
      System.out.println("\ncommit success");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  // 수동 롤백(Rollback- 트랜잭션의 실패로 작업을 취소하고 이전 상태로 되돌리는 데이터제어어)
  public static void rollback(Connection con) {
    try {
      con.rollback();
      System.out.println("\nrollback success");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
