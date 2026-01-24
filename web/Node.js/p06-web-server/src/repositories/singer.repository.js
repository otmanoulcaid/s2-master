import fs from 'fs';

const source = 'src/data/singers.json';

export function selectAll() {
    return new new Promise((resolve, reject) => {
        fs.readFile(source, 'utf8', (err, data) => {
            if (err)
                reject(err);
            else
                resolve(data);
        });
    }) 
}