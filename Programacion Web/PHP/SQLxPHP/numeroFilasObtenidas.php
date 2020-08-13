<?php
//Metodo 1
$id=1;
$total = mysqli_num_rows(mysqli_query($mysqli,"SELECT * FROM booksbibliotecaitcg WHERE codLibros=$id;"));
if($total==0){
    echo "No se encontro ningun libro con el id ".$id;
}
//Metodo 2
$getCant=mysqli_query($mysqli,"SELECT COUNT(noEjemplar) AS disponibilidad FROM copybibliotecaitcg WHERE codLibros=$id;");
if($f3=mysqli_fetch_assoc($getCant)){
    $cant=$f3['disponibilidad'];
    echo
    '
        <h4><b>Ejemplares Disponibles*:</b></h4>
        <p>'.$cant.' Libros disponibles</p>
    ';
}
?>
