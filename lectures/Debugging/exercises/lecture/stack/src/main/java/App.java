import java.util.*;

/**
 * Exercise: Add code to IntStack to catch bugs early and fix any bugs you find.
 *           Keep in mind that users of IntStack must be able to check any preconditions themselves.
 *           Add any public or private methods you need.
 */
public class App {
    /** A stack of integers, with a maximum size. */
    static final class IntStack {
        private int top;
        private final int[] values;

        /** Creates an empty stack with the given max size; it is forbidden to push more items than that. */
        public IntStack(int maxSize) {
            if(maxSize < 0) {
                throw new IllegalArgumentException();
            }
            top = -1;
            values = new int[maxSize];
        }

        /** Returns and pops the top of the stack, or returns null if the stack is empty. */
        public Integer pop() {
            invariant();
            if(top >= 0) {
                top--;
                invariant();
                return values[top];
            }
            return null;
        }

        /** Pushes the given value on the stack. */
        public void push(int value) {
            invariant();
            values[top] = value;
            top++;
            invariant();
        }

        private void invariant() {
            if(!(-1 <= top && top < values.length)) {
                throw new AssertionError();
            }
        }
    }

    public static void main(String[] args) {
        useStack(new IntStack(4));
    }

    // IntStack usage example
    private static void useStack(IntStack stack) {
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
    }
}
