package exercise;

import java.util.stream.IntStream;

// BEGIN
class ReversedSequence implements CharSequence {
    private String text;

    public ReversedSequence(String text) {
        this.text = text;
    }

    @Override
    public int length() {
        return 0;
    }

    @Override
    public char charAt(int index) {
        return 0;
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        return null;
    }


}
// END
