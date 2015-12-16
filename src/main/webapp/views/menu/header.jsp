<%--
  Created by IntelliJ IDEA.
  User: Slavyanin
  Date: 21.07.2015
  Time: 18:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<div id="layout1">
    <div id="header">
        <h1><a href="#">Company<strong>Name</strong></a> <span>Your Slogan Goes Here</span></h1>
        <a href="#" class="rss">RSS</a>
        <form id="searchform" method="get" action="post">
            <div>
                <input
                        type="text"
                        onblur="this.value=(this.value=='') ? 'Search' : this.value;"
                        onfocus="this.value=(this.value=='Search') ? '' : this.value;"
                        maxlength="150"
                        value="Search"
                        name="search"
                        class="searchfield"
                        />
                <input
                        type="submit"
                        class="sbutt"
                        value="GO"
                        />
            </div>
        </form>
    </div><!-- end header -->

    <div class="containerleft">
        <div id="menu">
            <ul>
                <li><a href="#">About Us</a></li>
                <li><a href="#">Services</a></li>
                <li><a href="#">Portfolio</a></li>
                <li><a href="#">Our Blog</a></li>
                <li><a href="#">Contact Us</a></li>
            </ul>
        </div><!-- end menu -->
        <h4>Our Clients</h4>
        <p class="white mb30 pr20">Lorem ipsum dolor sit amet sectetuer adipiscing.</p>
        <img src="img/z-logo1.gif" alt="" />
        <img src="img/z-logo2.gif" alt="" />
        <img src="img/z-logo3.gif" alt="" />
        <img src="img/z-logo4.gif" alt="" />
    </div><!-- end containerleft -->

    <div class="containercenter">
        <div class="promo">
            <div>
                <h2>
                    We Made a Fresh Business Solutions!
                </h2>
                <a class="linkgreen" href="#">Learn&nbsp;More...</a>
            </div>
            <img src="img/promo.jpg" alt="" />
        </div><!-- end promo -->
        <div class="pl20-pr20-pb40">
            <div class="w280 pt35 right absolute">
                <a class="linkgreen" href="#">Archive</a>
            </div><!-- end w280 -->
            <h4>
                Our Blog
            </h4>
            <h3>
                <a class="white invert" href="#">
                    Lorem ipsum dolor sit amet consectetuer
                </a>
            </h3>
            <div>
                <img class="b3dark absolute mt3" src="img/user50.gif" alt="" />
                <p class="blogpost">
                    Praesent egestas ullamcorper arcu. Maecenas sit amet turpis. Aliquam pretium quam ac pede. Mauris eget orci id leo rhoncus volutpat.
		<span class="pt5 block">
		<a class="lblue" href="#">
            Read&nbsp;More...
        </a>
		</span><!-- end pt5 -->
                    <span class="f9 block lh1 bt1dark">Autor: iGor</span>
                    <span class="f9 block lh1 pt5">Date: December 24th, 2008</span>
                    <span class="f9 block lh1 pt5 lbluelink">Tags: <a href="#">fames</a>, <a href="#">ac turpis</a>, <a href="#">egestas</a></span>
                </p>
            </div>
        </div><!-- end pl20-pr20 -->
    </div><!-- end containercenter -->

    <div class="containerright">
        <div class="slider">
            <ul id="slideshow">
                <li>
                    <h3>WP Theme Typographicus Clouds</h3>
                    <span>img/z1.jpg</span>
                    <p>A stylish theme with 2 columns, gravatars and widget support. <a href="#">More...</a></p>
                    <a href="#"><img src="" alt=""/></a>
                </li>
                <li>
                    <h3>WP Theme Typographicus Black</h3>
                    <span>img/z2.jpg</span>
                    <p>This theme is a widget ready clean, crisp WordPress blog layout with three design variations that is easy to customize and use. <a href="#">More...</a></p>
                    <a href="#"><img src="thumbnails/image-one.jpg" alt=""/></a>
                </li>
                <li>
                    <h3>WP Theme Typographicus White</h3>
                    <span>img/z3.jpg</span>
                    <p>Typographicus designed to be used as personal blog. <a href="#">More...</a></p>
                    <a href="#"><img src="thumbnails/image-one.jpg" alt=""/></a>
                </li>
            </ul>
            <div id="wrapper">
                <div id="fullsize">
                    <div id="imgprev" class="imgnav" title="Previous Image"></div>
                    <div id="imglink"></div>
                    <div id="imgnext" class="imgnav" title="Next Image"></div>
                    <div id="image"></div>
                    <div id="information">
                        <h3><!-- --></h3>
                        <p><!-- --></p>
                    </div>
                </div>
                <div id="thumbnails">
                    <div id="slideleft" title="Slide Left"><!-- --></div>
                    <div id="slidearea">
                        <div id="slider"><!-- --></div>
                    </div>
                    <div id="slideright" title="Slide Right"></div>
                </div>
            </div>
        </div><!-- end slider -->

        <div class="pl30">
            <div class="w410 pt35 right absolute">
                <a class="linkgreen" href="#">Learn&nbsp;More...</a>
            </div><!-- end w280 -->
            <h4>
                Services
            </h4>
            <p class="white mb30 pr20">
                Lorem ipsum dolor sit amet consectetuer adipiscing elit nunc ullamcorper blandit urna. Sed facilisis accumsan nisi. Ut mattis libero quis sapien. Integer fermentum.
            </p>
            <ol class="f12 lh15 m0 bt1dark2">
                <li class="bb1dot pb15 mb12">
			<span class="white block f16 bold pb5">
			<a class="white invert" href="#">
                Web Design
            </a>
			</span>
                    Lorem ipsum dolor sit amet consectetuer adipiscing elit nunc ullamcorper blandit urna. Sed facilisis accumsan nisi. Ut mattis libero quis sapien.
                    <a class="lblue" href="#">
                        Learn&nbsp;More...
                    </a>
                </li>
                <li class="bb1dot pb15 mb12">
			<span class="white block f16 bold pb5">
			<a class="white invert" href="#">
                Web Development
            </a>
			</span>
                    Integer fermentum venenatis libero. Integer luctus, mi ut pretium ullamcorper, nibh lorem volutpat odio, id facilisis diam metus non libero.
                    <a class="lblue" href="#">
                        Learn&nbsp;More...
                    </a>
                </li>
                <li class="bb1dot pb15 mb12">
			<span class="white block f16 bold pb5">
			<a class="white invert" href="#">
                Internet Marketing
            </a>
			</span>
                    Ut placerat tellus sed neque. Mauris sit amet mi. Vivamus commodo. Nam pharetra suscipit leo. Morbi ut turpis. Nulla facilisi. Duis non lacus.
                    <a class="lblue" href="#">
                        Learn&nbsp;More...
                    </a>
                </li>
            </ol>
        </div><!-- end pl30 -->
    </div><!-- end containerright -->

    <div class="clear"><!-- --></div>
</div><!-- end layout -->
