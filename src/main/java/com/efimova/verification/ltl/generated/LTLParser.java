package com.efimova.verification.ltl.generated;

import com.efimova.verification.ltl.Formula;
import com.efimova.verification.ltl.Next;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.ATN;
import org.antlr.v4.runtime.atn.ATNDeserializer;
import org.antlr.v4.runtime.atn.ParserATNSimulator;
import org.antlr.v4.runtime.atn.PredictionContextCache;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.List;

import static com.efimova.verification.ltl.Utils.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class LTLParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		NOT=1, DIS=2, CON=3, IMPL=4, EQ=5, RELEASE=6, UNTIL=7, NEXT=8, GLOB=9, 
		FUTURE=10, TRUE=11, FALSE=12, LP=13, RP=14, StringLiteral=15, WS=16, ErrorChar=17;
	public static final int
		RULE_ltl = 0, RULE_primary = 1, RULE_constant = 2;
	public static final String[] ruleNames = {
		"ltl", "primary", "constant"
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

	@Override
	public String getGrammarFileName() { return "LTL.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public LTLParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class LtlContext extends ParserRuleContext {
		public Formula f;
		public LtlContext l;
		public PrimaryContext primary;
		public LtlContext ltl;
		public LtlContext r;
		public PrimaryContext primary() {
			return getRuleContext(PrimaryContext.class,0);
		}
		public TerminalNode NEXT() { return getToken(LTLParser.NEXT, 0); }
		public List<LtlContext> ltl() {
			return getRuleContexts(LtlContext.class);
		}
		public LtlContext ltl(int i) {
			return getRuleContext(LtlContext.class,i);
		}
		public TerminalNode GLOB() { return getToken(LTLParser.GLOB, 0); }
		public TerminalNode FUTURE() { return getToken(LTLParser.FUTURE, 0); }
		public TerminalNode RELEASE() { return getToken(LTLParser.RELEASE, 0); }
		public TerminalNode UNTIL() { return getToken(LTLParser.UNTIL, 0); }
		public TerminalNode CON() { return getToken(LTLParser.CON, 0); }
		public TerminalNode DIS() { return getToken(LTLParser.DIS, 0); }
		public TerminalNode IMPL() { return getToken(LTLParser.IMPL, 0); }
		public TerminalNode EQ() { return getToken(LTLParser.EQ, 0); }
		public LtlContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ltl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LTLListener ) ((LTLListener)listener).enterLtl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LTLListener ) ((LTLListener)listener).exitLtl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LTLVisitor ) return ((LTLVisitor<? extends T>)visitor).visitLtl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LtlContext ltl() throws RecognitionException {
		return ltl(0);
	}

	private LtlContext ltl(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		LtlContext _localctx = new LtlContext(_ctx, _parentState);
		LtlContext _prevctx = _localctx;
		int _startState = 0;
		enterRecursionRule(_localctx, 0, RULE_ltl, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(22);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NOT:
			case TRUE:
			case FALSE:
			case LP:
			case StringLiteral:
				{
				setState(7);
				((LtlContext)_localctx).primary = primary();
				((LtlContext)_localctx).f =  ((LtlContext)_localctx).primary.f;
				}
				break;
			case NEXT:
				{
				setState(10);
				match(NEXT);
				setState(11);
				((LtlContext)_localctx).ltl = ltl(9);
				((LtlContext)_localctx).f =  new Next(((LtlContext)_localctx).ltl.f);
				}
				break;
			case GLOB:
				{
				setState(14);
				match(GLOB);
				setState(15);
				((LtlContext)_localctx).ltl = ltl(8);
				((LtlContext)_localctx).f =  globally(((LtlContext)_localctx).ltl.f);
				}
				break;
			case FUTURE:
				{
				setState(18);
				match(FUTURE);
				setState(19);
				((LtlContext)_localctx).ltl = ltl(7);
				((LtlContext)_localctx).f =  future(((LtlContext)_localctx).ltl.f);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(56);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(54);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
					case 1:
						{
						_localctx = new LtlContext(_parentctx, _parentState);
						_localctx.l = _prevctx;
						_localctx.l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_ltl);
						setState(24);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(25);
						match(RELEASE);
						setState(26);
						((LtlContext)_localctx).r = ((LtlContext)_localctx).ltl = ltl(7);
						((LtlContext)_localctx).f =  release(((LtlContext)_localctx).l.f, ((LtlContext)_localctx).r.f);
						}
						break;
					case 2:
						{
						_localctx = new LtlContext(_parentctx, _parentState);
						_localctx.l = _prevctx;
						_localctx.l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_ltl);
						setState(29);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(30);
						match(UNTIL);
						setState(31);
						((LtlContext)_localctx).r = ((LtlContext)_localctx).ltl = ltl(6);
						((LtlContext)_localctx).f =  until(((LtlContext)_localctx).l.f, ((LtlContext)_localctx).r.f);
						}
						break;
					case 3:
						{
						_localctx = new LtlContext(_parentctx, _parentState);
						_localctx.l = _prevctx;
						_localctx.l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_ltl);
						setState(34);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(35);
						match(CON);
						setState(36);
						((LtlContext)_localctx).r = ((LtlContext)_localctx).ltl = ltl(5);
						((LtlContext)_localctx).f =  conjunction(((LtlContext)_localctx).l.f, ((LtlContext)_localctx).r.f);
						}
						break;
					case 4:
						{
						_localctx = new LtlContext(_parentctx, _parentState);
						_localctx.l = _prevctx;
						_localctx.l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_ltl);
						setState(39);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(40);
						match(DIS);
						setState(41);
						((LtlContext)_localctx).r = ((LtlContext)_localctx).ltl = ltl(4);
						((LtlContext)_localctx).f =  disjunction(((LtlContext)_localctx).l.f, ((LtlContext)_localctx).r.f);
						}
						break;
					case 5:
						{
						_localctx = new LtlContext(_parentctx, _parentState);
						_localctx.l = _prevctx;
						_localctx.l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_ltl);
						setState(44);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(45);
						match(IMPL);
						setState(46);
						((LtlContext)_localctx).r = ((LtlContext)_localctx).ltl = ltl(2);
						((LtlContext)_localctx).f =  implication(((LtlContext)_localctx).l.f, ((LtlContext)_localctx).r.f);
						}
						break;
					case 6:
						{
						_localctx = new LtlContext(_parentctx, _parentState);
						_localctx.l = _prevctx;
						_localctx.l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_ltl);
						setState(49);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(50);
						match(EQ);
						setState(51);
						((LtlContext)_localctx).r = ((LtlContext)_localctx).ltl = ltl(2);
						((LtlContext)_localctx).f =  eq(((LtlContext)_localctx).l.f, ((LtlContext)_localctx).r.f);
						}
						break;
					}
					} 
				}
				setState(58);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class PrimaryContext extends ParserRuleContext {
		public Formula f;
		public ConstantContext constant;
		public LtlContext ltl;
		public ConstantContext constant() {
			return getRuleContext(ConstantContext.class,0);
		}
		public TerminalNode LP() { return getToken(LTLParser.LP, 0); }
		public LtlContext ltl() {
			return getRuleContext(LtlContext.class,0);
		}
		public TerminalNode RP() { return getToken(LTLParser.RP, 0); }
		public TerminalNode NOT() { return getToken(LTLParser.NOT, 0); }
		public PrimaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primary; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LTLListener ) ((LTLListener)listener).enterPrimary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LTLListener ) ((LTLListener)listener).exitPrimary(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LTLVisitor ) return ((LTLVisitor<? extends T>)visitor).visitPrimary(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrimaryContext primary() throws RecognitionException {
		PrimaryContext _localctx = new PrimaryContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_primary);
		try {
			setState(71);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TRUE:
			case FALSE:
			case StringLiteral:
				enterOuterAlt(_localctx, 1);
				{
				setState(59);
				((PrimaryContext)_localctx).constant = constant();
				((PrimaryContext)_localctx).f =  ((PrimaryContext)_localctx).constant.f;
				}
				break;
			case LP:
				enterOuterAlt(_localctx, 2);
				{
				setState(62);
				match(LP);
				setState(63);
				((PrimaryContext)_localctx).ltl = ltl(0);
				setState(64);
				match(RP);
				((PrimaryContext)_localctx).f =  ((PrimaryContext)_localctx).ltl.f;
				}
				break;
			case NOT:
				enterOuterAlt(_localctx, 3);
				{
				setState(67);
				match(NOT);
				setState(68);
				((PrimaryContext)_localctx).ltl = ltl(0);
				((PrimaryContext)_localctx).f =  not(((PrimaryContext)_localctx).ltl.f);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConstantContext extends ParserRuleContext {
		public Formula f;
		public Token StringLiteral;
		public TerminalNode TRUE() { return getToken(LTLParser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(LTLParser.FALSE, 0); }
		public TerminalNode StringLiteral() { return getToken(LTLParser.StringLiteral, 0); }
		public ConstantContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constant; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LTLListener ) ((LTLListener)listener).enterConstant(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LTLListener ) ((LTLListener)listener).exitConstant(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LTLVisitor ) return ((LTLVisitor<? extends T>)visitor).visitConstant(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstantContext constant() throws RecognitionException {
		ConstantContext _localctx = new ConstantContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_constant);
		try {
			setState(79);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TRUE:
				enterOuterAlt(_localctx, 1);
				{
				setState(73);
				match(TRUE);
				((ConstantContext)_localctx).f =  trueConst();
				}
				break;
			case FALSE:
				enterOuterAlt(_localctx, 2);
				{
				setState(75);
				match(FALSE);
				((ConstantContext)_localctx).f =  falseConst();
				}
				break;
			case StringLiteral:
				enterOuterAlt(_localctx, 3);
				{
				setState(77);
				((ConstantContext)_localctx).StringLiteral = match(StringLiteral);

				            String name = (((ConstantContext)_localctx).StringLiteral!=null?((ConstantContext)_localctx).StringLiteral.getText():null);
				            ((ConstantContext)_localctx).f =  variable(name.substring(1, name.length() - 1));
				        
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 0:
			return ltl_sempred((LtlContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean ltl_sempred(LtlContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 6);
		case 1:
			return precpred(_ctx, 5);
		case 2:
			return precpred(_ctx, 4);
		case 3:
			return precpred(_ctx, 3);
		case 4:
			return precpred(_ctx, 2);
		case 5:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\23T\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2"+
		"\3\2\5\2\31\n\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3"+
		"\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\7\2"+
		"9\n\2\f\2\16\2<\13\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5"+
		"\3J\n\3\3\4\3\4\3\4\3\4\3\4\3\4\5\4R\n\4\3\4\2\3\2\5\2\4\6\2\2\2]\2\30"+
		"\3\2\2\2\4I\3\2\2\2\6Q\3\2\2\2\b\t\b\2\1\2\t\n\5\4\3\2\n\13\b\2\1\2\13"+
		"\31\3\2\2\2\f\r\7\n\2\2\r\16\5\2\2\13\16\17\b\2\1\2\17\31\3\2\2\2\20\21"+
		"\7\13\2\2\21\22\5\2\2\n\22\23\b\2\1\2\23\31\3\2\2\2\24\25\7\f\2\2\25\26"+
		"\5\2\2\t\26\27\b\2\1\2\27\31\3\2\2\2\30\b\3\2\2\2\30\f\3\2\2\2\30\20\3"+
		"\2\2\2\30\24\3\2\2\2\31:\3\2\2\2\32\33\f\b\2\2\33\34\7\b\2\2\34\35\5\2"+
		"\2\t\35\36\b\2\1\2\369\3\2\2\2\37 \f\7\2\2 !\7\t\2\2!\"\5\2\2\b\"#\b\2"+
		"\1\2#9\3\2\2\2$%\f\6\2\2%&\7\5\2\2&\'\5\2\2\7\'(\b\2\1\2(9\3\2\2\2)*\f"+
		"\5\2\2*+\7\4\2\2+,\5\2\2\6,-\b\2\1\2-9\3\2\2\2./\f\4\2\2/\60\7\6\2\2\60"+
		"\61\5\2\2\4\61\62\b\2\1\2\629\3\2\2\2\63\64\f\3\2\2\64\65\7\7\2\2\65\66"+
		"\5\2\2\4\66\67\b\2\1\2\679\3\2\2\28\32\3\2\2\28\37\3\2\2\28$\3\2\2\28"+
		")\3\2\2\28.\3\2\2\28\63\3\2\2\29<\3\2\2\2:8\3\2\2\2:;\3\2\2\2;\3\3\2\2"+
		"\2<:\3\2\2\2=>\5\6\4\2>?\b\3\1\2?J\3\2\2\2@A\7\17\2\2AB\5\2\2\2BC\7\20"+
		"\2\2CD\b\3\1\2DJ\3\2\2\2EF\7\3\2\2FG\5\2\2\2GH\b\3\1\2HJ\3\2\2\2I=\3\2"+
		"\2\2I@\3\2\2\2IE\3\2\2\2J\5\3\2\2\2KL\7\r\2\2LR\b\4\1\2MN\7\16\2\2NR\b"+
		"\4\1\2OP\7\21\2\2PR\b\4\1\2QK\3\2\2\2QM\3\2\2\2QO\3\2\2\2R\7\3\2\2\2\7"+
		"\308:IQ";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}