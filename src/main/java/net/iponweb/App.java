package net.iponweb;

import main.java.net.iponweb.grammar.GraphiteLexer;
import main.java.net.iponweb.grammar.GraphiteParser;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        GraphiteLexer lexer = new GraphiteLexer(new ANTLRInputStream("sum(average(asas1,hhhd), eqwyetwyuqet, 1, \"asas asasas aaa\")"));
        CommonTokenStream tokens = new CommonTokenStream( lexer );
        GraphiteParser parser = new GraphiteParser( tokens );
        ParseTree tree = parser.expression();
        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk( new TargetWalker(), tree );    }
}
