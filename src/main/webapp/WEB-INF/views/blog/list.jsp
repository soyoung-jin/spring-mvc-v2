<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>블로그 컨텐츠 목록</title>
</head>
<body>
	<div>
		<form>
			<input type="text" name="search" value="${blogListRequestDTO.search}" style="width:50%">
			<input type="submit" name="search_button" valut="검색">
		</form>
	</div>
	<c:if test ="${not empty blogListResponseDTOList}">
	<table>
		<thead>
			<tr>
				<th>글번호</th>
				<th>제목</th>
				<th>입력일</th>
				<th>수정</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="blogListResponseDTO" items="${blogListResponseDTOList}">
			<tr>
				<td>${blogListResponseDTO.blogContSeq}</td>
				<td>${blogListResponseDTO.title}</td>
				<td>${blogListResponseDTO.insertDtFormat}</td>
				<td><a href="/edit/${blogListResponseDTO.blgContSeq}">수정</a></td>
			
			</tr>
			</c:forEach>
		</tbody>
	</table>
	</c:if>
	<c:if test="${empty blogListResponseDTOList}">
		<strong>검색 결과가 없습니다.</strong>
	
	</c:if>
</body>
</html>