<!doctype html>
<html>
<head>
    <meta charset="utf-8">

    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">

    <title>Cooker</title>
    <meta name="description" content="">
    <meta name="author" content="">

    <link rel="shortcut icon" href="/favicon.ico">
    <link rel="stylesheet" href="../css/style.css?v=2">
    <link rel="stylesheet" href="../css/jcarousel.css">

    <!-- All JavaScript at the bottom, except for Modernizr which enables HTML5 elements & feature detects -->
    <script src="../js/libs/modernizr-1.7.min.js"></script>

</head>

<body>

<!-- LOGIN POP UPS -->
<div id="popup-overlay"></div>
<div class="popup" id="popup-login">
    <h2>Login form</h2>
    <hr class="separator">
    <form method="post" action="" class="form clearfix">
        <fieldset>
            <label for="login-username">Username:</label>
            <input type="text" name="" id="login-username" class="input text">
            <label for="login-password">Password:</label>
            <input type="password" name="" id="login-password" class="input text">
        </fieldset>
    </form>
    <hr class="separator">
    <button class="button submit">Login</button>
    <div class="links"><a href="#">Forgotten password </a> | <a href="#" class="register-btn"> New account</a></div>
    <a class="close" href="#"></a>
</div>
<div class="popup" id="popup-register">
    <h2>Registration form</h2>
    <hr class="separator">
    <form method="post" action="" class="form clearfix">
        <fieldset>
            <label for="login-username">Username:</label>
            <input type="text" name="" id="login-username" class="input text">
            <label for="login-email">Email:</label>
            <input type="text" name="" id="login-email" class="input text error" value="Error">
            <label for="login-password">Password:</label>
            <input type="password" name="" id="login-password" class="input text">
            <label for="login-confirm-password">Confirm password:</label>
            <input type="password" name="" id="login-confirm-password" class="input text">
        </fieldset>

        <hr class="separator">

        <div class="checks">
            <div class="check-row">
                <label><input type="checkbox" class="input checkbox">I have read and agree to the <a href="#">Terms &amp; Conditions</a></label>
            </div>
            <div class="check-row">
                <label><input type="checkbox" class="input checkbox">I agree to recieve promotional mails</label>
            </div>
        </div>

        <button class="button submit">Register now</button>
    </form>
    <a class="close" href="#"></a>
