package controller;

import action.*;
import vo.ActionForward;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = "*.bo")
public class WebController extends HttpServlet {

    protected void doProcess(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        String RequestURI = request.getRequestURI();
        String contextPath = request.getContextPath();
        String command = RequestURI.substring(contextPath.length());
        ActionForward forward = null;

        /* 웹에서 어떤 로직을 수행할지를 결정해주는 Action객체 -> 유지보수 및 관리를 위한 분산 처리
        동일한 action 라는 인터페이스를 이용하여 동일한 메소드를 통해 각자 알맞은 로직을 수행하게 만들기위한 객체.*/

        Action action = null;

        if(command.equals("Login.bo")){
            forward = new ActionForward();
            forward.setPath("/view/Login.jsp");
        }
        else if(command.equals("/LoginProcess.bo")){
            HttpSession session = request.getSession(true);
            action = new LoginAction(session);
            try {
                forward = action.execute(request, response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else if(command.equals("/SignUp.bo")){
            forward = new ActionForward();
            forward.setPath("/view/SignUpForm.jsp");
        }
        else if(command.equals("/SignUpProcess.bo")){
            action = new SignUpAction();
            try {
                forward = action.execute(request, response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else if(command.equals("/Main.bo")){
            action = new MainAction();
            try {
                forward = action.execute(request, response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else if(command.equals("/Create.bo")){
            forward = new ActionForward();
            forward.setPath("/view/CreateForm.jsp");
        }
        else if(command.equals("/CreateProcess.bo")){
            action = new CreateAction();
            try {
                forward = action.execute(request, response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else if(command.equals("/Detail.bo")){
            action = new DetailAction();
            try {
                forward = action.execute(request, response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else if(command.equals("/Modify.bo")){
            action = new ModifyFormAction();
            try {
                forward = action.execute(request, response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else if(command.equals("/ModifyProcess.bo")){
            action = new ModifyAction();
            try {
                forward = action.execute(request, response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else if(command.equals("/DeleteProcess.bo")){
            action = new DeleteAction();
            try {
                forward = action.execute(request, response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if (forward != null) {
            if (forward.isRedirect()) {
                response.sendRedirect(forward.getPath());
            } else {
                RequestDispatcher dispatcher =
                        request.getRequestDispatcher(forward.getPath());
                dispatcher.forward(request, response);
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doProcess(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doProcess(request, response);
    }
}