//목표 : .confirm-link 를 누르면 확인창 출력 후 "예"를 누를 때에만 이동 처리
$(function(){
	$("a.confirm-link").click(function(e){
		//var message = $(this).attr("data-message");
		var message = $(this).data("message");
		if(!message){
			message = "정말 이동하시겠습니까?";
		}
		
		var choice = window.confirm(message);
		if(!choice){
			e.preventDefault();//return false;
		}
	});
});