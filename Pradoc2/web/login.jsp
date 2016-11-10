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
        <form class="form-horizontal" method="POST">
            <div class="control-group">
                <label class="control-label" for="inputEmail">E-mail</label>
                <div class="controls">
                    <input id="inputEmail" type="text" placeholder="Digite o seu e-mail..." />
                </div>
            </div>
            <div class="control-group">
                <label class="control-label" for="inputPassword">Senha</label>
                <div class="controls">
                    <input id="inputPassword" type="password" placeholder="Digite a sua senha..." />
                </div>
            </div>
            <div class="control-group">
                <div class="controls">
                    <button class="btn" type="submit">Acessar</button>
                </div>
            </div>
        </form>
        </div>
    </body>
</html>
