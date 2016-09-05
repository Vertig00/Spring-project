<%@   page language="java" contentType="text/html; charset=ISO-8859-2" pageEncoding="UTF-8"%>
<%@    taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@    taglib uri="http://www.springframework.org/tags"  prefix="spring" %>
<%@    taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

</br>
</br>
</br>
</br>
</br>

<div class="row">
    <div class="col-md-4"></div>
    <div class="col-md-4">
        <div class="panel panel-primary ">
          <div class="panel-heading"><spring:message code="label.loginPage"/></div>
          <div class="panel-body">
            <form:form action="logging" method="post" id="form" modelAttribute="logginForm" data-toggle="validator" role="form" >
                <div class="row form-group">
                  <div class="col-md-2"></div>
                  <div class="col-md-2"><label for="login"><spring:message code="form.login"/> </label></div>
                  <div class="col-md-4">
                     <form:input class="form-control" type="text" name="login" path="login"
                            data-error='<spring:message code="error.invalidText"/>' required="required"/>
                  </div>
                  <form:errors path="login" class="help-block with-errors"/>
                </div>
                <div class="row form-group">
                  <div class="col-md-2"></div>
                  <div class="col-md-2"><label for="password"><spring:message code="form.password"/></label></div>
                  <div class="col-md-4">
                    <form:input class="form-control" type="password" name="password" path="password"
                       data-error='<spring:message code="error.invalidText"/>' required="required"/>
                  </div>
                  <form:errors path="password" class="help-block with-errors"/>
                </div>
                <div class="row form-group">
                  <div class="col-md-4"></div>
                  <div class="col-md-4"><input type="submit" class="btn btn-primary" value='<spring:message code="button.loggin"/>' disabled="disabled"/></div>
                </div>
            </form:form>
          </div>
        </div>
    </div>
</div>