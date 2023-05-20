package student.yeonjae.controllerdemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.slf4j.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

//@Controller는 View를 보여주기 위한 어노테이션임
//@RestController는 Data를 주고받기 위한 어노테이션임
@RestController
@RequestMapping("/rest")
public class SampleRestController {
    private static final Logger logger = LoggerFactory.getLogger(SampleRestController.class);

    @GetMapping("/sample-payload")
    public SamplePayload samplePayload(){
        return new SamplePayload("yeonjae", 23, "Student");
    }

    @GetMapping(
            value = "/sample-image",
            produces = MediaType.IMAGE_PNG_VALUE)

    public byte[] sampleImage() throws IOException{
        InputStream inputStream = getClass().getResourceAsStream("");
        return inputStream.readAllBytes();
    }
}
