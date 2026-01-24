export function sum()
{
    let n = arguments.length;
    console.log('la fonction est appellé avec ' + n + ' arguments');

    let s = 0;
    for (let i = 0; i < n; i++)
        s+=arguments[i];
    return s;
}

export function sumv2(...args)
{
    //...args est appelé rest parametre du reste;
    //args est un tableau,par contre arguments ne l'est pas;
    //reduce peut ne pas mentionner l'initialiseur des tableau

    let n = args.length;
    console.log('la fonction est appellé avec ' + n + ' arguments');
    return args.reduce((e, c) => e + c);
}
