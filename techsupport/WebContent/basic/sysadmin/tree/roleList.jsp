<table>
	<c:if test="${roleList!=null}">
		<c:forEach var="roleBean" items="${roleList}" varStatus="status">
			<tr>
				<td height='20'>
					<a class="linkOperate" href="#"
						onclick="javascript: fnquery('<c:out value='${roleBean.roleid}'/>')">
						<c:out value="${roleBean.rolename}" /> 
					</a>
				</td>
			</tr>
		</c:forEach>
	</c:if>
</table>