package action;

import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.SignUpService;
import vo.AccountVO;
import vo.ActionForward;

public class SignUpAction implements Action {

    @Override
    public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        AccountVO vo = new AccountVO();
        ActionForward forward = new ActionForward();
        vo.setId(request.getParameter("id"));
        vo.setPassword(request.getParameter("password"));
        vo.setNickname(request.getParameter("nickname"));
        SignUpService signUpService = new SignUpService();
        boolean isWriteSuccess = signUpService.registAccount(vo);

        if(!isWriteSuccess){
            request.setCharacterEncoding("UTF-8");
            response.setContentType("text/html;charset=utf-8");
            PrintWriter out=response.getWriter();
            out.println("<script>");
            out.println("alert('계정등록에 실패하였습니다.');");
            out.println("history.back();");
            out.println("</script>");
            out.close();
        }else{
            forward.setRedirect(true);
            forward.setPath("Login.bo");
        }
        return forward;
    }
}