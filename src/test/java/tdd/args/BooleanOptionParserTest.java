package tdd.args;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static tdd.args.BooleanParse.option;

public class BooleanOptionParserTest{


    @Test
    public void should_not_accept_extra_argument_for_boolean_option() {
        TooManyArgumentsException e = assertThrows(TooManyArgumentsException.class,
                () -> new BooleanParse().parse ("-l", "t",option("l")));
        assertEquals("l", e.getOption());
    }

    @Test
    public void should_not_accept_extra_argument_for_boolean_option() {
        TooManyArgumentsException e = assertThrows(TooManyArgumentsException.class, () ->
                new BooleanOptionParser().parse("-l", "t", option("l")));
        assertEquals("l", e.getOption());
    }
}
