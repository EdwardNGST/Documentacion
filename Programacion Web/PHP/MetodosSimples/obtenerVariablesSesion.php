<?php
session_start();
if(isset($_SESSION['id'])){
	echo "El id tiene un dato";
}else{
	echo "El id no tiene datos";
}
?>