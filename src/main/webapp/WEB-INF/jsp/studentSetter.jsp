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
          <div class="panel-heading">
            <spring:message code="label.connectStudentToSubject"/>
          </div>
          <div class="panel-body">
            <form:form action="${pageContext.request.contextPath}/setStudentToSubject" modelAttribute="studentSetter"
                       method="post" data-toggle="validator" role="form">
                <div class="row">
                    <div class="col-md-1"></div>
                    <div class="col-md-5">
                        <div class="form-group">
                          <label for="subject"><spring:message code="form.selectSubject"/></label>
                          <select class="form-control" id="subject" name="subject" multiple>
                            <c:forEach items="${subjectList}" var="subject">
                                <option value="<c:out value="${subject.subject_id}"/>">
                                    <c:out value="${subject.name}"/>
                                </option>
                            </c:forEach>
                          </select>
                        </div>
                    </div>
                    <div class="col-md-5">
                        <div class="form-group">
                          <label for="student"><spring:message code="form.selectStudent"/></label>
                          <select class="form-control" id="student" name="student">
                            <c:forEach items="${studentList}" var="student">
                                <option value="<c:out value="${student.id}"/>">
                                    <c:out value="${student.name} ${student.surname}"/>
                                </option>
                            </c:forEach>
                          </select>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-5"></div>
                    <div class="col-md-2">
                       <input type="submit" class="btn btn-primary" value="<spring:message code="submit"/>">
                    </div>
                </div>
              </div>
            </form:form>
        </div>
    </div>
</div>


<script type="text/javascript">
	$(document).ready( function () {
		$("#subject").chosen({
			allow_single_deselect: true,
			no_results_text: "Brak takiej opcji"
		});
        $("#student").chosen({
            allow_single_deselect: true,
            no_results_text: "Brak takiej opcji"
        });
	});
</script>