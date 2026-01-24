let { getAllAUthors } = require('./authors-service');
let { getAllDocuments } = require('./documents-service');

console.log('package services');

module.exports = {
    getAllAUthors,
    getAllDocuments
}

