package hello.hellospring.controller;

import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller //해당 애너테이션이 붙으면 스프링 컨테이너에 스프링 빈으로 자동 등록 됨
public class MemberController {

    private final MemberService memberService;

    @Autowired //해당 애너테이션이 붙으면 스프링 컨테이너에서 연관된 객체를 찾아서 넣어줌(DI)
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
}
