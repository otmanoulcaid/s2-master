/**
 * 
 */

const baseUrl = "biblio/api/";

// Solution N2 : 
function getAllAuthors() {
	let url = baseUrl + "authors";

	// par défaut méthode get
	fetch(url)
		.then(data => data.json())
		.then(authors => printAuthors(authors, 'result'))
		.catch(err => printErr(err, 'result'));
}