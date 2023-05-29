<!DOCTYPE html>
<html lang="en">
    <head>
    <link rel="stylesheet" type="text/css" href="webjars/bootstrap/5.2.0/css/bootstrap.min.css"/>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Product Creation</title>
    </head>
    <body>
        <header>
            <h1>Product Creation</h1>
        </header>
        <main>
            <form action="saveProduct" method="post">
                <div>
                    <label for="nameProduct">Product Name : </label>
                    <input type="text" id="nameProduct" name="nameProduct">
                </div>
                <div>
                    <label for="priceProduct">Price : </label>
                    <input type="text" id="priceProduct" name="priceProduct">
                </div>
                <div>
                    <label for="dateCreate">Creation Date : </label>
            	     <input type="date" id="dateCreate" name="dateJsp" value="${now}">
                </div>
                <div>
                                                    <label for="fat">Fat : </label>
                                                    <input type="text" id="fat" name="fat">
                                                </div>
                                                <div>
                                      <label for="calories">calories : </label>
                                      <input type="text" id="calories" name="calories">

                                     </div>
                            <div>
                        <label for="protein">Protein : </label>
                         <input type="text" id="protein" name="protein">
                 </div>
                 <div>
                         <label for="description">Description : </label>
                          <input type="text" id="description" name="description">
                  </div>
                <div>
                    <input type="submit" value="Save">
                </div>
            </form>
            ${messageJsp}
        </main>
        <footer>
            <a href="productsList">Products List</a>
        </footer>
    </body>
</html>

