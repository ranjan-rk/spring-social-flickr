
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome Page</title>
</head>
<body>
	${welcomeMessage}
	${messages}
	<br>
	<h1>Testing Photo Template</h1>
	<hr>
	<h2>Add tags to photo</h2>
	<form action="addtags" method="POST">
		<label>Tags(comma separated) : </label><input type="text" name="tags"/>
		<label>Photo Id : </label><input type="text" name="photoid"/>
		<input type="submit" value="add tags"/>
	</form>
	
</body>
</html>