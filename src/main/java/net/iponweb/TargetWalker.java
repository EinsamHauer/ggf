package net.iponweb;

import main.java.net.iponweb.grammar.GraphiteBaseListener;
import main.java.net.iponweb.grammar.GraphiteParser;

/**
 * Created by aivanov on 14.06.2015.
 */
public class TargetWalker extends GraphiteBaseListener {

    @Override
    public void enterExpression(GraphiteParser.ExpressionContext ctx) {
        System.out.println("Enter expression: " + ctx.getText());
    }

    @Override
    public void enterFunction(GraphiteParser.FunctionContext ctx) {
        System.out.println("Enter function: " + ctx.getChild(0));
    }
}
