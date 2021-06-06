package service;

import dao.CardDAO;
import vo.CardVO;

import static db.DbBridge.*;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class CardListService {
    public int getTotalpage() throws Exception {
        int count = 0;
        Connection con = getConnection();
        CardDAO cardDAO = CardDAO.getInstance();
        cardDAO.setConnection(con);
        count = cardDAO.getListCount();
//        close(con);
        return count;
    }

    public ArrayList<CardVO> getLists(int page, int limit, String uid) throws Exception {
        ArrayList<CardVO> list = null;
        Connection con = getConnection();
        CardDAO cardDAO = CardDAO.getInstance();
        cardDAO.setConnection(con);
        list = (ArrayList<CardVO>) cardDAO.getCardList(page, limit, uid);
//        close(con);
        return list;
    }
}
