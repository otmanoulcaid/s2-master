import timer from './timer.js'
import io from './io.js'

export function exp01() {
    timer.pause(5000, ()=> {
        console.log('5s sont ecoulé');
    })
}

export function exp02() {
    timer.promises.pause(5000)
    .then(response => {
        console.log(`pause de ${response.time} fonction promise de second arg : ${response.message}`);
        return response.message   
    })
    .then(response => {
        console.log(`deuxieme then : ${response}`);
        return true;
    })
    .then(status => console.log(status))
}

export async function exp03() {
    try {
        let response = await timer.promises.pause(2000);
        console.log(`pause de ${response.time} fonction promise de second arg : ${response.message}`);    
        return true;
    } catch (error) {
        console.log('erreur dans la promesse : ', error);
        return false;
    }
}

// parametre de fonction de resolution

export function exp04() {
   io.readfile('data/test.txt', (data) => {
    console.log('----------donnée lues-------');
    console.log(data);
    console.log('----------fin de fichier-------');
   });
}

export function exp05() {
    io.promises.readfile('data/test.txt')
    .then(data => {
        console.log('----------donnée lues-------');
        console.log(data);
        console.log('----------fin de fichier-------');
    })
    .catch(err => {
        console.log('erreur dans la promesse : ', err);
    })
}

