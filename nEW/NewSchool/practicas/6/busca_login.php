<?php
    $con = mysql_connect('localhost','root') or die('No se pudo conectar al Servidor MySQL');
	mysql_select_db('daniel',$con) or die('No existe la base de datos sistema');
	$x = $_REQUEST['login'];
    $res = mysql_query("select nombre, password from usuarios where login='$x'") or die('No se pudo acceder a la tabla');
	
	$nr = mysql_num_rows($res);
	if($nr == 0) {
		header('location:alta_login.php');
	} else {
		$fila=mysql_fetch_row($res);
		?>
        
        <!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Documento sin título</title>
</head>
<body>
<h1>Modificar Usuarios</h1>
<form action="graba_login.php" method="post">
<label>Login</label>
<input id="login" name="login" type="text" value="<?php echo $x; ?>" readonly="true"/>
<br />
<label>Nombre</label>
<input id="nombre" name="nombre" type="text" value="<?php echo $fila[0]; ?>"/>
<br />
<label>Password</label>
<input id="password" name="password" type="text" value="<?php echo $fila[1]; ?>"/>
<br />
<input name="buscar" type="submit" value="Grabar">
<input name="cancelar" type="button" value="Cancelar" />
</form>
</body>
</html>
        
        
        <?php
	}
	
?>
