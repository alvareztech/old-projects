<?php

echo 'Conexión al Servidor MySQL';
$con = mysql_connect('localhost', 'root') or die('No se pudo conectar al Servidor MySQL');
echo 'Conexión a la base de datos';
mysql_select_db('sistema', $con) or die('No existe la base de datos sistema');


$qcod = $_REQUEST['cod'];
$res = mysql_query("delete from deptos where codigo='$qcod'") or die('No se pudo acceder a la tabla deptos');

mysql_close($con);
?>