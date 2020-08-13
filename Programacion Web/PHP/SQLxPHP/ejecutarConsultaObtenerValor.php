<?php
$getBook=mysqli_query($mysqli,"SELECT * FROM booksbibliotecaitcg WHERE codLibros=$id;");//Ya tiene que estar declarada la variable $mysqli
if($f2=mysqli_fetch_assoc($getBook)){
    //Se guardaran los resultados en variables
    $title=$f2['titulo'];
    $autor=$f2['autor'];
    $year=$f2['año'];
}
?>
