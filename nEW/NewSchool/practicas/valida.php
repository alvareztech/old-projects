<?php

$conexion = mysql_connect('localhost', 'root') or die('No se pudo conectar al Servidor MySQL');
mysql_select_db('usuarios', $conexion) or die('No existe la base de datos sistema');
$usuario = $_REQUEST['vlogin'];
$pwd = $_REQUEST['vpasword'];
$res = mysql_query("select count(*) from usuaios where login='$usuario' AND pwd='$pwd' ") or die('No se pudo acceder a la tabla');
$fila = mysql_fetch_row($res);
//echo $fila[0];
if ($fila[0] == 1) {
    session_start();
    $_SESSION['y'] = 'si';
    header('location:principal.php');
} else {
    header('location:inicio.php');
}
?>