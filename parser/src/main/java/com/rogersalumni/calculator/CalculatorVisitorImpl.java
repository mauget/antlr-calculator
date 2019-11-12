package com.rogersalumni.calculator;

import com.rogersalumni.calculator.g4.CalculatorBaseVisitor;
import com.rogersalumni.calculator.g4.CalculatorParser;
import org.antlr.v4.runtime.tree.ParseTree;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Stack;

public class CalculatorVisitorImpl extends CalculatorBaseVisitor<Double> {

    private static final Logger Log = LogManager.getLogger(CalculatorVisitorImpl.class);

    private Stack<Double> argStack;
    private Stack<String> operandStack;


    Double walkAst(ParseTree tree) {
        visit(tree);
        return extractResult();
    }

    @Override
    public Double visitStart(CalculatorParser.StartContext ctx) {
        Log.debug("visitStart " + ctx.getText());

        argStack = new Stack<>();
        operandStack = new Stack<>();

        return super.visitStart(ctx);
    }

    @Override
    public Double visitAtom(CalculatorParser.AtomContext ctx) {
        Double result;

        if (ctx.getChildCount() == 1) {
            result = Double.parseDouble(ctx.getText());
            argStack.push(result);
            Log.debug("visitAtom argStack after push: " + argStack.toString());
        } else {
            result = super.visitAtom(ctx);
        }
        return result;
    }


    @Override
    public Double visitAddOp(CalculatorParser.AddOpContext ctx) {
        operandStack.push(ctx.getText());
        Log.debug("visitAddOp operandStack after: " + operandStack.toString());

        return super.visitAddOp(ctx);
    }


    @Override
    public Double visitMulOp(CalculatorParser.MulOpContext ctx) {
        operandStack.push(ctx.getText());
        Log.debug("visitMulOp operandStack after: " + operandStack.toString());

        return super.visitMulOp(ctx);
    }

    private void eval() {
        while (argStack.size() > 1) {
            String operand = operandStack.pop();
            Double arg2 = argStack.pop();
            Double arg1 = argStack.pop();

            switch (operand) {
                case "+":
                    argStack.push(arg1 + arg2);
                    break;
                case "-":
                    argStack.push(arg1 - arg2);
                    break;
                case "*":
                    argStack.push(arg1 * arg2);
                    break;
                case "/":
                    argStack.push(arg1 / arg2);
                    break;
            }
        }
    }

    private Double extractResult() {
        eval();
        return argStack.pop();
    }

}
