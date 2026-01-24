console.log(`...exemple N° 1...`);

// window // erreur : object not defined
// document // erreur : object not defined

// global : global context <=> window navigateur

let x = 20;

global.console.log('x = ', x);
global.console.log('x = ', global.x);

// module, exports, require, __filename, __dirname : les  parametre de module

//module.path : chemin de recherche par defaut de node

// les module ont apparue avant ES6


let obj = Object.getOwnPropertyNames(global);

console.log(obj);

console.log('la taile de global est : ' + obj.length);

// console.log(module)


