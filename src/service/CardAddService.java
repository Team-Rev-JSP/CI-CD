package service;

import dao.CardDAO;
import vo.CardVO;
import java.sql.Connection;
import static db.DbBridge.*;

public class CardAddService {

    public boolean registcard(CardVO param) throws Exception{
        // TODO Auto-generated method stub

        boolean isWriteSuccess = false;
        CardDAO cardDAO = CardDAO.getInstance();
        Connection con = getConnection();
        cardDAO.setConnection(con);
        int insertCount = cardDAO.insertCard(param);

        if(insertCount > 0){
            commit(con);
            isWriteSuccess = true;
        }
        else{
            rollback(con);
        }
//        close(con);
        return isWriteSuccess;
    }
}
