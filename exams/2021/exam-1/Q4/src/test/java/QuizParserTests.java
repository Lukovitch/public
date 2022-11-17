import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Class for the quiz parser tests.
 * !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
 * You MUST use this file for quiz parser tests.
 * You CAN add new constructors, methods, and nested classes to this class.
 * You MUST NOT rename this file.
 * You MUST NOT delete this file.
 * !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
 */
final class QuizParserTests {

    @Test
    public void NullTextIsInvalid() {
        var parser = new QuizParser();
        assertThrows(IllegalArgumentException.class, () -> parser.parse(null));
    }

    @Test
    public void EmptyTextIsInvalid() {
        var parser = new QuizParser();
        assertThrows(IllegalArgumentException.class, () -> parser.parse(""));
    }

    @Test
    public void TextIsInvalid() {
        var parser = new QuizParser();
        assertThrows(IllegalArgumentException.class, () -> parser.parse(""));
    }
}
