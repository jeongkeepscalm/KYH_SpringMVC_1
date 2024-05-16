package hello.servlet.web.springMVC.v3;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/springmvc/v3/members")
public class SpringMemberControllerV3 {

  /**
   * 스프링 MVC 에서 제공하는 편의 기능
   *
   *    Model 파라미터: Model 을 파라미터로 받아 데이터를 넘긴다.
   *
   *    ViewName 직접 반환: 뷰의 논리 이름을 반환할 수 있다.
   *
   *    @RequestParam 사용: == request.getParameter("username")
   *
   *    @RequestMapping -> @GetMapping, @PostMapping
   *        @RequestMapping(value = "/new-form", method = RequestMethod.GET)
   */

  private MemberRepository memberRepository = MemberRepository.getInstance();
  @GetMapping("/new-form")
  public String newForm() {
    return "new-form";
  }

  @PostMapping("/save")
  public String save(@RequestParam("username") String username, @RequestParam("age") int age, Model model) {
    Member member = new Member(username, age);
    memberRepository.save(member);
    model.addAttribute("member", member);
    return "save-result";
  }

  @GetMapping
  public String members(Model model) {
    List<Member> members = memberRepository.findAll();
    model.addAttribute("members", members);
    return "members";
  }
}