package generic;

import org.junit.jupiter.api.Test;

public class GenericTest {

    @Test
    void name() {
        UserWithGeneric<String> user = new UserWithGeneric<>();
        user.setName("a");
        String name = user.getName();
        System.out.println(name);
    }

    @Test
    void should_use_String() {
        UserSonIsFirstIsNoGeneric noGeneric = new UserSonIsFirstIsNoGeneric();
        noGeneric.setName("12");
        String name = noGeneric.getName();
    }

    @Test
    void should_use_generic() {
      UserWithGeneric<Integer> user =  new UserWithGeneric<>();
      new UserSonIsGeneric<>();
        Integer name = user.getName();
    }
}
