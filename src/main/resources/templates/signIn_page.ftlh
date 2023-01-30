<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Sign In</title>
    <style media="screen">
        p, .header-main {
            margin-left: auto;
            margin-right: auto;
            text-align: center;
        }

        .header {
            width: 100%;
            background-color: #4C549A;
            display: flex;
            align-items: center;
            position: fixed;
            top: 0;
            color: white;
        }

        html {
            background-color: #F0FCFF;
        }

        .container {
            padding-left: 0;
            padding-right: 0;
            padding-top: 100px;
            margin-left: auto;
            margin-right: auto;
            text-align: center;
            margin-top: 7%;
        }

        form {
            margin-left: 0;
        }
    </style>
</head>
<body>

<header class="header">
    <div class="header-main">
        <h1>TransactionInfo</h1>
    </div>
</header>
<div class="main">
    <div class="container">
        <h1 style="margin-bottom: 50px;">Вход</h1>
        <form action="/signIn" method="post">
            <div>
                <input style="background-color: white;
            border-radius: 4px; border-width:1px; width:250px; height:34px; font-size:16px;" type="email" name="email"
                       id="email" placeholder="Почта">
            </div>
            <div class="form-group" style="padding-top:20px;">
                <input style="background-color: white;
            border-radius: 4px; border-width:1px; width:250px; height:34px; font-size:16px;" type="password"
                       id="password" name="password" placeholder="Пароль">
            </div>
            <div class="Enter" style="padding-top:20px;">
                <input style="margin-top:25px; background-color: #95B3F9;
            border-radius: 12px; border-width:1px; width:70px; height:34px; font-size:16px;" type="submit"
                       value="Войти">
            </div>
        </form>
    </div>
</div>
<div class="container" style="margin-top:10px; padding-top: 0;">
    <form action="signInGo" method="post">
        <input style="background-color: #F0FCFF; border-width:0; text-decoration:underline;" type="submit"
               value="Нажмите для регистрации">
    </form>
</div>
</body>
</html>