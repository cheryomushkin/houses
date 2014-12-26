<!DOCTYPE html>
<!--[if lt IE 7 ]> <html lang="en" class="no-js ie6"> <![endif]-->
<!--[if IE 7 ]> <html lang="en" class="no-js ie7"> <![endif]-->
<!--[if IE 8 ]> <html lang="en" class="no-js ie8"> <![endif]-->
<!--[if IE 9 ]> <html lang="en" class="no-js ie9"> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!-->
<html lang="en" class="no-js" ng-csp><!--<![endif]-->
<head lang="en">
    <meta charset="utf-8">
    <title>Houses</title>
    <link rel="stylesheet" href="/webjars/bootstrap/3.3.1/css/bootstrap.css">
    <link rel="stylesheet" href="/webjars/font-awesome/4.2.0/css/font-awesome.css">
    <link rel="stylesheet" href="/resources/css/application.css">
    <script data-main="/resources/js/core.js" src="/webjars/requirejs/2.1.15/require.js"></script>
    <base href="/"/>
</head>
<body role="document" ng-controller="AppController">
<nav class="navbar navbar-default navbar-fixed-top" role="navigation">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a ui-sref="index" class="navbar-brand">Houses</a>
        </div>

        <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
                <%--some menu is here--%>
            </ul>
        </div>
    </div>
</nav>
<div class="container main-container" style="margin-top: 75px" hidden="hidden">
    <div class="row">
        <div class="col-md-12">
            <h1 class="text-center">{{_page.header}}</h1>
        </div>
    </div>
    <div class="row" style="margin-top: 50px;">
        <div class="col-md-12">
            <div ui-view></div>
        </div>
    </div>
</div>
</body>