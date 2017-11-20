<?php
$nombre_fichero = 'Images/books/'.$id.'.jpg';//Antes de todo tiene que haber obtenido el nombre de la imagen, en mi caso lmis imagenes tienen por nombre un id del libro
if (file_exists($nombre_fichero)) {//Revisa si este libro tiene imagen
    echo '<img src="Images/books/'.$id.'.jpg" class="img-responsive" style=" height:80%rem; width:80%" alt="Image">';
} else {//Si no tiene imagen le pondra una por default
    echo '<img src="Images/books/Sin_foto.png" class="img-responsive" style=" height:80%rem; width:80%" alt="Image">';
}
?>
