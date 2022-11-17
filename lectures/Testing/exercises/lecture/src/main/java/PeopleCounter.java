public class PeopleCounter {
    // EXERCISE: Design a "people counter" with TDD.
    // The counter:
    // - starts at 0
    // - has a configurable max
    // - can increment (+1)
    // - can reset (=0)

    private int count;
    private int max;
    public PeopleCounter(int max) {
        this.count = 0;
        this.max = max;
    }

    public void increment() {
        if(count < max){
            this.count++;
        }
    }

    public void reset() {
        count = 0;
    }

    public int get() {
        return count;
    }

}
