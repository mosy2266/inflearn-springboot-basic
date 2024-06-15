package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/") //메인 화면
    public String home() {
        return "home";
    }
    /* 기본 화면에 매핑되는 html 파일이 있으므로 static의 index.html은 무시됨
        -> 컨트롤러의 우선순위가 정적 리소스 파일보다 더 높다! */
}