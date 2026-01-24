// const arrays = new Object();
const arrays = {};

// les objet ressemble au tableau

function printArray(name, t)
{
    console.log(`${name} (${t.length})`);
    for (let i = 0; i < t.length ; i++)
    {
        console.log('- ' + i + ' - ' + t[i]);
    }
}

arrays.exp01 = function()
{
    let t1 = [];
    t1[0] = 20;
    t1[1] = 23;
    t1[2] = 22;
    t1[5] = 23;

    printArray('t1', t1);
    
    delete t1[1];
    
    printVar('t1', t1);

    printArray('t1', t1);

    console.log('t1 = ', t1);
    console.log('t1 = ' + t1);//toString    
}

arrays.exp02 = function()
{
    let t1 = new Array(10, 24, 15, 84, 12);
    t1.push(25);
    t1.push(29);
    printArray('t1', t1);
}

arrays.exp03 = function()
{
    let t1 = [10, 24];
    t1[4] = 30;
    t1[7] = 12;
    t1['clavier'] = 12;
    t1['ecran'] = 30;
    
    console.log('- avec for : ');
    printArray('t1', t1);
    
    console.log('- avec for in : ');
    for (const key in t1)
    {
        console.log(key + ' : ' + t1[key]);
        //les of recupere tous les elements dont les valeurs sont defined
    }

    console.log('- avec for in : ');
    for (const it of t1)
    {
        console.log(' - ' + it);
        //les of recupere tous les elements dont les clés sont number
        // ça marche sur des objet itterable
        //seul les tableau sont par defaut itterable
    }
    //recuperer les cles d'un tableau
    let keys = Object.keys(t1);
    console.log('keys : ' + keys);
}

arrays.exp04 =  function ()
{
    let author = [];
    author['id'] = '101';
    author['name'] = 'breeindan Eich' 
    author['yearBorn'] = 1961
    let div = document.getElementById('author')
    if (div)
        printInHtmlTable(author, 'author');
    else
        console.log("nothing");
        
}

function printInHtmlTable(data, id)
{
    let content = `<table class="data-table"><tr><th>key</th><th>value</th></tr>`
    let keys = Object.keys(data);
    for (let $key of keys)
    {
        content += `<tr><td>${key}</td><td>${data[key]}</td></tr>`
    }
    content += '</table>'
    document.getElementById('author').innerHTML(content)
}

arrays.exp05 = function (){
    console.clear();
    //possibilite ES-6 : spread operator (operatuer d'etalement ou decomposition)
    let t1 = [20, 45, 17];
    //cas n1 : insertion en tete : 
    t1 = [30, ...t1]; //extraction des element de t1 avec ...t1
    console.log('t1', t1);
    //cas n2 : insertion à la fin: 
    t1 = [...t1, 30]; //extraction des element de t1 avec ...t1
    console.log('t1', t1);
    //cas n3 : funsion de tableau: 
    let t2 = [23, 24, 26]
    let t3 = [...t1, ...t2]
    t1 = [...t1, 30]; //extraction des element de t1 avec ...t1
    console.log('t3', t3);
    //cas n4 : copie d'un  
    let t4 = [...t2];
    t4.push(5)
    console.log('t4', t4);
    console.log('t2', t2);
}

arrays.exp06 = function (){
    console.clear();
    // ES-6 : Object Destructring (Decomposition, Destruction, destructuration)
    let t1 = [20,30,40,50]
    let [x1 , x2, , x4] = t1;
    console.log('x1 =', x1);
    console.log('x2 =', x2);
    console.log('x4 =', x4);
}