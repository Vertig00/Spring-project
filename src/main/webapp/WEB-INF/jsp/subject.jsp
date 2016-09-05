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
          <div class="panel-heading"><spring:message code="label.subjectInfo"/></div>
          <div class="panel-body">
            <div class="row">
            <form:form modelAttribute="subjectInfo">
                  <div class="col-md-2"></div>
                  <div class="col-md-2"><label for="id"><spring:message code="form.id"/></label></div>
                  <div class="col-md-4"><form:input class="form-control" type="text" name="subject_id" path="subject_id" disabled="true"/></div>
                </div>
                <div class="row">
                  <div class="col-md-2"></div>
                  <div class="col-md-2"><label for="name"><spring:message code="form.subject.name"/></label></div>
                  <div class="col-md-4"><form:input class="form-control" type="text" name="name" path="name" disabled="true"/></div>
                </div>
                <div class="row">
                  <div class="col-md-2"></div>
                  <div class="col-md-2"><label for="ects"><spring:message code="form.subject.ects"/></label></div>
                  <div class="col-md-4"><form:input class="form-control" type="text" name="ects" path="ects" disabled="true"/></div>
                </div>
                <div class="row">
                  <div class="col-md-2"></div>
                  <div class="col-md-2"><label for="description"><spring:message code="form.subject.description"/></label></div>
                  <div class="col-md-4"><form:textarea class="form-control" type="text"
                                              name="description" path="description" disabled="true" rows="5"/></div>
                </div>
            </form:form>
          </div>
        </div>
    </div>
</div>
<div class="row">
    <div class="col-md-2"></div>
    <div class="col-md-8">
        <div class="panel panel-primary">
          <div class="panel-heading"><spring:message code="label.subjectStudents"/></div>
          <div class="panel-body">
            <ul class="list-group">
                <c:forEach items="${studentList}" var="student">
                  <li class="list-group-item"><c:out value="${student.name} ${student.surname}"/></li>
                </c:forEach>
            </ul>
          </div>
        </div>
    </div>
</div>