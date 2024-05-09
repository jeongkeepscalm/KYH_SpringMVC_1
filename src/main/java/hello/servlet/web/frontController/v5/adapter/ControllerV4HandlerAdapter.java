package hello.servlet.web.frontController.v5.adapter;

import hello.servlet.web.frontController.ModelView;
import hello.servlet.web.frontController.v4.ControllerV4;
import hello.servlet.web.frontController.v5.MyHandlerAdapter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.HashMap;
import java.util.Map;

public class ControllerV4HandlerAdapter implements MyHandlerAdapter {

  /**
   * supports(): handler 가 ControllerV4 인 경우에만 처리하는 어댑터
   */
  @Override
  public boolean supports(Object handler) {
    return (handler instanceof ControllerV4);
  }
  @Override
  public ModelView handle(HttpServletRequest request, HttpServletResponse response, Object handler) {

    /**
     * handler 를 ControllerV4로 캐스팅 하고, paramMap, model 을 만들어서 해당 컨트롤러를 호출
     * viewName 반환
     */
    ControllerV4 controller = (ControllerV4) handler;
    Map<String, String> paramMap = createParamMap(request);
    Map<String, Object> model = new HashMap<>();
    String viewName = controller.process(paramMap, model);

    // 어댑터 변환
    ModelView mv = new ModelView(viewName);
    mv.setModel(model);
    return mv;

  }

  private Map<String, String> createParamMap(HttpServletRequest request) {
    Map<String, String> paramMap = new HashMap<>();
    request.getParameterNames().asIterator().forEachRemaining(v -> paramMap.put(v, request.getParameter(v)));
    return paramMap;
  }

}
