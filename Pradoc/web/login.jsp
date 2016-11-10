<%-- 
    Document   : login
    Created on : 10/11/2016, 11:09:00
    Author     : Anderson
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pradoc - Login</title>
    </head>
    <body>
        <div class="container">
            <form method="POST">
                <div class="form_input">
                    <label>Username do Usuário</label><br>
                    <input type="text" name="username" placeholder="username">
                </div>
                <div class="form_input">
                    <label>Senha do Usuário</label><br>
                    <input type="password" name="senha" placeholder="senha">
                </div>
                <input type="submit" name="submit" value="LOGIN">
            </form>
        </div>
    </body>
</html>
