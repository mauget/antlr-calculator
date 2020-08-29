package com.rogersalumni.calculator;

import com.rogersalumni.calculator.g4.CalculatorLexer;
import com.rogersalumni.calculator.g4.CalculatorParser;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CodePointCharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Drive calculator with demo input.
 */
public class CalculatorAppImpl implements CalculatorApp {

    private static final Logger Log = LoggerFactory.getLogger(CalculatorAppImpl.class);

    public static void main(String[] args) {
        String arg = args.length > 0 ? args[0] : "-1 / 2";

        CalculatorAppImpl calculator = new CalculatorAppImpl();
        Double result = calculator.calculate(arg);

        Log.info(String.format("%s = %s", arg, result));
    }

    @Override
    public Double calculate(String arithmeticExpression) {
        CodePointCharStream input = CharStreams.fromString(arithmeticExpression);
        return compile(input);
    }

    private Double compile(CharStream input) {
        CalculatorParser parser = new CalculatorParser(new CommonTokenStream(new CalculatorLexer(input)));
        ParseTree tree = parser.start();

        CalculatorVisitorImpl calculatorVisitor = new CalculatorVisitorImpl();
        return calculatorVisitor.visit(tree);
    }
}
