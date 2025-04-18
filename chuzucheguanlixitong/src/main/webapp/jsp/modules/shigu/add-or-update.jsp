<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="zh-cn">

<head>
    <%@ include file="../../static/head.jsp" %>
    <link href="http://www.bootcss.com/p/bootstrap-datetimepicker/bootstrap-datetimepicker/css/datetimepicker.css"
          rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/bootstrap-select.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <script type="text/javascript" charset="utf-8">
        window.UEDITOR_HOME_URL = "${pageContext.request.contextPath}/resources/ueditor/"; //UEDITOR_HOME_URL、config、all这三个顺序不能改变
    </script>
    <script type="text/javascript" charset="utf-8"
            src="${pageContext.request.contextPath}/resources/ueditor/ueditor.config.js"></script>
    <script type="text/javascript" charset="utf-8"
            src="${pageContext.request.contextPath}/resources/ueditor/ueditor.all.min.js"></script>
    <script type="text/javascript" charset="utf-8"
            src="${pageContext.request.contextPath}/resources/ueditor/lang/zh-cn/zh-cn.js"></script>
</head>
<style>
    .error {
        color: red;
    }
</style>
<body>
<!-- Pre Loader -->
<div class="loading">
    <div class="spinner">
        <div class="double-bounce1"></div>
        <div class="double-bounce2"></div>
    </div>
</div>
<!--/Pre Loader -->
<div class="wrapper">
    <!-- Page Content -->
    <div id="content">
        <!-- Top Navigation -->
        <%@ include file="../../static/topNav.jsp" %>
        <!-- Menu -->
        <div class="container menu-nav">
            <nav class="navbar navbar-expand-lg lochana-bg text-white">
                <button class="navbar-toggler" type="button" data-toggle="collapse"
                        data-target="#navbarSupportedContent"
                        aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="ti-menu text-white"></span>
                </button>

                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul id="navUl" class="navbar-nav mr-auto">

                    </ul>
                </div>
            </nav>
        </div>
        <!-- /Menu -->
        <!-- Breadcrumb -->
        <!-- Page Title -->
        <div class="container mt-0">
            <div class="row breadcrumb-bar">
                <div class="col-md-6">
                    <h3 class="block-title">编辑事故</h3>
                </div>
                <div class="col-md-6">
                    <ol class="breadcrumb">
                        <li class="breadcrumb-item">
                            <a href="${pageContext.request.contextPath}/index.jsp">
                                <span class="ti-home"></span>
                            </a>
                        </li>
                        <li class="breadcrumb-item">事故管理</li>
                        <li class="breadcrumb-item active">编辑事故</li>
                    </ol>
                </div>
            </div>
        </div>
        <!-- /Page Title -->

        <!-- /Breadcrumb -->
        <!-- Main Content -->
        <div class="container">

            <div class="row">
                <!-- Widget Item -->
                <div class="col-md-12">
                    <div class="widget-area-2 lochana-box-shadow">
                        <h3 class="widget-title">事故信息</h3>
                        <form id="addOrUpdateForm">
                            <div class="form-row">
                            <!-- 级联表的字段 -->
                                    <div class="form-group col-md-6">
                                        <label>车辆</label>
                                        <div>
                                            <select id="carSelect" name="carSelect"
                                                    class="selectpicker form-control"  data-live-search="true"
                                                    title="请选择" data-header="请选择" data-size="5">
                                            </select>
                                        </div>
                                    </div>
                                    <div class="form-group col-md-6">
                                        <label>车牌号</label>
                                        <input id="carNumber" name="carNumber" class="form-control"
                                               placeholder="车牌号" readonly>
                                    </div>
                                    <div class="form-group col-md-6">
                                        <label>车架号</label>
                                        <input id="chejiaNumber" name="chejiaNumber" class="form-control"
                                               placeholder="车架号" readonly>
                                    </div>
                                    <div class="form-group col-md-6">
                                        <label>购买日期</label>
                                        <input id="goumaiTime" name="goumaiTime" class="form-control"
                                               placeholder="购买日期" readonly>
                                    </div>
                            <!-- 当前表的字段 -->
                                    <input id="updateId" name="id" type="hidden">
                                <input id="carId" name="carId" type="hidden">
                                   <div class="form-group col-md-6">
                                       <label>事故时间</label>
                                       <input id="insertTime-input" name="insertTime" type="text" class="form-control layui-input">
                                   </div>
                                   <div class="form-group col-md-6">
                                       <label>事故类型</label>
                                       <select id="shiguTypesSelect" name="shiguTypes" class="form-control">
                                       </select>
                                   </div>
                                   <div class="form-group col-md-6">
                                       <label>事故照片</label>
                                       <img id="shiguPhotoImg" src="" width="100" height="100">
                                       <input name="file" type="file" id="shiguPhotoupload"
                                              class="form-control-file">
                                       <input name="shiguPhoto" id="shiguPhoto-input" type="hidden">
                                   </div>
                                   <div class="form-group col-md-6">
                                       <label>是否处理</label>
                                       <select id="shiguchuliTypesSelect" name="shiguchuliTypes" class="form-control">
                                       </select>
                                   </div>
                                   <div class="form-group  col-md-6">
                                       <label>事故备注</label>
                                       <input id="shiguContentupload" name="file" type="file">
                                       <script id="shiguContentEditor" type="text/plain"
                                               style="width:100%;height:230px;"></script>
                                       <script type = "text/javascript" >
                                       //建议使用工厂方法getEditor创建和引用编辑器实例，如果在某个闭包下引用该编辑器，直接调用UE.getEditor('editor')就能拿到相关的实例
                                       //相见文档配置属于你自己的编译器
                                       var shiguContentUe = UE.getEditor('shiguContentEditor', {
                                           toolbars: [
                                               [
                                                   'undo', //撤销
                                                   'bold', //加粗
                                                   'redo', //重做
                                                   'underline', //下划线
                                                   'horizontal', //分隔线
                                                   'inserttitle', //插入标题
                                                   'cleardoc', //清空文档
                                                   'fontfamily', //字体
                                                   'fontsize', //字号
                                                   'paragraph', //段落格式
                                                   'inserttable', //插入表格
                                                   'justifyleft', //居左对齐
                                                   'justifyright', //居右对齐
                                                   'justifycenter', //居中对
                                                   'justifyjustify', //两端对齐
                                                   'forecolor', //字体颜色
                                                   'fullscreen', //全屏
                                                   'edittip ', //编辑提示
                                                   'customstyle', //自定义标题
                                               ]
                                           ]
                                       });
                                       </script>
                                       <input type="hidden" name="shiguContent" id="shiguContent-input">
                                   </div>
                                <div class="form-group col-md-12 mb-3">
                                    <button id="submitBtn" type="button" class="btn btn-primary btn-lg">提交</button>
                                    <button id="exitBtn" type="button" class="btn btn-primary btn-lg">返回</button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
                <!-- /Widget Item -->
            </div>
        </div>
        <!-- /Main Content -->
    </div>
    <!-- /Page Content -->
