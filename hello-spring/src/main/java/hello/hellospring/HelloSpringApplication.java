package hello.hellospring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//어노테이션
@SpringBootApplication
public class HelloSpringApplication {
	public static void main(String[] args) {
		//어노케이션이 SpringBoot Server를 실행시킴
		SpringApplication.run(HelloSpringApplication.class, args);
	}
}
