// Simple add/sub/mul/div with MDAS precidence and paren grouping.
// compbined parser and lexer

grammar calculator;

// parser (lowercase vars)

start: expression | <EOF> ;

expression: multExpr ( ('+' | '-') multExpr)* ;

multExpr: atom ( ('*' | '/') atom)*;

atom: NUMBER | ('(' expression ')');

// lexer (uppercase vars)

NUMBER : ('0' .. '9') + ('.' ('0' .. '9') +)? ;

WS : [ \r\n\t] + -> skip ;