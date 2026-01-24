let result = (data) => {
    let table = '<table>' + data.map(e =>
        Object.values(e).reduce((c, ed) => c+=`<td>${ed}</td>`, '<tr>') + '</tr>'
    ).join('') + '</table>';
    document.getElementById('result').innerHTML = table;
}
