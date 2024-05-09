package hello.servlet.web.frontController.v3;

import hello.servlet.web.frontController.ModelView;

import java.util.Map;

public class MemberFormControllerV3 implements ControllerV3 {
  @Override
  public ModelView process(Map<String, String> paramMAp) {
    return new ModelView("new-form");
  }
}
