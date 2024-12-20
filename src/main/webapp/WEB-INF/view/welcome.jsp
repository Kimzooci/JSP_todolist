

<tiles:insertDefinition name="defaultTemplate">
  <tiles:putAttribute name="body">

    <div class="container">

      <%--<h1 class="mt-4">KYUNGSEO.PoC</h1>--%>
      <div class="card">
        <div class="card-body">
          <h5 class="card-title">[KYUNGSEO.PoC] Todo Application</h5>
          <h6 class="card-subtitle mb-2 text-muted">Spring Boot and JSP Sample Project</h6>
          <p class="card-text">스프링 부트와 JSP로 구현하는 Todo 애플리케이션 샘플입니다.</p>
          <ul class="list-group list-group-flush">
            <li class="list-group-item">@version v0.1.0</li>
            <li class="list-group-item">@link https://github.com/kyungseo/spring-boot-todo-jsp</li>
            <li class="list-group-item">Copyright (c) 2023 박경서 (Kyungseo.Park@gmail.com)</li>
            <li class="list-group-item">License Apache 2.0</li>
          </ul>
          <%--
          <a href="/todos" class="btn btn-primary">할일 관리</a>
          --%>
        </div>
      </div>

    </div>

  </tiles:putAttribute>
</tiles:insertDefinition>
