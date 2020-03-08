<?php
    $con = mysql_connect('localhost','root') or die('No se pudo conectar al Servidor MySQL');
	mysql_select_db('daniel',$con) or die('No existe la base de datos sistema');
	$x = $_REQUEST['login'];
	$y = $_REQUEST['nombre'];
	$z = $_REQUEST['password'];
    mysql_query("update usuarios set nombre='$y', password='$z' where login='$x'") or die('No se pudo acceder a la tabla');
	header('location:modificar_usuarios.php');
?>