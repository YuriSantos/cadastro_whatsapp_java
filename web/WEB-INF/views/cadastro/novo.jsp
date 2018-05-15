<%--
  Created by IntelliJ IDEA.
  User: yuris
  Date: 10/02/2018
  Time: 16:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="spring" uri="http://java.sun.com/jsp/jstl/fmt" %>


<c:import url="${request.contextPath}/top-menu"/>
<c:import url="${request.contextPath}/left-menu"/>

<div class="row">

    <div class="col-xs-12">
        <!-- general form elements -->
        <div class="box box-primary">
            <div class="box-header with-border">
                <h3 class="box-title">Cadastro</h3>
            </div>

            <div class="box-body">
                <div class="form-group">
                    <form:form action="${pageContext.request.contextPath}/cadastro/salvar" method="POST" modelAttribute="cadastro">
                        <input type="hidden" name="id" value="${cadastro.id}"/>
                        <input type="hidden" name="salvo_por" value="${usuario.nome}"/>
                        <div class="form-group">
                            <label>Nome</label>
                            <form:input path="nome" class="form-control" required="required"/>
                        </div>

                        <div class="form-group">
                            <label>Tipo de Parte</label>
                            <form:select path="parte.id" items="${parte}" class="form-control" size="1">
                                <option>Selecione o Tipo da Parte</option>
                            </form:select>
                        </div>

                        <div class="form-group">
                            <label>CPF/CNPJ</label>
                            <form:input path="cpf" class="form-control"/>
                        </div>

                        <div class="form-group">
                            <label>Telefone</label>
                            <form:input path="telefone" class="form-control"/>
                        </div>

                        <div class="form-group">
                            <label>Local</label>
                            <form:input path="local" class="form-control"/>
                        </div>


                        <div class="box-footer">
                            <button type="submit" class="btn btn-primary">Salvar</button>
                            <a href="${pageContext.request.contextPath}/cadastro/listar" class="btn btn-primary">Cancelar</a>
                        </div>
                    </form:form>

                </div>
            </div>
            <!-- /.box -->

        </div>
    </div>

    </section>
</div>


<c:import url="${request.contextPath}/rodape"/>
