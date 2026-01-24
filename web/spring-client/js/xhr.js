//Moteur ajax : Asynchronous javascript And XML

const getAllProductsXhr = () =>
{
    let xhr = new XMLHttpRequest();
    xhr.open('GET', 'http://localhost/api/client', true); 
    xhr.onreadystatechange = () => { //cette calback se rappele plusieur fois
        if (xhr.readyState == xhr.DONE) 
        {
            if (xhr.status == 200)
            {
                let response = xhr.responseText;
                let products = JSON.parse(response);
                result(products);
            }
            else
            {/*handle the error*/}
        }
    }
    xhr.send();
}
