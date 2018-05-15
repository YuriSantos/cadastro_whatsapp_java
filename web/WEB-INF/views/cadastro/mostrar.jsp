<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: estagio.yuris
  Date: 14/03/2018
  Time: 10:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<c:import url="${request.contextPath}/top-menu"/>
<c:import url="${request.contextPath}/left-menu"/>

<div class="row">
    <div class="col-md-12">
        <div class="box box-primary">
            <div class="box-body">

                <ul class="list-group list-group-unbordered">
                    <li class="list-group-item">
                        <strong>Nome:</strong>
                        ${cadastro.nome}
                    </li>

                    <li class="list-group-item">
                        <strong>Tipo da Parte:</strong>
                        ${cadastro.parte.nome}

                    </li>

                    <li class="list-group-item">
                        <strong>CPF/CNPJ:</strong>
                        ${cadastro.cpf}

                    </li>

                    <li class="list-group-item">
                        <strong>Data do Cadastro:</strong>
                        ${cadastro.data_cadastro}

                    </li>

                    <li class="list-group-item">
                        <strong>Local:</strong>
                        ${cadastro.local}

                    </li>
                </ul>
            </div>
        </div>
    </div>
</div>

<c:import url="${request.contextPath}/rodape"/>