<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
</head>
<body>

	Apresentacao:
	<form action="apresentacao" method="POST">
		Nome: <input type="text" name="nome"> Sobrenome: <input
			type="text" name="sobrenome"> <input type="submit"
			value="Enviar">
	</form>


	Cookie:
	<form action="login" method="POST">
		Usuario: <input type="text" name="usuario"> Senha: <input
			type="text" name="senha"> <input type="submit"
			value="Enviar">
	</form>
	
	Session:
	<form action="loginSession" method="POST">
		Usuario: <input type="text" name="usuario"> Senha: <input
			type="text" name="senha"> <input type="submit"
			value="Enviar">
	</form>

</body>
</html>