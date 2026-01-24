/**
 * 
 */

function printAuthors(authors, id) {
	let content = `
	<table class="data-table">
		<tr><th>id</th><th>nom</th><th>année</th></tr>`;

	for (let a of authors) {
		content += `
			<tr><td>${a.id}</td><td>${a.name}</td><td>${a.yearBorn}</td></tr>`
	}
	content += `</table>`;
	document.getElementById(id).innerHTML = content;

}

function printErr(err, id) {
	document.getElementById(id).innerHTML = err.message;
}