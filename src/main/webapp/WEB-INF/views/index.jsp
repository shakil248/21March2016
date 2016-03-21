<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html ng-app="loginApp">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<!-- <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular.js"></script> -->

<spring:url value="/resources/lib/angular/angular.js" var="angularJS" />
<spring:url value="/resources/lib/angular/angular-route.js" var="angularRouteJS" />
<spring:url value="/resources/js/app.js" var="appJS" />
<spring:url value="/resources/js/directives/loginDirective.js" var="loginDirectiveJS" />
<spring:url value="/resources/js/directives/userDirective.js" var="userDirectiveJS" />
<spring:url value="/resources/js/directives/otpDirective.js" var="otpDirectiveJS"/>
<spring:url value="/resources/js/controllers/loginCtrl.js" var="loginCtrlJS" />
<spring:url value="/resources/js/controllers/userCtrl.js" var="userCtrlJS" />
<spring:url value="/resources/js/controllers/otpCtrl.js" var="otpCtrlJS" />
<spring:url value="/resources/js/services/loginService.js" var="loginServiceJS" />
<spring:url value="/resources/js/services/sessionService.js" var="sessionServiceJS" />
<spring:url value="/resources/js/services/userService.js" var="userServiceJS" />

    <spring:url value="/resources/js/directives/adminDirective.js" var="adminDirectiveJS" />
    <spring:url value="/resources/js/controllers/adminCtrl.js" var="adminCtrlJS" />
    <spring:url value="/resources/js/services/adminService.js" var="adminServiceJS" />



<script src="${angularJS}"></script>
<script src="${angularRouteJS}"></script>
<script src="${appJS}"></script>
<script src="${loginDirectiveJS}"></script>
<script src="${userDirectiveJS}"></script>
<script src="${otpDirectiveJS}"></script>
<script src="${loginCtrlJS}"></script>
<script src="${userCtrlJS}"></script>
<script src="${otpCtrlJS}"></script>
<script src="${loginServiceJS}"></script>
<script src="${sessionServiceJS}"></script>
<script src="${userServiceJS}"></script>

    <script src="${adminDirectiveJS}"></script>
    <script src="${adminCtrlJS}"></script>
     <script src="${adminServiceJS}"></script>

</head>
<body   >
<div ng-view></div>

</body>
</html>