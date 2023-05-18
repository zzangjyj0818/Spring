package student.yeonjae.controllerdemo;

import org.springframework.stereotype.Controller;

import org.slf4j.*;
import org.springframework.web.bind.annotation.*;

@Controller
public class SampleController {
    private static final Logger logger = LoggerFactory.getLogger(SampleController.class);

    //URL Mapping
    @GetMapping(
        value = "hello"
    )

    //경로에 대한 요청을 하거나 경로에 대해 반환함
    //경로에 대한 요청을 할 시, 파일명.html을 반환
    //경로에 대해 반환을 요청할 시, 파일명을 반환
    //Query는 RequestParam으로 받아올 수 있음
    //id값이 NULL이라도 프로그램이 돌아가는데 지장은 없음
    public String hello(@RequestParam(name = "id", required = false, defaultValue = "")String id){
        logger.info("Path : hello");
        logger.info("Query Param id : " + id);
        return "hello.html";
    }

    //사용자의 id를 적으면 하단 실행창에 id가 출력됨
    @GetMapping(
            value = "/hello/{id}"
    )
    public String helloPath(@PathVariable("id") String id){
        logger.info("Path Variable is " + id);
        return "/hello.html";
    }

    @GetMapping(
            "/get-profile"
    )
    // @ResponseBody 어떤 객체의 데이터를 Body에 포함하여 전송하고 싶을 때 사용함
    // @ResponseBody를 작성 시 View를 찾는 것이 아니라 객체의 데이터를 사용함
    public @ResponseBody SamplePayload getProfile(){
        return new SamplePayload("yeonjae", 23, "Student");
    }
}
