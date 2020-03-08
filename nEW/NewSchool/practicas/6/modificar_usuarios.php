<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Documento sin título</title>
</head>
<body>
<h1>Modificar Usuarios</h1>
<form action="busca_login.php" method="post">
<label>Login</label>
<input id="login" name="login" type="text" />
<br />
<label>Nombre</label>
<input id="nombre" name="nombre" type="text" readonly="true"/>
<br />
<label>Password</label>
<input id="password" name="password" type="text" readonly="true"/>
<br />
<input name="buscar" type="submit" value="Buscar">
<input name="cancelar" type="button" value="Cancelar" />
</form>
</body>
</html>