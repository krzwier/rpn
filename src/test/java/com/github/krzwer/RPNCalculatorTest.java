package com.github.krzwer;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.stream.Stream;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.provider.Arguments;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import org.junit.jupiter.params.*;

class RPNCalculatorTest {

    private RPNCalculator rpn;

    @BeforeEach
    void setUp() {
        rpn = new RPNCalculator();
    }

    @ParameterizedTest(name = "Return {1} for input \"{0}\"")
    @MethodSource("input_to_expected")
    void testCalculator(String input, int expected) {
        assertEquals(expected, rpn.calculate(input));
    }

    static Stream<Arguments> input_to_expected() {
        return Stream.of(
           arguments("", 0), 
           arguments("1", 1), 
           arguments("3", 3),
           arguments("1 1 +", 2),
           arguments("1 3 +", 4),
           arguments("3 4 5 + +", 12)
           );
    }

    @Nested
    @DisplayName("Default Tests")
    class DefaultTests {

        @Test
        @DisplayName("Empty test")
        void contextLoads() {}

        @Test
        @DisplayName("True equals true")
        void true_equals_true() {
            assertTrue(true);
        }
    }

   //  @Nested
   //  @DisplayName("RPNCalculator.calculate")
   //  class calculateTest {
   //      @Test
   //      @DisplayName("Return 0 for empty expression")
   //      void empty_returns_0() {
   //          int actual = rpn.calculate("");
   //          assertEquals(0, actual);
   //      }

   //      @Test
   //      @DisplayName("Return 1 for input 1")
   //      void input1_returns_1() {
   //          int actual = rpn.calculate("1");
   //          assertEquals(1, actual);
   //      }

   //      @Test
   //      @DisplayName("Return 2 for input 1 1 +")
   //      void input11plus_returns_2() {
   //          int actual = rpn.calculate("1 1 +");
   //          assertEquals(2, actual);
   //      }

   //      @Test
   //      @DisplayName("Return 12 for input 3 4 5 + +")
   //      void input345plusplus_returns_12() {
   //          int actual = rpn.calculate("3 4 5 + +");
   //          assertEquals(12, actual);
   //      }

   //  }

}
