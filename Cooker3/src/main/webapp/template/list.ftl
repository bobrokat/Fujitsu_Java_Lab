

<head>
    <meta charset="windows-1251">

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
                    <li><a href="#" id="login-btn">Вход</a></li>
                    <li><a href="#" class="register-btn">Регистрация</a></li>
                    <li><a href="about.html">О нас</a></li>
                    <li><a href="contact.html">Контакты</a></li>
                    <li><a href="menu.html">Меню</a></li>
                    <li><a href="menu.html">Мой профиль</a></li>
                </ul>
            </nav>

            <form class="search-form" method="post">
                <input type="text" class="search" placeholder="Search for product">
                <input type="submit" class="search-submit" value="">
            </form>

        </div>
        <a href="/index" class="logo"><img src="../images/logo.png" alt="your logo" /></a>
        <nav class="main-menu">
            <ul>
                <li id="lava-elm"></li>
                <li class="current"><form action="/list" >
                    <button type="submit" value="KOMBO" name="type">Наборы</button>
                </form></li>
                <li>
                    <form action="/list" >
                        <button type="submit" value="PIZZA" name="type">Пицца</button>
                    </form></li>
                <li><form action="/list" >
                    <button type="submit" value="ROLL" name="type">Роллы</button>
                </form></li>
                <li><form action="/list" >
                    <button type="submit" value="DRINK" name="type">Напитки</button>
                </form></li>
                <li><form action="/list" >
                    <button type="submit" value="DESERT" name="type">Десерты</button>
                </form></li>
                <li><form action="/list" >
                    <button type="submit" value="WOK" name="type">Вок</button>
                </form></li>
                <li><form action="/list" >
                    <button type="submit" value="ANOTHER" name="type">Дополнительно</button>
                </form></li>
            </ul>
        </nav>
    </header>
    <div class="content clearfix">
        <div class="breadcrumbs">
            <ul>
                <li><a href="#">Home</a></li>
                <li>Entrees</li>
            </ul>
        </div>
        <div class="left-content">
        <#--<div class="paging">-->
        <#--<ul>-->
        <#--<li class="prev"><a href="#">prev</a></li>-->
        <#--<li><a href="#">1</a></li>-->
        <#--<li><a href="#">2</a></li>-->
        <#--<li  class="active"><a href="#">3</a></li>-->
        <#--<li><a href="#">4</a></li>-->
        <#--<li><a href="#">5</a></li>-->
        <#--<li class="next"><a href="#">next</a></li>-->
        <#--</ul>-->
        <#--</div>-->

            <div class="meals-listing">
                <ul>
                <#list products as p >
                    <li class="meal-details">
                        <div class="image"><img src=${p.getPhoto()} alt=""></div>
                        <div class="info">
                            <div class="descr-holder">
                                <h3><a href="single.html">${p.getName()}</a></h3>
                                <div class="date_categories"></div>
                                <p>${p.getDescription()} </p>
                            </div>
                            <span class="price">${p.getPrice()}</span>
                            <a href="check-out.html" class="add-to-cart-button">add to cart</a>

                        </div>
                    </li>
                </#list>
                </ul>
            </div>

        <#--<div class="paging mar-t-20">-->
        <#--<ul>-->
        <#--<li class="prev"><a href="#">prev</a></li>-->
        <#--<li><a href="#">1</a></li>-->
        <#--<li><a href="#">2</a></li>-->
        <#--<li class="active"><a href="#">3</a></li>-->
        <#--<li><a href="#">4</a></li>-->
        <#--<li><a href="#">5</a></li>-->
        <#--<li class="next"><a href="#">next</a></li>-->
        <#--</ul>-->
        <#--</div>-->
        </div>
        <div class="right-content">
            <div class="call-us">
                <span class="label">Call us now!</span>
                <span class="pop phone">0800/ 567 345</span>
                <span class="label">Working time:</span>
                <span class="pop">0-24h</span>
            </div>

            <div class="cart-box">
                <div class="top">Cart</div>
                <div class="body">
                    <ul>
                        <li class="info">
                            <span class="products"><strong>5</strong> products</span>
                            <a href="#">View cart</a>
                        </li>
                        <li class="price">
                            <span class="label">Shipping</span>
                            <span class="value">$0.00</span>
                        </li>
                        <li class="price">
                            <span class="label">Total</span>
                            <span class="value">$0.00</span>
                        </li>
                    </ul>
                    <a class="submit-button" href="check-out.html">Check out</a>
                    <div class="graphic"></div>
                </div>
            </div>

            <div class="separator dark box-and-meals"></div>

            <div class="featured-meals">

                <h2 class="heading">Featured meals</h2>

                <div class="prev-next-buttons">
                    <a href="#" class="prev"></a>
                    <a href="#" class="next"></a>
                </div>

                <div class="block meal">
                    <ul>
                    <#list productsFeatured as prodFeatured>
                        <li class="meal">
                            <div class="img-holder"><img src=${prodFeatured.getPhoto()} alt=""></div>
                            <h1><a href="#">${prodFeatured.getName()}</a></h1>
                            <p>${prodFeatured.getDescription()}</p>
                            <span class="price">${prodFeatured.getPrice()}</span>
                            <a href="check-out.html" class="add-to-cart-button">add to cart</a>
                        </li>
                    </#list>

                    </ul>
                </div>
            </div>
        </div>
    </div>
</div>
<footer>
    <div class="footer-holder">
        <a href="" class="logo">Cooker Logo</a>
        <div class="newsletter">
            <div class="quote">
                <h6>Newsletter</h6>
                <p>Sign-up for our newsletter and be always aware of the new offers and services:</p>
                <form method="post">
                    <input type="text" placeholder="Email"><input type="submit" value="Submit" class="submit-button">
                </form>
            </div>
        </div>
        <div class="links first">
            <h6>follow us on...</h6>
            <ul>
                <li class="facebook"><a href="#">Facebook</a></li>
                <li class="twitter"><a href="#">Twitter</a></li>
                <li class="rss"><a href="#">Rss feed</a></li>
            </ul>
        </div>
        <div class="links">
            <h6>useful links</h6>
            <ul>
                <li><a href="#">Specials</a></li>
                <li><a href="#">New orders</a></li>
                <li><a href="#">Terms and conditions of use</a></li>
                <li><a href="#">About</a></li>
                <li><a href="#">Contact</a></li>
                <li><a href="#">Sitemap</a></li>
            </ul>
        </div>
        <div class="links">
            <h6>categories</h6>
            <ul>
                <li><a href="#">Fruits and vegetables</a></li>
                <li><a href="#">Seafood</a></li>
                <li><a href="#">Meat</a></li>
                <li><a href="#">Entrees</a></li>
                <li><a href="#">Pizza and pasta</a></li>
                <li><a href="#">Desserts</a></li>
            </ul>
        </div>
        <div class="credits clearfix">
            Copyright &copy; 2011 Cooker. All rights reserved
        </div>
    </div>
</footer>
</body>
<script type="text/javascript" src="../js/libs/jquery-1.7.1.min.js"></script>
<script src="../js/libs/jquery.easing.1.3.js"></script>
<script src="../js/script.js"></script>
<script src="../js/libs/jquery.jcarousel.min.js"></script>
</html>