package PluralSight.TDD;

import org.junit.Test;

import static java.lang.Math.min;
import static org.junit.Assert.assertEquals;

//TODO: TDD katas have more things likethis
/*
//Example of Triangulation.
So in order to understand how triangulation works in practice, we're going to implement a word wrap class. So our spec for this is it's a method that breaks words on the specified space with a new line.
*/
public class WordWrapTest {

    public static final int LINE_LIMIT = 5;
    // a method that breaks words on specified space with new line, like a word processor would.

    @Test
    public void lineShouldWrapIfOverLineLength() {
        String result = WordWrap.wrap1Time("The Sleepy", LINE_LIMIT);
        assertEquals("The S\nleepy", result);
    }

    @Test
    public void shortLinesShouldNotWrap() {
        String result = WordWrap.noWrapForShortLine("The", LINE_LIMIT);
        assertEquals("The", result);
    }

    @Test
    public void longerLineShouldWrapTwice() {
        String result = WordWrap.wrap2Times("The Sleepy Brow", LINE_LIMIT);
        assertEquals("The S\nleepy\n Brow", result);
    }

    @Test
    public void evenLongerLinesShouldWrapThrice() {
        String result = WordWrap.wrap3Times("The Sleepy Brown Fox", LINE_LIMIT);
        assertEquals("The S\nleepy\n Brow\nn Fox", result);
    }

    @Test
    public void longLinesDontHaveToBeAMultipleOfLineLength() {
        String result = WordWrap.wrapNLines("The Sleepy Brown Fox.", LINE_LIMIT);
        assertEquals("The S\nleepy\n Brow\nn Fox\n.", result);
    }


    //o/p:we've taken a word wrap implementation and at no point in the implementation of this word wrap code did we try and think of the general case. We made it work for 1, made it work for 0, we made it work for 2, and then we triangulated the 1 and the 2 cases to work for an n case.

}

class WordWrap {

    static StringBuilder accumulator ;

    //to 1 time cahnge
    public static String wrap1Time(String inputLine, int lineLimit) {
        accumulator = new StringBuilder();

        accumulator.append(inputLine, 0, lineLimit);// like String.subString(0,n);
        accumulator.append('\n');
        accumulator.append(inputLine, lineLimit, inputLine.length());

        return accumulator.toString();
    }

    //for short line(give word < lineLimit)
    public static String noWrapForShortLine(String inputLine, int lineLimit) {
        accumulator = new StringBuilder();

        int length = inputLine.length();
        accumulator.append(inputLine, 0, Math.min(length, lineLimit));// like String.subString(0,n);
        if(length > lineLimit) {
            accumulator.append('\n');
            accumulator.append(inputLine, lineLimit, length);
        }

        return accumulator.toString();
    }

    //To 2 time changes (the Sleep brow) word crosses two times the lineLimit(5)
    public static String wrap2Times(String inputLine, int lineLimit) {
        accumulator = new StringBuilder();

        int length = inputLine.length();
        accumulator.append(inputLine, 0, Math.min(length, lineLimit));// like String.subString(0,n);

        int split = lineLimit;
        if(length > split) {
            accumulator.append('\n');
            accumulator.append(inputLine, split, split+length);
        }

        split += length;
        if(length > split) {
            accumulator.append('\n');
            accumulator.append(inputLine, split, length);
        }

        return accumulator.toString();
    }

    //To 3 time changes (the Sleep brow Fox ) word crosses two times the lineLimit(5)
    public static String wrap3Times(String inputLine, int lineLimit) {
        accumulator = new StringBuilder();

        int length = inputLine.length();
        accumulator.append(inputLine, 0, Math.min(length, lineLimit));// like String.subString(0,n);

        int split = lineLimit;

        while(length > split) {
            accumulator.append('\n');
            accumulator.append(inputLine, split, split+length);
            split += length;
        }

        return accumulator.toString();
    }

    //longLinesDontHaveToBeAMultipleOfLineLength (the Sleep brow Fox ...)
public static String wrapNLines(final String inputLine, final int lineLimit) {
final StringBuilder accumulator = new StringBuilder();
final int length = inputLine.length();

        accumulator.append(inputLine, 0, min(length, lineLimit));

        int split = lineLimit;

        while (length > split) {
        accumulator.append('\n');
        accumulator.append(inputLine, split, min(length, split + lineLimit));
        split += lineLimit;
        }

        return accumulator.toString();
        }
        }


