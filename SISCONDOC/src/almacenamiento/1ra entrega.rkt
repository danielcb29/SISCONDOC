#lang eopl


;<expresion>   ::=   <variable>
;                     var-exp(id)
;-----
;              ::=   proc"{"<nombre-proc>{<variable>}*"}"
;              ::=   <cuerpo>
;              ::=   end
;                    proc-exp(nombre vars cuerpo)

;              ::=   fun"{"<nombre-proc>{<variable>}*"}"
;              ::=   <cuerpo>
;              ::=   end  
;                    fun-exp(nombre vars cuerpo)

;                   "{"<expression>{<expression>}*"}"
;                    app-exp(ractor rand)

;              ::=  <primitiva>"{"{<expression>}*"}"
;                   prim-exp(prim rands)
;... (siguen agregando el bnf ).. Recuerden en orden de los puntos




;<primitiva>   ::=    "isdet?"
;                     <isdet-prim>
;                     "isfree?"
;                     <isfree-prim>
;              ::=   "+"
;                    <sum-prim>
;              ::=   "*"
;                    <mult-prim>
;              ::=   "-"
;                    <sub-prim>
;              ::=   "/"
;                    <div-prim>
;              ::=   "<"
;                    <menor-prim>
;              ::=   "=<"
;                    <menoreq-prim>
;              ::=   ">"
;                    <mayor-prim>
;              ::=   ">="
;                    <mayig-prim>
;              ::=   "=="
;                    <igual-prm>
;              ::=   "orelse"
;                    <orelse-prim>
;              ::=   "andthen"
;                    <andthen-prim>
;              ::=   "="
;                    <unif-prim>
;              ::=   "newport"
;                    <newport-prim>
;              ::=   "isport?"
;                    <isport-prim>
;              ::=   "send"
;                    <send-prim>
;              ::=   "newcell"
;                    <newcell-prim>
;              ::=   "iscell?"
;                    <iscell-prim>
;              ::=   "@"
;                    <acces-prim>
;              ::=   "setcell"
;                    <setcell-prim>


;_______________________________________________


;Especificación Léxica
(define scanner-spec-simple-interpreter
  '((white-sp
     (whitespace) skip)
    (comment
     ("%" (arbno (not #\newline))) skip)
    (variable
     ((or "_"(concat  (or "A" "B" "C" "D" "E" "F" "G" "H" "I" "J" "K" "L" "M" "N" "O" "P" "Q" "R" "S" "T" "U" "V" "W" "X" "Y" "Z")
                      (arbno (or letter digit "_"))))) symbol)
    (number
     (digit (arbno digit)) number)
    (number
     ("-" digit (arbno digit)) number)))

;Especificación Sintáctica (gramática)

(define grammar-simple-interpreter
  '(
    ;;Programa
    (programa (expression) 
               a-program);;2.1.1 David 1 4 7 10 13
    ;variable
    (expression (identifier) var-exp)
    
    ;variables locales
    (expression ("local" variable (arbno variable) "in" cuerpo "end")local-exp);;2.1.4 David
    
    ;Numeros
    (expression ()entero-exp) ;; 2.1.7 David 
    (expression ()flotante-exp);; 2.1.7 David
    
    ;Procedimientos
    (expression
     ("proc{" nombre-proc (arbno variable) "}" cuerpo "end")
     proc-exp)
    
    (expression
     ("fun{" nombre-proc (arbno variable) "}" cuerpo "end")
     proc-exp)
    
    (expression
     ("{" expression (arbno expression)"}")
     app-exp)
    
    ;Ejecucion Condicional
    
    (expression ("if" expression "then" cuerpo 
    
    (expression ("else" cuerpo "end") end-if)
    
    (expression ("case" expression "of" patron "then" cuerpo "{" "}" "{ else" cuerpo "}") case-exp) ;;2.1.10 David 
                      
   
                      
  ;siguen agregando en orden de los puntos  
    
    ;Primitivas
    (expression
     (primitive "{" (arbno expression) "}")
     prim-exp)
    ;Operaciones sobre variables
    (primitive ("isdet?") isdet-prim)
    (primitive ("isfree?") isfree-prim)
    ;Operaciones aritḿeticas
    (primitive ("+") sum-prim)
    (primitive ("*") mult-prim)
    (primitive ("-") sub-prim)
    (primitive ("/") div-prim)
    ;Comparacíon      
    (primitive ("<") menor-prim)
    (primitive ("=<") menoreq-prim)
    (primitive (">") mayor-prim)
    (primitive (">=") mayig-prim)
    (primitive ("==") igual-prim)
    ;Logicas
    (primitive ("orelse") orelse-prim)
    (primitive ("andthen") andthen-prim)
    ;Unificacion 
    (primitive ("=") unif-prim)
    ;Operaciones sobre puertos
    (primitive ("newport") newport-prim)
    (primitive ("isport?") isport-prim)
    (primitive ("send") send-prim)
    ;Operaciones de celdas
    (primitive ("newcell") newcell-prim)
    (primitive ("iscell?") iscell-prim)
    (primitive ("@") acces-prim)
    (primitive ("setcell") setcell-prim)
    
    
    
    
    
    ))

;Tipos de datos para la sintaxis abstracta de la gramática

;Construidos manualmente:

;(define-datatype expresion expresion?
;(var-exp  
;(id symbol?))
;(proc-exp
; (nombre nombre-proc?)
; (vars (list-of symbol?))
; (cuerpo cuerpo?))
;(fun-exp
; (nombre nombre-proc?)
; (vars (list-of symbol?))
; (cuerpo cuerpo?))
;(app-exp 
; (ractor expression?)
; (rands (list-of expression?)))
;  ...(aqui siguen todos las variantes que sean de tipo de dato expression)Nota: Recuerden en orden de los puntos
;  )


;(define-datatype primitiva primitiva?
;  (isdet-prim)
;  (isfree-prim)
;  (sum-prim)
;  (mult-prim)
;  (sub-prim)
;  (div-prim)
;  (menor-prim)
;  (meneq-prim)
;  (mayor-prim)
;  (mayig-prim)
;  (igual-prim)
;  (orelse-prim)
;  (andthen-prim)
;  (unif-prim)
;  (newport-prim)
;  (isport-prim)
;  (send-prim)
;  (newcell-prim)
;  (iscell-prim)
;  (acces-prim)
;  (setcell-prim)
;    )




