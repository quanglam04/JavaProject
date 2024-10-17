<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <style>
        /* Đảm bảo chiều cao tối thiểu của section là 100% chiều cao màn hình */
        section {
            height: 100vh;
        }

        a :hover {
            opacity: 0.3;
        }

        a {
            text-decoration: none;
        }
    </style>
</head>

<body>
    <section class="bg-light d-flex justify-content-center align-items-center">
        <div class="container">
            <div class="row justify-content-center">
                <div class="col-lg-8 mb-4 mb-sm-5">
                    <div class="row " style="width: 15%;margin-right: auto; margin-left: auto; margin-bottom: 70px; ">
                        <img src="/images/logo/logo.png" alt="">
                    </div>
                    <div class="card card-style1 border-0  ">
                        <div class="card-body p-1-9 p-sm-2-3 p-md-6 p-lg-7">
                            <div class="row align-items-center">
                                <div class="col-lg-6 mb-4 mb-lg-0">
                                    <img src="/images/avatar/${user.avatar}" class="img-thumbnail" alt="avatar">
                                    <!-- <div style="margin-left: 107px; margin-top: 5px;">
                                        <a href="">Upload images</a>
                                    </div> -->
                                </div>
                                <div class="col-lg-6 px-xl-10">
                                    <div class="d-lg-inline-block py-1-9 px-1-9 px-sm-6 mb-3 rounded">
                                        <h3 class="h2 text-primary mb-0 ">${user.fullName}</h3>

                                    </div>
                                    <ul class="  mb-1-9">
                                        <li class="mb-2 mb-xl-3 display-28">
                                            <span
                                                class="display-26 text-secondary me-2 font-weight-600 text-secondary">Email:
                                                ${user.email}
                                            </span>
                                        </li>
                                        <li class="mb-2 mb-xl-3 display-28"><span
                                                class="display-26 text-secondary me-2 font-weight-600 text-secondary">Phone:
                                                ${user.phone}</span>
                                        </li>
                                        <li class="mb-2 mb-xl-3 display-28"><span
                                                class="display-26 text-secondary me-2 font-weight-600 text-secondary">Address:
                                                ${user.address}</span>
                                        </li>
                                        <li class="mb-2 mb-xl-3 display-28"><span
                                                class="display-26 text-secondary me-2 font-weight-600 text-secondary">Role:
                                                ${user.role.name}</span>
                                        </li>


                                        <div class="btn btn-success mt-3">
                                            <a style="color: white; text-decoration: none;" href="/">Back</a>
                                        </div>
                                        <div class="btn btn-warning mt-3">
                                            <a style="color: white; text-decoration: none;"
                                                href="/update-profile/${user.id}">Update</a>
                                        </div>
                                    </ul>

                                </div>
                            </div>
                        </div>
                    </div>
                </div>


            </div>
        </div>
    </section>

</body>

</html>