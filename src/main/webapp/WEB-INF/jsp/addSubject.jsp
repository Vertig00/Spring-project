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
    <div class="col-md-2"></div>
    <div class="col-md-8">
        <div class="panel panel-primary">
          <div class="panel-heading"><spring:message code="message.addNewSubject"/></div>
          <div class="panel-body">
            <form:form action="addSubject" method="post" id="form" modelAttribute="addSubjectForm" data-toggle="validator" role="form" >
                <div class="row form-group">
                  <div class="col-md-2"></div>
                  <div class="col-md-2"><label for="name"><spring:message code="form.subject.name"/> </label></div>
                  <div class="col-md-4">
                     <form:input class="form-control" type="text" name="name" path="name"
                            data-error='<spring:message code="error.invalidText"/>' required="required"/>
                  </div>
                  <form:errors path="name" class="help-block with-errors"/>
                </div>
                <div class="row form-group">
                  <div class="col-md-2"></div>
                  <div class="col-md-2"><label for="ects"><spring:message code="form.subject.ects"/></label></div>
                  <div class="col-md-4">
                    <form:input class="form-control" type="number" name="ects" path="ects"
                       data-error='<spring:message code="error.invalidText"/>' value="2" min="2" max="10" required="required"/>
                  </div>
                  <form:errors path="ects" class="help-block with-errors"/>
                </div>
                <div class="row form-group">
                  <div class="col-md-2"></div>
                  <div class="col-md-2"><label for="date"><spring:message code="form.subject.description"/></label></div>
                  <div class="col-md-4">
                    <form:textarea class="form-control" type="text" name="description" path="description"
                           data-error='<spring:message code="error.invalidBirthDate"/>' required="required" rows="5"/>
                  </div>
                  <form:errors path="description" class="help-block with-errors"/>
                </div>
                </br>
                <div class="row form-group">
                  <div class="col-md-4"></div>
                  <div class="col-md-4"><input type="submit" class="btn btn-primary" value='<spring:message code="submit"/>' /></div>
                </div>
            </form:form>
          </div>
        </div>
    </div>
</div>