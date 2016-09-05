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
        <div class="panel panel-primary ">
          <div class="panel-heading"><spring:message code="label.studentInfo"/></div>
          <div class="panel-body">
            <div class="row">
                <form:form modelAttribute="studentInfo">
                    <div class="row">
                      <div class="col-md-2"></div>
                      <div class="col-md-2"><label for="id"><spring:message code="form.id"/></label></div>
                      <div class="col-md-4"><form:input class="form-control" type="text" name="id" path="id" disabled="true"/></div>
                    </div>
                    <div class="row">
                      <div class="col-md-2"></div>
                      <div class="col-md-2"><label for="name"><spring:message code="form.name"/></label></div>
                      <div class="col-md-4"><form:input class="form-control" type="text" name="name" path="name" disabled="true"/></div>
                    </div>
                    <div class="row">
                      <div class="col-md-2"></div>
                      <div class="col-md-2"><label for="surname"><spring:message code="form.surname"/></label></div>
                      <div class="col-md-4"><form:input class="form-control" type="text" name="surname" path="surname" disabled="true"/></div>
                    </div>
                    <div class="row">
                      <div class="col-md-2"></div>
                      <div class="col-md-2"><label for="pesel"><spring:message code="form.pesel"/></label></div>
                      <div class="col-md-4"><form:input class="form-control" type="text" name="pesel" path="pesel" disabled="true"/></div>
                    </div>
                    <div class="row">
                      <div class="col-md-2"></div>
                      <div class="col-md-2"><label for="email"><spring:message code="form.email"/></label></div>
                      <div class="col-md-4"><form:input class="form-control" type="email" name="email" path="email" disabled="true"/></div>
                    </div>
                </form:form>
            </div>
          </div>
        </div>
    </div>
</div>
<div class="row">
    <div class="col-md-2"></div>
    <div class="col-md-8">
        <div class="panel panel-primary">
          <div class="panel-heading"><spring:message code="label.studentsSubject"/></div>
          <div class="panel-body">
            <c:forEach items="${subjectList}" var="subject">
                <ul class="list-group">
                 <li class="list-group-item"><c:out value="${subject.name}"/>
                     <form:form modelAttribute="studentInfo" action="removeStudentSubject" method="post"
                                >
                          <input type="hidden" name="subjectId" value="${subject.subject_id}"/>
                          <form:input type="hidden" name="id" path="id" />
                          <input type="submit" class="btn btn-danger" value="<spring:message code="delete"/>" />
                     </form:form>
                 </li>
                </ul>
            </c:forEach>
          </div>
        </div>
    </div>
</div>