</div>
<!-- END LOGIN POP UPS -->
<div class='wrapper'>
    <header>
        <div class="top-nav">
            <nav>
                <ul>
                    <li><a href="/default">Мой профиль</a></li>
                    <li><a href="/logout">Выйти</a></li>
                </ul>
            </nav>



        </div>
        <a href="/index" class="logo"><img src="../images/logo.png" alt="your logo" /></a>
        <nav class="main-menu">
            <ul><li id="lava-elm"></li>
                <li class="current"><form action="/listing" >
                    <button type="submit" value="KOMBO" name="type">Наборы</button>
                </form></li>
                <li>
                    <form action="/listing" >
                        <button type="submit" value="PIZZA" name="type">Пицца</button>
                    </form></li>
                <li><form action="/listing" >
                    <button type="submit" value="ROLL" name="type">Роллы</button>
                </form></li>
                <li><form action="/listing" >
                    <button type="submit" value="DRINK" name="type">Напитки</button>
                </form></li>
                <li><form action="/listing" >
                    <button type="submit" value="DESERT" name="type">Десерты</button>
                </form></li>
                <li><form action="/listing" >
                    <button type="submit" value="WOK" name="type">Вок</button>
                </form></li>
                <li><form action="/listing" >
                    <button type="submit" value="ANOTHER" name="type">Дополнительно</button>
                </form></li>
            </ul>
        </nav>
    </header>
    <div class="content clearfix">
        <div class="breadcrumbs">
            <ul>
                <li><a href="/index">Главная</a></li>
                <li>Администратор кухни и доставки</li>
            </ul>
        </div>
        <div class="left-content">



            <h2 class="heading">Добавление нового продукта  </h2>

            <form method="post" enctype="multipart/form-data" action="/contentadmin/addtoDB" class="form contact-form">
                <fieldset>
                    <label for="prodname">Название: <span class="required"></span></label>
                    <input type="text" id="prodname" class="input text" name="name" oninput="responsenewProd()">
                    <br>
                    <p class="prodname_msg" id="infoprodname"></p>
                    <label for="contact-subject">Цена:</label>
                    <input type="text" id="contact-subject" class="input text" name="price">
                    <label for="type-subject">Тип:</label>
                    <select class="select-dropdown" id="type-subject" name="type" >
                        <option value="KOMBO">Наборы</option>
                        <option value="PIZZA">Пицца</option>
                        <option value="ROLL">Роллы</option>
                        <option value="DRINK">Напитки</option>
                        <option value="DESERT">Десерты</option>
                        <option value="WOK">Вок</option>
                        <option value="ANOTHER">Дополнительно</option>
                    </select>
                    <label for="contact-details">Описание: <span class="required"></span></label>
                    <textarea id="contact-details" rows="30" cols="50" class="input textarea" name="description"></textarea>
                    <label for="exampleInputFile">Фотография: <span class="required"></span></label>
                    <input type="file" name="photo" id="exampleInputFile">
                    <br>

                    <span class="required-desr"></span>
                    <button class="button" type="submit">Добавить продукт</button>
                </fieldset>
            </form>


            <hr />
            <h2 class="heading">Добавление нового продуктов в слайдер</h2>

            <form method="post" action="/contentadmin/addtoSlider" class="form contact-form">
                <fieldset>
                    <label for="prod1">Название продукта1: <span class="required"></span></label>
                    <input type="text" id="prod1" name="prod1" class="input text" oninput="responseSlider()">
                    <br>
                    <p class="prod1_msg" id="infoprod1"></p>

                    <label for="prod2">Название продукта2: <span class="required"></span></label>
                    <input type="text" id="prod2" name="prod2" class="input text" oninput="responseSlider()">
                    <br>
                    <p class="prod2_msg" id="infoprod2"></p>

                    <label for="prod3">Название продукта3: <span class="required"></span></label>
                    <input type="text" id="prod3" name="prod3" class="input text" oninput="responseSlider()">
                    <br>
                    <p class="prod3_msg" id="infoprod3"></p>

                    <button class="button" type="submit">Добавить продукты</button>
                </fieldset>
            </form>


            <#--<hr />-->
            <#--<h2 class="heading">Удаление продукта</h2>-->
            <#--<form method="post" action="/contentadmin/removeProduct" class="form contact-form">-->
                <#--<label for="prodremove">Название продукта: <span class="required"></span></label>-->
                <#--<input type="text" id="prodremove" name="prodremove" class="input text" oninput="responseremoveProd()">-->
                <#--<br>-->
                <#--<p class="prodremove_msg" id="infoprodremove"></p>-->
                <#--<button class="button" type="submit">Удалить продукт</button>-->
                <#--</form>-->



        </div>
    </div>
</div>
<footer>
    <div class="footer-holder">
        <a href="" class="logo">Cooker Logo</a>
        <div class="links first">
            <h6>Подписывайтесь</h6>
            <ul>
                <li class="facebook"><a href="https://www.facebook.com/profile.php?id=100009318339260">Facebook</a></li>
                <li class="twitter"><a href="https://twitter.com/bobrkate">Twitter</a></li>
                <li class="rss"><a href="https://vk.com/id22146520">Vk</a></li>
            </ul>
        </div>

        <div class="credits clearfix">
            Copyright &copy; 2011 Cooker. All rights reserved
        </div>
    </div>
</footer>
</body>
<script src="../js/libs/jquery-1.7.1.min.js" type="text/javascript"></script>
<script src="../js/libs/jquery.easing.1.3.js"></script>
<script src="../js/script.js"></script>
<script src="../js/validator.js"></script>
<script src="../js/libs/jquery.jcarousel.min.js"></script>
</html>