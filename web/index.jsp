<%--
  Created by IntelliJ IDEA.
  User: 就这样乖乖哒等着
  Date: 2021/3/7
  Time: 20:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
    <style type="text/css">
      table{
        border: 1px solid lightsteelblue;

        width: 60%;
        text-align: center;
        margin: 100px auto;
      }
      td{
        border: 1px solid black;
        height: 50px;
      }
      #part_one{
        /*border: 1px solid red;*/
        float: left;
        margin-left: 250px;
      }
      #logging{
        margin-left: 700px;
      }
      .serch{
        float: left;
        margin-left: 100px;
        margin-top: 50px;
      }
      a{
        margin-left: 15px;
      }
      a:hover{
        cursor: pointer;
      }
    </style>

  </head>
  <body>
  <div id="logging"></div>
  <div>
<%--    <button type="button" id="addBtn">增添图书</button>--%>
    <a href="users?action=logout" style="margin-left: 1350px">退出登录</a>
  </div>
  <div id="part_one">
    <div class="serch">图书分类
      <select id="type_name">
          <option></option>
          <option>编程类</option>
          <option>小说类</option>
          <option>文学类</option>
      </select>
    </div>
    <div class="serch">图书作者<input type="text" id="book_author" name="book_author"></div>
    <div class="serch">借阅状态
      <select id="is_borrow">
        <option></option>
        <option>已借阅</option>
        <option>未借阅</option>
      </select>
    </div>
    <div class="serch"><button id="search_book">搜索</button></div>

  </div>
<table>
  <thead>
    <tr>
      <td>图书编码</td>
      <td>图书名称</td>
      <td>图书作者</td>
      <td>图书类型</td>
      <td>出版时间</td>
      <td>出版社</td>
      <td>操作</td>

    </tr>
  </thead>
  <tbody id="tbody">

  </tbody>
  <tfoot>
    <tr>
      <td colspan="7">
        <a id="index">首页</a>
        <a id="last">上一页</a>
        <a id="page"></a>
        <a id="next">下一页</a>
        <a id="end">尾页</a>
        <a>共<span id="curpage"></span>/<span id="pageCount"></span>页</a>
      </td>
    </tr>
  </tfoot>
</table>
  </body>
  <script src="js/jquery-3.5.1.js"></script>
  <script type="text/javascript">
    // var book = document.getElementById("#book_type").value;
    var curPage=1;
    var pageCount;
    function re(o,i) {
      // alert(val);
      o.style.color="blue";
      curPage=i;
      show(curPage);
    }
    function borrow(o,book_id) {
      if(o.text=="已借阅") {
        var update_id = 0;
      }else {
        update_id=1;
      }
      $.getJSON("book?action=borrow",{book_id:book_id,update_id:update_id},function (data) {
        alert("借阅成功");
        show(curPage);
      })
    }
    function show(curPage){
      book_author=$("#book_author").val();
      type_name=$("#type_name").val();
      is_borrow=$("#is_borrow").val();
      // alert(book_author+"=="+is_borrow+"=="+type_name);
      $.ajax({
        url:"book?action=list",
        data:{curPage:curPage,book_author:book_author,type_name:type_name,is_borrow:is_borrow},
        type:"POST",
        beforeSend:function(){
          $("#logging").html("正在加载中");
        },
        success:(function (data) {
          $("#logging").empty();
          var data = eval("("+data+")");
            var tbodyStr="";
          // alert(data.list);
          curpage=data.curPage;
          pageCount = data.pageCount;
          if($("#page").children().length>0){
            $("#page").children().remove();
          }

          for (let i = 1; i <= pageCount; i++) {
            if($("#page").children().length<pageCount){
              $("#page").append("<a id='page'"+i+"  onclick='re(this,"+i+")'>"+i+"</a>")
            }
          }
          $("#pageCount").text(pageCount);
          $("#curpage").text(curpage);
            if(data.list==""){
                $("#curpage").text("0");
                tbodyStr=tbodyStr+"<tr><td colspan='7'>没有更多数据了</td></tr>"
                $("#tbody").html(tbodyStr);
                return;
            }
          for (var i = 0; i < data.list.length; i++) {
            if(i%2==1){
              tbodyStr=tbodyStr+"<tr style='background-color: lightsteelblue'>";
            }else {
              tbodyStr=tbodyStr+"<tr>";
            }
            // alert(data.list[i].book_name);
            tbodyStr=tbodyStr+"<td style='line-height: 50px'>"+data.list[i].book_code+"</td>";
            tbodyStr=tbodyStr+"<td style='line-height: 50px'>"+data.list[i].book_name+"</td>";
            tbodyStr=tbodyStr+"<td style='line-height: 50px'>"+data.list[i].book_author+"</td>";
            tbodyStr=tbodyStr+"<td style='line-height: 50px'>"+data.list[i].type_name+"</td>";
            tbodyStr=tbodyStr+"<td style='line-height: 50px'>"+data.list[i].publish_date+"</td>";
            tbodyStr=tbodyStr+"<td style='line-height: 50px'>"+data.list[i].publish_press+"</td>";
            // tbodyStr=tbodyStr+"<a href='register.jsp'>1223</a>";
            if(data.list[i].is_borrow==0){
              tbodyStr=tbodyStr+"<td style='line-height: 50px' ><a id='borrow' style='color: blue' onclick='borrow(this,"+data.list[i].book_id+")'>申请借阅</a></td>";
            }else {
              tbodyStr=tbodyStr+"<a href='book?action=borrow&book_id="+data.list[i].book_id+"'><td style='line-height: 50px'>已借阅</td></a>";
            }
            tbodyStr=tbodyStr+"</tr>";
            // var tr=$("<div>123</div>");
          }
          $("#tbody").html(tbodyStr);
        })
      })
    }
    $(document).ready(function () {
      show(curPage);



      $("#addBtn").click(function () {
        location.href="addBook.jsp";
      });
      $("#search_book").click(function () {
        show(curPage);
      });
      $("#index").click(function () {
        curPage=1;
        show(curPage);
      })
      $("#last").click(function () {
        curPage=curPage-1;
        if(curPage<1){
          alert("已经是首页了");
          // curPage=1;
        }else {
          show(curPage);
        }

      })
      $("#next").click(function () {
        curPage=curPage+1;
        if(curPage>pageCount){
          alert("没有更多了");
          // curPage=pageCount;
        }else {
          show(curPage);
        }

      })
      $("#end").click(function () {
        curPage=pageCount;
        show(curPage);
      })
    })
  </script>
</html>
