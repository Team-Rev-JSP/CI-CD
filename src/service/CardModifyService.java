package service;

import dao.CardDAO;
import vo.CardVO;
import java.sql.Connection;
import static db.DbBridge.*;

public class CardModifyService {
    public CardVO ModifyView(int idx) {
        CardDAO cardDAO = CardDAO.getInstance();
        CardVO param = new CardVO();
        Connection con = getConnection();
        cardDAO.setConnection(con);
        param = cardDAO.findOneCard(idx);
        commit(con);
//        close(con);
        return param;
    }

    public boolean ModifyCards(CardVO param) {
        boolean modifychk = false;
        CardDAO cardDAO = CardDAO.getInstance();
        Connection con = getConnection();
        cardDAO.setConnection(con);
        int result = cardDAO.ModifyCard(param);

        if(result > 0) {
            commit(con);
            modifychk = true;
        } else {
            rollback(con);
        }
//        close(con);
        return modifychk;
    }
}
