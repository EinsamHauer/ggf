package net.iponweb;

import com.google.common.base.Function;
import main.java.net.iponweb.grammar.GraphiteLexer;
import main.java.net.iponweb.grammar.GraphiteParser;
import net.iponweb.exceptions.EvaluationException;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException, EvaluationException {
        GraphiteLexer lexer = new GraphiteLexer(new ANTLRInputStream("averageSeries(sumSeries(asas1.fff.ttt))"));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        GraphiteParser parser = new GraphiteParser(tokens);
        ParseTree tree = parser.expression();
        Target target = (new TargetVisitor("test", 1433116800L, 1433203140L)).visit(tree);

        System.out.println(target);

        System.out.println(new TargetEvaluator().eval(target));
    }
}
