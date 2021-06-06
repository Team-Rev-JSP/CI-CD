package service;

import dao.CardDAO;
import static db.DbBridge.*;
import java.sql.Connection;

public class DeleteService {
    public boolean deleteCard(int idx) throws Exception{ // 명함 삭제
        boolean isDeleteSuccess = false;
        CardDAO cardDAO = CardDAO.getInstance();
        Connection con = getConnection();
        cardDAO.setConnection(con);
        int delete = cardDAO.deleteCard(idx);

        if(delete > 0){
            commit(con);
            isDeleteSuccess = true;
        }
        else{
            rollback(con);
        }
//        close(con);
        return isDeleteSuccess;
    }

//    public boolean isChkCardUser(int id, String password) throws Exception{ // 명함 주인 체크
//        boolean isChkCardUser = false;
//        Connection con = getConnection();
//        CardDAO cardDAO = CardDAO.getInstance();
//        cardDAO.setConnection(con);
//        isChkCardUser = cardDAO.isChkCardWriter(id, password);
//        close(con);
//        return isChkCardUser;
//    }
}
