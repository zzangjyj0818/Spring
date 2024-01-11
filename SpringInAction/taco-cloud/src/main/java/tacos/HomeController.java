package tacos;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

// 컨트롤러
// 웹 요청과 응답을 처리하는 컴포넌트
// 컨트롤러는 선택적으로 모델 데이터를 채워서 응답하며,
// 브라우저에 반환 되는 HTML을 생성하기 위해 해당 읍답의 웹 요청을 뷰에 전달함.
@Controller
public class HomeController {
    @GetMapping("/")
    public String home() {
        return "home";
    }
}
