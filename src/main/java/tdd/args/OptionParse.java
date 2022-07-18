package tdd.args;

import java.util.List;

public interface OptionParse {
    Object parse(List<String> arguments, Option option);

}
