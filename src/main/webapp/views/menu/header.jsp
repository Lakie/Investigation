<%--
 Created by IntelliJ IDEA.
 User: Slavyanin
 Date: 21.07.2015
 Time: 18:28
 To change this template use File | Settings | File Templates.
--%>
<%@ page pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div id="header">
    <div>
        <h1><a href="#">Lakie</a> <span>Your header here</span></h1>
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
    </div>
    <div id="locale">
        <a href="?locale=ua" class="flag flag-ua"><img src="/img/blank.gif" class="flag flag-ua" alt="Ukrainian" /></a>
        <a href="?locale=ru" class="flag flag-ua"><img src="/img/blank.gif" class="flag flag-ru" alt="Russian" /></a>
        <a href="?locale=en" class="flag flag-ua"><img src="/img/blank.gif" class="flag flag-gb" alt="English" /></a>
    </div>
</div>
<!-- end header -->










