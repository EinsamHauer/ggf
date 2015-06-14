grammar Graphite;

arg: Identifier | QoutedString | function;
arguments: (WS* arg WS* COMMA WS*)* arg WS*;
function: Identifier '(' arguments ')';
expression: Identifier | function;


QoutedString: DoubleQuotedString | SingleQuotedString;
DoubleQuotedString: '"' ~[\r\n]* '"';
SingleQuotedString: '\'' ~[\r\n]* '\'';
Identifier: VALIDCHARS+;

VALIDCHARS : ~[,(){}\[\]\n\r\t ];
ALPHA: [a-zA-z];
WS: (' ' | '\t')+ -> skip;
COMMA: ',';