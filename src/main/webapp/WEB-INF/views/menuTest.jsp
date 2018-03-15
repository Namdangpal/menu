<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>jQuery TreeGrid Unit tests</title>
    </head>
    <body>            
        <hr>
        Event tests
        <table id='tree-4' border="1" cellpadding="0" cellspacing="0">
            <tr>
                <th>1</th><th>2</th>
            </tr>
            <tr class="treegrid-alfa1" id="anode-1">
                <td>1</td><td>Simple text of ...</td>
            </tr>
            <tr class="treegrid-alfa2 treegrid-parent-alfa1" id="anode-1-1">
                <td>1.1</td><td>Simple text of ...</td>
            </tr>
            <tr class='treegrid-alfa3 treegrid-parent-alfa2' id="anode-1-1-1">
                <td>1.1.1</td><td>Simple text of ...</td>
            </tr>
            <tr class='treegrid-alfa9 treegrid-parent-alfa2' id="anode-1-1-2">
                <td>1.1.2</td><td>Simple text of ...</td>
            </tr>
            <tr class='treegrid-alfa10 treegrid-parent-alfa9' id="anode-1-1-2-1">
                <td>1.1.2.1</td><td>Simple text of ...</td>
            </tr>
            <tr class='treegrid-alfa4 treegrid-parent-alfa1' id="anode-1-2">
                <td>1.2</td><td>Simple text of ...</td>
            </tr>
            <tr class='treegrid-alfa5 treegrid-parent-alfa1' id="anode-1-3">
                <td>1.3</td><td>Simple text of ...</td>
            </tr>
            <tr class='treegrid-alfa6 treegrid-parent-alfa5' id="anode-1-3-1">
                <td>1.3.1</td><td>Simple text of ...</td>
            </tr>
            <tr class='treegrid-alfa7 treegrid-parent-alfa1' id="anode-1-4">
                <td>1.4</td><td>Simple text of ...</td>
            </tr>
            <tr class='treegrid-alfa8 treegrid-parent-alfa7' id="anode-1-4-1">
                <td>1.4.1</td><td>Simple text of ...</td>
            </tr>
            <tr class="treegrid-alfa11" id="anode-2">
                <td>2</td><td>Simple text of ...</td>
            </tr>
        </table>

        <hr>
        <link rel="stylesheet" href="/js/qunit-1.12.0.css">
        <link rel="stylesheet" href="/css/jquery.treegrid.css">
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
        <script src="js/jquery.treegrid.min.js"></script>
        <script src="js/jquery.cookie.js"></script>
        <script>
            var globalCounter = 0;
            var saveStateName = 'state-save-4';
            $("#tree-1").treegrid({initialState: 'collapsed'});
            $("#tree-2").treegrid({treeColumn: 1, initialState: 'expanded', 'saveState': true, 'saveStateName': saveStateName});
            $("#tree-3").treegrid({initialState: 'collapsed'});
            $("#tree-4").treegrid({onChange: function() {
                    globalCounter++;
                }, onCollapse: function() {
                    globalCounter++;
                }, onExpand: function() {
                    globalCounter++;
                }});
        </script>
        <script src="js/qunit-1.12.0.js"></script>
        <script src="js/tests.js"></script>

    </body>
</html>
