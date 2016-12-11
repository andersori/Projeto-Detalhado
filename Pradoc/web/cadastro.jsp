<%-- 
    Document   : cadastro
    Created on : 10/11/2016, 17:37:36
    Author     : Anderson
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
     <title>PraDoc-Cadastro</title>
     <meta charset="UTF-8">
     <meta name="viewport" content="width=device-width, initial-scale=1.0">
        
    <!--Acessando o BootStrap para fazer o menu -->    
    <!-- jQuery library -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <!-- Latest compiled JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    </head>

    
    <body>
        <div class="container">
            <!--Criando a parte de cima da tela-->
            <div class="container-fluid">
            <div class="row">
                <div class="col-sm-4"></div>
                <div class="col-sm-4">  <h1>Sistema PRADOC</h1>  </div>
                <div class="col-sm-4"/></div>
            </div>
            <div class="row">
                <nav class="navbar navbar-default">
                    <div class="container-fluid">
                        <div class="navbar-header">
                            <ul class="nav navbar-nav">
                                <li class="active"><a href="index.html">Home</a></li>
                                <li><a href="meus-eventos.jsp">Meus Eventos</a></li>
                                <li><a href="avaliacoes.jsp">Avaliações</a></li>
                                <li><a href="criar-evento.jsp">Crie seu Evento</a></li>
                                <li><a href="login.jsp">Fazer Login</a></li>                                
                            </ul>
                        </div>
                    </div>    
                </nav>    
            </div>    
            </div>    
            <!--Parte Main, o corpo -->
             <div class="container-fluid">
                 <div class="col-sm-2"></div>
                 <div class="col-sm-8">
                     <div class="form-group">
                         <form action="cadastro.do" method="POST">
                             <div class="form-group">
                                <label for="nome">Nome:</label>
                                <input type="text" id="nome" class="form-control" autofocus>
                             </div> 
                             <div class="form-group">
                                 <label for="telefone">Telefone:</label>
                                 <input type="tel" id="telefone" class="form-control">
                             </div>
                             <div class="form-group">
                                 <label for="email">Email:</label>
                                 <input type="email" id="email" class="form-control">
                             </div>
                             <div class="form-group">
                                 <label for="cpf">CPF:</label>
                                 <input type="text" id="cpf" class="form-control">
                             </div>
                             <div class="form-group">
                                 <label for="username">Username:</label>
                                 <input type="text" id="username" class="form-control"
                             </div>
                             <div class="form-group">
                                 <label for="senha">Senha:</label>
                                 <input type="password" id="senha" class="form-control">
                             </div>
                             <div class="form-group">
                                 <label for="instituicao">Instituição de Ensino:</label>
                                 <input type="text" id="instituicao" class="form-control">
                             </div>
                             <div class="form-group">
                                 <label for="especializacao">Especialização:</label>
                                 <input type="text" id="especializacao" class="form-control">
                             </div>
                         </form>
                        </div>
                     </div>
                </div>
                <div class="col-sm-2"></div>
            </div>
            <!--Rodapé da pagina-->
            <div class="container-fluid">
                 <footer class="container-fluid text-center">
                        <p>É o Texto de rodapé</p>
                 </footer>        
           
            </div>
            
        </div>
    </body>
</html>
