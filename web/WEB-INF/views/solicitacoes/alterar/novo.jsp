<%--
  Created by IntelliJ IDEA.
  User: estagio.yuris
  Date: 07/03/2018
  Time: 09:16
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
                    <form:form action="${pageContext.request.contextPath}/solicitacoes/salvar" method="POST" modelAttribute="solicitacoes">
                    <input type="hidden" name="id" value="${solicitacoes.id}"/>
                    <input type="hidden" name="salvo_por" value="${usuario.nome}"/>
                        <input type="hidden" name="Tipo_Solicitacao" value="2"/>
                        <div class="form-group">
                            <label>Cadastro</label>
                            <form:select path="cadastro.id" items="${cadastro}" class="form-control" size="1">
                                <option>Selecione o cadastro para solicitação</option>
                            </form:select>
                        </div>
                        <div class="form-group">
                            <label>Informações a serem alteradas</label>
                            <form:textarea path="observacoes" class="form-control" rows="5"/>
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
