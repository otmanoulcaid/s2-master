const getAllProducts = () => {
    fetch(baseUrl).then(data => data.json())
                .then(data =>result(data))
                .catch(e => console.log(e))
}

const addProduct = () => {
        const httpOption = {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            id: 106,
            name: 'PC',
            price: 10,
            quantity: 100
        })
    };
    fetch(baseUrl, httpOption)
        .then(data  => data.json())
        .then(response => result([response]))
        .catch(e => console.log(e))
} 

const getProduct = () => {
    
    let id = document.getElementById('p_id1').value
    fetch(`${baseUrl}/${id}`)
        .then(data  => data.json())
        .then(response => result([response]))
        .catch(e => console.log(e))
} 

const deleteProduct = () => {
    
    let id = document.getElementById('p_id2').value
    fetch(`${baseUrl}/delete/${id}`)
        .then(data  => {
            return "ok"
        })
        .then(response => result([response]))
        .catch(e => console.log(e))
}
