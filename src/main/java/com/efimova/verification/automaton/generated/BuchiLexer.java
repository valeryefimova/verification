package com.efimova.verification.automaton.generated;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.ATN;
import org.antlr.v4.runtime.atn.ATNDeserializer;
import org.antlr.v4.runtime.atn.LexerATNSimulator;
import org.antlr.v4.runtime.atn.PredictionContextCache;
import org.antlr.v4.runtime.dfa.DFA;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class BuchiLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, WS=17, 
		BlockComment=18, False=19, StringLiteral=20, One=21;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "T__15", "WS", "BlockComment", 
		"False", "StringLiteral", "One"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'never'", "'{'", "'}'", "':'", "'skip'", "'if'", "'fi'", "';'", 
		"'::'", "'->'", "'goto'", "'('", "')'", "'!'", "'&&'", "'||'", null, null, 
		"'false;'", null, "'1'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, "WS", "BlockComment", "False", "StringLiteral", 
		"One"
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


	public BuchiLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Buchi.g4"; }

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

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\27\177\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3"+
		"\3\3\4\3\4\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\b\3\b\3\b\3\t\3\t"+
		"\3\n\3\n\3\n\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\16\3\16\3\17"+
		"\3\17\3\20\3\20\3\20\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\23\3\23\3\23"+
		"\3\23\7\23f\n\23\f\23\16\23i\13\23\3\23\3\23\3\23\3\23\3\23\3\24\3\24"+
		"\3\24\3\24\3\24\3\24\3\24\3\25\3\25\7\25y\n\25\f\25\16\25|\13\25\3\26"+
		"\3\26\3g\2\27\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16"+
		"\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27\3\2\5\5\2\13\f\16\17\"\"\4"+
		"\2C\\c|\6\2\62;C\\aac|\2\u0080\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t"+
		"\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2"+
		"\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2"+
		"\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2"+
		"+\3\2\2\2\3-\3\2\2\2\5\63\3\2\2\2\7\65\3\2\2\2\t\67\3\2\2\2\139\3\2\2"+
		"\2\r>\3\2\2\2\17A\3\2\2\2\21D\3\2\2\2\23F\3\2\2\2\25I\3\2\2\2\27L\3\2"+
		"\2\2\31Q\3\2\2\2\33S\3\2\2\2\35U\3\2\2\2\37W\3\2\2\2!Z\3\2\2\2#]\3\2\2"+
		"\2%a\3\2\2\2\'o\3\2\2\2)v\3\2\2\2+}\3\2\2\2-.\7p\2\2./\7g\2\2/\60\7x\2"+
		"\2\60\61\7g\2\2\61\62\7t\2\2\62\4\3\2\2\2\63\64\7}\2\2\64\6\3\2\2\2\65"+
		"\66\7\177\2\2\66\b\3\2\2\2\678\7<\2\28\n\3\2\2\29:\7u\2\2:;\7m\2\2;<\7"+
		"k\2\2<=\7r\2\2=\f\3\2\2\2>?\7k\2\2?@\7h\2\2@\16\3\2\2\2AB\7h\2\2BC\7k"+
		"\2\2C\20\3\2\2\2DE\7=\2\2E\22\3\2\2\2FG\7<\2\2GH\7<\2\2H\24\3\2\2\2IJ"+
		"\7/\2\2JK\7@\2\2K\26\3\2\2\2LM\7i\2\2MN\7q\2\2NO\7v\2\2OP\7q\2\2P\30\3"+
		"\2\2\2QR\7*\2\2R\32\3\2\2\2ST\7+\2\2T\34\3\2\2\2UV\7#\2\2V\36\3\2\2\2"+
		"WX\7(\2\2XY\7(\2\2Y \3\2\2\2Z[\7~\2\2[\\\7~\2\2\\\"\3\2\2\2]^\t\2\2\2"+
		"^_\3\2\2\2_`\b\22\2\2`$\3\2\2\2ab\7\61\2\2bc\7,\2\2cg\3\2\2\2df\13\2\2"+
		"\2ed\3\2\2\2fi\3\2\2\2gh\3\2\2\2ge\3\2\2\2hj\3\2\2\2ig\3\2\2\2jk\7,\2"+
		"\2kl\7\61\2\2lm\3\2\2\2mn\b\23\2\2n&\3\2\2\2op\7h\2\2pq\7c\2\2qr\7n\2"+
		"\2rs\7u\2\2st\7g\2\2tu\7=\2\2u(\3\2\2\2vz\t\3\2\2wy\t\4\2\2xw\3\2\2\2"+
		"y|\3\2\2\2zx\3\2\2\2z{\3\2\2\2{*\3\2\2\2|z\3\2\2\2}~\7\63\2\2~,\3\2\2"+
		"\2\5\2gz\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}