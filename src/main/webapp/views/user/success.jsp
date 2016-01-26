<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN" "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page session="false" %>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head profile="http://gmpg.org/xfn/11">
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
  <meta name="distribution" content="global"/>
  <meta name="robots" content="follow, all"/>
  <meta name="language" content="en, fr, de, ru"/>

  <title><spring:message code="label.form.title"></spring:message></title>
  <meta name="generator" content=""/>
  <link rel="Shortcut Icon" href="../../img/favicon.ico" type="image/x-icon"/>

  <style type="text/css" media="all">@import "../../css/style.css";</style>
  <style type="text/css" media="all">@import "../../css/flags.css";</style>
  <!--[if IE]>
  <link href="../css/ie.css" rel="stylesheet" type="text/css"><![endif]-->
  <script type="text/javascript">
    <!--
    if (window.opera) {
      document.write('<link rel="stylesheet" type="text/css" href="../../css/opera.css" />');
    }
    //-->
  </script>
  <script type="text/javascript" src="../../js/compressed.js"></script>
</head>
<body>
<div id="layout1">
  <jsp:include page="../menu/header.jsp"/>
  <div class="containercontent">
    <jsp:include page="../menu/leftMenu.jsp"/>
    <div class="content">
      <H2>
        <spring:message code="label.registration.success.title"></spring:message>
      </H2>

      <spring:message code="label.registration.success.content"></spring:message>

    </div>
  </div>

</div>
<jsp:include page="../menu/footer.jsp"/>
</body>
</html>