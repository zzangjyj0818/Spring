package tacos;

import lombok.Data;
import lombok.RequiredArgsConstructor;

// 도메인 클래스
// @Data 어노테이션 : 소스 코드에 누락된 final 속성들을 초기화 하는 생성자는 물론이고,
// 속성들의 게터와 세터 등을 생성하라고 롬복에게 알려줌
@Data
@RequiredArgsConstructor
public class Ingredient {
    private final String id;
    private final String name;
    private final Type type;

    public static enum Type {
        WRAP, PROTEIN, VEGGIES, CHEESE, SAUCE
    }
}
