package com.rogersalumni.calculator;

import com.rogersalumni.calculator.g4.CalculatorBaseVisitor;
import com.rogersalumni.calculator.g4.CalculatorParser;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BinaryOperator;

public class CalculatorVisitorImpl extends CalculatorBaseVisitor<Double> {

//    private static final Logger Log = LogManager.getLogger(CalculatorVisitorImpl.class);

    private Map<String, BinaryOperator<Double>> operatorMap;

    CalculatorVisitorImpl() {
        createOperationMap();
    }

    private void createOperationMap(){
        operatorMap = new HashMap<>();

        operatorMap.put("+", Double::sum);
        operatorMap.put("-", (x, y) -> x - y);
        operatorMap.put("*", (x, y) -> x * y);
        operatorMap.put("/", (x, y) -> x / y);
        operatorMap.put("%", (x, y) -> x % y);
    }

    private Double eval(String op, Double left, Double right){
        return operatorMap.get(op).apply(left, right);
    }

    @Override
    public Double visitUMINUS(CalculatorParser.UMINUSContext ctx){
        return  -visit(ctx.expr());
    }

    @Override
    public Double visitMULOPGRP(CalculatorParser.MULOPGRPContext ctx) {
        String op = ctx.mulop().getText();
        Double left = visit(ctx.expr(0));
        Double right = visit(ctx.expr(1));

        return eval(op, left, right);
    }

    @Override
    public Double visitADDOPGRP(CalculatorParser.ADDOPGRPContext ctx) {
        String op = ctx.addop().getText();
        Double left = visit(ctx.expr(0));
        Double right = visit(ctx.expr(1));

        return eval(op, left, right);
    }

    @Override
    public Double visitPARENGRP(CalculatorParser.PARENGRPContext ctx) {
        return visit(ctx.expr());
    }

    @Override
    public Double visitDOUBLE(CalculatorParser.DOUBLEContext ctx) {
        return Double.valueOf(ctx.NUMBER().getText());
    }

}
