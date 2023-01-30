<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Info</title>
    <style>
        p, .header-main {
            margin-left: auto;
            margin-right: auto;
            text-align: center;
        }

        div {
            display: block;
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

        .main {
            padding-left: 50px;
            padding-right: 50px;
        }

        html {
            background-color: #F0FCFF;
        }

        .table {
            width: 100%;
            margin-bottom: 20px;
            border: 1px solid #dddddd;
            border-collapse: collapse;
        }

        .table th {
            font-weight: bold;
            padding: 5px;
            background: #7c93a6;
            border: 1px solid #dddddd;
        }

        .table td {
            border: 1px solid #dddddd;
            padding: 5px;

            text-align: center;
        }

        ul {
            list-style-type: none;
            margin: 0;
            padding: 0;
            overflow: hidden;
        }

        li.nav {
            float: right;
        }

        li.navback {
            float: left;
        }

        input {
            background-color: #F0FCFF;
            border: none;
            margin-bottom: 28px;
        }

        form {
            display: block;
            color: black;
            text-align: center;
            width: 190px;

            padding: 14px 16px;
        }

        li a {
            display: block;
            color: black;
            text-align: center;
            padding: 14px 16px;
            text-decoration: none;
        }

        li:hover {
            border: 1px solid #4C549A;
        }
    </style>
</head>
<body>
<header class="header">
    <div class="header-main">
        <h1 href='#'>TransactionInfo</h1>
    </div>
</header>
<div class="main" style="margin-top: 10%">
    <div class="navBar">
        <ul>
            <form action="/info" method="post">
                <li class="navback"><input type="submit" name="return" value="Вернуться к загрузке файла"></li>
            </form>
        </ul>
    </div>
    <table class="table">
        <tr>
            <th>ID транзакции</th>
            <th>Тип транзакции</th>
            <th>MCC</th>
            <th>Описание</th>
            <th>Сумма</th>
        </tr>
        <#list transactions as trans>
            <tr>
                <td>${trans.id}</td>
                <td>${trans.type}</td>
                <td>${trans.mcc}</td>
                <td>${trans.description}</td>
                <td>${trans.sum}</td>
            </tr>
        </#list>

    </table>
    <table class="table">
        <tr>
            <th>Тип и код транзакции</th>
            <th>Описание</th>
            <th>Количество</th>
            <th>Общая сумма</th>
            <th>Дисперсия</th>
        </tr>
        <#list statistics as st>
            <tr>
                <td>${st.type}</td>
                <td>${st.description}</td>
                <td>${st.number}</td>
                <td>${st.amount}</td>
                <td>${st.dispersion}</td>
            </tr>
        </#list>
    </table>

</div>

<div style="padding-left: 0;
    padding-right: 0;
    padding-top: 100px;
    margin-left: 43%;
    margin-right: auto;
    text-align: center;
    margin-top: 2%;">
    <a><span></span></a>
    <form style="margin-top:2px; background-color: #4C549A; color: white;
        border-radius: 5px; border-width:1px; width:170px; height:26px; font-size:16px;" action="/downloadCsv"
          method="get">
        <input style="background-color:#4C549A; font-size:17px; color: #dddddd" type="submit"
               value="Скачать статистику">
    </form>
</div>
</body>
</html>