<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Space</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <!-- Le styles -->
    <link href="resources/css/bootstrap.css" rel="stylesheet">
    <link href="resources/css/bootstrap-responsive.css" rel="stylesheet">
    <link href="resources/css/style.css" rel="stylesheet">

    <!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
    <script src="//html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->

    <!-- Le fav and touch icons -->
    <%--<link rel="shortcut icon" href="images/favicon.ico">--%>
    <link rel="apple-touch-icon" href="images/apple-touch-icon.png">
    <link rel="apple-touch-icon" sizes="72x72" href="images/apple-touch-icon-72x72.png">
    <link rel="apple-touch-icon" sizes="114x114" href="images/apple-touch-icon-114x114.png">
</head>

<body>
<%@ page isELIgnored ="true" %>
<div class="navbar">
    <div class="navbar-inner">
        <div class="container">
            <a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </a>
            <a class="brand" href="#">Space</a>
            <div class="nav-collapse">
                <ul class="nav">
                    <li class="active"><a href="#">Dashboard</a></li>
                    <li><a href="#about">Statistics</a></li>
                    <li><a href="#contact">Settings</a></li>
                </ul>
                <form class="navbar-search pull-left">
                    <input type="text" class="search-query" placeholder="Search">
                </form>
                <ul class="nav pull-right">
                    <li class="divider-vertical"></li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">User <b class="caret"></b></a>
                        <ul class="dropdown-menu">
                            <li><a href="#">Profile</a></li>
                            <li><a href="#">Settings</a></li>
                            <li class="divider"></li>
                            <li><a href="#">Logout</a></li>
                        </ul>
                    </li>
                </ul>
            </div><!--/.nav-collapse -->
        </div>
    </div>
</div>

<!-- Columns menu -->
<div class="columns-menu">

    <ul class="container columns-menu-list">
        <li><a href="#" class="btn btn-primary btn-mini">Backlog</a></li>
        <li><a href="#" class="btn btn-primary btn-mini">In progress</a></li>
        <li><a href="#" class="btn btn-primary btn-mini">Done</a></li>
        <li class="new-story"><a href="#stories/new" class="btn btn-warning btn-mini">Add story +</a></li>
    </ul>

</div>

<div class="container">
    <!-- Example row of columns -->
    <div id="dashboard">

        <div class="column">
            <h4>Backlog</h4>
            <div class="story">
                <div class="story-content">
                    <span class="story-number">120</span>
                    <a href="#stories/1" class="story-title">
                        Donec id elit non mi porta gravida at eget metus.
                    </a>
                    <div class="story-links">
                        <span>5p</span><a class="user-link" href="/users/1">FN</a>
                    </div>
                </div>
            </div>
            <div class="story">
                <div class="story-content">
                    <span class="story-number">122</span>
                    <a data-toggle="modal" href="#myModal" class="story-title">
                        Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh. Etiam porta sem malesuada magna mollis euismod.
                    </a>
                    <div class="story-links">
                        <span>5p</span><a class="user-link" href="/users/1">FN</a>
                    </div>
                </div>
            </div>
        </div>
        <div class="column">
            <h4>In progress</h4>
            <div class="story">
                <div class="story-content">
                    <span class="story-number">123</span>
                    <a data-toggle="modal" href="#myModal" class="story-title">
                        Donec id elit non mi porta gravida at eget metus. Donec sed odio dui.
                    </a>
                    <div class="story-links">
                        <span>5p</span><a class="user-link" href="/users/1">FN</a>
                    </div>
                </div>
            </div>
        </div>
        <div class="column">
            <h4>Done</h4>
            <div class="story">
                <div class="story-content">
                    <span class="story-number">124</span>
                    <a href="#" class="story-title">
                        Donec id edivt non mi porta gravida at eget metus. Etiam porta sem malesuada magna moldivs euismod. Donec sed odio dui.
                    </a>
                    <div class="story-links">
                        <span>5p</span><a class="user-link" href="/users/1">FN</a>
                    </div>
                </div>
            </div>
        </div>

    </div>

</div> <!-- /container -->

<!-- Templates -->
<div class="modal hide fade in" id="story-modal"></div>

<script type="text/template" id="StoryTemplate">
    <div class="modal-header">
        <a href="#" class="close" data-dismiss="modal">&#120;</a>
        <h3>
            <span class="title"><@= title @></span>
            <input type="text" name="title" class="title-input hide span3" value="<@= title @>">
        </h3>
    </div>
    <div class="modal-body">
        <p>
            <span class="description"><@= description @></span>
            <textarea name="description" class="description-input hide span3"><@= description @></textarea>
        </p>
    </div>
</script>

<script type="text/template" id="NewStoryTemplate">
    <div class="modal-header">
        <a href="#" class="close" data-dismiss="modal">&#120;</a>
        <h3>
            New story
        </h3>
    </div>
    <div class="modal-body">
        <p>
            <form class="story-form">
                <label>Title</label>
                <input type="text" name="title" class="span3" placeholder="Type title...">
                <label>Description</label>
                <textarea name="description" class="span3" placeholder="Type description..."></textarea>
                <br/>
                <button type="submit" class="btn save">Add</button>
            </form>
        </p>
    </div>
</script>

<!-- Le javascript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="resources/js/libs/jquery.js"></script>
<script src="resources/js/libs/bootstrap-transition.js"></script>
<script src="resources/js/libs/jquery-ui.custom.min.js"></script>
<script src="resources/js/libs/bootstrap-alert.js"></script>
<script src="resources/js/libs/bootstrap-modal.js"></script>
<script src="resources/js/libs/bootstrap-dropdown.js"></script>
<script src="resources/js/libs/bootstrap-scrollspy.js"></script>
<script src="resources/js/libs/bootstrap-tab.js"></script>
<script src="resources/js/libs/bootstrap-tooltip.js"></script>
<script src="resources/js/libs/bootstrap-popover.js"></script>
<script src="resources/js/libs/bootstrap-button.js"></script>
<script src="resources/js/libs/bootstrap-collapse.js"></script>
<script src="resources/js/libs/bootstrap-carousel.js"></script>
<script src="resources/js/libs/bootstrap-typeahead.js"></script>
<script src="resources/js/libs/json2.js"></script>
<script src="resources/js/libs/underscore-1.3.1.js"></script>
<script src="resources/js/libs/backbone-0.9.1.js"></script>
<script src="resources/js/app/models.js"></script>
<script src="resources/js/app/views.js"></script>
<script src="resources/js/app/router.js"></script>
<script src="resources/js/dragable-stories.js"></script>
<script src="resources/js/application.js"></script>

</body>
</html>
