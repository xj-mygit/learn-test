package generic;

public class UserSonIsFirstIsNoGeneric extends UserWithGeneric<String>{
    @Override
    public String getName() {
        return super.getName();
    }

    /**
     * 可以看出原本父类是泛型的形参，则这个子类i直接变为String类型的
     * @param name
     */
    @Override
    public void setName(String name) {
        super.setName(name);
    }
}
