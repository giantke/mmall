<%@ page contentType="text/html; charset=UTF-8"%>
<html>
<body>
<h2>Hello World!</h2>


<form name="file1" action="/manage/product/upload.do" method="post" enctype="multipart/form-data">
    <input type="file" name="upload-file">
    <input type="submit" value="上传文件">
</form>

<form name="file2" action="/manage/product/richText-img-upload.do" method="post" enctype="multipart/form-data">
    <input type="file" name="upload-file">
    <input type="submit" value="上传文件">
</form>
</body>
</html>
