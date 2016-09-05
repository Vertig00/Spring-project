<%@    taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@    taglib prefix="spring" uri="http://www.springframework.org/tags" %>


<c:if test="${notification == true}">
    <div class="alert alert-success alert-dismissible" role="alert">
      <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
      <c:out value="${message}"/>
    </div>
</c:if>

</br>
</br>
</br>
</br>
</br>

<div class="row">
    <div class="col-md-2"></div>
    <div class="col-md-8">
        <div class="panel panel-primary">
          <div class="panel-heading"><spring:message code="label.subjectList"/></div>
          <div class="panel-body">
            <div class="table-responsive">
                <table class="table">
                    <tr>
                        <th class="text-center"><spring:message code="form.id"/></th>
                        <th class="text-center"><spring:message code="form.subject.name"/></th>
                        <th class="text-center"><i class="fa fa-info" aria-hidden="true"></i></th>
                        <th class="text-center"><i class="fa fa-pencil" aria-hidden="true"></i></th>
                        <th class="text-center"><i class="fa fa-times" aria-hidden="true"></i></th>
                    </tr>
                    <c:forEach items="${subjectList}" var="subject">
                        <tr>
                            <td align="center"><c:out value="${subject.subject_id}"/></td>
                            <td align="center"><c:out value="${subject.name}"/></td>
                            <td align="center">
                                <a style="text-decoration: none;" href='subject/<c:out value="${subject.subject_id}"/>'>
                                    <input type="button" class="btn btn-info" value="<spring:message code="info"/>"/>
                                </a>
                            </td>
                            <td align="center">
                               <a style="text-decoration: none;" href="editSubject/<c:out value="${subject.subject_id}"/>">
                                   <input type="button" class="btn btn-warning" value="<spring:message code="edit"/>" />
                               </a></td>
                            <td align="center">
                                 <form action="removeSubject" method="post"
                                 onsubmit="return confirm('<spring:message code="message.confirm"/>') ? true : false;">
                                      <input type="hidden" name="id" value="${subject.subject_id}"/>
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
</div>