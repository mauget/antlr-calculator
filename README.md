# Antlr Expression Calculator
Antlr v4 parses a text string as a simple arithmetic expression.

`com.rogersalumni.calculator.CalculatorAppImpl` takes a valid arithmetic expression from the command line,
returning its evaluated result - or a parsing error, depeding upon what it encounters. 

If no expression supplied, it assumes the following input `"-1 / 2"`.

## Console Output

Example 1:

`13:58:25.680 [main] INFO  com.rogersalumni.calculator.CalculatorAppImpl: (5-4)*(12-11)/((((5-4)*(12-11)))) = 1.0`

Example 2:

`13:59:54.817 [main] INFO  com.rogersalumni.calculator.CalculatorAppImpl: 2+4+-4+-2*10%9*7 = -12.0`

Example 3:

`14:00:57.800 [main] INFO  com.rogersalumni.calculator.CalculatorAppImpl: -2+2*10+2 = 20.0`

## Blog Reference

For complete information: https://keyholesoftware.com/2020/01/21/an-antlr4-based-expression-parser/ 