import { exp01, exp02 , exp03, exp04, exp05} from './exemples.js';

async function main()
{
    // exp01();
    // exp02();
    // exp03()
    // .then(response => {
    //     console.log('apres exp03().');
    //     console.log(response);
    // })
    // console.log('apres exp03()..');  
    // exp04();
    exp05();
}

main();


// util // promisify

// une promise est creée a base d'une executor, l'executor est une fonction qui prend deux arguments resolve et reject qui sont des fonctions

//la fonction de resolution admet un seul argument qui est la valeur de la promesse, et si on est besoin de plusieurs valeurs, on peut les encapsuler dans un tableau ou un objet