/*
Trouver une expression régulière qui permet de déterminer si une
chaı̂ne de caractère contient 3 occurrences (pas forcement
consécutives) de la sous-chaı̂ne ab.
true pour abacccababcc
true pour abababccccab
false pour baaaaabaccccba
*/
console.log("-----exo1-----");
var tableau = ["abacccababcc", "abababccccab", "baaaaabaccccba",];
var regex = /(ab.*){3}/i; //var regex = /(ab){3}/;   i????? sort des nulls ? ou gi ???
for (i = 0; i < tableau.length; i++) { // page 129 pdf hachref
    console.log(regex.test(tableau[i]));
}

/*
Trouver une expression régulière qui permet de déterminer si une
chaı̂ne commence par la lettre a, se termine par la lettre b et pour
chaque x suivi de y (pas forcement consécutives), il existe un z situé
entre x et y.
true pour ab
true pour abxyb
true pour abxazyb
false pour abxuyb
false pour abxazyxyb
a(?=b) : a suivi de b
*/
console.log("-----exo2-----");
var tableau = ["ab", "abxyb", "abxazyb","abxuyb", "abxazyxyb"];
var regex = /^a.*(?=[x.*z.*y.*]|[^x])b$/; //faux
tableau.forEach(element => {
    console.log(regex.test(element));
});

/*
Trouver une expression régulière qui permet de déterminer si une
chaı̂ne de caractère correspond à une adresse e-mail.
*/
console.log("-----exo3-----");
var tableau = ["ab@g.c", "abxyb@g", "abxazyb.c", "gauthier@gmail.com"
    ,"abxuyb@.c", "abxaz@y.x.yb", "ab.xaz@y.x.", "abxaz@y.x.yb", "abxéaz@y.x.yb"];
var regex = /^[a-z0-9]*@[a-z0-9]*\.[a-z]/ //faux
regex = /^[a-zA-Z0-9.!#$%&’*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$/ //faux
for (valeur in tableau) {
    console.log(regex.test(tableau));
}