import { sum, sumv2 } from './math.mjs'

// dans le cote client il est pas possible

function main()
{
    console.log('ES Module System');
    
    console.log(sum(10, 20, 30));
    console.log(sumv2(10, 20, 30));
}

main()
