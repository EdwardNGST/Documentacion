<?php
//Antes de realizar cualquier peticion poner lo siguiente
header('Content-Type: text/html; charset=utf-8');

require("../conexion/conexion.php");//Aqui se crea la cadena de conexion con un archivo externo, la variable de conexion es $mysqli

//Despues de crear la cadena de conexion especificarle que tambien debe de ser utf-8
if (!$mysqli->set_charset("utf8")) {
}
//Aun no se porque debe de ir dentro de una sentencia
//Despues de hacer lo anterior podemos seguir normalmente con nuestro codigo php
?>
