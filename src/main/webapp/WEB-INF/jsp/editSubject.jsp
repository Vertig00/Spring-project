<%@   page language="java" contentType="text/html; charset=ISO-8859-2" pageEncoding="UTF-8"%>
<%@    taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
          <div class="panel-heading"><spring:message code="label.editSubject"/></div>
          <div class="panel-body">
            <div class="row">
            <form:form action="${pageContext.request.contextPath}/editSubject" modelAttribute="editSubjectForm" method="post" data-toggle="validator" role="form">
                  <div class="col-md-2"></div>
                  <div class="col-md-2"><label for="id"><spring:message code="form.id"/></label></div>
                  <div class="col-md-4"><form:input class="form-control" type="text" name="subject_id" path="subject_id" disabled="true"/></div>
                </div>
                <div class="row">
                  <div class="col-md-2"></div>
                  <div class="col-md-2"><label for="name"><spring:message code="form.subject.name"/></label></div>
                  <div class="col-md-4"><form:input class="form-control" type="text" name="name" path="name"
                       data-error="Invalid subject name" />
                  </div>
                  <form:errors path="name" class="help-block with-errors"/>
                </div>
                <div class="row">
                  <div class="col-md-2"></div>
                  <div class="col-md-2"><label for="ects"><spring:message code="form.subject.ects"/></label></div>
                  <div class="col-md-4"><form:input class="form-control" type="number" min="2" max="10" name="ects" path="ects"
                       data-error="Invalid ects points value"/>
                  </div>
                  <form:errors path="ects" class="help-block with-errors"/>
                </div>
                <div class="row">
                  <div class="col-md-2"></div>
                  <div class="col-md-2"><label for="description"><spring:message code="form.subject.description"/></label></div>
                  <div class="col-md-4"><form:textarea class="form-control" type="text" name="description" path="description"
                       data-error="Invalid description" rows="5"/>
                  </div>
                  <form:errors path="description" class="help-block with-errors"/>
                </div>
                </br>
                <div class="row">
                  <div class="col-md-4"></div>
                  <div class="col-md-4"><input type="submit" class="btn btn-primary" value="<spring:message code="submit"/>"></div>
                </div>
            </form:form>
          </div>
        </div>
    </div>
</div>