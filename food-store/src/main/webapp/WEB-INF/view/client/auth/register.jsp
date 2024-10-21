<%@page contentType="text/html" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

            <!DOCTYPE html>
            <html lang="en">

            <head>
                <meta charset="utf-8">
                <meta name="author" content="Kodinger">
                <meta name="viewport" content="width=device-width,initial-scale=1">
                <title>My Login Page &mdash; Bootstrap 4 Login Page Snippet</title>
                <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
                    integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
                    crossorigin="anonymous">
                <link rel="stylesheet" type="text/css" href="/client/css/my-login.css">
            </head>

            <body class="my-login-page">
                <section class="h-100">
                    <div class="container h-100">
                        <div class="row justify-content-md-center h-100">
                            <div class="card-wrapper">
                                <div class="brand">
                                    <img src="/images/logo/logo.png" alt="bootstrap 4 login page">
                                </div>
                                <div class="card fat">
                                    <div class="card-body">
                                        <h4 class="card-title">Register</h4>
                                        <form:form method="post" action="/verify" modelAttribute="registerUser">

                                            <c:set var="errorPassword">
                                                <form:errors path="confirmPassword" cssClass="invalid-feedback" />
                                            </c:set>

                                            <c:set var="errorEmail">
                                                <form:errors path="email" cssClass="invalid-feedback" />
                                            </c:set>
                                            <c:set var="errorFullname">
                                                <form:errors path="fullName" cssClass="invalid-feedback" />
                                            </c:set>

                                            <div class="form-group">
                                                <label for="name">Name</label>
                                                <form:input id="name" type="text"
                                                    class="form-control ${not empty errorFullname? 'is-invalid':''}"
                                                    name="name" required="true" path="fullName" />
                                                ${errorFullname}
                                            </div>

                                            <div class="form-group">
                                                <label for="email">E-Mail Address</label>
                                                <form:input id="email" type="email"
                                                    class="form-control ${not empty errorEmail? 'is-invalid':''}"
                                                    name="email" required="true" path="email" />
                                                ${errorEmail}

                                            </div>

                                            <div class="form-group">
                                                <label for="password">Password</label>
                                                <form:input id="password" type="password"
                                                    class="form-control ${not empty errorPassword? 'is-invalid':''}"
                                                    name="password" required="true" path="password" />

                                                ${errorPassword}

                                            </div>

                                            <div class="form-group">
                                                <label for="password">Confirm Password</label>
                                                <form:input id="password" type="password" class="form-control"
                                                    name="password" required="true" path="confirmPassword" />
                                            </div>

                                            <div class="form-group">
                                                <div class="custom-checkbox custom-control">
                                                    <input type="checkbox" name="agree" id="agree"
                                                        class="custom-control-input" required="true">
                                                    <label for="agree" class="custom-control-label">I agree to the <a
                                                            href="#">Terms
                                                            and Conditions</a></label>
                                                    <div class="invalid-feedback">
                                                        You must agree with our Terms and Conditions
                                                    </div>
                                                </div>
                                            </div>

                                            <div class="form-group m-0">
                                                <button type="submit" class="btn btn-primary btn-block">
                                                    Register
                                                </button>
                                            </div>
                                        </form:form>
                                    </div>

                                    <div class="mt-4 text-center">
                                        Already have an account? <a href="/login">Login</a>
                                    </div>
                                </div>
                            </div>

                        </div>
                    </div>
                    </div>
                </section>

                <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
                    integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
                    crossorigin="anonymous"></script>
                <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
                    integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
                    crossorigin="anonymous"></script>
                <script src="js/my-login.js"></script>
            </body>

            </html>