package com.rogersalumni.caclulator;

import com.rogersalumni.calculator.g4.CalculatorBaseVisitor;
import com.rogersalumni.calculator.g4.CalculatorParser;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class CalulatorVisitorImpl extends CalculatorBaseVisitor<Double> {

    private static final Logger logger = LogManager.getLogger(CalulatorVisitorImpl.class);

    @Override
    public Double visitStart(CalculatorParser.StartContext ctx) {
        return null;
    }

    @Override
    public Double visitExpression(CalculatorParser.ExpressionContext ctx) {
        return null;
    }

    @Override
    public Double visitMultExpr(CalculatorParser.MultExprContext ctx) {
        return null;
    }

    @Override
    public Double visitAtom(CalculatorParser.AtomContext ctx) {
        return null ;
    }
}
