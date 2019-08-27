/**
 * 小区管理的前端控制JS
 * 作者：刘勇超
 * 
 */

//取得小区的列表，分页模式
(function(){
	var rows=10;
	var page=1;
	var pageCount=0;
	var BuildingTypeNo=0; //选择的部门编号
	 
	$("span#mainpagetille").html("楼宇管理");
	
	function getListInfo(){
		//调用后台取得部门列表REST API
		$.getJSON("http://localhost/buildingType/list/all/page",{page:page,rows:rows},function(data){
				//显示个数和页数
				$("span#count").html();
				$("span#pagecount").html(data.page+"/"+data.pageCount);
				pageCount=data.pageCount;
				//显示列表
				$("table#BuildingTypeTable tbody").html("");
				for(var i=0;i<data.list.length;i++){
					var tr="<tr id='"+data.list[i].no+"'><td>"+data.list[i].TYPENO+"</td><td>"+data.list[i].TYPENAME+"</td></tr>";
					$("table#BuildingTypeTable tbody").append(tr);
				}
				//定义表格行的点击时间，取得选择的部门编号
				$("table#BuildingTypeTable tbody tr").on("click",function(){
					BuildingTypeNo=$(this).attr("id");
					$("table#BuildingTypeTable tbody tr").css("background-color","#FFFFFF");
					$(this).css("background-color","#CDCD9A");
				});
		 });
	}	
});