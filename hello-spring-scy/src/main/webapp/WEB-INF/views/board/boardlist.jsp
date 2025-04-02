<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Insert title here</title>
    <!-- 
        이 페이지의 endpoint http://localhost:8080/board/list-scy
        http://         <-- Protocal
        localhost       <-- Domain
        :8080           <-- Port
        /board/list-scy <-- Path
        ?n=n            <-- query string parameter

        http://localhost:8080   <-- host
    -->
    <!-- 현재 페이지와 이동할 페이지의 host가 같다면 host를 생략할 수 있음 -->
    <link rel="stylesheet" href="/common.css" type="text/css" />
  </head>
  <body>
    <h1>게시글 목록</h1>
    <p>게시글 수: ${boardList.getBoardCnt()}</p>
    <p>조회한 게시글의 수: ${boardList.getBoardList().size()}</p>

    <a href="/board/write-scy">게시글 등록하기</a>
  </body>
</html>
