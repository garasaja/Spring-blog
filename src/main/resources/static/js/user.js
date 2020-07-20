let index = {
	
	init: function() {
		// 리스너
		let _this = this;
		$("#btn-save").on("click",function() {
			// 콜백
			_this.save();
		});
		
		// 리스너
		$("#btn-login").on("click",()=> {
			// 콜백
			this.login();
		});
	},
	
	save: function() {
		let data = {
				username: $("#username").val(),
				password: $("#password").val(),
				email: $("#email").val()
		};
		
		$.ajax({
			type: "POST",
			url:"/auth/joinProc",
			data:JSON.stringify(data),
			contentType:"application/json; charset=utf-8",
			dataType:"json"
		}).done(function(resp){

				alert("회원가입이 성공되었습니다.");
				location.href="/";
			
		}).fail(function(error){
			console.log(error);
			alert("회원가입실패");
			
		})
	},
	
	login: function() {
		let data = {
				username: $("#username").val(),
				password: $("#password").val()
		};
		
		$.ajax({
			type: "POST",
			url:"/auth/loginProc",
			data:JSON.stringify(data),
			contentType:"application/json; charset=utf-8",
			dataType:"json"
		}).done(function(resp){
			
				alert("로그인이 성공되었습니다.");
				location.href="/";
		
		}).fail(function(error){
			console.log(error);
			alert("로그인실패");
			
		})
	}
}

index.init();