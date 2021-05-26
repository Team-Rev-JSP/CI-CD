package com.sh.project.db;

import com.sh.project.db.DbBridge;
import project.vo.UserVO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CardDAO {
    public static String joinUser() {
        String result = "";

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = "SELECT id from test";

        try {
            con = DbBridge.getCon();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            if (rs.next()) {
                result = rs.getString("id");
                System.out.print("있다");
            }

        } catch (Exception e) {

        } finally {
            DbBridge.close(con, ps);
        }
        return result;
    }
}
