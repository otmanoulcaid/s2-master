function printAuthors(authors, id){
	let content=`
		<table class='data-table'>
		<tr><th>Id</th><th>Nom</th><th>Annee</th></tr>
	`
	for(let a of authors){
		content += `
			<tr><td>${a.id}</td><td>${a.name}</td><td>${a.yearBorn}</td></tr>
		`
	}
	content+=`</table>`;
	document.getElementById(id).innerHTML=content;
}

function printError(err, id){
	document.getElementById(id).innerHTML=err.message;
}