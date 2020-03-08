<?php

echo 'Conexión al Servidor MySQL';
$con = mysql_connect('localhost', 'root') or die('No se pudo conectar al Servidor MySQL');
echo 'Conexión a la base de datos';
mysql_select_db('sistema', $con) or die('No existe la base de datos sistema');
$res = mysql_query('select * from deptos') or die('No se pudo acceder a la tabla deptos');

echo "<table border=1>";
while ($fila = mysql_fetch_row($res))
    echo "<tr>" . "<td>" . $fila[0] . "<td>" . $fila[1] . "<td>" . $fila[2] . "<td>" . "<a href=borrar.php?cod=$fila[0]>borrar";
echo "</table>";
mysql_close($con);
?>

