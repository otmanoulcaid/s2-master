import express from 'express';
import { getAllSingers } from './services/singer.service.js';
import cors from 'cors';

export default class Server {
    constructor(port) {
        this.port = port || 3000;
        this.app = express();
        this.config();
        this.routes();
    }

    config () {
        this.app.use(express.static('public')); // preciser le chemin des ressources statiques
        this.app.use(express.json()); // pour parser le corps des requetes JSON est envoyer le corps sous format JSON
        this.app.use(cors()); // pour activer CORS
    }

    routes () {
        this.app.get('/api/singers', (req, res) => {
            getAllSingers()
                .then(singers => {
                    res.json(singers);
                })
                .catch(err => {
                    console.error(err);
                    res.status(500).send('Internal Server Error');
                });
        });
    }

    start (callback) {
        if (callback == undefined)
            callback = () => console.log(`Server is running on http://localhost:${this.port}`);
        this.app.listen(this.port, callback);
    }
}