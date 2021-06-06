package action;

import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.LoginService;
import vo.AccountVO;
import vo.ActionForward;

public class LoginAction implements Action {
    HttpSession session;

    public LoginAction(HttpSession session){
        this.session = session;
    }

    @Override
    public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        AccountVO vo = new AccountVO();
        ActionForward forward = new ActionForward();
        vo.setId(request.getParameter("id"));
        vo.setPassword(request.getParameter("password"));
        LoginService loginService = new LoginService();
        boolean isWriteSuccess = loginService.registAccount(vo);

        if(!isWriteSuccess){
            request.setCharacterEncoding("UTF-8");
            PrintWriter out=response.getWriter();
            out.println("<script type=\"text/javascript\"charset=\"utf-8\">");
            out.println("alert('로그인 실패');");
            out.println("history.back();");
            out.println("</script>");
            out.close();
        }else{
            session.setAttribute("id", vo.getId());
            forward.setRedirect(true);
            forward.setPath("Main.bo");
        }
        return forward;
    }
}