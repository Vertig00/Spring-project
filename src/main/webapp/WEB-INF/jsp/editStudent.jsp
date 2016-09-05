<%@   page language="java" contentType="text/html; charset=ISO-8859-2" pageEncoding="UTF-8"%>
<%@    taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@    taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@    taglib uri="http://www.springframework.org/tags"  prefix="spring" %>
<%@    taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<link rel="stylesheet" href="../css/custom.css"/>

</br>
</br>
</br>
</br>
</br>

<div class="row">
    <div class="col-md-2"></div>
    <div class="col-md-8">
        <div class="panel panel-primary">
          <div class="panel-heading"><spring:message code="label.editStudent"/></div>
          <div class="panel-body">
            <form:form action="${pageContext.request.contextPath}/editStudent" modelAttribute="editStudentForm" method="post" data-toggle="validator" role="form">
                <div class="row">
                  <div class="col-md-2"></div>
                  <div class="col-md-2"><label for="name"><spring:message code="form.name"/></label></div>
                  <div class="col-md-4">
                    <form:input class="form-control" type="text" name="name" path="name"
                           data-error="Invalid student name" pattern="([a-zA-Z]|[Łł]){1}([a-z]|[ąęóźćżśł])*"
                           />
                  </div>
                  <form:errors path="name" class="help-block with-errors"/>
                </div>
                <div class="row">
                  <div class="col-md-2"></div>
                  <div class="col-md-2"><label for="surname"><spring:message code="form.surname"/></label></div>
                  <div class="col-md-4">
                    <form:input class="form-control" type="text" name="surname" path="surname"
                           data-error="Invalid student surname" pattern="([a-zA-Z]|[Łł]){1}([a-z]|[ąęóźćżśł])*"
                           />
                  </div>
                  <form:errors path="surname" class="help-block with-errors"/>
                </div>
                <div class="row">
                  <div class="col-md-2"></div>
                  <div class="col-md-2"><label for="surname"><spring:message code="form.pesel"/></label></div>
                  <div class="col-md-4">
                    <form:input class="form-control" type="text" name="pesel" path="pesel"
                           data-error="Invalid student surname" pattern="[0-9]{11}"
                           />
                  </div>
                  <form:errors path="pesel" class="help-block with-errors"/>
                </div>
                <div class="row">
                  <div class="col-md-2"></div>
                  <div class="col-md-2"><label for="email"><spring:message code="form.email"/></label></div>
                  <div class="col-md-4">
                    <form:input class="form-control" type="email" name="email" path="email"
                           data-error="Invalid student surname"
                           />
                  </div>
                  <form:errors path="email" class="help-block with-errors"/>
                </div>
                <div class="row">
                  <div class="col-md-2"></div>
                  <div class="col-md-2"><label for="sex"><spring:message code="form.gender"/></label></div>
                      <div class="col-md-2">
                          <form:radiobutton name="sex" id="male" value="M" path="sex" />
                          <label for="male"><spring:message code="male"/></label><br>
                      </div>
                      <div class="col-md-2">
                         <form:radiobutton name="sex" id="female" path="sex" value="K"/>
                         <label for="female"><spring:message code="female"/></label><br>
                      </div>
                      <form:errors path="sex" class="help-block with-errors"/>
                </div>
                <div class="row">
                  <div class="col-md-4"></div>
                  <div class="col-md-4"><input type="submit" class="btn btn-primary" value="<spring:message code="submit"/>"></div>
                </div>
            </form:form>
          </div>
        </div>
    </div>
</div>