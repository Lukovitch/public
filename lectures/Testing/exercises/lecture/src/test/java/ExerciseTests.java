import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

final class ExerciseTests {
    @Test
    void onePlusOneIsTwo() {
        assertThat(1 + 1, is(2));
    }

    // TODO: tests!
    // Remember "assertThat" with matchers (see the documentation!)
    // and "assertThrows" to assert an exception is thrown
    @Test
    void initialCounter() {
        PeopleCounter x = new PeopleCounter(10);
        assertThat(x.get(), is(0));
    }

    @Test
    void  incrementPeopleCount() {
        PeopleCounter x = new PeopleCounter(10);
        x.increment();
        assertThat(x.get(), is(1));
    }

    @Test
    void maxPeople() {
        PeopleCounter x = new PeopleCounter(1);
        x.increment();
        x.increment();
        assertThat(x.get(), is(1));
    }

    @Test
    void resetPeople() {
        PeopleCounter x = new PeopleCounter(10);
        x.increment();
        x.increment();
        x.reset();
        assertThat(x.get(), is(0));
    }
}
