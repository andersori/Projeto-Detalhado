<%-- 
    Document   : login
    Created on : 10/11/2016, 11:59:54
    Author     : Anderson
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <link rel="stylesheet" type="text/css" href="style.css"/>
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container">
        <img src="img/PradocLogo.png" width="10%" height="15%"/>
        <form action="login.do" method="POST">
            <label id="userlabel" class="control-label" for="inputEmail">Username</label>
            <div class="controls">
                <input id="inputUsername" type="text" placeholder="Digite o seu username..." />
            </div>
            <label class="control-label" for="inputPassword">Senha</label>
            <div class="controls">
                <input id="inputPassword" type="password" placeholder="Digite a sua senha..." />
            </div>
            <div class="controls">
                <button class="btn" type="submit">Acessar</button>
            </div>
        </form>
        </div>
    </body>
</html>
