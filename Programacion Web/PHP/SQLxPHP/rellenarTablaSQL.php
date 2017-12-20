<!DOCTYPE html>
<html>
<head>
	<title>Rellenar tabla mediante SQL</title>
</head>
<body>
	<?php 
	include('connection.php');
	$total = mysqli_num_rows(mysqli_query($mysqli,"SELECT * FROM tabla;"));
	if($total==0){
    	echo "No hay nada en la tabla";
    }
	?>
	<table class="table">
	    <thead>
		    <tr>
			    <th>ID</th>
			    <th>Nombre Completo</th>
			    <th>Dirección</th>
			    <th>Area</th>
			    <th>Puesto</th>
			    <th>Administración</th>
			    <th>Usuarios</th>
			    <th>Servicios</th>
			    <th>Ejemplares y Libros</th>
		    </tr>
	    </thead>
	    <tbody>
		    <?php
		    include("../../model/Connection/Connection.php");
		    $query=mysqli_query($mysqli,"SELECT * FROM adminbibliotecaitcg;");
		    while ($f=mysqli_fetch_array($query)){
			    if($f["estado"]=="Activo"){
			    	echo '<tr class="success">';
			    }else{
			    	echo '<tr class="danger">';
			    }
			    if($f["addAdmin"]==1){
				    $administration="SI";
				    $administration="NO";
			    }else{

			    }
			    if($f["addUsuario"]==1){
			    	$userChange="SI";
			    }else{
			    	$userChange="NO";
			    }
			    if($f["Servicios"]==1){
			    	$serviceChange="SI";
			    }else{
			    	$serviceChange="NO";
			    }
			    if($f["addEjemplar"]==1){
			    	$booksChange="SI";
			    }else{
			    	$booksChange="NO";
			    }
			    ?>
			    <td><?php echo $f["idAdmin"];?></td>
			    <td><?php echo $f["nombre"]." ".$f["apellidos"];?></td>
			    <td><?php echo $f["direccion"];?></td>
			    <td><?php echo $f["areaAdmin"];?></td>
			    <td><?php echo $f["puesto"];?></td>
			    <td><?php echo $administration?></td>
			    <td><?php echo $userChange?></td>
			    <td><?php echo $serviceChange?></td>
			    <td><?php echo $booksChange?></td>
			    <?php
			    echo '</tr>';
		    }
		    	?>
	    </tbody>
    </table>
</body>
</html>