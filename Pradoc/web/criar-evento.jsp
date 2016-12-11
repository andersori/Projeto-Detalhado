<%-- 
    Document   : criar-evento
    Created on : 10/11/2016, 17:38:42
    Author     : Anderson
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
     <title>PraDoc-Crie Seu Evento</title>
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
                     <form action="criar-evento.do" method="post" enctype="multipart/form-data">
                     <div class="form-group">
                         <label for="nome">Nome:</label>
                         <input type="text" id="nome" class="form-actions">
                     </div>
                     <div class="form-group">
                         <label for="descricao">Descrição:</label>
                         <input type="text" id="descricao" class="form-actions">
                     </div>
                     <div class="form-group">
                         <label for="instituicao">Instituição:</label>
                         <input type="text" id="instituicao" class="form-actions">
                     </div>
                     <div class="form-group">
                         <label for="nota">Nota de Aprovação:</label>
                         <input type="number" id="nota" class="form-actions">
                     </div>
                     <div class="form-group">
                         <label for="inicioSubimicao">Periodo de Inicio de Submissão:</label>
                         <input type="datetime" id="inicioSubimicao" class="form-actions">
                     </div>
                     <div class="form-group">
                         <label for="fimSubmicao">Periodo de Fim de Submissão:</label>
                         <input type="datetime" id="fimSubmicao" class="form-actions">
                     </div>
                     <div class="form-group">
                         <label for="inicioAvaliacao">Periodo de Inicio das Avaliações:</label>
                         <input type="datetime" id="inicioAvaliacao" class="form-actions">
                     </div>
                     <div class="form-group">
                         <label for="fimAvaliacao">Periodo de Fim das Avaliações:</label>
                         <input type="datetime" id="fimAvaliacao" class="form-actions">
                     </div>    
                     <div class="form-group">
                         <label for="inicioRecurso">Periodo de Inicio dos Recursos:</label>
                         <input type="datetime" id="inicioRecurso" class="form-actions">
                     </div>
                     <div class="form-group">
                         <label for="fimRecurso">Periodo de Fim dos Recursos:</label>
                         <input type="datetime" id="fimRecurso" class="form-actions">
                     </div>     
                     <div class="form-group">
                         <label for="avaliadores">Avaliadores(somente o email):</label>
                         <input type="text" id="avaliadores" class="form-actions">
                     </div>
                     <div class="form-group">
                         <label for="">Avaliadores(somente o email):</label>
                         <input type="text" id="avaliadores" class="form-actions">
                     </div>
                     <div class="form-group">
                         <label for="modeloDocumento">Modelo do Documento:</label>
                         <input type="file" id="modeloDocumento" class="form-actions">
                     </div>    
                     </form>    
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
