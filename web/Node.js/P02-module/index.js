// let mysql = require('mysql') // si il est dans node_module;

let { exp01, print } = require('./examples');
let {getAllAUthors, getAllDocuments} = require('./services');
// let { builtinModules } = require('node:module'); // certain module exige de prefixer le module par node
let { builtinModules } = require('module');

let { sum, sumv2 } = require ('math')

let { test } = require('node:test')
// let { test } = require('test') //ça marche pas

function main()
{
    console.log(getAllAUthors());
    console.log(getAllDocuments());
    console.log(builtinModules);
    console.log('built-in modules : ' + builtinModules.length);

    // exp01();
    print('CommonJS module System');
    console.log(sum(10, 20, 30));
    console.log(sumv2(10, 20, 30));
    
}

main();

//module built-in

// installer notre module comme global
