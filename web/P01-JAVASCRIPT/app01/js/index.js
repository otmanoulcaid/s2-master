const path = 'photos/authors/';

function main()
{
    let content = `
        <h1>liste des auteurs</h1>
        <div class="authors-list">
    `;

    // for (let a of authors)
    // {
    //     content += `
    //         <div class="">
    //             <img src="${path}${a.photo}" alt="" />
    //             <div>${a.name}</div>
    //             <div><span>${a.yearBorn}</span>, <span>${a.coubtry}</span></div>
    //             <div><span>oeuvre principale : <span>${a.technology}</span></span></div>
    //         </div>
    //     `
    // }

    content += authors.map(a =>
        `
            <div >
                <img src="${path}${a.photo}" alt="" />
                <div>${a.name}</div>
                <div><span>${a.yearBorn}</span>, <span>${a.country}</span></div>
                <div><span>oeuvre principale</span> : <span>${a.technology}</span></div>
            </div>
        `
    )
    .reduce((prev, next)=>prev + next, '');

    content+= `</div>`;
    document.getElementById('root').innerHTML= content;
}