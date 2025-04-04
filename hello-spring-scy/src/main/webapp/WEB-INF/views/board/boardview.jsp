<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>게시글 내용 조회</title>
    <link rel="stylesheet" href="/common.css" type="text/css" />
  </head>
  <body>
    <h1>게시글 조회</h1>
    <div class="detail-wrapper">
      <div class="grid">
        <label>제목</label>
        <div>${boardVO.subject}</div>

        <label>이메일</label>
        <div>${boardVO.email}</div>

        <label>첨부파일</label>
        <div>
            <a href="/file/${boardVO.id}/${boardVO.fileList[0].flId}">
                ${boardVO.fileList[0].flNm}
            </a>
        </div>

        <label>조회수</label>
        <div>${boardVO.viewCnt}</div>

        <label>등록일</label>
        <div>${boardVO.crtDt}</div>

        <label>수정일</label>
        <div>${boardVO.mdfyDt}</div>

        <label>내용</label>
        <div>${boardVO.content}</div>

        <div class="btn-group">
          <div class="right-align">
            <a href="/board/modify-scy/${boardVO.id}">수정</a>
            <a href="/board/delete-scy/${boardVO.id}">삭제</a>
          </div>
        </div>
      </div>
    </div>
  </body>
</html>
