package net.iponweb;

import main.java.net.iponweb.grammar.GraphiteBaseListener;
import main.java.net.iponweb.grammar.GraphiteParser;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;

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
        System.out.println("Enter function: " + ctx.getText());
    }

    @Override
    public void exitExpression(GraphiteParser.ExpressionContext ctx) {
        System.out.println("Exit expression: " + ctx.getText());
    }

    @Override
    public void enterArg(GraphiteParser.ArgContext ctx) {
        System.out.println("Enter Arg: " + ctx.getText());
    }

    @Override
    public void exitArg(GraphiteParser.ArgContext ctx) {
        System.out.println("Exit arg: " + ctx.getText());
    }

    @Override
    public void enterArguments(GraphiteParser.ArgumentsContext ctx) {
        System.out.println("Enter arguments: " + ctx.getText());
    }

    @Override
    public void exitArguments(GraphiteParser.ArgumentsContext ctx) {
        System.out.println("Exit arguments: " + ctx.getText());
    }

    @Override
    public void exitFunction(GraphiteParser.FunctionContext ctx) {
        System.out.println("Exit function: " + ctx.getText());
    }

    @Override
    public void enterEveryRule(ParserRuleContext ctx) {
        super.enterEveryRule(ctx);
    }

    @Override
    public void exitEveryRule(ParserRuleContext ctx) {
        super.exitEveryRule(ctx);
    }

    @Override
    public void visitTerminal(TerminalNode node) {
        System.out.println("Visit terminal: " + node.getText());
    }

    @Override
    public void visitErrorNode(ErrorNode node) {
        super.visitErrorNode(node);
    }
}
