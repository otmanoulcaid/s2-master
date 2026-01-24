const prompt = '# Node.js > ';

function exp01()
{
    console.log('export : ' , exports);
    console.log('---------------------------------------');
    
    console.log('require : ' , require);
    console.log('---------------------------------------');

    console.log('__filename : ' , __filename);
    console.log('---------------------------------------');

    console.log('__direname : ' , __dirname);
}

function print( data )
{
    console.log(prompt + data);
}

// module.exports = exp01;
module.exports = { exp01, print };  // par defaut la cle de l'object exporter est exp01