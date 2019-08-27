/**
 * 模块：feeinfo
 * 业务对象：收费项目
 * 作者:梁国豪
 * 
 */
$(function(){
	var rows=10;
	var page=1;
	var pageCount=0;
	var feeitemNo=0; //选择的收费序号
	
	//设置系统页面标题
	$("span#mainpagetille").html("收费项目");
	//取得收费项目的列表，分页模式
	function getListInfo(){
		//调用后台取得收费列表REST API
		$.getJSON("http://10.1.53.60:8080/feeitem/list/all/page",{page:page,rows:rows},function(data){
				//显示个数和页数
				$("span#count").html(data.count);
				$("span#pagecount").html(data.page+"/"+data.pageCount);
				pageCount=data.pageCount;
				//显示列表
				$("table#FeeitemTable tbody").html("");
				for(var i=0;i<data.list.length;i++){
					var tr="<tr id='"+data.list[i].no+"'><td>"+data.list[i].code+"</td><td>"+data.list[i].name+"</td></tr>";
					$("table#FeeitemTable tbody").append(tr);
				}
				//定义表格行的点击时间，取得选择的收费序号
				$("table#FeeitemTable tbody tr").on("click",function(){
					feeitemNo=$(this).attr("id");
					$("table#FeeitemTable tbody tr").css("background-color","#FFFFFF");
					$(this).css("background-color","#CDCD9A");
				});
		 });
	}	
	//定义分页导航链接处理事件
	$("div#page_nav a").on("click",function(event){
			  var action=$(this).attr("href");
			  event.preventDefault();
			  switch(action){
			  	case "top":
			  		page=1;
			  		getListInfo();
			  		break;
			  	case "pre":
			  		if(page>1){
			  			page=page-1;
			  			getListInfo();
			  		}
			  		break;
			  	case "next":
			  		if(page<pageCount){
			  			page=page+1;
			  			getListInfo();
			  		}
			  		break;
			  	case "last":
			  		page=pageCount;
			  		getListInfo();
			  		break;
			  }
		
	});
	
	//初始调用取得分页列表数据
	getListInfo();
	//点击增加链接处理，嵌入add.html
	$("a#FeeitemAddLink").off().on("click",function(event){
				
		$("div#FeeitemDialogArea").load("feeitem/add.html",function(){
			$("div#FeeitemDialogArea" ).dialog({
				title:"增加收费条目",
				width:600
			});
			//验证数据
			$("form#FeeitemAddForm" ).validate({
				  rules: {
				    code: {
				      required: true
				    },
				    name:{
				    	required: true
				    }
				  },
				  messages:{
					code: {
					      required: "收费编码为空"
					    },
					    name:{
					    	required:"收费名称为空"
					    }
				 }
			});
			//拦截增加表单提交
			$("form#FeeitemDepartmentAddForm").ajaxForm(function(result){
				if(result.status=="OK"){
					getListInfo(); 
				}
				//alert(result.message);
				//BootstrapDialog.alert(result.message);
				BootstrapDialog.show({
		            title: '收费操作信息',
		            message:result.message
		        });
				$("div#FeeitemDialogArea" ).dialog( "close" );
				$("div#FeeitemDialogArea" ).dialog( "destroy" );
				$("div#FeeitemDialogArea").html("");
				
			});
			//点击取消按钮处理
			$("input[value='取消']").on("click",function(){
				$( "div#FeeitemDialogArea" ).dialog( "close" );
				$( "div#FeeitemDialogArea" ).dialog( "destroy" );
				$( "div#FeeitemDialogArea" ).html("");
			});
		});
		
	});
	//点击修改按钮事件处理
	$("a#FeeitemModifyLink").off().on("click",function(event){
		if(feeitemNo==0){
			BootstrapDialog.show({
	            title: '收费部门操作信息',
	            message:"请选择要修改的收费条目"
	        });
		}
		else {
			$("div#FeeitemDialogArea").load("feeitem/modify.html",function(){
				//取得选择的部门
				$.getJSON("feeitem/get",{no:feeitemNo},function(data){
					if(data.status=="OK"){
						$("input[name='no']").val(feeitemNo);
						$("input[name='code']").val(data.model.itemcode);
						$("input[name='name']").val(data.model.itemname);
						
					}
				});
				
				$("div#FeeitemDialogArea" ).dialog({
					title:"收费修改",
					width:600
				});
				//拦截表单提交
				$("form#FeeitemModifyForm").ajaxForm(function(result){
					if(result.status=="OK"){
						getListInfo(); 
					}
					//alert(result.message);
					//BootstrapDialog.alert(result.message);
					BootstrapDialog.show({
			            title: '收费操作信息',
			            message:result.message
			        });
					$("div#FeeitemDialogArea" ).dialog( "close" );
					$("div#FeeitemDialogArea" ).dialog( "destroy" );
					$("div#FeeitemDialogArea").html("");
					
				});
				
				
				//点击取消按钮处理
				$("input[value='取消']").on("click",function(){
					$( "div#FeeitemDialogArea" ).dialog( "close" );
					$( "div#FeeitemDialogArea" ).dialog( "destroy" );
					$( "div#FeeitemDialogArea" ).html("");
				});
			});
			
		}
		
		
	});
	
	//点击删除按钮事件处理
	$("a#FeeitemDelteLink").off().on("click",function(event){
		
		if(feeitemNo==0){
			BootstrapDialog.show({
	            title: '收费操作信息',
	            message:"请选择要删除的收费条目"
	        });
		}
		else {
			//先检查此部门能否被删除
			$.getJSON("feeitem/checkDelete",{no:feeitemNo},function(data){
				if(data.status!="OK"){
					BootstrapDialog.show({
			            title: '收费操作信息',
			            message:data.message
			        });
				}
				else{
					BootstrapDialog.confirm('确认删除此收费条目?', function(result){
			            if(result) {
			                $.post("feeitem/delete",{no:feeitemNo},function(result){
			                	if(result.status=="OK"){
									getListInfo(); 
								}
								BootstrapDialog.show({
						            title: '收费操作信息',
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
	$("a#FeeitemViewLink").off().on("click",function(event){
		
		if(feeitemNo==0){
			BootstrapDialog.show({
	            title: '收费部门操作信息',
	            message:"请选择要查看的收费条目"
	        });
		}
		else{
			$("div#FeeitemDialogArea").load("feeitem/view.html",function(){
				//取得选择的部门
				$.getJSON("feeitem/get",{no:feeitemNo},function(data){
					if(data.status=="OK"){
						$("span#feeitemCode").html(data.model.itemcode);
						$("span#feeitemName").html(data.model.itemname);
						
					}
				});
				//弹出Dialog
				$("div#FeeitemDialogArea" ).dialog({
					title:"部门详细",
					width:600
				});
				//点击取消按钮处理
				$("input[value='返回']").on("click",function(){
					$( "div#FeeitemDialogArea" ).dialog( "close" );
					$( "div#FeeitemDialogArea" ).dialog( "destroy" );
					$( "div#FeeitemDialogArea" ).html("");
				});
			});
			
		}
	});
	
});