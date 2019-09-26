package com.rulai.antlr.calculator;

import com.rulai.antlr.calculator.out.CalculatorBaseVisitorImpl;
import com.rulai.antlr.calculator.out.CalculatorLexer;
import com.rulai.antlr.calculator.out.CalculatorParser;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

/**
 * <p></p>
 * @author z```s
 * @version 1.0
 * @date 2019/9/25 10:03
 */
public class CalculatorRun {

    public static void main(String[] args) {
        String text = "77 * 138 + 567 / 255";
        CharStream inputStream = CharStreams.fromString(text);
        CalculatorLexer lexer = new CalculatorLexer(inputStream);
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        CalculatorParser parser = new CalculatorParser(tokenStream);
        ParseTree parseTree = parser.input();
        CalculatorBaseVisitorImpl visitor = new CalculatorBaseVisitorImpl();
        Double result = visitor.visit(parseTree);
        System.out.println("result : " + result);
    }

}