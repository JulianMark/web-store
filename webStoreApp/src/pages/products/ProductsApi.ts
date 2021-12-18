import Product from "./Product";

export function searchProducts(){

    if (!localStorage['products']){
        localStorage['products'] = '[]';
    }

    let products = localStorage['products'];
    products = JSON.parse(products);
    
    return products;
}

export function removeProduct(id: string){
    let products = searchProducts();
    console.log(products);
    let index = products.findIndex((product: Product) => product.id === id);
    console.log(index);
    products.splice(index, 1);
    localStorage['products'] = JSON.stringify(products);
}

export function saveProduct(product: Product){
    console.log(product)
    let products = searchProducts();
    if(product.id){
        let index = products.findIndex((p: Product) => p.id === product.id);
        products[index] = product;
    }
    else {
        product.id = String(Math.round(Math.random() * 10000));
        product.createAt = new Date().toISOString();
        products.push(product);
    }
    localStorage['products'] = JSON.stringify(products);
}

export function searchProductById(id: string){
    let products = searchProducts();
    return products.find((product: Product) => product.id === id);
}