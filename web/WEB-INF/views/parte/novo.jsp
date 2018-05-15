<%--
  Created by IntelliJ IDEA.
  User: yuris
  Date: 10/02/2018
  Time: 19:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<c:import url="${request.contextPath}/top-menu"/>
<c:import url="${request.contextPath}/left-menu"/>

<div class="row">
    <div class="col-xs-12">
        <!-- general form elements -->
        <div class="box box-primary">
            <div class="box-header with-border">
                <h3 class="box-title">Cadastro de conciliacao</h3>
            </div>

            <div class="box-body">
                <div class="form-group">
                    <form:form action="salvar" method="POST" modelAttribute="parte">
                    <input type="hidden" name="id" value="${parte.id}"/>
                        <input type="hidden" name="salvo_por" value="${usuario.nome}"/>
                    <div class="form-group">
                        <label>Nome</label>
                        <form:input path="nome" class="form-control"/>
                    </div>

                </div>
                <div class="box-footer">
                    <button type="submit" class="btn btn-primary">Salvar</button>
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