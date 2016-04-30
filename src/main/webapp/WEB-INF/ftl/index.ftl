<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="${ctx}/bootstrap/css/bootstrap.css"/>
    <link rel="stylesheet" type="text/css" href="${ctx}/bootstrap/css/bootstrap-theme.css"/>
    <script type="text/javascript" src="${ctx}/bootstrap/js/jquery.min.js"></script>
    <script type="text/javascript" src="${ctx}/bootstrap/js/bootstrap.js"></script>
    <title>${title}</title>
</head>
<body>
    <#import "pagin.ftl" as my/>
    <div class="alert alert-danger">home page</div>
    <@userInfo userName = "${username!}" pageNo = "${pageNo}" pageSize = "${pageSize}"></@userInfo>
    <#include "content.ftl" />
    <p>
        ${content}
    </p>
    <@my.pager pageNo pageSize "${ctx}${url}" recordCount />
</body>
</html>