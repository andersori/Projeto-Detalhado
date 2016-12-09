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
         <!--Acessando o BootStrap para fazer o menu -->    
        <!-- jQuery library -->
            <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
        <!-- Latest compiled JavaScript -->
            <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <!-- Latest compiled and minified CSS -->
            <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
            <link rel="stylesheet" type="text/css" href="style.css"/>
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container">
            <div class="container-fluid text-center">
                <div class="row"> <img alt="Logomarca do site PRADOC." src="img/PradocLogo.png" width="10%" height="15%"/>
             </div>  
            <div class="container-fluid">    
            <form action="login.do" method="POST">
                    <div class="form-group">
                        <label for="email">Nome de Usuário:</label>
                        <input alt="Insira o email" type="email" class="form-control" id="inputUsername" placeholder="Digite o seu username...">
                     </div>
                    <div class="form-group">
                    <label for="pwd">Senha:</label>
                    <input alt="Insira a senha" type="password" class="form-control" id="inputpassword" placeholder="Digite a sua senha...">
                    </div>
                    <div class="checkbox">
                        <label><input type="checkbox"> Remember me</label>
                    </div>
                    <button type="submit" class="btn btn-default">Submit</button>
                </form>
            </div>   
            </div>
            </div>
        </form>
        </div>
    </body>
</html>
