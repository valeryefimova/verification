grammar LTL;

@header {
package com.efimova.verification.ltl.generated;

import com.efimova.verification.ltl.*;
import static com.efimova.verification.ltl.Utils.*;
}

ltl returns [Formula f] :
        primary {$f = $primary.f;}
    |   NEXT ltl {$f = new Next($ltl.f);}
    |   GLOB ltl{$f = globally($ltl.f);}
    |   FUTURE ltl {$f = future($ltl.f);}
    |   l=ltl RELEASE r=ltl {$f = release($l.f, $r.f);}
    |   l=ltl UNTIL r=ltl {$f = until($l.f, $r.f);}
    |   l=ltl CON r=ltl {$f = conjunction($l.f, $r.f);}
    |   l=ltl DIS r=ltl {$f = disjunction($l.f, $r.f);}
    |   <assoc=right> l=ltl IMPL r=ltl {$f = implication($l.f, $r.f);}
    |   l=ltl EQ r=ltl {$f = eq($l.f, $r.f);}
    ;

primary returns [Formula f]:
        constant {$f = $constant.f;}
    |   LP ltl RP {$f = $ltl.f;}
    |   NOT ltl{$f = not($ltl.f);}
    ;

constant returns [Formula f]:
        TRUE {$f = trueConst();}
    |   FALSE {$f = falseConst();}
    |   StringLiteral {
            String name = $StringLiteral.text;
            $f = variable(name.substring(1, name.length() - 1));
        }
    ;

NOT     :   '!'     ;
DIS     :   '|'     ;
CON     :   '&'     ;
IMPL    :   '->'    ;
EQ      :   '=='   ;
RELEASE :   'R'     ;
UNTIL   :   'U'     ;
NEXT    :   'X'     ;
GLOB    :   'G'     ;
FUTURE  :   'F'     ;
TRUE    :   'true'  ;
FALSE   :   'false' ;
LP      :   '('     ;
RP      :   ')'     ;

StringLiteral:
        SingleQuoteSeq
    |   DoubleQuoteSeq
    ;

fragment
SingleQuoteSeq:   '\'' (~['\\\r\n] | EscapeSeq)+ '\'';

fragment
DoubleQuoteSeq:   '"' (~["\\\r\n] | EscapeSeq)+ '"';

fragment
EscapeSeq:   '\\' ['"abfnrtv\\];

WS  :	[ \t\r\n\f] -> skip;

ErrorChar : . {
        System.err.println("Invalid character: ");};

