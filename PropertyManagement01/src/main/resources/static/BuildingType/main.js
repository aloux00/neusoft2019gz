/**
 * 小区管理前端控制JS
 * 作者：刘勇超
 * 
 */
$(function(){
	var rows=10;
	var page=1;
	var pageCount=0;
	var TypeNO=0; 
	
	$("span#mainpagetille").html("小区管理");
	//取得小区的列表，分页模式
	function getListInfo(){
		//调用后台取得小区列表
		$.getJSON("http://localhost:8080/buildingType/list/all/page",{page:page,rows:rows},function(data){
				//显示个数和页数
				$("span#count").html(data.count);
				$("span#pagecount").html(data.page+"/"+data.pageCount);
				pageCount=data.pageCount;
				//显示列表
				$("table#buildingTypeTable tbody").html("");
				for(var i=0;i<data.list.length;i++){
					var tr="<tr id='"+data.list[i].typeno+"'><td>"+data.list[i].typename+"</td></tr>";
					$("table#buildingTypeTable tbody").append(tr);
				}
				//定义表格行的点击时间，取得选择的编号
				$("table#buildingTypeTable tbody tr").on("click",function(){
					TypeNONo=$(this).attr("id");
					$("table#buildingTypeTable tbody tr").css("background-color","#FFFFFF");
					$(this).css("background-color","#CDCD9A");
				});
		 });
	}

	
	
	getListInfo();
	//点击增加链接处理，嵌入add.html
	$("a#BuildingTypeAddLink").off().on("click",function(event){	
		$("div#BuildingTypeDialogArea").load("BuildingType/add.html",function(){
			$("div#BuildingTypeDialogArea" ).dialog({
				title:"增加小区",
				width:600
			});
			//验证数据
			$("form#BuildingTypeAddForm" ).validate({
				  rules: {
				    TYPENO: {
				      required: true
				    },
				    TYPENAME:{
				    	required: true
				    }
				  },
				  messages:{
					  TYPENO: {
					      required: "部门编码为空"
					    },
					    TYPENAME:{
					    	required:"部门名称为空"
					    }
				 }
			});
			//拦截增加表单提交
			$("form#BuildingTypeAddForm").ajaxForm(function(result){
				if(result.status=="OK"){
					getListInfo(); 
				}
				//alert(result.message);
				//BootstrapDialog.alert(result.message);
				BootstrapDialog.show({
		            title: '小区操作信息',
		            message:result.message
		        });
				$("div#BuildingTypeDialogArea" ).dialog( "close" );
				$("div#BuildingTypeDialogArea" ).dialog( "destroy" );
				$("div#BuildingTypeDialogArea").html("");
				
			});
			//点击取消按钮处理
			$("input[value='取消']").on("click",function(){
				$( "div#BuildingTypeDialogArea" ).dialog( "close" );
				$( "div#BuildingTypeDialogArea" ).dialog( "destroy" );
				$("div#BuildingTypeDialogArea").html("");
			});
		});
		
	});
	
	
	
	//点击修改按钮事件处理
	$("a#BuildingTypeModifyLink").off().on("click",function(event){
		if(departmentNo==0){
			BootstrapDialog.show({
	            title: '部门操作信息',
	            message:"请选择要修改的部门"
	        });
		}
		else {
			$("div#BuildingTypeDialogArea").load("department/modify.html",function(){
				//取得选择的部门
				$.getJSON("department/get",{no:departmentNo},function(data){
					if(data.status=="OK"){
						$("input[name='no']").val(departmentNo);
						$("input[name='code']").val(data.model.code);
						$("input[name='name']").val(data.model.name);
						
					}
				});
				
				$("div#BuildingTypeDialogArea" ).dialog({
					title:"部门修改",
					width:600
				});
				//拦截表单提交
				$("form#BuildingTypeModifyForm").ajaxForm(function(result){
					if(result.status=="OK"){
						getListInfo(); 
					}
					//alert(result.message);
					//BootstrapDialog.alert(result.message);
					BootstrapDialog.show({
			            title: '部门操作信息',
			            message:result.message
			        });
					$("div#BuildingTypeDialogArea" ).dialog( "close" );
					$("div#BuildingTypeDialogArea" ).dialog( "destroy" );
					$("div#BuildingTypeDialogArea").html("");
					
				});
				
				
				//点击取消按钮处理
				$("input[value='取消']").on("click",function(){
					$( "div#BuildingTypeDialogArea" ).dialog( "close" );
					$( "div#BuildingTypeDialogArea" ).dialog( "destroy" );
					$("div#BuildingTypeDialogArea").html("");
				});
			});
			
		}
		
		
	});
	
	//点击删除按钮事件处理
	$("a#DepartmentDelteLink").off().on("click",function(event){
		
		if(departmentNo==0){
			BootstrapDialog.show({
	            title: '部门操作信息',
	            message:"请选择要删除的部门"
	        });
		}
		else {
			//先检查此部门能否被删除
			$.getJSON("department/checkDelete",{no:departmentNo},function(data){
				if(data.status!="OK"){
					BootstrapDialog.show({
			            title: '部门操作信息',
			            message:data.message
			        });
				}
				else{
					BootstrapDialog.confirm('确认删除此部门么?', function(result){
			            if(result) {
			                $.post("department/delete",{no:departmentNo},function(result){
			                	if(result.status=="OK"){
									getListInfo(); 
								}
								BootstrapDialog.show({
						            title: '部门操作信息',
						            message:result.message
						        });
			                });
			            }
			        });
				}
			});
			
		}
		
	});
	//点击查看详细按钮事件处理
	$("a#DepartmentViewLink").off().on("click",function(event){
		
		if(departmentNo==0){
			BootstrapDialog.show({
	            title: '部门操作信息',
	            message:"请选择要查看的部门"
	        });
		}
		else{
			$("div#DepartmentDialogArea").load("department/view.html",function(){
				//取得选择的部门
				$.getJSON("department/get",{no:departmentNo},function(data){
					if(data.status=="OK"){
						$("span#departmentCode").html(data.model.code);
						$("span#departmentName").html(data.model.name);
						
					}
				});
				//弹出Dialog
				$("div#DepartmentDialogArea" ).dialog({
					title:"部门详细",
					width:600
				});
				//点击取消按钮处理
				$("input[value='返回']").on("click",function(){
					$( "div#DepartmentDialogArea" ).dialog( "close" );
					$( "div#DepartmentDialogArea" ).dialog( "destroy" );
					$("div#DepartmentDialogArea").html("");
				});
			});
			
		}
	});
	
});