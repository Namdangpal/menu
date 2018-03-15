<%@ page language="java" contentType="text/html; charset=UTF-8"     pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
 
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="chrome=1">
        <title>TreeGrid events example</title>

        <link rel="stylesheet" href="/css/styles.css">
        <link rel="stylesheet" href="http://yandex.st/highlightjs/7.3/styles/default.min.css">
        <link rel="stylesheet" href="/css/jquery.treegrid.css">

        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
        <script type="text/javascript" src="/js/jquery.treegrid.js"></script>
        <script type="text/javascript">
            $(document).ready(function() {
                $('.tree').treegrid({
                    onChange: function() {
                        //alert("Changed: " + $(this).attr("id"));
                    },
                    onCollapse: function() {
                        //alert("Collapsed " + $(this).attr("id"));
                    },
                    onExpand: function() {
                        //alert("Expanded: " + $(this).attr("id"));
                    }});
                $('#node-1').on("change", function() {
                    //alert("Event from " + $(this).attr("id"));
                });
            });
        </script>


        <script src="http://yandex.st/highlightjs/7.3/highlight.min.js"></script>
        <script>hljs.initHighlightingOnLoad();</script>
        <script>
            (function(i, s, o, g, r, a, m) {
                i['GoogleAnalyticsObject'] = r;
                i[r] = i[r] || function() {
                    (i[r].q = i[r].q || []).push(arguments)
                }, i[r].l = 1 * new Date();
                a = s.createElement(o),
                        m = s.getElementsByTagName(o)[0];
                a.async = 1;
                a.src = g;
                m.parentNode.insertBefore(a, m)
            })(window, document, 'script', '//www.google-analytics.com/analytics.js', 'ga');

            ga('create', 'UA-43342702-1', 'maxazan.github.io');
            ga('send', 'pageview');

        </script>
        <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no">
        <!--[if lt IE 9]>
        <script src="//html5shiv.googlecode.com/svn/trunk/html5.js"></script>
        <![endif]-->
    </head>
    <body>
        <div class="wrapper">


            <h1><a href="http://maxazan.github.io/jquery-treegrid/">TreeGrid</a> events example</h1>

            <table class="tree">
                <tr id="node-1" class="treegrid-1">
                    <td>Root node</td><td>Additional info</td>
                </tr>
                <tr id="node-1-1" class="treegrid-2 treegrid-parent-1">
                    <td>Node 1-1</td><td>Additional info</td>
                </tr>
                <tr id="node-1-2" class="treegrid-3 treegrid-parent-1">
                    <td>Node 1-2</td><td>Additional info</td>
                </tr>
                <tr id="node-1-2-1" class="treegrid-4 treegrid-parent-3">
                    <td>Node 1-2-1</td><td>Additional info</td>
                </tr>
            </table>	  

            <h2>Code</h2>

            <pre>
<code class='html'>
&lt;!doctype html&gt;
&lt;html&gt;
  &lt;head&gt;
    &lt;meta charset=&quot;utf-8&quot;&gt;
    &lt;meta http-equiv=&quot;X-UA-Compatible&quot; content=&quot;chrome=1&quot;&gt;
    &lt;title&gt;Jquery-treegrid basic example&lt;/title&gt;

    &lt;link rel=&quot;stylesheet&quot; href=&quot;../css/jquery.treegrid.css&quot;&gt;

    &lt;script src=&quot;http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js&quot;&gt;&lt;/script&gt;
    &lt;script type=&quot;text/javascript&quot; src=&quot;../js/jquery.treegrid.js&quot;&gt;&lt;/script&gt;
    &lt;script type=&quot;text/javascript&quot;&gt;
      $(document).ready(function() {
            $('.tree').treegrid({
            onChange: function() {
                alert("Changed: "+$(this).attr("id"));
            }, 
            onCollapse: function() {
                alert("Collapsed: "+$(this).attr("id"));
            }, 
            onExpand: function() {
                alert("Expanded "+$(this).attr("id"));
            }});
            $('#node-1').on("change", function() {
                alert("Event from " + $(this).attr("id"));
            });            
      });
    &lt;/script&gt;

  &lt;/head&gt;
  &lt;body&gt;

      &lt;table class=&quot;tree&quot;&gt;
        &lt;tr class=&quot;treegrid-1&quot;&gt;
          &lt;td&gt;Root node&lt;/td&gt;&lt;td&gt;Additional info&lt;/td&gt;
        &lt;/tr&gt;
        &lt;tr class=&quot;treegrid-2 treegrid-parent-1&quot;&gt;
          &lt;td&gt;Node 1-1&lt;/td&gt;&lt;td&gt;Additional info&lt;/td&gt;
        &lt;/tr&gt;
        &lt;tr class=&quot;treegrid-3 treegrid-parent-1&quot;&gt;
          &lt;td&gt;Node 1-2&lt;/td&gt;&lt;td&gt;Additional info&lt;/td&gt;
        &lt;/tr&gt;
        &lt;tr class=&quot;treegrid-4 treegrid-parent-3&quot;&gt;
          &lt;td&gt;Node 1-2-1&lt;/td&gt;&lt;td&gt;Additional info&lt;/td&gt;
        &lt;/tr&gt;
      &lt;/table&gt;	  

  &lt;/body&gt;
&lt;/html&gt;
</code>
            </pre>
        </div>

        <script type="text/javascript">
            var metas = document.getElementsByTagName('meta');
            var i;
            if (navigator.userAgent.match(/iPhone/i)) {
                for (i = 0; i < metas.length; i++) {
                    if (metas[i].name == "viewport") {
                        metas[i].content = "width=device-width, minimum-scale=1.0, maximum-scale=1.0";
                    }
                }
                document.addEventListener("gesturestart", gestureStart, false);
            }
            function gestureStart() {
                for (i = 0; i < metas.length; i++) {
                    if (metas[i].name == "viewport") {
                        metas[i].content = "width=device-width, minimum-scale=0.25, maximum-scale=1.6";
                    }
                }
            }</script>

    </body>
</html>