package tacos.data;

import tacos.Ingredient;

public interface IngredientRepository {
    // 데이터베이스의 모든 식자재 데이터를 쿼리하여 Ingredient 객체 컬렉션에 넣음
    Iterable<Ingredient> findAll();
    // id를 사용하여 하나의 Ingredient 를 쿼리함
    Ingredient findById(String id);
    // Ingredient 객체를 데이터베이스에 저장
    Ingredient save(Ingredient ingredient);
}