</div>
<!-- Back to Top -->
<a id="back-to-top" href="#" class="back-to-top">
    <span class="ti-angle-up"></span>
</a>
<!-- /Back to Top -->
<%@ include file="../../static/foot.jsp" %>
<script src="${pageContext.request.contextPath}/resources/js/vue.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/jquery.ui.widget.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/jquery.fileupload.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/jquery.form.js"></script>
<script type="text/javascript" charset="utf-8"
        src="${pageContext.request.contextPath}/resources/js/validate/jquery.validate.min.js"></script>
<script type="text/javascript" charset="utf-8"
        src="${pageContext.request.contextPath}/resources/js/validate/messages_zh.js"></script>
<script type="text/javascript" charset="utf-8"
        src="${pageContext.request.contextPath}/resources/js/validate/card.js"></script>
<script type="text/javascript" charset="utf-8"
        src="${pageContext.request.contextPath}/resources/js/datetimepicker/bootstrap-datetimepicker.min.js"></script>
</script><script type="text/javascript" charset="utf-8"
                 src="${pageContext.request.contextPath}/resources/js/bootstrap-select.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/laydate.js"></script>
<script>
    <%@ include file="../../utils/menu.jsp"%>
    <%@ include file="../../static/setMenu.js"%>
    <%@ include file="../../utils/baseUrl.jsp"%>

    var tableName = "shigu";
    var pageType = "add-or-update";
    var updateId = "";
    var crossTableId = -1;
    var crossTableName = '';
    var ruleForm = {};
    var crossRuleForm = {};


    // 下拉框数组
        <!-- 当前表的下拉框数组 -->
    var shiguTypesOptions = [];
    var shiguchuliTypesOptions = [];
        <!-- 级联表的下拉框数组 -->
    var carOptions = [];

    var ruleForm = {};


    // 文件上传
    function upload() {

        <!-- 当前表的文件上传 -->

        $('#shiguPhotoupload').fileupload({
            url: baseUrl + 'file/upload',
            headers: {token: window.sessionStorage.getItem("token")},
            dataType: 'json',
            done: function (e, data) {
                var photoUrl= baseUrl + 'file/download?fileName=' + data.result.file;
                document.getElementById('shiguPhotoImg').setAttribute('src',photoUrl);
                document.getElementById('shiguPhoto-input').setAttribute('value',photoUrl);
            }
        });


        $('#shiguContentupload').fileupload({
            url: baseUrl + 'file/upload',
            headers: {token: window.sessionStorage.getItem("token")},
            dataType: 'json',
            done: function (e, data) {
                UE.getEditor('shiguContentEditor').execCommand('insertHtml', '<img src=\"' + baseUrl + 'upload/' + data.result.file + '\" width=900 height=560>');
            }
        });


    }

    // 表单提交
    function submit() {
        if (validform() == true && compare() == true) {
            let data = {};
            getContent();
           if($("#carId") !=null){
               var carId = $("#carId").val();
               if(carId == null || carId =='' || carId == 'null'){
                   alert("车辆不能为空");
                   return;
               }
           }
            let value = $('#addOrUpdateForm').serializeArray();
            $.each(value, function (index, item) {
                data[item.name] = item.value;
            });
            let json = JSON.stringify(data);
            var urlParam;
            var successMes = '';
            if (updateId != null && updateId != "null" && updateId != '') {
                urlParam = 'update';
                successMes = '修改成功';
            } else {
                urlParam = 'save';
                    successMes = '添加成功';
            }
            httpJson("shigu/" + urlParam, "POST", data, (res) => {
                if(res.code == 0){
                    window.sessionStorage.removeItem('addshigu');
                    window.sessionStorage.removeItem('updateId');
                    let flag = true;
                    if (flag) {
                        alert(successMes);
                    }
                    if (window.sessionStorage.getItem('onlyme') != null && window.sessionStorage.getItem('onlyme') == "true") {
                        window.sessionStorage.removeItem('onlyme');
                        window.sessionStorage.setItem("reload","reload");
                        window.parent.location.href = "${pageContext.request.contextPath}/index.jsp";
                    } else {
                        window.location.href = "list.jsp";
                    }
                }
            });
        } else {
            alert("表单未填完整或有错误");
        }
    }

    // 查询列表
        <!-- 查询当前表的所有列表 -->
        function shiguTypesSelect() {
            //填充下拉框选项
            http("dictionary/page?page=1&limit=100&sort=&order=&dicCode=shigu_types", "GET", {}, (res) => {
                if(res.code == 0){
                    shiguTypesOptions = res.data.list;
                }
            });
        }
        function shiguchuliTypesSelect() {
            //填充下拉框选项
            http("dictionary/page?page=1&limit=100&sort=&order=&dicCode=shiguchuli_types", "GET", {}, (res) => {
                if(res.code == 0){
                    shiguchuliTypesOptions = res.data.list;
                }
            });
        }
        <!-- 查询级联表的所有列表 -->
        function carSelect() {
            //填充下拉框选项
            http("car/page?page=1&limit=100&sort=&order=", "GET", {}, (res) => {
                if(res.code == 0){
                    carOptions = res.data.list;
                }
            });
        }

        function carSelectOne(id) {
            http("car/info/"+id, "GET", {}, (res) => {
                if(res.code == 0){
                ruleForm = res.data;
                carShowImg();
                carDataBind();
            }
        });
        }



    // 初始化下拉框
    <!-- 初始化当前表的下拉框 -->
        function initializationShigutypesSelect(){
            var shiguTypesSelect = document.getElementById('shiguTypesSelect');
            if(shiguTypesSelect != null && shiguTypesOptions != null  && shiguTypesOptions.length > 0 ){
                for (var i = 0; i < shiguTypesOptions.length; i++) {
                    shiguTypesSelect.add(new Option(shiguTypesOptions[i].indexName,shiguTypesOptions[i].codeIndex));
                }
            }
        }
        function initializationShiguchulitypesSelect(){
            var shiguchuliTypesSelect = document.getElementById('shiguchuliTypesSelect');
            if(shiguchuliTypesSelect != null && shiguchuliTypesOptions != null  && shiguchuliTypesOptions.length > 0 ){
                for (var i = 0; i < shiguchuliTypesOptions.length; i++) {
                    shiguchuliTypesSelect.add(new Option(shiguchuliTypesOptions[i].indexName,shiguchuliTypesOptions[i].codeIndex));
                }
            }
        }

    <!-- 初始化级联表的下拉框(要根据内容修改) -->
    <!-- 初始化级联表的下拉框(要根据内容修改) -->
    <!-- 初始化级联表的下拉框(要根据内容修改) -->
    <!-- 初始化级联表的下拉框(要根据内容修改) -->
    <!-- 初始化级联表的下拉框(要根据内容修改) -->
    <!-- 初始化级联表的下拉框(要根据内容修改) -->
        function initializationcarSelect() {
            var carSelect = document.getElementById('carSelect');
            if(carSelect != null && carOptions != null  && carOptions.length > 0 ) {
                for (var i = 0; i < carOptions.length; i++) {
                        carSelect.add(new Option("车牌号:"+carOptions[i].carNumber+" 车架号:"+carOptions[i].chejiaNumber, carOptions[i].id));
                }

                $("#carSelect").change(function(e) {
                        carSelectOne(e.target.value);
                });
            }

        }



    // 下拉框选项回显
    function setSelectOption() {

        <!-- 当前表的下拉框回显 -->

        var shiguTypesSelect = document.getElementById("shiguTypesSelect");
        if(shiguTypesSelect != null && shiguTypesOptions != null  && shiguTypesOptions.length > 0 ) {
            for (var i = 0; i < shiguTypesOptions.length; i++) {
                if (shiguTypesOptions[i].codeIndex == ruleForm.shiguTypes) {//下拉框value对比,如果一致就赋值汉字
                        shiguTypesSelect.options[i].selected = true;
                }
            }
        }

        var shiguchuliTypesSelect = document.getElementById("shiguchuliTypesSelect");
        if(shiguchuliTypesSelect != null && shiguchuliTypesOptions != null  && shiguchuliTypesOptions.length > 0 ) {
            for (var i = 0; i < shiguchuliTypesOptions.length; i++) {
                if (shiguchuliTypesOptions[i].codeIndex == ruleForm.shiguchuliTypes) {//下拉框value对比,如果一致就赋值汉字
                        shiguchuliTypesSelect.options[i].selected = true;
                }
            }
        }
        <!--  级联表的下拉框回显  -->
            var carSelect = document.getElementById("carSelect");
            if(carSelect != null && carOptions != null  && carOptions.length > 0 ) {
                for (var i = 0; i < carOptions.length; i++) {
                    if (carOptions[i].id == ruleForm.carId) {//下拉框value对比,如果一致就赋值汉字
                        carSelect.options[i+1].selected = true;
                        $("#carSelect" ).selectpicker('refresh');
                    }
                }
            }
    }


    // 填充富文本框
    function setContent() {

        <!-- 当前表的填充富文本框 -->
        if (ruleForm.shiguContent != null && ruleForm.shiguContent != 'null' && ruleForm.shiguContent != '') {

            var shiguContentUeditor = UE.getEditor('shiguContentEditor');
            shiguContentUeditor.ready(function () {
                var mes = '' + ruleForm.shiguContent;
                shiguContentUeditor.setContent(mes);
            });
        }
    }
    // 获取富文本框内容
    function getContent() {

        <!-- 获取当前表的富文本框内容 -->
        var shiguContentEditor =UE.getEditor('shiguContentEditor');
        if (shiguContentEditor.hasContents()) {
                $('#shiguContent-input').attr('value', shiguContentEditor.getPlainTxt());
        }
    }
    //数字检查
        <!-- 当前表的数字检查 -->

    function exit() {
        window.sessionStorage.removeItem("updateId");
        window.sessionStorage.removeItem('addshigu');
        window.location.href = "list.jsp";
    }
    // 表单校验
    function validform() {
        return $("#addOrUpdateForm").validate({
            rules: {
                carId: "required",
                insertTime: "required",
                shiguTypes: "required",
                shiguPhoto: "required",
                shiguchuliTypes: "required",
                shiguContent: "required",
            },
            messages: {
                carId: "车辆不能为空",
                insertTime: "事故时间不能为空",
                shiguTypes: "事故类型不能为空",
                shiguPhoto: "事故照片不能为空",
                shiguchuliTypes: "是否处理不能为空",
                shiguContent: "事故备注不能为空",
            }
        }).form();
    }

    // 获取当前详情
    function getDetails() {
        var addshigu = window.sessionStorage.getItem("addshigu");
        if (addshigu != null && addshigu != "" && addshigu != "null") {
            window.sessionStorage.removeItem('addshigu');
            //注册表单验证
            $(validform());
            $('#submitBtn').text('新增');

        } else {
            $('#submitBtn').text('修改');
            var userId = window.sessionStorage.getItem('userId');
            updateId = userId;//先赋值登录用户id
            var uId  = window.sessionStorage.getItem('updateId');//获取修改传过来的id
            if (uId != null && uId != "" && uId != "null") {
                //如果修改id不为空就赋值修改id
                updateId = uId;
            }
            window.sessionStorage.removeItem('updateId');
            http("shigu/info/" + updateId, "GET", {}, (res) => {
                if(res.code == 0)
                {
                    ruleForm = res.data
                    // 是/否下拉框回显
                    setSelectOption();
                    // 设置图片src
                    showImg();
                    // 数据填充
                    dataBind();
                    // 富文本框回显
                    setContent();
                    //注册表单验证
                    $(validform());
                }

            });
        }
    }

    // 清除可能会重复渲染的selection
    function clear(className) {
        var elements = document.getElementsByClassName(className);
        for (var i = elements.length - 1; i >= 0; i--) {
            elements[i].parentNode.removeChild(elements[i]);
        }
    }

    function dateTimePick() {
            laydate.render({
                elem: '#insertTime-input'
                ,type: 'datetime'
            });
    }


    function dataBind() {


    <!--  级联表的数据回显  -->
        carDataBind();


    <!--  当前表的数据回显  -->
        $("#updateId").val(ruleForm.id);
        $("#carId").val(ruleForm.carId);
        $("#insertTime-input").val(ruleForm.insertTime);
        $("#shiguContent").val(ruleForm.shiguContent);

    }
    <!--  级联表的数据回显  -->
    function carDataBind(){

                    <!-- 把id赋值给当前表的id-->
        $("#carId").val(ruleForm.id);

        $("#jiashiyuanId").val(ruleForm.jiashiyuanId);
        $("#carNumber").val(ruleForm.carNumber);
        $("#chejiaNumber").val(ruleForm.chejiaNumber);
        $("#goumaiTime").val(ruleForm.goumaiTime);//把时间戳转换为日期带时分秒格式
        $("#carContent").val(ruleForm.carContent);
    }


    //图片显示
    function showImg() {
        <!--  当前表的图片  -->
        $("#shiguPhotoImg").attr("src",ruleForm.shiguPhoto);

        <!--  级联表的图片  -->
        carShowImg();
    }


    <!--  级联表的图片  -->

    function carShowImg() {
    }



    $(document).ready(function () {
        //设置右上角用户名
        $('.dropdown-menu h5').html(window.sessionStorage.getItem('username'))
        //设置项目名
        $('.sidebar-header h3 a').html(projectName)
        //设置导航栏菜单
        setMenu();
        $('#exitBtn').on('click', function (e) {
            e.preventDefault();
            exit();
        });
        //初始化时间插件
        dateTimePick();
        //查询所有下拉框
            <!--  当前表的下拉框  -->
            shiguTypesSelect();
            shiguchuliTypesSelect();
            <!-- 查询级联表的下拉框(用id做option,用名字及其他参数做名字级联修改) -->
            carSelect();



        // 初始化下拉框
            <!--  初始化当前表的下拉框  -->
            initializationShigutypesSelect();
            initializationShiguchulitypesSelect();
            <!--  初始化级联表的下拉框  -->
            initializationcarSelect();

        $(".selectpicker" ).selectpicker('refresh');
        getDetails();
        //初始化上传按钮
        upload();
    <%@ include file="../../static/myInfo.js"%>
                $('#submitBtn').on('click', function (e) {
                    e.preventDefault();
                    //console.log("点击了...提交按钮");
                    submit();
                });
        readonly();
    });

    function readonly() {
        if (window.sessionStorage.getItem('role') != '管理员') {
            $('#jifen').attr('readonly', 'readonly');
            //$('#money').attr('readonly', 'readonly');
        }
    }

    //比较大小
    function compare() {
        var largerVal = null;
        var smallerVal = null;
        if (largerVal != null && smallerVal != null) {
            if (largerVal <= smallerVal) {
                alert(smallerName + '不能大于等于' + largerName);
                return false;
            }
        }
        return true;
    }


    // 用户登出
    <%@ include file="../../static/logout.jsp"%>
</script>
</body>

</html>