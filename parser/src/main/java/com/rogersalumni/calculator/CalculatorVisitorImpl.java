package com.rogersalumni.calculator;

import com.rogersalumni.calculator.g4.CalculatorBaseVisitor;
import com.rogersalumni.calculator.g4.CalculatorParser;
import org.antlr.v4.runtime.tree.ParseTree;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.function.BinaryOperator;

public class CalculatorVisitorImpl extends CalculatorBaseVisitor<Double> {

    private static final Logger Log = LogManager.getLogger(CalculatorVisitorImpl.class);

    private Stack<Double> argStack;
    private Stack<String> operatorStack;
    private Map<String, BinaryOperator<Double>> operatorMap;

    CalculatorVisitorImpl() {
        init();
    }

    private void init() {
        createStacks();
        createOperationMap();
    }

    private void createStacks(){
        argStack = new Stack<>();
        operatorStack = new Stack<>();
    }

    private void createOperationMap(){
        operatorMap = new HashMap<>();

        operatorMap.put("+", (x, y) -> x + y);
        operatorMap.put("-", (x, y) -> x - y);
        operatorMap.put("*", (x, y) -> x * y);
        operatorMap.put("/", (x, y) -> x / y);
    }

    // Walk AST, stacking operations and args accordingly, then reduce stacks to single Double
    Double walkAst(ParseTree tree) {
        visit(tree);
        return reduce();
    }

    @Override
    public Double visitStart(CalculatorParser.StartContext ctx) {
        Log.debug("visitStart " + ctx.getText());

        argStack.empty();
        operatorStack.empty();

        return super.visitStart(ctx);
    }

    @Override
    public Double visitFactor(CalculatorParser.FactorContext ctx)  {
        Double result;

        if (ctx.getChildCount() == 1) {
            result = Double.parseDouble(ctx.getText());
            argStack.push(result);
            Log.debug("visitAtom argStack after push: " + argStack.toString());
        } else {
            result = super.visitFactor(ctx);
        }
        return result;
    }


    @Override
    public Double visitAddOp(CalculatorParser.AddOpContext ctx) {
        operatorStack.push(ctx.getText());
        Log.debug("visitAddOp operandStack after: " + operatorStack.toString());

        return super.visitAddOp(ctx);
    }


    @Override
    public Double visitMulOp(CalculatorParser.MulOpContext ctx) {
        operatorStack.push(ctx.getText());
        Log.debug("visitMulOp operandStack after: " + operatorStack.toString());

        return super.visitMulOp(ctx);
    }

    private void compute() {
        while (argStack.size() > 1) {
            String operator = operatorStack.pop();
            // Pop order matters:
            Double arg2 = argStack.pop();
            Double arg1 = argStack.pop();
            argStack.push(operatorMap.get(operator).apply(arg1, arg2));
        }
    }

    private Double reduce() {
        compute();
        return argStack.pop();
    }

}
