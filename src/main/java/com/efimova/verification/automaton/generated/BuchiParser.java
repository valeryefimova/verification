package com.efimova.verification.automaton.generated;

import com.efimova.verification.automaton.State;
import com.efimova.verification.automaton.Transition;
import com.efimova.verification.ltl.Formula;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.ATN;
import org.antlr.v4.runtime.atn.ATNDeserializer;
import org.antlr.v4.runtime.atn.ParserATNSimulator;
import org.antlr.v4.runtime.atn.PredictionContextCache;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.ArrayList;
import java.util.List;

import static com.efimova.verification.ltl.Utils.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class BuchiParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, WS=17, 
		BlockComment=18, False=19, StringLiteral=20, One=21;
	public static final int
		RULE_automaton = 0, RULE_stateDescr = 1, RULE_stateName = 2, RULE_transition = 3, 
		RULE_expression = 4, RULE_literal = 5;
	public static final String[] ruleNames = {
		"automaton", "stateDescr", "stateName", "transition", "expression", "literal"
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

	@Override
	public String getGrammarFileName() { return "Buchi.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public BuchiParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class AutomatonContext extends ParserRuleContext {
		public List<State> list;
		public StateDescrContext stateDescr;
		public TerminalNode EOF() { return getToken(BuchiParser.EOF, 0); }
		public TerminalNode False() { return getToken(BuchiParser.False, 0); }
		public List<StateDescrContext> stateDescr() {
			return getRuleContexts(StateDescrContext.class);
		}
		public StateDescrContext stateDescr(int i) {
			return getRuleContext(StateDescrContext.class,i);
		}
		public AutomatonContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_automaton; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BuchiListener ) ((BuchiListener)listener).enterAutomaton(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BuchiListener ) ((BuchiListener)listener).exitAutomaton(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BuchiVisitor ) return ((BuchiVisitor<? extends T>)visitor).visitAutomaton(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AutomatonContext automaton() throws RecognitionException {
		AutomatonContext _localctx = new AutomatonContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_automaton);
		((AutomatonContext)_localctx).list =  new ArrayList<State>();
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(12);
			match(T__0);
			setState(13);
			match(T__1);
			{
			setState(23);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__2:
			case StringLiteral:
				{
				setState(19);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==StringLiteral) {
					{
					{
					setState(14);
					((AutomatonContext)_localctx).stateDescr = stateDescr();
					_localctx.list.add(((AutomatonContext)_localctx).stateDescr.state);
					}
					}
					setState(21);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case False:
				{
				setState(22);
				match(False);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(25);
			match(T__2);
			}
			setState(27);
			match(EOF);
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

	public static class StateDescrContext extends ParserRuleContext {
		public State state;
		public StateNameContext stateName;
		public TransitionContext transition;
		public StateNameContext stateName() {
			return getRuleContext(StateNameContext.class,0);
		}
		public TerminalNode False() { return getToken(BuchiParser.False, 0); }
		public List<TransitionContext> transition() {
			return getRuleContexts(TransitionContext.class);
		}
		public TransitionContext transition(int i) {
			return getRuleContext(TransitionContext.class,i);
		}
		public StateDescrContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stateDescr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BuchiListener ) ((BuchiListener)listener).enterStateDescr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BuchiListener ) ((BuchiListener)listener).exitStateDescr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BuchiVisitor ) return ((BuchiVisitor<? extends T>)visitor).visitStateDescr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StateDescrContext stateDescr() throws RecognitionException {
		StateDescrContext _localctx = new StateDescrContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_stateDescr);
		 List<Transition> list = new ArrayList<>();
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(29);
			((StateDescrContext)_localctx).stateName = stateName();
			setState(30);
			match(T__3);
			setState(44);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__4:
				{
				setState(31);
				match(T__4);
				}
				break;
			case False:
				{
				setState(32);
				match(False);
				}
				break;
			case T__5:
				{
				{
				setState(33);
				match(T__5);
				setState(37); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(34);
					((StateDescrContext)_localctx).transition = transition();
					list.add(((StateDescrContext)_localctx).transition.t);
					}
					}
					setState(39); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==T__8 );
				setState(41);
				match(T__6);
				setState(42);
				match(T__7);
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}

			        String name = (((StateDescrContext)_localctx).stateName!=null?_input.getText(((StateDescrContext)_localctx).stateName.start,((StateDescrContext)_localctx).stateName.stop):null);
			        ((StateDescrContext)_localctx).state =  new State(name, list);
			    
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

	public static class StateNameContext extends ParserRuleContext {
		public TerminalNode StringLiteral() { return getToken(BuchiParser.StringLiteral, 0); }
		public StateNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stateName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BuchiListener ) ((BuchiListener)listener).enterStateName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BuchiListener ) ((BuchiListener)listener).exitStateName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BuchiVisitor ) return ((BuchiVisitor<? extends T>)visitor).visitStateName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StateNameContext stateName() throws RecognitionException {
		StateNameContext _localctx = new StateNameContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_stateName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(48);
			match(StringLiteral);
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

	public static class TransitionContext extends ParserRuleContext {
		public Transition t;
		public ExpressionContext expression;
		public StateNameContext stateName;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public StateNameContext stateName() {
			return getRuleContext(StateNameContext.class,0);
		}
		public TransitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_transition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BuchiListener ) ((BuchiListener)listener).enterTransition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BuchiListener ) ((BuchiListener)listener).exitTransition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BuchiVisitor ) return ((BuchiVisitor<? extends T>)visitor).visitTransition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TransitionContext transition() throws RecognitionException {
		TransitionContext _localctx = new TransitionContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_transition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(50);
			match(T__8);
			setState(51);
			((TransitionContext)_localctx).expression = expression(0);
			setState(52);
			match(T__9);
			setState(53);
			match(T__10);
			setState(54);
			((TransitionContext)_localctx).stateName = stateName();
			((TransitionContext)_localctx).t =  new Transition(((TransitionContext)_localctx).expression.f, (((TransitionContext)_localctx).stateName!=null?_input.getText(((TransitionContext)_localctx).stateName.start,((TransitionContext)_localctx).stateName.stop):null));
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

	public static class ExpressionContext extends ParserRuleContext {
		public Formula f;
		public ExpressionContext left;
		public ExpressionContext expression;
		public LiteralContext literal;
		public ExpressionContext right;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public TerminalNode One() { return getToken(BuchiParser.One, 0); }
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BuchiListener ) ((BuchiListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BuchiListener ) ((BuchiListener)listener).exitExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BuchiVisitor ) return ((BuchiVisitor<? extends T>)visitor).visitExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 8;
		enterRecursionRule(_localctx, 8, RULE_expression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(72);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				{
				}
				break;
			case 2:
				{
				setState(58);
				match(T__11);
				setState(59);
				((ExpressionContext)_localctx).expression = expression(0);
				setState(60);
				match(T__12);
				 ((ExpressionContext)_localctx).f =  ((ExpressionContext)_localctx).expression.f;
				}
				break;
			case 3:
				{
				setState(63);
				((ExpressionContext)_localctx).literal = literal();
				((ExpressionContext)_localctx).f =  variable((((ExpressionContext)_localctx).literal!=null?_input.getText(((ExpressionContext)_localctx).literal.start,((ExpressionContext)_localctx).literal.stop):null));
				}
				break;
			case 4:
				{
				setState(66);
				match(T__13);
				setState(67);
				((ExpressionContext)_localctx).expression = expression(4);
				((ExpressionContext)_localctx).f =  not(((ExpressionContext)_localctx).expression.f);
				}
				break;
			case 5:
				{
				setState(70);
				match(One);
				((ExpressionContext)_localctx).f =  trueConst();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(86);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(84);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(74);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(75);
						match(T__14);
						setState(76);
						((ExpressionContext)_localctx).right = ((ExpressionContext)_localctx).expression = expression(4);
						((ExpressionContext)_localctx).f =  conjunction(((ExpressionContext)_localctx).left.f, ((ExpressionContext)_localctx).right.f);
						}
						break;
					case 2:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(79);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(80);
						match(T__15);
						setState(81);
						((ExpressionContext)_localctx).right = ((ExpressionContext)_localctx).expression = expression(3);
						((ExpressionContext)_localctx).f =  disjunction(((ExpressionContext)_localctx).left.f, ((ExpressionContext)_localctx).right.f);
						}
						break;
					}
					} 
				}
				setState(88);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
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

	public static class LiteralContext extends ParserRuleContext {
		public TerminalNode StringLiteral() { return getToken(BuchiParser.StringLiteral, 0); }
		public LiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BuchiListener ) ((BuchiListener)listener).enterLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BuchiListener ) ((BuchiListener)listener).exitLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BuchiVisitor ) return ((BuchiVisitor<? extends T>)visitor).visitLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LiteralContext literal() throws RecognitionException {
		LiteralContext _localctx = new LiteralContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_literal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(89);
			match(StringLiteral);
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
		case 4:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 3);
		case 1:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\27^\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\3\2\3\2\3\2\3\2\3\2\7\2\24\n\2\f\2"+
		"\16\2\27\13\2\3\2\5\2\32\n\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\6\3(\n\3\r\3\16\3)\3\3\3\3\3\3\5\3/\n\3\3\3\3\3\3\4\3\4\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3"+
		"\6\3\6\3\6\5\6K\n\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\7\6W\n\6\f"+
		"\6\16\6Z\13\6\3\7\3\7\3\7\2\3\n\b\2\4\6\b\n\f\2\2\2b\2\16\3\2\2\2\4\37"+
		"\3\2\2\2\6\62\3\2\2\2\b\64\3\2\2\2\nJ\3\2\2\2\f[\3\2\2\2\16\17\7\3\2\2"+
		"\17\31\7\4\2\2\20\21\5\4\3\2\21\22\b\2\1\2\22\24\3\2\2\2\23\20\3\2\2\2"+
		"\24\27\3\2\2\2\25\23\3\2\2\2\25\26\3\2\2\2\26\32\3\2\2\2\27\25\3\2\2\2"+
		"\30\32\7\25\2\2\31\25\3\2\2\2\31\30\3\2\2\2\32\33\3\2\2\2\33\34\7\5\2"+
		"\2\34\35\3\2\2\2\35\36\7\2\2\3\36\3\3\2\2\2\37 \5\6\4\2 .\7\6\2\2!/\7"+
		"\7\2\2\"/\7\25\2\2#\'\7\b\2\2$%\5\b\5\2%&\b\3\1\2&(\3\2\2\2\'$\3\2\2\2"+
		"()\3\2\2\2)\'\3\2\2\2)*\3\2\2\2*+\3\2\2\2+,\7\t\2\2,-\7\n\2\2-/\3\2\2"+
		"\2.!\3\2\2\2.\"\3\2\2\2.#\3\2\2\2/\60\3\2\2\2\60\61\b\3\1\2\61\5\3\2\2"+
		"\2\62\63\7\26\2\2\63\7\3\2\2\2\64\65\7\13\2\2\65\66\5\n\6\2\66\67\7\f"+
		"\2\2\678\7\r\2\289\5\6\4\29:\b\5\1\2:\t\3\2\2\2;K\b\6\1\2<=\7\16\2\2="+
		">\5\n\6\2>?\7\17\2\2?@\b\6\1\2@K\3\2\2\2AB\5\f\7\2BC\b\6\1\2CK\3\2\2\2"+
		"DE\7\20\2\2EF\5\n\6\6FG\b\6\1\2GK\3\2\2\2HI\7\27\2\2IK\b\6\1\2J;\3\2\2"+
		"\2J<\3\2\2\2JA\3\2\2\2JD\3\2\2\2JH\3\2\2\2KX\3\2\2\2LM\f\5\2\2MN\7\21"+
		"\2\2NO\5\n\6\6OP\b\6\1\2PW\3\2\2\2QR\f\4\2\2RS\7\22\2\2ST\5\n\6\5TU\b"+
		"\6\1\2UW\3\2\2\2VL\3\2\2\2VQ\3\2\2\2WZ\3\2\2\2XV\3\2\2\2XY\3\2\2\2Y\13"+
		"\3\2\2\2ZX\3\2\2\2[\\\7\26\2\2\\\r\3\2\2\2\t\25\31).JVX";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}