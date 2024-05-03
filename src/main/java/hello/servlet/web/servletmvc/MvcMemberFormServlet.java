package hello.servlet.web.servletmvc;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "mvcMemberFormServlet", urlPatterns = "/servlet-mvc/members/ new-form")
public class MvcMemberFormServlet extends HttpServlet {
  @Override
  protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String viewPath = "/WEB-INF/views/new-form.jsp";
    RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
    dispatcher.forward(request, response);
  }
}
/**
 * dispatcher.forward(): 다른 서블릿이나 JSP 로 이동할 수 있는 기능. 서버 내부에서 다시 호출이 발생한다.
 *
 * /WEB-INF
 * 이 경로안에 JSP가 있으면 외부에서 직접 JSP 를 호출할 수 없다. 우리가 기대하는 것은 항상 컨트롤러를 통해서 JSP 를 호출하는 것이다.
 */