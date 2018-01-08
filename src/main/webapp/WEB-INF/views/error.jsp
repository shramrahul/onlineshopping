<%--
  Created by IntelliJ IDEA.
  User: shram
  Date: 12/28/2017
  Time: 2:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<spring:url var="css" value="/resources/css"/>
<c:set var="context" value="${pageContext.request.contextPath}"/>



<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>OnlineShopping- ${title}</title>

    <script>
        window.menu='${title}';
        window.contextRoot='${contextRoot}'
    </script>
    <!-- Bootstrap core CSS -->
    <link href="${css}/bootstrap.min.css" rel="stylesheet">

    <!-- Bootstrap datatable  CSS -->
    <link href="${css}/dataTables.bootstrap.css" rel="stylesheet">

    <!-- Bootstrap bootswatch-theme CSS -->
    <%--<link href="${css}/bootstrap.theme.css" rel="stylesheet">--%>

    <!-- Custom styles for this template -->
    <link href="${css}/myapp.css" rel="stylesheet">

</head>

<body>

<div class="wrapper">
    <!-- Navigation -->
   <div class="wrapper">

       <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
           <div class="container">

               <div class="collapse navbar-collapse" id="navbarResponsive">
                   <ul class="navbar-nav ml-auto">
                       <li class="nav-item" id="home">
                           <a class="nav-link" href="${contextRoot}/home">Home</a>
                       </li>
                   </ul>
               </div>
           </div>
       </nav>

       <div class="content">
           <div class="container">
               <div class="row">
                   <div class="col-xs-12">

                       <div class="jumbotron">
                           <h1>${errorTitle}</h1>
                           <hr/>

                           <blockquote>
                               ${errorDescription}
                           </blockquote>
                       </div>

               </div>
           </div>
       </div>


   </div>
    <!-- Footer -->
    <%@include file="shared/footer.jsp"%>

    <!-- Bootstrap core JavaScript -->
    <script src="${js}/jquery.min.js" type="text/javascript"></script>
    <script src="${js}/bootstrap.min.js" type="text/javascript"></script>

    <!-- Data Table plugin-->
    <script src="${js}/jquery.dataTables.js" type="text/javascript"></script>

    <%--<!-- Data Table js-->--%>
    <%--<script src="${js}/dataTables.bootstrap.js"></script>--%>

    <script src="${js}/myapp.js" type="text/javascript"></script>

    <script src="${js}/table.js" type="text/javascript"></script>



</div>

</body>

</html>

