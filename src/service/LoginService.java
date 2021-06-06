package service;

import static db.DbBridge.close;
import static db.DbBridge.commit;
import static db.DbBridge.getConnection;
import static db.DbBridge.rollback;

import dao.AccountDAO;
import java.sql.Connection;
import vo.AccountVO;

public class LoginService {

    public boolean registAccount(AccountVO param) throws Exception{

        boolean isWriteSuccess = false;
        AccountDAO accountDAO = AccountDAO.getInstance();
        Connection con = getConnection();
        accountDAO.setConnection(con);
        int insertCount = accountDAO.getAccount(param);

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