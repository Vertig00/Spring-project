<%@    taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<ul class="ul">
    <li>
        <h4 class="menu">
            <spring:message code="menu.message"/>
        </h4>
    </li>
    <li>
        <a onclick="change_class('1')" class="hrefLink" id="1" style="text-decoration: none;" href="/students">
            <i class="fa fa-users fa-fw" aria-hidden="true"></i>
            <spring:message code="button.listStudents"/>
        </a>
    </li>
    <li>
        <a onclick="change_class('2')" class="hrefLink" id="2" style="text-decoration: none;" href="/addStudent">
            <i class="fa fa-user-plus fa-fw" aria-hidden="true"></i>
            <spring:message code="button.addStudent"/>
        </a>
    </li>
    <li>
        <a onclick="change_class('3')" class="hrefLink" id="3" style="text-decoration: none;" href="/subjects">
            <i class="fa fa-server fa-fw" aria-hidden="true"></i>
            <spring:message code="button.listSubjects"/>
        </a>
    </li>
    <li>
        <a onclick="change_class('4')" class="hrefLink" id="4" style="text-decoration: none;" href="/addSubject">
        <i class="fa fa-plus-square fa-fw" aria-hidden="true"></i>
            <spring:message code="button.addSubject"/>
        </a>
    </li>
    <li>
        <a onclick="change_class('5')" class="hrefLink" id="5" style="text-decoration: none;" href="/studentSetter">
            <i class="fa fa-puzzle-piece fa-fw" aria-hidden="true"></i>
            <spring:message code="button.setStudents"/>
        </a>
    </li>
    <li>
        <a class="hrefLink" style="text-decoration: none;" href="#" onclick="history.go(-1)">
            <i class="fa fa-arrow-left fa-fw" aria-hidden="true"></i>
            <spring:message code="button.goBack"/>
        </a>
    </li>
</ul>



<script type="text/javascript">
  function change_class(element_id)
  {
    document.getElementById(element_id).setAttribute("class", "active");
  }
</script>
