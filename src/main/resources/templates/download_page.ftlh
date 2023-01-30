<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Download</title>
    <style>
        .downloadBtn {
            box-sizing: border-box;
            background: #7c93a6;
            padding: 24px 20px;
            font-weight: 600;
            font-size: 22px;
            line-height: 23px;
            color: #fff;
            border-radius: 8px;
            box-shadow: 0 3px 6px 0 rgb(0 0 0 / 30%);
        }

        a {
            text-decoration: none;
            color: #e5322d;
            background: rgba(0, 0, 0, 0);
        }

        html {
            margin: 0;
            padding: 0;
            border: 0;
            font: inherit;
            vertical-align: baseline;
        }

        html {
            background-color: #F0FCFF;
        }

        .download {
            display: flex;
            flex-wrap: wrap;
            margin-left: auto;
            margin-right: auto;
            margin-bottom: 72px;
            text-align: center;
            position: relative;
        }

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

        .showInfo {
            padding-top: 20px;
            margin-left: 0;
            padding-left: 0;
            padding-right: 0;
            padding-top: 100px;
            margin-left: auto;
            margin-right: auto;
            text-align: center;
            margin-top: 2%;
        }

        .download {
            margin-left: 42.7%;
        }
    </style>
</head>
<body>

<header class="header">
    <div class="header-main">
        <h1 href='#'>TransactionInfo</h1>
    </div>
</header>
<div class="main">
    <h1>/</h1>
    <p style="margin-top: 10%; font-size: 30px;">Для продолжения выберите файл транзакций в формате .csv</p>
    <form enctype="multipart/form-data" action="fileIn" method="post">
        <div class="download" style="margin-bottom:20px; margin-top:100px;">
            <input class="file-input" accept="text/csv" type="file" name="file">
        </div>
        <input style="padding-left: 30px; position: relative; z-index: 1; text-align: center; margin-left:43%; value-align:center; background-color:#7c93a6; border:none; width:220px; font-size: 25px; height:55px; border-radius:13px;"
               class="download" type="submit" value="Подтвердить">
    </form>

</div>
<div class="showInfo" style="">

    <form action="getInfoPage" method="post">
        <input style="margin-top:2px; background-color: #4C549A; color: white;
        border-radius: 5px; border-width:1px; width:170px; height:34px; font-size:16px;" type="submit"
               class="btn btn-sm btn-success btn-user btn-block" value="Данные и статистика">
    </form>

</div>
</body>
</html>
