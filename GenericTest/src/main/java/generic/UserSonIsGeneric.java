package generic;

public class UserSonIsGeneric<T> extends UserWithGeneric<T> {
    private T age;

    public T getAge() {
        return age;
    }

    public void setAge(T age) {
        this.age = age;
    }
}
