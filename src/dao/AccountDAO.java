package dao;

import static db.DbBridge.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import vo.AccountVO;

public class AccountDAO {
    DataSource ds;
    Connection con;
    private static AccountDAO AccountDAO;

    private AccountDAO() {
        // TODO Auto-generated constructor stub
    }

    public static AccountDAO getInstance(){
        if(AccountDAO == null){
            AccountDAO = new AccountDAO();
        }
        return AccountDAO;
    }

    public void setConnection(Connection con){
        this.con = con;
    }
    public int insertAccount(AccountVO param){ // 회원가입
        int result = 0;
        PreparedStatement ps = null;
        String id = param.getId();
        String password = param.getPassword();
        String nickname = param.getNickname();

        String sql = "INSERT INTO account (id, password, nickname) VALUES (?,?,?)";

        try{
            ps = con.prepareStatement(sql);
            ps.setString(1, id);
            ps.setString(2, password);
            ps.setString(3, nickname);
            result = ps.executeUpdate();
        } catch (Exception e){
            e.printStackTrace();
        } finally{
            close(ps);
        }
        return result;
    }
    public int getAccount(AccountVO param){ // 로그인
        int result = 0;
        ResultSet rs;
        PreparedStatement ps = null;
        String id = param.getId();
        String password = param.getPassword();

        String sql = "SELECT password from account WHERE id = ?";

        try{
            String check = "";
            ps = con.prepareStatement(sql);
            ps.setString(1, id);
            rs = ps.executeQuery();
            while(rs.next()) {
                check = rs.getString(1);
            }
            if(password.equals(check)) {
                System.out.print("login success");
                result = 1;
            }else System.out.print("login failed");
        } catch (Exception e){
            e.printStackTrace();
        } finally{
            close(ps);
        }
        return result;
    }


}