package dao;

import static db.DbBridge.*;

import vo.CardVO;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CardDAO {
    DataSource ds;
    Connection con;
    private static CardDAO cardDAO;

    private CardDAO() {
        // TODO Auto-generated constructor stub
    }

    public static CardDAO getInstance() {
        if (cardDAO == null) {
            cardDAO = new CardDAO();
        }
        return cardDAO;
    }

    public void setConnection(Connection con) {
        this.con = con;
    }

    /* ---------------------INSERT---------------------------
     사용자가 등록을 할때 DB에 등록된 값을 삽입해주는 메서드 */
    public int insertCard(CardVO param) {
        int result = 0;
        PreparedStatement ps = null;

        String sql = "INSERT INTO card (name, phone, email, position, address, fax, url, company, photo_path, uid) VALUES (?,?,?,?,?,?,?,?,?,?)";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, param.getName());
            ps.setString(2, param.getPhone());
            ps.setString(3, param.getEmail());
            ps.setString(4, param.getPosition());
            ps.setString(5, param.getAddress());
            ps.setString(6, param.getFax());
            ps.setString(7, param.getUrl());
            ps.setString(8, param.getCompany());
            ps.setString(9, param.getPhoto_path());
            ps.setString(10, param.getUid());
            result = ps.executeUpdate();
            System.out.println("check");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(ps);
        }
        return result;
    }
    /* ---------------------SELECT---------------------------
        한개의 명함만 가져오고 싶을때 사용하는 메서드  */

    public CardVO findOneCard(int idx) {
        CardVO vo = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = "SELECT * FROM card WHERE idx = ?";

        try {
            System.out.println("findOneCard idx : " + idx);
            ps = con.prepareStatement(sql);
            ps.setInt(1, idx);
            rs = ps.executeQuery();

            if (rs.next()) {
                vo = new CardVO();
                vo.setId(rs.getInt("idx"));
                vo.setName(rs.getString("name"));
                vo.setPhone(rs.getString("phone"));
                vo.setEmail(rs.getString("email"));
                vo.setPosition(rs.getString("position"));
                vo.setAddress(rs.getString("address"));
                vo.setFax(rs.getString("fax"));
                vo.setUrl(rs.getString("url"));
                vo.setCompany(rs.getString("company"));
                vo.setPhoto_path(rs.getString("photo_path"));
                vo.setUid(rs.getString("uid"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(ps);
            close(rs);
        }
        return vo;
    }

    //전체 명함의 개수 구하기
    public int getListCount() {
        int count = 0;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = "SELECT count(*) from card";

        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(ps);
            close(rs);
        }
        return count;
    }

    // 메인화면에 현재 명함들을 List로 전부 가지고오는 메서드
    public List<CardVO> getCardList(int page, int limit, String  uid) {
        List<CardVO> list = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        CardVO card = null;

        String sql = "SELECT * FROM card WHERE uid = ? ORDER BY idx DESC limit ?, ?";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, uid);
            ps.setInt(2, page*limit);
            ps.setInt(3, limit);
            rs = ps.executeQuery();

            while (rs.next()) {
                card = new CardVO();
                card.setId(rs.getInt("idx"));
                card.setName(rs.getString("name"));
                card.setPhone(rs.getString("phone"));
                card.setEmail(rs.getString("email"));
                card.setPosition(rs.getString("position"));
                card.setAddress(rs.getString("address"));
                card.setFax(rs.getString("fax"));
                card.setUrl(rs.getString("url"));
                card.setCompany(rs.getString("company"));
                card.setPhoto_path(rs.getString("photo_path"));
                list.add(card);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(ps);
            close(rs);
        }
        return list;
    }
    /*
    // 명함 삭제하는 사용자가 본인 자신인지 체크하는 메서드
    public boolean isChkCardWriter(int id, String password) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        boolean chk = false;

        String sql = "SELECT * FROM card WHERE id = ?";

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            rs.next();

            if(password.equals(rs.getString("name"))) {// 카드DB에도 비번이 필요해 보이는데
                    chk = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return chk;
    }
    */

    /* ---------------------UPDATE---------------------------
//     사용자가 수정을 필요로할때 수정 할 수 있도록 해주는 메서드 */
    public int ModifyCard(CardVO vo) {
        PreparedStatement ps = null;
        int result = 0;

        String sql = "UPDATE card SET name=?, phone=?, email=?, position=?, "
                + "address=?, fax=?, url=?, company=?, photo_path=? WHERE idx = ?";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, vo.getName());
            ps.setString(2, vo.getPhone());
            ps.setString(3, vo.getEmail());
            ps.setString(4, vo.getPosition());
            ps.setString(5, vo.getAddress());
            ps.setString(6, vo.getFax());
            ps.setString(7, vo.getUrl());
            ps.setString(8, vo.getCompany());
            ps.setString(9, vo.getPhoto_path());
            ps.setInt(10, vo.getId());
            result = ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(ps);
        }
        return result;
    }

    /* ---------------------DELETE---------------------------
            사용자가 명함을 삭제할때 필요한 메서드 */
    public int deleteCard(int idx) {
        int result = 0;
        PreparedStatement ps = null;

        String sql = "DELETE FROM card WHERE idx = ?";

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, idx);
            result = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(ps);
        }
        return result;
    }


}
