<%@page contentType="text/html" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
            <!DOCTYPE html>
            <html lang="en">

            <head>
                <meta charset="utf-8">
                <meta name="author" content="Kodinger">
                <meta name="viewport" content="width=device-width,initial-scale=1">
                <title>Deny Access</title>
                <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
                    integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
                    crossorigin="anonymous">
            </head>

            <body>
                <div class="container">
                    <div class="row">
                        <div class="col-12 mt-5">
                            <div class="alert alert-danger">
                                Bạn không có quyền truy cập vào nguyên tài nguyên chạy
                            </div>
                            <a href="/" class="btn btn-success">Trang chủ</a>
                        </div>
                    </div>
                </div>
            </body>

            </html>