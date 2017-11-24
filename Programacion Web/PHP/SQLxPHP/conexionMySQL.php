<?php
$conn="local";
if($conn=="local"){
        $mysqli = new MySQLi("localhost", "usuario","contraseña", "database");
        if ($mysqli -> connect_errno) {
            die( "Fallo la conexión a MySQL: (" . $mysqli -> mysqli_connect_errno()
                . ") " . $mysqli -> mysqli_connect_error());
        }
}else{//Esto se hizo para pasar de local a un hosting sin tener que eliminar nada de codigo
    $mysqli = new MySQLi("mysql.hostinger.mx", "nombrebase","contraseña", "database");
    if ($mysqli -> connect_errno) {
        die( "Fallo la conexión a MySQL: (" . $mysqli -> mysqli_connect_errno()
            . ") " . $mysqli -> mysqli_connect_error());
    }
}
?>
