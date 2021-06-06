package action;

import action.Action;
import dao.CardDAO;
import service.CardAddService;
import vo.ActionForward;
import vo.CardVO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;

public class CreateAction implements Action {

    @Override
    public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        CardVO vo = new CardVO();
        ActionForward forward = new ActionForward();
        HttpSession session = request.getSession();
        vo.setName(request.getParameter("name"));
        vo.setPhone(request.getParameter("phone"));
        vo.setEmail(request.getParameter("email"));
        vo.setPosition(request.getParameter("position"));
        vo.setAddress(request.getParameter("address"));
        vo.setFax(request.getParameter("fax"));
        vo.setUrl(request.getParameter("url"));
        vo.setCompany(request.getParameter("company"));
        vo.setPhoto_path(request.getParameter("photo_path"));
        vo.setUid((String)session.getAttribute("id"));
        CardAddService cardAddService = new CardAddService();
        boolean isWriteSuccess = cardAddService.registcard(vo);

        if(!isWriteSuccess){
            request.setCharacterEncoding("UTF-8");
            response.setContentType("text/html;charset=utf-8");
            PrintWriter out=response.getWriter();
            out.println("<script>");
            out.println("alert('명함등록에 실패하였습니다.');");
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
