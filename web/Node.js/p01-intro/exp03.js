console.log('### exemple 03 ###');

let args = process.argv;

args = args.slice(2)

console.log(args);

let somme = args.reduce((e, c) => parseInt(c) + parseInt(e), 0);

console.log('la somme est : ' + somme);
