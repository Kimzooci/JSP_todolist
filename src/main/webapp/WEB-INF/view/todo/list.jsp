

<tiles:insertDefinition name="defaultTemplate">
  <tiles:putAttribute name="body">

    <div class="container">

      <div class="card">
        <div class="card-body">
          <h5 class="card-title"><spring:message code="todo.page.list.title" /></h5>
          <div class="col-md-12">
            <table class="table table-hover">
              <thead>
                <tr>
                  <th width="45%" class="text-center"><spring:message code="todo.description.label" /></th>
                  <th width="15%" class="text-center"><spring:message code="todo.targetdate.label" /></th>
                  <th width="15%" class="text-center"><spring:message code="todo.isdone.label" /></th>
                  <th width="25%" class="text-center"><spring:message code="todo.action.label" /></th>
                </tr>
              </thead>
              <tbody>
                <c:forEach items="${todos}" var="todo">
                  <tr>
                    <td>
                      <a href="/todos/${todo.id}">${todo.description}</a>
                    </td>
                    <td class="text-center">
                      <fmt:parseDate value="${todo.targetDate}" pattern="yyyy-MM-dd" var="parseTargetDate" type="date" />
                      <fmt:formatDate value="${parseTargetDate}" pattern="yyyy-MM-dd" />
                    </td>
                    <td class="text-center">
                      <c:choose>
                        <c:when test="${todo.done}">completed</c:when>
                        <c:otherwise>pending...</c:otherwise>
                      </c:choose>
                    </td>
                    <td class="text-center">
                      <a type="button" id="btnDone" class="btn btn-success" href="/todos/${todo.id}/done">
                        <spring:message code="todo.action.button.change" />
                      </a>
                      <a type="button" id="btnDelete" class="btn btn-danger" href="/todos/${todo.id}/delete">
                        <spring:message code="todo.action.button.delete" />
                      </a>
                    </td>
                  </tr>
                </c:forEach>
              </tbody>
            </table>
            <a type="button" class="btn btn-primary btn-md" href="/todos/new">
              <spring:message code="todo.action.button.add" />
            </a>
          </div>
        </div>
      </div>

    </div>

  </tiles:putAttribute>
</tiles:insertDefinition>
