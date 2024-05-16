package hello.servlet.web.springMVC.old;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

@Component(value = "/springmvc/old-controller")
public class OldController implements Controller {

  @Override
  public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {

    System.out.println("OldController.handleRequest");
    return new ModelAndView("new-form");
    // return new ModelAndView("/WEB-INF/views/new-form.jsp"); 권장 x

    /**
     * 스프링 부트는 InternalResourceViewResolver 라는 뷰리졸버를 자동으로 등록하는데,
     * 이 때 application.properties 에 등록한 spring.mvc.view.prefix, spring.mvc.view.suffix 설정 정보를 사용해서 등록한다.
     */

  }

}
