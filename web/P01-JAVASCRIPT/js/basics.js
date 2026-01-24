// "use strict"; //le mode d'interpretation strict de javascript ?? v7 = 'var' n'est pas acceptable


console.log('script extern');

//context global ??

afficher("script intern")

function afficher (message)
{
	console.log(message)
}



function printVar(name, variable)
{
	console.log(name + ' - ' + typeof variable + '=' + variable);
}

function falsyTruthy(name, value)
{
	if (value)
		console.log('-' + name + ' : is truthy');
	else
		console.log('-' + name + ' : is falsy');

}

v7 = 'var global';
var v1 = 20, v2 = 100000000000000000n, v3 = 'string', v4 = true, v5 = null, v6, v9 = function(){}, v10 = Symbol('');

function exp01()
{
	printVar('v1', v1);
	printVar('v2', v2);
	printVar('v3', v3);
	printVar('v4', v4);
	printVar('v5', v5);
	printVar('v6', v6);
	printVar('v7', v7);
	printVar('v9', v9);
	console.log('v10', typeof v10,  v10);
	if ([] instanceof Array)console.log('Array');
	
}

// number sur 8 byte
// Symbol type introduit dans ES6
//tous les var et function et remonter en haut 

function exp02()
{
	printVar('window.v1', window.v1);
	window.v8 = 'global object';
	window.printVar('v8', v8);
	window.console.log('console est aussi propriete de l\'objet window');
	window.test = function(){
		console.log('ceci est la function test()');
	}
	test();
}


function exp03()
{
	let x1 = 20;
	let x2 = new Number(20);
	let x3 = new Number(20);
	// let x3 = new BigInt();
	// let x4 = new String();
	// let x5 = new Boolean();

	console.log('x1 == x2',  x1 == x2);
	console.log('x1 == x3',  x1 == x3);
	console.log('x2 == x3',  x2 == x3);
	console.log('x1 === x2',  x1 === x2); //comparaison stricte
	//le mode d'interpretation de javascript ?? v7 = 'var'
	// l'interpreteur convert l'objet Number à un number puis il le compare

	
}
// context global ??

function exp04()
{
	//valeur falsy (falsy values)
	//valeur truthy (truthy values)
	let x1 = 0;
	let x2 = '';
	let x3 = false;
	let x5;
	let x6 = null;
	let x7 = NaN;

	//sont tous des falsy values

	falsyTruthy('x1', x1);
	falsyTruthy('x2', x2);
	falsyTruthy('x3', x3);
	falsyTruthy('x5', x5);
	falsyTruthy('x6', x6);
	falsyTruthy('x7', x7);

	//à l'interieur de la fonction tous les var vont remonté en debut 
	// de fnoction meme si ils sont declare à l'interieur d'un block for ou else

	if (!x1) console.log('x1 = false');
	if (!x2) console.log('x2 = false');
	if (!x3) console.log('x3 = false');
	
	
	printVar('x1',x1);
	printVar('x2',x2);
	printVar('x3',x3);
	
	console.log('x1 == x2', x1==x2);
	console.log('x1 == x3', x1==x3);
	console.log('x2 == x3', x2==x3);
	
	let x4 = []; //tableau vide n'est pas falsy
	if (!x4) console.log('x4 = false');
	console.log('x1 == x4', x1==x5);
}

function exp05()
{
	let x1 = '20.5';
	let x2 = 14.2;
	printVar('x1', x1);
	printVar('x2', x2);
	
	let x3 = x1 + x2;
	printVar('x3', x3);
	
	let x4 = parseFloat(x1) + x2;
	printVar('x4', x4);
}
