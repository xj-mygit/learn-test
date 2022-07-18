package tdd.args;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class ArgsTest {

    //  single
    //todo  -l

    @Test
    void should_set_boolean_option_to_true_if_flag_present() {
        BooleanOptions booleanOptions = Args.parse(BooleanOptions.class, "-l");
        Assertions.assertTrue(booleanOptions.logging());
    }

    @Test
    void should_set_boolean_option_to_false_if_flag_not_present() {
        BooleanOptions booleanOptions = Args.parse(BooleanOptions.class);
        Assertions.assertFalse(booleanOptions.logging());
    }

    static record BooleanOptions(@Option("l") boolean logging) {
    }

    @Test
    void should_parse_int_value_by_option_value() {
        intOptions intOptions = Args.parse(intOptions.class, "-p","8080");
        Assertions.assertEquals(intOptions.port(),8080);
    }

    static record intOptions(@Option("p") int port) {
    }

    @Test
    void should_parse_string_value_by_option_value() {
        stringOptions parse = Args.parse(stringOptions.class, "-d", "/usr/log");
        Assertions.assertEquals("/usr/log",parse.directory());
    }

    static record  stringOptions(@Option("d") String directory){}
    //todo -d
    //multi example1


   // BooleanOptionParserTest:
// sad path:
// TODO: -bool -l t / -l t f
// default:
// TODO: - bool : false

   // SingleValuedOptionParserTest:
// sad path:
// TODO: - int -p/ -p 8080 8081
// TODO: - string -d/ -d /usr/logs /usr/vars
// default value:
// TODO: -int :0
// TODO: - string ""


    @Test
    void should_multi_options() {
        Options options = Args.parse(Options.class, "-l", "-p", "8080", "-d", "/usr/logs");
        Assertions.assertTrue(options.logging());
        Assertions.assertEquals(8080, options.port());
        Assertions.assertEquals("/usr/logs", options.directory());
    }

    static record Options(@Option("l") boolean logging, @Option("p") int port, @Option("d") String directory) {
    }

    @Test
    @Disabled
    void should_example_of_2() {
        ListOptions listOptions = Args.parse(ListOptions.class, "-g", "this", "is", "a", "list", "d", "1", "2", "3", "4", "5");
        Assertions.assertEquals(listOptions.group(), new String[]{"this", "is", "a", "list"});
        Assertions.assertEquals(listOptions.decimals(), new int[]{1, 2, 3, 4, 5});
    }

    static record ListOptions(@Option("g") String[] group, @Option("d") int[] decimals) {
    }
}
