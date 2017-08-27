<%@ page import="java.util.Enumeration" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>MrMat :: Hello Java :: Java EE :: JSP</title>

    <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.2.13/semantic.min.css"/>
</head>
<body>
    <div class="ui container">
        <h1 class="ui header">Request</h1>
        <table class="ui tiny celled table">
            <thead>
            <tr><th>Property</th><th>Value</th></tr>
            </thead>
            <tbody>
            <tr><td>Auth Type</td><td><%= request.getAuthType() %></td></tr>
            <tr><td>Context Path</td><td><%= request.getContextPath() %></td></tr>
            <tr><td>Path Info</td><td><%= request.getPathInfo() %></td></tr>
            <tr><td>Path Translated</td><td><%= request.getPathTranslated() %></td></tr>
            <tr><td>Query String</td><td><%= request.getQueryString() %></td></tr>
            <tr><td>Method</td><td><%= request.getMethod() %></td></tr>
            <tr><td>Remote User</td><td><%= request.getRemoteUser() %></td></tr>
            <tr><td>Requested Session Id</td><td><%= request.getRequestedSessionId()%></td></tr>
            <tr><td>Request URI</td><td><%= request.getRequestURI() %></td></tr>
            <tr><td>Request URL</td><td><%= request.getRequestURL().toString() %></td></tr>
            <tr><td>Is Requested Session From Cookie</td><td><%= request.isRequestedSessionIdFromCookie() %></td></tr>
            <tr><td>Is Requested Session from URL</td><td><%= request.isRequestedSessionIdFromURL()%></td></tr>
            </tbody>
        </table>

        <h1 class="ui header">Headers</h1>
        <table class="ui tiny celled table">
            <thead>
            <tr><th>Header</th><th>Value</th></tr>
            </thead>
            <tbody>
            <%
                final Enumeration<String> headerNames = request.getHeaderNames();
                while(headerNames.hasMoreElements()) {
                    String header = headerNames.nextElement();
                    out.println("<tr><td>" + header + "</td><td>" + request.getHeader(header));
                }
            %>
            </tbody>
        </table>

        <h1 class="ui header">Session</h1>
        <table class="ui tiny celled table">
            <thead>
            <tr><th>Attribute</th><th>Value</th></tr>
            </thead>
            <tbody>
            <%
                final Enumeration<String> attributeNames = request.getSession().getAttributeNames();
                while(attributeNames.hasMoreElements()) {
                    String attr = attributeNames.nextElement();
                    out.println("<tr><td>" + attr + "</td><td>" + request.getSession().getAttribute(attr) + "</td></tr>");
                }
            %>
            </tbody>
        </table>
    </div>
</body>
</html>
