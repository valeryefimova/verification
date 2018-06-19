package com.efimova.verification.ltl.generated;


import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link LTLParser}.
 */
public interface LTLListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link LTLParser#ltl}.
	 * @param ctx the parse tree
	 */
	void enterLtl(LTLParser.LtlContext ctx);
	/**
	 * Exit a parse tree produced by {@link LTLParser#ltl}.
	 * @param ctx the parse tree
	 */
	void exitLtl(LTLParser.LtlContext ctx);
	/**
	 * Enter a parse tree produced by {@link LTLParser#primary}.
	 * @param ctx the parse tree
	 */
	void enterPrimary(LTLParser.PrimaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link LTLParser#primary}.
	 * @param ctx the parse tree
	 */
	void exitPrimary(LTLParser.PrimaryContext ctx);
	/**
	 * Enter a parse tree produced by {@link LTLParser#constant}.
	 * @param ctx the parse tree
	 */
	void enterConstant(LTLParser.ConstantContext ctx);
	/**
	 * Exit a parse tree produced by {@link LTLParser#constant}.
	 * @param ctx the parse tree
	 */
	void exitConstant(LTLParser.ConstantContext ctx);
}