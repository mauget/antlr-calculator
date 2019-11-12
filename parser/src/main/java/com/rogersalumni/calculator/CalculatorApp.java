package com.rogersalumni.calculator;

import com.rogersalumni.calculator.g4.CalculatorLexer;
import com.rogersalumni.calculator.g4.CalculatorParser;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CodePointCharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Drive calculator with demo input.
 */
public class CalculatorApp {

    private static final Logger Log = LogManager.getLogger(CalculatorApp.class);

    public static void main(String[] args) {
        CalculatorApp calculator = new CalculatorApp();
        String arg = "2 + 3 * (4 - 5)";
        Double result = calculator.calculate(arg);
        Log.info(arg + " = " + result);
    }

    private Double calculate(String arithmeticExpression) {
        CodePointCharStream input = CharStreams.fromString(arithmeticExpression);
        return compile(input);
    }

    private Double compile(CharStream input) {
        CalculatorLexer lexer = new CalculatorLexer(input);
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);

        CalculatorParser parser = new CalculatorParser(tokenStream);
        ParseTree tree = parser.start();

        CalculatorVisitorImpl visitor = new CalculatorVisitorImpl();
        return visitor.start(tree);
    }
}
