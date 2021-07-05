<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改书籍</title>

    <%--  Bootstrap美化  --%>
    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

</head>
<body>
<div class="container">

    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    <small>修改书籍</small>
                </h1>
            </div>
        </div>
    </div>

    <form action="${pageContext.request.contextPath}/book/updateBook" method="post">
        <%--出现的问题：我们提交了修改的SQL请求，但是提交修改失败，初步考虑是事务问题，配置事务后依旧失败！--%>
        <%--看一下SQL语句，能否执行成功，SQL执行失败，修改未完成--%>
        <%--最后发现是没有指定用户id，解决办法：采用隐藏域传递用户id--%>

        <%--前端传递隐藏域--%>
        <input type="hidden" name="bookId" value="${queryBook.bookId}">

        <div class="form-group">
            <label>书籍名称：</label>
            <input type="text" name="bookName" class="form-control" value="${queryBook.bookName}" required>
        </div>
        <div class="form-group">
            <label>书籍数量：</label>
            <input type="text" name="bookCounts" class="form-control" value="${queryBook.bookCounts}" required>
        </div>
        <div class="form-group">
            <label>书籍描述：</label>
            <input type="text" name="detail" class="form-control" value="${queryBook.detail}" required>
        </div>
        <div class="form-group">
            <input type="submit" class="btn btn-primary" value="修改">
        </div>
    </form>

</div>
</body>
</html>
