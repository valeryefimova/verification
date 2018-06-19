package com.efimova.verification.ltl;

import com.efimova.verification.ltl.generated.LTLLexer;
import com.efimova.verification.ltl.generated.LTLParser;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;


public class LtlFormulaParser {

    public Formula parse(String str) {
        CharStream in = CharStreams.fromString(str);
        LTLLexer lexer = new LTLLexer(in);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        LTLParser parser = new LTLParser(tokens);
        return parser.ltl().f;
    }
}
