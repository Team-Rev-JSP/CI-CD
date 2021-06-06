package action;

import service.DeleteService;
import vo.ActionForward;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

public class DeleteAction implements Action {
    @Override
    public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {


        int idx = Integer.parseInt( request.getParameter("idx") ) ;
        ActionForward forward = new ActionForward();
        DeleteService deleteService = new DeleteService();
            boolean isDeleteChk = deleteService.deleteCard(idx);
            if(!isDeleteChk) {
                response.setContentType("text/html;charset=UTF-8");
                PrintWriter out=response.getWriter();
                out.println("<script>");
                out.println("alert('삭제에 실패하였습니다.');");
                out.println("history.back();");
                out.println("</script>");
                out.close();
            }else{
                forward.setRedirect(true);
                forward.setPath("Main.bo");
            }
        return forward;
    }
}
