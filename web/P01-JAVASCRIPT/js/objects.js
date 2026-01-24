const objects = {};

objects.exp01 = function()
{
    console.clear();

    let z = 40
    let p1 = {
        x : 20,
        y : 30,
        z, // c'est de ES-6 
        //redefinition de toString 
        toString : function(){
            return 'Point('  + this.x + ', ' + this.y + ', ' + this.z + ')';
        },
        //raccourci ES-6
        print(message){
            if (!message)
                message = 'Point';
            console.log(message + '(' + this.x + ', ' + this.y + ', ' + this.z + ')');
        }
    } // on pourra meme creer un objet vide et l'alimenter par la suite
    
    //tous les objet ayant pas de type specific, il prend Object par defaut
    
    console.log('p1 = ' + p1); //comme si on appel to string
    console.log('p1 = ', p1);
    printVar('p1', p1);
    p1.print();
    p1.print('p1');
}

//typeof pour tous les type , operateur unaire
//instanceof -> pour les objects , operateur binaire
//si on veut cacher les objets, privatiser les attribues, on peut, c'est possible


objects.exp03 = function ()
{
    let prop = 'id';
    let value = 100;
    console.clear();
    let p1 = {
        x : 20,
        y :30,
        ['max-y'] : 40,
        [prop] : value,
        // prop : value //ces deux derniers vont cree deux propriete diferent
    }
    p1.name = 'p1';

    console.log('p1.x : ' ,p1);
    console.log('p1.x : ' + p1.x);
    console.log('p1.y : ' + p1.y);
    
    
    console.log("p1['x'] : " + p1['x']);
    p1['max-x'] = 30; // util si je veux acceder a un propriete de style
    let keys = Object.keys(p1);
    console.log('keys : ', keys);

    prop = 'y';
    console.log('p1.' + prop + ' = ' + p1[prop]);
 
    for (let key in p1)
    {
        console.log( 'p1.' + key + ' = ' + p1[key]);
        
    }
}


objects.exp04 = function (){
    let t1 = [];
    let o1 = {};

    console.log('t1 : ' + typeof t1);
    console.log('o1 : ' + typeof o1);

    t1[0] = 20;
    o1[0] = 20;
    
    console.log('t1.length = ' + t1.length);
    console.log('o1.length = ' + o1.length);
    
    o1.length = 1;

    console.log('o1.length (apres affectation) = ' + o1.length);

    console.log('t1 keys : ' + Object.keys(t1));
    console.log('o1 keys : ' + Object.keys(o1));   
}

objects.exp05 = function ()
{
    console.clear();
    // spread operator
    let p1 = {x:20, y:30}

    p1 = {...p1, x:50, z:80}; // reconstruction de l'objet

    console.log('p1 : ' , p1);
    // Destructuring
    let {x, y:a} = p1; // le :a pour le renomer
    console.log('x = ' + x);
    console.log('a = ' + a);
}

objects.exp06 = function()
{
    let p1 = {
        x : 20,
        y : 30,
        toString(){
            return 'point(' + this.id + ',' + this.x + ',' + this.y + ')';
        } 
    };
    
    // prototype de object.prototype est null 
    Object.prototype.id = 100 //prototype pere de tout le monde tous les objets

    let p2 = Object.create(p1); // p2 a comme prototype p1, comme pere // heritage prtotypage
    //p1 pere de p2
    p2.x = 0;
    p2.name = 'p2';
    console.log('p1 : ' + p1);
    console.log('p2 : ' + p2);
    
    console.log('p1 : ' , p1);
    console.log('p2 : ' , p2);

    let pp2 = Object.getPrototypeOf(p2);

    console.log('pp2 : ', pp2);
    let ppp2 = Object.getPrototypeOf(pp2);

    console.log('ppp2 : ', ppp2);
    let pppp2 = Object.getPrototypeOf(ppp2);

    console.log('pppp2 : ', pppp2);
    
}

objects.exp07 = function() {
    function Point(x = 0, y = 0)
    {
        this.x = x;
        this.y = y;
    }
    
    Point .prototype.toString = function () {
        return 'Point(' + this.name + ', ' + this.x + ', ' + this.y + ')';
    }

    Point.max = 20;

    /**
     * meme qu'onn a this à l'exterieur de definition de type il sera 
     * remplacé lors de la creation de l'objet par l'objet courant
     */

    Point.prototype.name = 'un point'

    let p1 = new Point(1, 3); 
    /** <==> let p1 = Object.create(Point.prototype ) 
     * + appel Point() sur p1 this dans point correspond à p1 
     */

    /*les methods qui sont la meme fonctionnalite entre tous les object instance de Type
     * on doit les metre dans prototype dans Point.prototype 
     */
    console.log(Point);

    /**
     * l'attribue MAX est appartien au type et non par les objets
     */

    console.log('p1 = ' + p1);
    console.log('p1 = ', p1);

    // let x = f;
    // x.length //pour savoir le nombre de parametre
    // x.name //pour savoir le nom
    
    // let x = new f(1, 2) // constructor function // par convention function constructor doit etre sous forme pascale
};

objects.exp08 = function () {
    // conslole.clear()

    class Point {
        #name = 'Point'; // champ privé
        static MAX = 20; // champ static

        constructor (x = 0, y = 0)
        {
            this.x = x;
            this.y = y;
        }

        toString ()
        {
            return 'Point (' + this.x + ', ' +this.y + ')';
        }

        print () 
        {
            console.log('Point (' + this.x + ', ' +this.y + ')');
        }

        get name() {
            console.log('getter');
            return this.#name;
        }

        set name(value) {
            console.log('setter');
            this.#name = value;
        }
    }

    console.log(Point);

    let p1 = new Point(20, 30);

    p1.name = 'salam';
    console.log(p1.name);
    console.log(p1);

    class city extends Point 
    {
        //we must call the parent constructor in the derived class constructor
        constructor (name, x,  y)
        {
            super(x, y);
            this.name = name;
        }
        print()
        {
            console.log('City(' + this.name + ', ' + this.x + ', ' + this.y + ')');
        }
    }

    let c1 = new city('fes', 10, 29);
    console.log(c1);
}
