 <%--
  Created by IntelliJ IDEA.
  User: Slavyanin
  Date: 21.07.2015
  Time: 18:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <div id="header">
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
    </div><!-- end header -->










