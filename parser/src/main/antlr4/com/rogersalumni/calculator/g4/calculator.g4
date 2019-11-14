// Simple add/sub/mul/div/modulo with JavaScript precidence and paren grouping.
// Compbined parser and lexer.

grammar Calculator;

// parser

start: expr | <EOF> ;

expr  : '-' expr         # UMINUS
      | expr mulop expr  # MULOPGRP
      | expr addop expr  # ADDOPGRP
      | '(' expr ')'     # PARENGRP
      | NUMBER           # DOUBLE
      ;

addop : '+' | '-' ;

mulop : '*' | '/' | '%' ;

// lexer

NUMBER : ('0' .. '9') + ('.' ('0' .. '9') +)? ;

WS : [ \r\n\t] + -> skip ;