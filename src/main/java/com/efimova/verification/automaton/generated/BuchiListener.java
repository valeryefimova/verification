package com.efimova.verification.automaton.generated;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link BuchiParser}.
 */
public interface BuchiListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link BuchiParser#automaton}.
	 * @param ctx the parse tree
	 */
	void enterAutomaton(BuchiParser.AutomatonContext ctx);
	/**
	 * Exit a parse tree produced by {@link BuchiParser#automaton}.
	 * @param ctx the parse tree
	 */
	void exitAutomaton(BuchiParser.AutomatonContext ctx);
	/**
	 * Enter a parse tree produced by {@link BuchiParser#stateDescr}.
	 * @param ctx the parse tree
	 */
	void enterStateDescr(BuchiParser.StateDescrContext ctx);
	/**
	 * Exit a parse tree produced by {@link BuchiParser#stateDescr}.
	 * @param ctx the parse tree
	 */
	void exitStateDescr(BuchiParser.StateDescrContext ctx);
	/**
	 * Enter a parse tree produced by {@link BuchiParser#stateName}.
	 * @param ctx the parse tree
	 */
	void enterStateName(BuchiParser.StateNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link BuchiParser#stateName}.
	 * @param ctx the parse tree
	 */
	void exitStateName(BuchiParser.StateNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link BuchiParser#transition}.
	 * @param ctx the parse tree
	 */
	void enterTransition(BuchiParser.TransitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link BuchiParser#transition}.
	 * @param ctx the parse tree
	 */
	void exitTransition(BuchiParser.TransitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link BuchiParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(BuchiParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link BuchiParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(BuchiParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link BuchiParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterLiteral(BuchiParser.LiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link BuchiParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitLiteral(BuchiParser.LiteralContext ctx);
}