
<!DOCTYPE html>
<html lang="en" class="no-js">

    <head>

        <meta charset="utf-8">
        <title>Fullscreen Login</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="">

        <!-- CSS -->
        <link rel='stylesheet' href='http://fonts.googleapis.com/css?family=PT+Sans:400,700'>
        <link rel="stylesheet" href="../static/assets/css/reset.css">
      <!--   <link rel="stylesheet" href="../static/assets/css/supersized.css"> -->
        <link rel="stylesheet" href="../static/assets/css/style.css">


    </head>

    <body>

        <div class="page-container">
            <h1>Login</h1>
            <form action="/user/login" method="post" id="form">
                <input type="text" name="name" class="name" placeholder="name">
                <input type="password" name="pwd" class="pwd" placeholder="pwd">
                <button type="submit">Sign me in</button>
                <div class="error"><span>+</span></div>
            </form>
            <div class="connect">
               
                <p>
                   
                </p>
            </div>
        </div>

        <!-- Javascript -->
        <script src="../static/assets/js/jquery-1.8.2.min.js"></script>
        <script src="../static/assets/js/supersized.3.2.7.min.js"></script>
        <script src="../static/assets/js/supersized-init.js"></script>
        <script src="../static/assets/js/scripts.js"></script>

    </body>

</html>

