package chap02;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

//싱글톤 객체
public class Main2 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx =
                new AnnotationConfigApplicationContext(AppContext.class);

        // 이름이 greeter인 빈 객체를 구해서 각각 g1과 g2에 할당
        Greeter g1 = ctx.getBean("greeter", Greeter.class);
        Greeter g2 = ctx.getBean("greeter", Greeter.class);
        // g1과 g2가 같은 객체인지 여부를 콘솔에 출력
        System.out.println("(g1 == g2) = " + (g1 == g2));
        //(g1 == g2) = true
        // getBean() 메서드는 같은 객체를 리턴함
        // 별도 설정을 하지않을 경우 스프링은 한 개의 빈 객체만을 생성
        // 이때 빈 객체는 싱글톤 범위를 갖는다고 표현 -> 싱글톤 : 단일 객체를 의미함
        // 스프링은 기본적으로 한 개의 @Bean  어노테이션에 대해 한 개의 빈 객체를 생성
        ctx.close();
    }
}
