<%@    taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<nav class="custom-navbar">
  <div class="container-fluid">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="#">
        <i style="color:black;" class="fa fa-empire fa-lg fa-fw" aria-hidden="true"></i>
      </a>
    </div>

      <ul class="nav navbar-nav navbar-right">
        <li>
            <a style="text-decoration: none; color: black;" href="${pageContext.request.contextPath}/loginPage">
              <i class="fa fa-sign-in" aria-hidden="true"></i>
              <spring:message code="label.loginPage"/>
            </a>
        </li>
        <li>
          <a style="text-decoration: none; " href="?language=pl">
            <img src="/icons/poland.png" alt="..." class="img-rounded">
          </a>
        </li>
        <li>
          <a style="text-decoration: none;" href="?language=en">
            <img  src="/icons/england.png" />
          </a>
        </li>
      </ul>
    </div>
  </div>
</nav>