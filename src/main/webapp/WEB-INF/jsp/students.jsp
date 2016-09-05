<%@    taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@    taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@    taglib uri="/WEB-INF/tld/start.tld" prefix="start" %>
<%@    taglib prefix="spring" uri="http://www.springframework.org/tags" %>

</br>
</br>
</br>
</br>
</br>
<div class="row">
    <div class="col-md-2"></div>
    <div class="col-md-8">
    <div class="panel panel-primary">
      <div class="panel-heading"><spring:message code="students_list"/></div>
      <div class="panel-body">
        <div class="table-responsive">
            <table class="table table-hover" name="table" id="table">
                <thead>
                    <tr>
                        <th class="text-center"><spring:message code="form.id"/></th>
                        <th class="text-center"><spring:message code="form.name"/></th>
                        <th class="text-center"><spring:message code="form.surname"/></th>
                        <th class="text-center"><spring:message code="form.birthDate"/></th>
                        <th class="text-center"><spring:message code="form.gender"/></th>
                        <th class="text-center"><i class="fa fa-info" aria-hidden="true"></i></th>
                        <th class="text-center"><i class="fa fa-pencil" aria-hidden="true"></i></th>
                        <th class="text-center"><i class="fa fa-times" aria-hidden="true"></i></th>
                    </tr>
                </thead>
                <c:forEach items="${studentsList}" var="stud">
                    <c:choose>
                        <c:when test="${stud.sex eq 'M'}">
                            <tr class="success">
                        </c:when>
                        <c:otherwise>
                            <tr class="info">
                        </c:otherwise>
                    </c:choose>
                            <td align="center"><c:out value="${stud.id}"/></td>
                            <td align="center"><c:out value="${stud.name}"/></td>
                            <td align="center"><c:out value="${stud.surname}"/></td>
                            <td align="center"><fmt:formatDate pattern="dd.MM.yyyy" value="${stud.date}" /></td>
                            <td align="center"><c:out value="${stud.sex}"/></td>
                            <td align="center">
                                <a style="text-decoration: none;" href='student/<c:out value="${stud.id}"/>'>
                                    <input type="button" class="btn btn-info" value="<spring:message code="info"/>"/>
                                </a>
                            </td>
                            <td align="center">
                               <a style="text-decoration: none;" href="editStudent/<c:out value="${stud.id}"/>">
                                   <input type="button" class="btn btn-warning" value="<spring:message code="edit"/>" />
                               </a></td>
                            <td align="center">
                                 <form action="removeStudent" method="post" onsubmit="return confirm('<spring:message code="message.confirm"/>') ? true : false;">
                                      <input type="hidden" name="id" value="${stud.id}"/>
                                      <input type="submit" class="btn btn-danger" value="<spring:message code="delete"/>">
                                 </form>
                            </td>
                        </tr>
                </c:forEach>
            </table>
        </div>
      </div>
    </div>
</div>