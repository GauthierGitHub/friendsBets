/**
 * CALL BACK
 * permet d'organiser dans le temps les fonctions
 */

function somme(x, y) {return x+y;}
function produit(x, y) {return x*y;}

/**
 * la fonction opération à deux fonction callback;
 * @param {*} x 
 * @param {*} y 
 * @param {*} z 
 * @param {*} functionA 
 * @param {*} functionB 
 */
function operation(x, y, z, functionA, functionB){
    return functionB(functionA(x, y), z);
}
console.log(
    operation(2, 3, 6, somme, produit)
);

////////////////////////////////////////////////

function direBonjour(){
    // alert("Bonjour ça va ?"); // only in windows env
    console.log("Bonjour ça va ?");
}

function direBonjourApresXSecondes(x) {
    setTimeout(direBonjour, x * 1000);
}

direBonjourApresXSecondes(3);
//clearTimeOut(timeout); supprime le timeOut;
