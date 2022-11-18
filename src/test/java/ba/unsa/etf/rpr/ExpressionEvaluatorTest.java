package ba.unsa.etf.rpr;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * This class contains tests for class ExpressionEvaluator
 * We test two methods: evaluate and isItValidString
 */
class ExpressionEvaluatorTest {
    /**
     * First test for simple example
     */
    @Test
    void evaluate() {
        String s = "( 5 + 2 )";
        ExpressionEvaluator e = new ExpressionEvaluator();
        assertEquals(7, e.evaluate(s));
    }

    /**
     * Tests multiplication
     */
    @Test
    void evaluate1() {
        String s = "( ( 2 + 2 ) * 2 )";
        ExpressionEvaluator e = new ExpressionEvaluator();
        assertEquals(8, e.evaluate(s));
    }

    /**
     * Tests sqrt
     */
    @Test
    void evalute2() {
        String s = "( sqrt 4 )";
        ExpressionEvaluator e = new ExpressionEvaluator();
        assertEquals(2, e.evaluate(s));
    }

    /**
     * Simple input string
     */
    @Test
    void isItValidString() {
        String s = "( 5 + 2 )";
        ExpressionEvaluator e = new ExpressionEvaluator();
        assertEquals(true, e.isItValidString(s));
    }

    /**
     * Tests string with two operators
     */
    @Test
    void isItValidString2() {
        String s = "( ( 2 + 2 ) * 2)";
        ExpressionEvaluator e = new ExpressionEvaluator();
        assertEquals(true, e.isItValidString(s));
    }
}