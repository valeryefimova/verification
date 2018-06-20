package com.efimova.verification.automaton.generated;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link BuchiParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface BuchiVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link BuchiParser#automaton}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAutomaton(BuchiParser.AutomatonContext ctx);
	/**
	 * Visit a parse tree produced by {@link BuchiParser#stateDescr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStateDescr(BuchiParser.StateDescrContext ctx);
	/**
	 * Visit a parse tree produced by {@link BuchiParser#stateName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStateName(BuchiParser.StateNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link BuchiParser#transition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTransition(BuchiParser.TransitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link BuchiParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(BuchiParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link BuchiParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral(BuchiParser.LiteralContext ctx);
}