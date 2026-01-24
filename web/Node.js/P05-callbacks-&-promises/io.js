import fs from 'fs';

const io = {
    readfile(source, callback) {
        fs.readFile(source, 'utf-8', (err, data) => {
            if (err)
                    console.log('error : ', err);
            else
                callback(data);
        })         
    },
    promises: {
        readfile(source) {
            return new Promise((resolve, reject) => {
                fs.readFile(source, 'utf-8', (err, data) => {
                    if (err) {
                        reject(err);
                    } else {
                        resolve(data);
                    }
                })
            })
        }
    }
}

export default io;
