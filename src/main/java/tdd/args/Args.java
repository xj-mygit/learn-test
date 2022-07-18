package tdd.args;

import java.lang.reflect.Constructor;
import java.lang.reflect.Parameter;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Args {
    public static <T> T parse(Class<T> optionsClass, String... args) {
        List<String> arguments = Arrays.asList(args);
        Constructor<?> constructor = optionsClass.getDeclaredConstructors()[0];
        try {
            Object[] values = Arrays.stream(constructor.getParameters()).map(it -> parseOptions(arguments, it)).toArray();
            return (T) constructor.newInstance(values);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static Map<Class<?>, OptionParse> PARSERS = Map.of(boolean.class, new BooleanParse(),
            int.class, new SingleValueOptionParser<>(Integer::parseInt),
            String.class, new SingleValueOptionParser<>(String::valueOf));

    private static Object parseOptions(List<String> arguments, Parameter parameter) {
        return PARSERS.get(parameter.getType()).parse(arguments, parameter.getAnnotation(Option.class));
    }
}
