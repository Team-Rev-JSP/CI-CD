package action;

import action.Action;
import dao.CardDAO;
import service.CardModifyService;
import vo.ActionForward;
import vo.CardVO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class DetailAction implements Action {
    @Override
    public ActionForward execute(HttpServletRequest request, HttpServletResponse response){
        int idx = Integer.parseInt(request.getParameter("idx"));
        System.out.println(idx);
        CardModifyService cardModifyViewService = new CardModifyService();
        CardVO card = cardModifyViewService.ModifyView(idx);
        request.setAttribute("card", card);
        ActionForward forward = new ActionForward();
        forward.setPath("/view/Detail.jsp");
        return forward;
    }
}
