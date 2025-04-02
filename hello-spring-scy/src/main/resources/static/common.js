$().ready(function () {
  // 글 작성 페이지 이벤트
  $("form.write-form")
    .find(".write-save")
    .on("click", function () {
      var invalidInputs = $("input:invalid, textarea:invalid");
      if (invalidInputs.length > 0) {
        return;
      }
      $("form.write-form")
        .attr({
          method: "POST",
          action: "/board/write-scy",
        })
        .submit();
    });

  $("form.modify-form")
    .find(".modify-save")
    .on("click", function () {
      var invalidInputs = $("input:invalid, textarea:invalid");
      if (invalidInputs.length > 0) {
        return;
      }

      var id = $("form.modify-form").find("input[type=hidden]").val();
      $("form.modify-form")
        .attr({
          method: "POST",
          action: "/board/modify/" + id,
        })
        .submit();
    });
});
