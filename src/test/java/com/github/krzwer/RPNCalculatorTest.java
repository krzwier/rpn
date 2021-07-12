package com.github.krzwer;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class RPNCalculatorTest {

    private RPNCalculator rpn;

    @BeforeEach
    void setUp() {
        rpn = new RPNCalculator();
    }

    @Nested
    @DisplayName("Default Tests")
    class DefaultTests {

        @Test
        @DisplayName("Empty test")
        void contextLoads() {
        }

        @Test
        @DisplayName("True equals true")
        void true_equals_true() {
            assertTrue(true);
        }
    }

    @Nested
    @DisplayName("RPNCalculator.calculate")
    class calculateTest {
        @Test
        @DisplayName("Return 0 for empty expression")
        void empty_returns_0() {
            int actual = rpn.calculate("");
            assertEquals(0, actual);
        }

        @Test
        @DisplayName("Return 1 for input 1")
        void input1_returns_1() {
            int actual = rpn.calculate("1");
            assertEquals(1, actual);
        }

        @Test
        @DisplayName("Return 2 for input 1 1 +")
        void input11plus_returns_2() {
            int actual = rpn.calculate("1 1 +");
            assertEquals(2, actual);
        }

        @Test
        @DisplayName("Return 12 for input 3 4 5 + +")
        void input345plusplus_returns_12() {
            int actual = rpn.calculate("3 4 5 + +");
            assertEquals(12, actual);
        }

    }

}