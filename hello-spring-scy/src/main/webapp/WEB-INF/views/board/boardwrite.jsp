<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>게시글 작성하기</title>
    <link rel="stylesheet" href="/common.css" type="text/css" />
    <script src="/jquery-3.7.1.min.js" type="text/javascript"></script>
    <script src="/common.js" type="text/javascript"></script>
  </head>
  <body>
    <h1>게시글 작성</h1>
    <form class="write-form" enctype="multipart/form-data">
      <div class="grid">
        <label for="subject">제목</label>
        <input id="subject" type="text" name="subject" required />

        <label for="email">이메일</label>
        <input id="email" type="email" name="email" required />

        <label for="file">첨부파일</label>
        <div>
          <input id="file1" type="file" name="file" />
          <input id="file2" type="file" name="file" />
          <input id="file3" type="file" name="file" />
        </div>

        <label for="content">내용</label>
        <textarea id="content" name="content" required></textarea>

        <div class="btn-group">
          <div class="right-align">
            <button type="submit" class="write-save">저장</button>
          </div>
        </div>
      </div>
    </form>
  </body>
</html>
