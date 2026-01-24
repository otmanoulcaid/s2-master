const baseUrl= 'biblio/api/';


//solution Num 2:
function getAllAuthors(){
	let url= baseUrl + 'authors';
	
	fetch(url)
	.then(data => data.json())
	.then(authors =>printAuthors(authors, 'result'))
	.catch(err => printError(err, "result"));
	

}