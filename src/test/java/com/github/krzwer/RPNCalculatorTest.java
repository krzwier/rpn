package com.github.krzwer;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.stream.Stream;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

class RPNCalculatorTest {

   private RPNCalculator rpn;

   @BeforeEach
   void setUp() {
      rpn = new RPNCalculator();
   }

   @ParameterizedTest(name = "Return {1} for input \"{0}\"")
   @MethodSource
   void testCalculator(String input, int expected) {
      assertEquals(expected, rpn.calculate(input));
   }

   static Stream<Arguments> testCalculator() {
      return Stream.of(
            arguments("", 0),
            arguments("1", 1),
            arguments("3", 3),
            arguments("1 1 +", 2),
            arguments("1 3 +", 4),
            arguments("8 7 +", 15),
            arguments("3 4 5 + +", 12),
            arguments("99 11 + 8 7 + +", 125),
            arguments("1 3 -", -2),
            arguments("8 3 -", 5),
            arguments("33 3 - 10 6 - -", 26),
            arguments("1 3 *", 3),
            arguments("4 7 *", 28),
            arguments("4 7 * 5 2 * *", 280),
            arguments("10 2 /", 5),
            arguments("36 9 /", 4),
            arguments("90 3 / 30 5 / /", 5),
            arguments("3 4 - 5 +", 4),
            arguments("12 4 / 1 -", 2),
            arguments("12 4 1 - /", 4),
            arguments("15 7 1 1 + - / 3 * 2 1 1 + + -", 5));
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


}
