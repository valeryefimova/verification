package com.efimova.verification.ltl.generated;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.ATN;
import org.antlr.v4.runtime.atn.ATNDeserializer;
import org.antlr.v4.runtime.atn.LexerATNSimulator;
import org.antlr.v4.runtime.atn.PredictionContextCache;
import org.antlr.v4.runtime.dfa.DFA;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class LTLLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		NOT=1, DIS=2, CON=3, IMPL=4, EQ=5, RELEASE=6, UNTIL=7, NEXT=8, GLOB=9, 
		FUTURE=10, TRUE=11, FALSE=12, LP=13, RP=14, StringLiteral=15, WS=16, ErrorChar=17;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"NOT", "DIS", "CON", "IMPL", "EQ", "RELEASE", "UNTIL", "NEXT", "GLOB", 
		"FUTURE", "TRUE", "FALSE", "LP", "RP", "StringLiteral", "SingleQuoteSeq", 
		"DoubleQuoteSeq", "EscapeSeq", "WS", "ErrorChar"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'!'", "'|'", "'&'", "'->'", "'=='", "'R'", "'U'", "'X'", "'G'", 
		"'F'", "'true'", "'false'", "'('", "')'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "NOT", "DIS", "CON", "IMPL", "EQ", "RELEASE", "UNTIL", "NEXT", "GLOB", 
		"FUTURE", "TRUE", "FALSE", "LP", "RP", "StringLiteral", "WS", "ErrorChar"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


	public LTLLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "LTL.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	@Override
	public void action(RuleContext _localctx, int ruleIndex, int actionIndex) {
		switch (ruleIndex) {
		case 19:
			ErrorChar_action((RuleContext)_localctx, actionIndex);
			break;
		}
	}
	private void ErrorChar_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0:

			        System.err.println("Invalid character: ");
			break;
		}
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\23p\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\5\3\6"+
		"\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\f\3\f\3\f"+
		"\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\5\20S\n\20\3\21"+
		"\3\21\3\21\6\21X\n\21\r\21\16\21Y\3\21\3\21\3\22\3\22\3\22\6\22a\n\22"+
		"\r\22\16\22b\3\22\3\22\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\25\3\25\3"+
		"\25\2\2\26\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33"+
		"\17\35\20\37\21!\2#\2%\2\'\22)\23\3\2\6\6\2\f\f\17\17))^^\6\2\f\f\17\17"+
		"$$^^\13\2$$))^^cdhhppttvvxx\5\2\13\f\16\17\"\"\2q\2\3\3\2\2\2\2\5\3\2"+
		"\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21"+
		"\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2"+
		"\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\3+\3\2\2\2\5-\3"+
		"\2\2\2\7/\3\2\2\2\t\61\3\2\2\2\13\64\3\2\2\2\r\67\3\2\2\2\179\3\2\2\2"+
		"\21;\3\2\2\2\23=\3\2\2\2\25?\3\2\2\2\27A\3\2\2\2\31F\3\2\2\2\33L\3\2\2"+
		"\2\35N\3\2\2\2\37R\3\2\2\2!T\3\2\2\2#]\3\2\2\2%f\3\2\2\2\'i\3\2\2\2)m"+
		"\3\2\2\2+,\7#\2\2,\4\3\2\2\2-.\7~\2\2.\6\3\2\2\2/\60\7(\2\2\60\b\3\2\2"+
		"\2\61\62\7/\2\2\62\63\7@\2\2\63\n\3\2\2\2\64\65\7?\2\2\65\66\7?\2\2\66"+
		"\f\3\2\2\2\678\7T\2\28\16\3\2\2\29:\7W\2\2:\20\3\2\2\2;<\7Z\2\2<\22\3"+
		"\2\2\2=>\7I\2\2>\24\3\2\2\2?@\7H\2\2@\26\3\2\2\2AB\7v\2\2BC\7t\2\2CD\7"+
		"w\2\2DE\7g\2\2E\30\3\2\2\2FG\7h\2\2GH\7c\2\2HI\7n\2\2IJ\7u\2\2JK\7g\2"+
		"\2K\32\3\2\2\2LM\7*\2\2M\34\3\2\2\2NO\7+\2\2O\36\3\2\2\2PS\5!\21\2QS\5"+
		"#\22\2RP\3\2\2\2RQ\3\2\2\2S \3\2\2\2TW\7)\2\2UX\n\2\2\2VX\5%\23\2WU\3"+
		"\2\2\2WV\3\2\2\2XY\3\2\2\2YW\3\2\2\2YZ\3\2\2\2Z[\3\2\2\2[\\\7)\2\2\\\""+
		"\3\2\2\2]`\7$\2\2^a\n\3\2\2_a\5%\23\2`^\3\2\2\2`_\3\2\2\2ab\3\2\2\2b`"+
		"\3\2\2\2bc\3\2\2\2cd\3\2\2\2de\7$\2\2e$\3\2\2\2fg\7^\2\2gh\t\4\2\2h&\3"+
		"\2\2\2ij\t\5\2\2jk\3\2\2\2kl\b\24\2\2l(\3\2\2\2mn\13\2\2\2no\b\25\3\2"+
		"o*\3\2\2\2\b\2RWY`b\4\b\2\2\3\25\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}