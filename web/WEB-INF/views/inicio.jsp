<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: yuris
  Date: 10/02/2018
  Time: 18:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

    <c:import url="${request.contextPath}/top-menu"/>
    <c:import url="${request.contextPath}/left-menu"/>

<div class="row">
    <div>
        <nav class="navbar" style="background-color: #696969">
            <center><h1><font color=#FFFFFF>Painel de Solicitações</font></h1></center>
        </nav>
    </div><br><br>

    <div class="col-xs-12">
        <c:import url="${request.contextPath}/solicitacoes/listar"/>
    </div>






</div>
</section>
    <c:import url="${request.contextPath}/rodape"/>

