<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: estagio.yuris
  Date: 07/03/2018
  Time: 09:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>




    <div class="col-xs-12">
        <div class="box box-primary">


            <table id="tabela" class="table table-striped">
                <thead>
                <tr>
                    <th>Nome</th>
                    <th>Tipo de solicitação</th>
                    <th>Solicitado por:</th>
                    <th>Motivo da solicitação</th>
                    <th></th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${solicitacao}" var="solicitacao">
                    <tr>
                        <td>${solicitacao.cadastro.nome}</td>
                        <td>${solicitacao.TSocilicitacao}</td>
                        <td>${solicitacao.salvo_por}</td>
                        <td>${solicitacao.observacoes}</td>

                        <td class="col-xs-1">
                            <a href="${pageContext.request.contextPath}/solicitacoes/atualizar/${solicitacao.id}" class="fa fa-2x fa-edit"></a>

                        </td>
                        <td class="col-xs-1">
                            <a href="${pageContext.request.contextPath}/solicitacoes/deletar/${solicitacao.id}" onclick="return confirm('Deseja excluir o registro?')"class="fa fa-2x fa-trash"></a>

                        </td>
                    </tr>
                </c:forEach>

                </tbody>


            </table>

        </div>
    </div>
</div>




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



