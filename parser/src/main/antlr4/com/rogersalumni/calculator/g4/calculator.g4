// Simple add/sub/mul/div with MDAS precidence and paren grouping.
// compbined parser and lexer

grammar Calculator;

// parser (lowercase)

start: expression | <EOF> ;

expression: multExpr ( addOp multExpr)* ;

multExpr: atom ( mulOp atom)*;

atom: NUMBER | (LPAR expression RPAR);

addOp: ADD | SUB;

mulOp: MUL | DIV;

// lexer (capitalized)

ADD: '+';

SUB: '-';

MUL: '*';

DIV: '/';

LPAR: '(';

RPAR: ')';

NUMBER : ('0' .. '9') + ('.' ('0' .. '9') +)? ;

WS : [ \r\n\t] + -> skip ;