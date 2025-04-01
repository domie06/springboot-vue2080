<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="zh-cn">


<head>
    <%@ include file="../../static/head.jsp" %>
    <!-- font-awesome -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/font-awesome.min.css">
</head>
<style>

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
                    <h3 class="block-title">年审管理</h3>
                </div>
                <div class="col-md-6">
                    <ol class="breadcrumb">
                        <li class="breadcrumb-item">
                            <a href="${pageContext.request.contextPath}/index.jsp">
                                <span class="ti-home"></span>
                            </a>
                        </li>
                        <li class="breadcrumb-item">年审管理</li>
                        <li class="breadcrumb-item active">年审列表</li>
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
                        <h3 class="widget-title">年审列表</h3>
                        <div class="table-responsive mb-3">
                            <div class="col-sm-12">
                                                                                                                                 
                                            <label>
                                                年审结果
                                                <select name="nianshenTypesSelectSearch" style="width: 100px;" id="nianshenTypesSelectSearch" class="form-control form-control-sm"
                                                        aria-controls="tableId">
                                                </select>
                                            </label>
                                 
                                            <label>
                                                年审费用
                                                <input type="text" id="nianshenNumberStartSearch" style="width: 100px;" onchange="nianshenNumberChickValue(this)"   class="form-control " placeholder="开始" aria-controls="tableId">
                                            </label>
                                                -
                                            <label>
                                                <input type="text" id="nianshenNumberEndSearch" style="width: 100px;" onchange="nianshenNumberChickValue(this)"     class="form-control" placeholder="结束" aria-controls="tableId">
                                            </label>
                                                                                                
                                                                                                                                                 
                                            <label>
                                                车牌号
                                                <input type="text" id="carNumberSearch"  style="width: 120px;" class="form-control form-control-sm"
                                                       placeholder="车牌号" aria-controls="tableId">
                                            </label>
                                                 
                                            <label>
                                                车架号
                                                <input type="text" id="chejiaNumberSearch"  style="width: 120px;" class="form-control form-control-sm"
                                                       placeholder="车架号" aria-controls="tableId">
                                            </label>
                                                                                                
                                <button onclick="search()" type="button" class="btn btn-primary">查询</button>
                                <button onclick="add()" type="button" class="btn btn-success 新增">添加</button>
                                <button onclick="graph()" type="button" class="btn btn-success 报表">报表</button>
                                <button onclick="deleteMore()" type="button" class="btn btn-danger 删除">批量删除</button>
                            </div>
                            <table id="tableId" class="table table-bordered table-striped">
                                <thead>
                                <tr>
                                    <th class="no-sort" style="min-width: 35px;">
                                        <div class="custom-control custom-checkbox">
                                            <input class="custom-control-input" type="checkbox" id="select-all"
                                                   onclick="chooseAll()">
                                            <label class="custom-control-label" for="select-all"></label>
                                        </div>
                                    </th>

                                    <th >驾驶员</th>
                                    <th >车牌号</th>
                                    <th >车架号</th>
                                    <th >购买日期</th>
                                    <th >车辆备注</th>

                                    <th >年审日期</th>
                                    <th >年审结果</th>
                                    <th >年审费用</th>
                                    <th >年审照片</th>
                                    <th >年审备注</th>
                                    <th>操作</th>
                                </tr>
                                </thead>
                                <tbody id="thisTbody">
                                </tbody>
                            </table>
                            <div class="col-md-6 col-sm-3">
                                <div class="dataTables_length" id="tableId_length">

                                    <select name="tableId_length" aria-controls="tableId" id="selectPageSize"
                                            onchange="changePageSize()">
                                        <option value="10">10</option>
                                        <option value="25">25</option>
                                        <option value="50">50</option>
                                        <option value="100">100</option>
                                    </select>
                                    条 每页

                                </div>
                            </div>
                            <nav aria-label="Page navigation example">
                                <ul class="pagination justify-content-end">
                                    <li class="page-item" id="tableId_previous" onclick="pageNumChange('pre')">
                                        <a class="page-link" href="#" tabindex="-1">上一页</a>
                                    </li>

                                    <li class="page-item" id="tableId_next" onclick="pageNumChange('next')">
                                        <a class="page-link" href="#">下一页</a>
                                    </li>
                                </ul>
                            </nav>
                        </div>
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
<script language="javascript" type="text/javascript"
        src="${pageContext.request.contextPath}/resources/My97DatePicker/WdatePicker.js"></script>

