package hello.servlet.web.springMVC.v1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SpringMemberFormControllerV1 {

  @RequestMapping("/springmvc/v1/members/new-form")
  public ModelAndView process() {
    return new ModelAndView("new-form");
  }

  /**
   * @Controller
   *  내부에 @Component 애노태이션이 있어 컴포넌트 스캔의 대상이 되고 스프링이 자동으로 스프링 빈으로 등록한다.
   *  스프링 MVC 에서 애노테이션 기반 컨트롤러로 인식한다.
   *
   * @RequestMapping
   *  요청 정보를 매핑한다. 해당 URL이 호출되면 이 메소드가 호출된다.
   *
   * ModelAndView: 모델과 뷰 정보를 담아서 반환하면 된다.
   */

}
