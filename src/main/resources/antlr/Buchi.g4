grammar Buchi;

@header {
package com.efimova.verification.automaton.antlr;

import com.efimova.verification.ltl.*;
import com.efimova.verification.automaton.State;
import com.efimova.verification.automaton.Transition;
import static com.efimova.verification.ltl.Utils.*;
}

automaton returns [List<State> list]
@init {$list = new ArrayList<State>();} :
    'never' '{' ( ((stateDescr {$list.add($stateDescr.state);})* | False) '}' ) EOF;

stateDescr returns [State state]
@init{ List<Transition> list = new ArrayList<>();} :
    stateName ':' ('skip' | False | ('if' (transition {list.add($transition.t);})+ 'fi' ';')) {
        String name = $stateName.text;
        $state = new State(name, list);
    };

stateName: StringLiteral;

transition returns [Transition t]:
    '::' expression '->' 'goto' stateName {$t = new Transition($expression.f, $stateName.text);};

expression returns [Formula f]:
        |   '(' expression ')' { $f = $expression.f;}
        |   literal {$f = variable($literal.text);}
        |   '!' expression {$f = not($expression.f);}
        |   left=expression '&&' right=expression {$f = conjunction($left.f, $right.f);}
        |   left=expression '||' right=expression {$f = disjunction($left.f, $right.f);}
        |   One {$f = trueConst();};


literal: StringLiteral;

WS: [ \t\r\n\f] -> skip;

BlockComment: '/*' .*? '*/' -> skip;

False: 'false;';

StringLiteral: [a-zA-Z][a-zA-Z0-9_]*;

One: '1';


