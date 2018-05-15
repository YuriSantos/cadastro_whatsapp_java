<%--
  Created by IntelliJ IDEA.
  User: yuris
  Date: 10/02/2018
  Time: 15:34
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<c:import url="${request.contextPath}/top-menu"/>
<c:import url="${request.contextPath}/left-menu"/>


<div class="row">
    <div class="col-xs-12">
        <div class="box box-primary">


            <table id="tabela" class="table table-striped">
                <thead>
                <tr>
                    <th>Nome</th>
                    <th>Tipo</th>
                    <th>Local</th>
                    <th></th>
                    <th></th>
                    <th></th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${cadastro}" var="cadastro">
                    <tr>
                        <td>${cadastro.nome}</td>
                        <td>${cadastro.parte.nome}</td>
                        <td>${cadastro.local}</td>
                        <td class="col-xs-1"><a href="mostrar/${cadastro.id}" class="fa fa-2x fa-eye"></a></td>

                        <td class="col-xs-1">
                            <c:if test="${usuario.administrador}"><a href="atualizar/${cadastro.id}" class="fa fa-2x fa-edit"></a></c:if>

                        </td>
                        <td class="col-xs-1">
                            <c:if test="${usuario.administrador}"> <a href="deletar/${cadastro.id}" onclick="return confirm('Deseja excluir o registro?')"class="fa fa-2x fa-trash"></a></c:if>

                        </td>
                    </tr>
                </c:forEach>

                </tbody>


            </table>

        </div>
    </div>
</div>
</section>
</div>

<c:import url="${request.contextPath}/rodape"/>

<script type="text/javascript" charset="utf8" src="//cdn.datatables.net/1.10.16/js/jquery.dataTables.js"></script>
<script type="text/javascript" charset="utf8" src="//cdn.datatables.net/plug-ins/1.10.16/i18n/Portuguese-Brasil.json"></script>


<script type="text/javascript">
    $(document).ready(function() {
        $('#tabela').DataTable({
            "bJQueryUI": true,
            "oLanguage": {
                "sEmptyTable": "Nenhum registro encontrado",
                "sInfo": "Mostrando de _START_ até _END_ de _TOTAL_ registros",
                "sInfoEmpty": "Mostrando 0 até 0 de 0 registros",
                "sInfoFiltered": "(Filtrados de _MAX_ registros)",
                "sInfoPostFix": "",
                "sInfoThousands": ".",
                "sLengthMenu": "_MENU_ resultados por página",
                "sLoadingRecords": "Carregando...",
                "sProcessing": "Processando...",
                "sZeroRecords": "Nenhum registro encontrado",
                "sSearch": "Pesquisar",
                "oPaginate": {
                    "sNext": "Próximo",
                    "sPrevious": "Anterior",
                    "sFirst": "Primeiro",
                    "sLast": "Último"
                },
                "oAria": {
                    "sSortAscending": ": Ordenar colunas de forma ascendente",
                    "sSortDescending": ": Ordenar colunas de forma descendente"
                }
            }
        });
    });
</script>





