<?php

echo 'Conexión al Servidor MySQL';
$con = mysql_connect('localhost', 'root') or die('No se pudo conectar al Servidor MySQL');
echo 'Conexión a la base de datos';
mysql_select_db('sistema', $con) or die('No existe la base de datos sistema');

$qcodigo = $_REQUEST['vcodigo'];
$qab = $_REQUEST['vab'];
$qdes = $_REQUEST['vdes'];

$res = mysql_query("insert into deptos values('$qcodigo','$qab','$qdes')") or die('No se pudo insertar el registro');
mysql_close($con);
?>








