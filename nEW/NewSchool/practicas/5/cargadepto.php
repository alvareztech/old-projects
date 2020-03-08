<?php

echo 'Conexión al Servidor MySQL';
$con = mysql_connect('localhost', 'root') or die('No se pudo conectar al Servidor MySQL');
echo 'Conexió a la base de datos';
mysql_select_db('sistema', $con) or die('No existe la base de datos sistema');
$res = mysql_query('insert into deptos values("C","CALAMA")') or die('No se pudo insertar el registro');
mysql_close($con);
?>








