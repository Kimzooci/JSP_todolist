
<tiles:insertDefinition name="defaultTemplate">
  <tiles:putAttribute name="body">

    <div class="container">

      <div class="card">
        <div class="card-body">
          <h5 class="card-title">${title}</h5>
          <div class="col-md-12">
            <c:forEach items="${todos}" var="todo">
              <div class="card">
                <div class="card-body">
                  <h5 class="card-title">
                    <fmt:parseDate value="${todo.targetDate}" pattern="yyyy-MM-dd" var="parseTargetDate" type="date" />
                    <fmt:formatDate value="${parseTargetDate}" pattern="yyyy-MM-dd" />
                  </h5>
                  <h6 class="card-subtitle mb-2 text-muted">
                    <c:choose>
                      <c:when test="${todo.done}">completed</c:when>
                      <c:otherwise>pending...</c:otherwise>
                    </c:choose>
                  </h6>
                  <p class="card-text">${todo.description}</p>
                </div>
              </div>
              <p>
            </c:forEach>
          </div>
        </div>
      </div>
      <p>

    </div>

  </tiles:putAttribute>
</tiles:insertDefinition>
