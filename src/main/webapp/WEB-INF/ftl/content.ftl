<script type="text/javascript">
    $(function () {
        document.onkeydown = function(e){
            var ev = document.all ? window.event : e;
            if(ev.keyCode==13) {
                $('#searcher).submit();//处理事件
            }
        }
    });
</script>
<div class="container">
    <div class="row">
        <form class="form-horizontal" id="searcher">
            <div class="form-group has-feedback">
                <label class="col-md-2 control-label" for="username">用户名</label>
                <div class="col-md-6">
                    <span style="cursor: pointer" class="glyphicon glyphicon-search form-control-feedback"></span>
                    <input type="text" class="form-control" id="username" name="username" placeholder="用户名" autofocus>
                </div>
            </div>
        </form>
        <table class="table table-bordered table-responsive table-hover">
            <tr>
                <td>num</td>
                <td>id</td>
                <td>name</td>
                <td>password</td>
            </tr>
            <#list dataList as data>
                <tr>
                    <td>${(data_index) + 1}</td>
                    <td>${data.id}</td>
                    <td>${data.name}</td>
                    <td>${data.password}</td>
                </tr>
            </#list>
        </table>
    </div>
</div>