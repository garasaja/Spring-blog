let index = {
	
	init: function() {
		// 리스너
		let _this = this;
		$("#btn-save").on("click",function() {
			// 콜백
			_this.save();
		});
		
		$("#btn-delete").on("click",()=> {
			this.deleteById();
		});
		
		$("#btn-update-mode").on("click",()=> {
			this.updateMode();
		});
		
		$("#btn-update").on("click",()=> {
			this.update();
		});
		$("#btn-update").hide();
	},
	
	save: function() {
		let data = {
				title: $("#title").val(),
				content: $("#content").val(),
				userId: $("#userId").val()
		};
		
		$.ajax({
			type: "POST",
			url:"/post",
			data:JSON.stringify(data),
			contentType:"application/json; charset=utf-8",
			dataType:"json"
		}).done(function(resp){
				console.log(resp);
				alert("글쓰기성공");
				location.href="/";
			
		}).fail(function(error){
			console.log(error);
			alert("글쓰기실패");
			
		})
	},
	
	deleteById: function() {
		let data = {
				id: $("#id").val()			
		};
		
		$.ajax({
			type: "DELETE",
			url:"/post/"+data.id,
			dataType:"json"
		}).done(function(resp){
				console.log(resp);
				alert("삭제성공");
				location.href="/";
			
		}).fail(function(error){
			console.log(error);
			alert("fail삭제실패");
			
		})
	},
	
	updateMode: function() {
		$("#btn-update-mode").hide();
		$("#btn-update").show();
				
		$("#title").attr("readOnly",false);
		$("#content").attr("readOnly",false);
	},
	
	update: function() {
		let data = {
				id: $("#id").val(),	
				title: $("#title").val(),
				content: $("#content").val()
				
		};
		
		$.ajax({
			type: "PUT",
			url:"/post/"+data.id,
			data:JSON.stringify(data),
			contentType:"application/json; charset=utf-8",
			dataType:"json"
		}).done(function(resp){
				console.log(resp);
				alert("수정성공");
				location.href="/post/"+data.id;
			
		}).fail(function(error){
			console.log(error);
			alert("수정실패");
			
		})
	}
	
}

index.init();