<script>
    <%@ include file="../../utils/menu.jsp"%>
            <%@ include file="../../static/setMenu.js"%>
            <%@ include file="../../utils/baseUrl.jsp"%>
            <%@ include file="../../static/getRoleButtons.js"%>
            <%@ include file="../../static/crossBtnControl.js"%>
    var tableName = "nianshen";
    var pageType = "list";
    var searchForm = {key: ""};
    var pageIndex = 1;
    var pageSize = 10;
    var totalPage = 0;
    var dataList = [];
    var sortColumn = '';
    var sortOrder = '';
    var ids = [];
    var checkAll = false;


    var nianshenTypesOptions = [];

    function init() {
        // 满足条件渲染提醒接口
    }

    // 改变每页记录条数
    function changePageSize() {
        var selection = document.getElementById('selectPageSize');
        var index = selection.selectedIndex;
        pageSize = selection.options[index].value;
        getDataList();
    }



    // 查询
    function search() {
        searchForm = {key: ""};

        <!-- 级联表的级联字典表 -->
                                                             
                        //车牌号
        var carNumberSearchInput = $('#carNumberSearch');
        if( carNumberSearchInput != null){
            if (carNumberSearchInput.val() != null && carNumberSearchInput.val() != '') {
                searchForm.carNumber = $('#carNumberSearch').val();
            }
        }
                     
                        //车架号
        var chejiaNumberSearchInput = $('#chejiaNumberSearch');
        if( chejiaNumberSearchInput != null){
            if (chejiaNumberSearchInput.val() != null && chejiaNumberSearchInput.val() != '') {
                searchForm.chejiaNumber = $('#chejiaNumberSearch').val();
            }
        }
                                            <!-- 本表的查询条件 -->

                 
            //年审结果
        var nianshenTypesSelectSearchInput = document.getElementById("nianshenTypesSelectSearch");
        if(nianshenTypesSelectSearchInput != null){
            var nianshenTypesIndex = nianshenTypesSelectSearchInput.selectedIndex;
            if( nianshenTypesIndex  != 0){
                searchForm.nianshenTypes= document.getElementById("nianshenTypesSelectSearch").options[nianshenTypesIndex].value;
            }
        }
     
            //年审费用
        var nianshenNumberStartSearchInput = $('#nianshenNumberStartSearch');
        if(nianshenNumberStartSearchInput != null){
            var nianshenNumberStartSearchValue = nianshenNumberStartSearchInput.val();
            if( nianshenNumberStartSearchValue  != 0){
                searchForm.nianshenNumberStart = nianshenNumberStartSearchValue;
            }
        }
        var nianshenNumberEndSearchInput = $('#nianshenNumberEndSearch');
        if(nianshenNumberEndSearchInput != null){
            var nianshenNumberEndSearchValue = nianshenNumberEndSearchInput.val();
            if( nianshenNumberEndSearchValue  != 0){
                searchForm.nianshenNumberEnd = nianshenNumberEndSearchValue;
            }
        }
                    getDataList();
    }

    // 获取数据列表
    function getDataList() {
        http("nianshen/page", "GET", {
            page: pageIndex,
            limit: pageSize,
            sort: sortColumn,
            order: sortOrder,
            //本表的
            nianshenTypes: searchForm.nianshenTypes,
            nianshenNumberStart: searchForm.nianshenNumberStart,
            nianshenNumberEnd: searchForm.nianshenNumberEnd,
            //级联表的
                        carNumber: searchForm.carNumber,
                        chejiaNumber: searchForm.chejiaNumber,


        }, (res) => {
            if(res.code == 0) {
                clear();
                $("#thisTbody").html("");
                dataList = res.data.list;
                totalPage = res.data.totalPage;
                for (var i = 0; i < dataList.length; i++) { //遍历一下表格数据  
                    var trow = setDataRow(dataList[i], i); //定义一个方法,返回tr数据 
                    $('#thisTbody').append(trow);
                }
                pagination(); //渲染翻页组件
                getRoleButtons();// 权限按钮控制
            }
        });
    }

    // 渲染表格数据
    function setDataRow(item, number) {
        //创建行 
        var row = document.createElement('tr');
        row.setAttribute('class', 'useOnce');
        //创建勾选框
        var checkbox = document.createElement('td');
        var checkboxDiv = document.createElement('div');
        checkboxDiv.setAttribute("class", "custom-control custom-checkbox");
        var checkboxInput = document.createElement('input');
        checkboxInput.setAttribute("class", "custom-control-input");
        checkboxInput.setAttribute("type", "checkbox");
        checkboxInput.setAttribute('name', 'chk');
        checkboxInput.setAttribute('value', item.id);
        checkboxInput.setAttribute("id", number);
        checkboxDiv.appendChild(checkboxInput);
        var checkboxLabel = document.createElement('label');
        checkboxLabel.setAttribute("class", "custom-control-label");
        checkboxLabel.setAttribute("for", number);
        checkboxDiv.appendChild(checkboxLabel);
        checkbox.appendChild(checkboxDiv);
        row.appendChild(checkbox)

                    //驾驶员
        var jiashiyuanIdCell = document.createElement('td');
        jiashiyuanIdCell.innerHTML = item.jiashiyuanId;
        row.appendChild(jiashiyuanIdCell);


                //车牌号
        var carNumberCell = document.createElement('td');
        carNumberCell.innerHTML = item.carNumber;
        row.appendChild(carNumberCell);


                //车架号
        var chejiaNumberCell = document.createElement('td');
        chejiaNumberCell.innerHTML = item.chejiaNumber;
        row.appendChild(chejiaNumberCell);


                //购买日期
        var goumaiTimeCell = document.createElement('td');
        goumaiTimeCell.innerHTML = item.goumaiTime;
        row.appendChild(goumaiTimeCell);


                //车辆备注
        var carContentCell = document.createElement('td');
        //如果图文详情包含图片
        if (item.carContent && item.carContent.indexOf('img') != -1) {
            //暂时只考虑图片+文字 和 文字+图片的情况
            var beginIndex = item.carContent.indexOf('<img');
            var endIndex = item.carContent.indexOf('>');
                carContentCell.innerHTML = item.carContent.substring(beginIndex, endIndex + 1).replace("img", "img width='100' height='100'");
        } else {
            if (item.carContent != null && item.carContent != "" && item.carContent.length >= 11) {
                    carContentCell.innerHTML = item.carContent.substring(0, 10) + "...";
            } else {
                    carContentCell.innerHTML = item.carContent;
            }
        }
        row.appendChild(carContentCell);



        //年审日期
        var nianshenTimeCell = document.createElement('td');
        nianshenTimeCell.innerHTML = item.nianshenTime;
        row.appendChild(nianshenTimeCell);


        //年审结果
        var nianshenTypesCell = document.createElement('td');
        nianshenTypesCell.innerHTML = item.nianshenValue;
        row.appendChild(nianshenTypesCell);


        //年审费用
        var nianshenNumberCell = document.createElement('td');
        nianshenNumberCell.innerHTML = item.nianshenNumber;
        row.appendChild(nianshenNumberCell);

            //年审照片
        var nianshenPhotoCell = document.createElement('td');
        var nianshenPhotoImg = document.createElement('img');
        var nianshenPhotoImgValue = item.nianshenPhoto;
        if(nianshenPhotoImgValue !=null && nianshenPhotoImgValue !='' && nianshenPhotoImgValue !='null'){
            nianshenPhotoImg.setAttribute('src', nianshenPhotoImgValue);
            nianshenPhotoImg.setAttribute('height', 100);
            nianshenPhotoImg.setAttribute('width', 100);
            nianshenPhotoCell.appendChild(nianshenPhotoImg);
        }else{
            nianshenPhotoCell.innerHTML = "暂无图片";
        }
        row.appendChild(nianshenPhotoCell);


            //年审备注
        var nianshenContentCell = document.createElement('td');
        //如果图文详情包含图片
        if (item.nianshenContent && item.nianshenContent.indexOf('img') != -1) {
            //暂时只考虑图片+文字 和 文字+图片的情况
            var beginIndex = item.nianshenContent.indexOf('<img');
            var endIndex = item.nianshenContent.indexOf('>');
                nianshenContentCell.innerHTML = item.nianshenContent.substring(beginIndex, endIndex + 1).replace("img", "img width='100' height='100'");
        } else {
            if (item.nianshenContent != null && item.nianshenContent != "" && item.nianshenContent.length >= 11) {
                    nianshenContentCell.innerHTML = item.nianshenContent.substring(0, 10) + "...";
            } else {
                    nianshenContentCell.innerHTML = item.nianshenContent;
            }
        }
        row.appendChild(nianshenContentCell);



        //每行按钮
        var btnGroup = document.createElement('td');

        //详情按钮
        var detailBtn = document.createElement('button');
        var detailAttr = "detail(" + item.id + ')';
        detailBtn.setAttribute("type", "button");
        detailBtn.setAttribute("class", "btn btn-info btn-sm 查看");
        detailBtn.setAttribute("onclick", detailAttr);
        detailBtn.innerHTML = "查看"
        btnGroup.appendChild(detailBtn)
        //修改按钮
        var editBtn = document.createElement('button');
        var editAttr = 'edit(' + item.id + ')';
        editBtn.setAttribute("type", "button");
        editBtn.setAttribute("class", "btn btn-warning btn-sm 修改");
        editBtn.setAttribute("onclick", editAttr);
        editBtn.innerHTML = "修改"
        btnGroup.appendChild(editBtn)
        //删除按钮
        var deleteBtn = document.createElement('button');
        var deleteAttr = 'remove(' + item.id + ')';
        deleteBtn.setAttribute("type", "button");
        deleteBtn.setAttribute("class", "btn btn-danger btn-sm 删除");
        deleteBtn.setAttribute("onclick", deleteAttr);
        deleteBtn.innerHTML = "删除"
        btnGroup.appendChild(deleteBtn)

        row.appendChild(btnGroup)
        return row;
    }


        // 整数
        function nianshenNumberChickValue(e){
            var this_val = e.value || 0;
            var reg=/^[0-9]*$/;
            if(!reg.test(this_val)){
                e.value = "";
                alert("输入不合法");
                return false;
            }
        }

        // 整数
        function nianshenNumberChickValue(e){
            var this_val = e.value || 0;
            var reg=/^[0-9]*$/;
            if(!reg.test(this_val)){
                e.value = "";
                alert("输入不合法");
                return false;
            }
        }

        // 整数
        function nianshenNumberChickValue(e){
            var this_val = e.value || 0;
            var reg=/^[0-9]*$/;
            if(!reg.test(this_val)){
                e.value = "";
                alert("输入不合法");
                return false;
            }
        }

        // 整数
        function nianshenNumberChickValue(e){
            var this_val = e.value || 0;
            var reg=/^[0-9]*$/;
            if(!reg.test(this_val)){
                e.value = "";
                alert("输入不合法");
                return false;
            }
        }

        // 整数
        function nianshenNumberChickValue(e){
            var this_val = e.value || 0;
            var reg=/^[0-9]*$/;
            if(!reg.test(this_val)){
                e.value = "";
                alert("输入不合法");
                return false;
            }
        }

        // 整数
        function nianshenNumberChickValue(e){
            var this_val = e.value || 0;
            var reg=/^[0-9]*$/;
            if(!reg.test(this_val)){
                e.value = "";
                alert("输入不合法");
                return false;
            }
        }

        //整数
        function nianshenNumberChickValue(e){
            var this_val = e.value || 0;
            // if(this_val == 0){
            //     e.value = "";
            //     alert("0不允许输入");
            //     return false;
            // }
            var reg=/^[0-9]*$/;
            if(!reg.test(this_val)){
                e.value = "";
                alert("输入不合法");
                return false;
            }
        }


    // 翻页
    function pageNumChange(val) {
        if (val == 'pre') {
            pageIndex--;
        } else if (val == 'next') {
            pageIndex++;
        } else {
            pageIndex = val;
        }
        getDataList();
    }

    // 下载
    function download(url) {
        window.open(url);
    }

    // 渲染翻页组件
    function pagination() {
        var beginIndex = pageIndex;
        var endIndex = pageIndex;
        var point = 4;
        //计算页码
        for (var i = 0; i < 3; i++) {
            if (endIndex == totalPage) {
                break;
            }
            endIndex++;
            point--;
        }
        for (var i = 0; i < 3; i++) {
            if (beginIndex == 1) {
                break;
            }
            beginIndex--;
            point--;
        }
        if (point > 0) {
            while (point > 0) {
                if (endIndex == totalPage) {
                    break;
                }
                endIndex++;
                point--;
            }
            while (point > 0) {
                if (beginIndex == 1) {
                    break;
                }
                beginIndex--;
                point--
            }
        }
        // 是否显示 前一页 按钮
        if (pageIndex > 1) {
            $('#tableId_previous').show();
        } else {
            $('#tableId_previous').hide();
        }
        // 渲染页码按钮
        for (var i = beginIndex; i <= endIndex; i++) {
            var pageNum = document.createElement('li');
            pageNum.setAttribute('onclick', "pageNumChange(" + i + ")");
            if (pageIndex == i) {
                pageNum.setAttribute('class', 'paginate_button page-item active useOnce');
            } else {
                pageNum.setAttribute('class', 'paginate_button page-item useOnce');
            }
            var pageHref = document.createElement('a');
            pageHref.setAttribute('class', 'page-link');
            pageHref.setAttribute('href', '#');
            pageHref.setAttribute('aria-controls', 'tableId');
            pageHref.setAttribute('data-dt-idx', i);
            pageHref.setAttribute('tabindex', 0);
            pageHref.innerHTML = i;
            pageNum.appendChild(pageHref);
            $('#tableId_next').before(pageNum);
        }
        // 是否显示 下一页 按钮
        if (pageIndex < totalPage) {
            $('#tableId_next').show();
            $('#tableId_next a').attr('data-dt-idx', endIndex + 1);
        } else {
            $('#tableId_next').hide();
        }
        var pageNumInfo = "当前第 " + pageIndex + " 页，共 " + totalPage + " 页";
        $('#tableId_info').html(pageNumInfo);
    }

    // 跳转到指定页
    function toThatPage() {
        //var index = document.getElementById('pageIndexInput').value;
        if (index < 0 || index > totalPage) {
            alert('请输入正确的页码');
        } else {
            pageNumChange(index);
        }
    }

    // 全选/全不选
    function chooseAll() {
        checkAll = !checkAll;
        var boxs = document.getElementsByName("chk");
        for (var i = 0; i < boxs.length; i++) {
            boxs[i].checked = checkAll;
        }
    }

    // 批量删除
    function deleteMore() {
        ids = []
        var boxs = document.getElementsByName("chk");
        for (var i = 0; i < boxs.length; i++) {
            if (boxs[i].checked) {
                ids.push(boxs[i].value)
            }
        }
        if (ids.length == 0) {
            alert('请勾选要删除的记录');
        } else {
            remove(ids);
        }
    }

    // 删除
    function remove(id) {
        var mymessage = confirm("真的要删除吗？");
        if (mymessage == true) {
            var paramArray = [];
            if (id == ids) {
                paramArray = id;
            } else {
                paramArray.push(id);
            }
            httpJson("nianshen/delete", "POST", paramArray, (res) => {
                if(res.code == 0){
                    getDataList();
                    alert('删除成功');
                }
            });
        } else {
            alert("已取消操作");
        }
    }

    // 用户登出
    <%@ include file="../../static/logout.jsp"%>

    //修改
    function edit(id) {
        window.sessionStorage.setItem('updateId', id)
        window.location.href = "add-or-update.jsp"
    }

    //清除会重复渲染的节点
    function clear() {
        var elements = document.getElementsByClassName('useOnce');
        for (var i = elements.length - 1; i >= 0; i--) {
            elements[i].parentNode.removeChild(elements[i]);
        }
    }

    //添加
    function add() {
        window.sessionStorage.setItem("addnianshen", "addnianshen");
        window.location.href = "add-or-update.jsp"
    }

    //报表
    function graph() {
        window.location.href = "graph.jsp"
    }

    // 查看详情
    function detail(id) {
        window.sessionStorage.setItem("updateId", id);
        window.location.href = "info.jsp";
    }

    //填充级联表搜索下拉框
                                                             
                     
                                        
    //填充本表搜索下拉框
                 
        function nianshenTypesSelectSearch() {
            var nianshenTypesSelectSearch = document.getElementById('nianshenTypesSelectSearch');
            if(nianshenTypesSelectSearch != null) {
                nianshenTypesSelectSearch.add(new Option('-请选择-',''));
                if (nianshenTypesOptions != null && nianshenTypesOptions.length > 0){
                    for (var i = 0; i < nianshenTypesOptions.length; i++) {
                            nianshenTypesSelectSearch.add(new Option(nianshenTypesOptions[i].indexName,nianshenTypesOptions[i].codeIndex));
                    }
                }
            }
        }
     
            
    //查询级联表搜索条件所有列表

    //查询当前表搜索条件所有列表
        function nianshenTypesSelect() {
            //填充下拉框选项
            http("dictionary/page?page=1&limit=100&sort=&order=&dicCode=nianshen_types", "GET", {}, (res) => {
                if(res.code == 0){
                    nianshenTypesOptions = res.data.list;
                }
            });
        }


    $(document).ready(function () {
        //激活翻页按钮
        $('#tableId_previous').attr('class', 'paginate_button page-item previous')
        $('#tableId_next').attr('class', 'paginate_button page-item next')
        //隐藏原生搜索框
        $('#tableId_filter').hide()
        //设置右上角用户名
        $('.dropdown-menu h5').html(window.sessionStorage.getItem('username'))
        //设置项目名
        $('.sidebar-header h3 a').html(projectName)
        setMenu();
        init();

        //查询级联表的搜索下拉框

        //查询当前表的搜索下拉框
        nianshenTypesSelect();
        getDataList();

        //级联表的下拉框赋值
                                                                         
                         
                                                
        //当前表的下拉框赋值
                                                 
            nianshenTypesSelectSearch();
             
                                    
    <%@ include file="../../static/myInfo.js"%>
    });
</script>
</body>

</html>