var players = [	{name: "Toto", avatar: "red"},
				{name: "Tata", avatar: "blue"},
				{name: "Titi", avatar: "green"}];


function update(){
	$.get("v1/userdb/lobby/", function(data, status){
		console.log(data);
		console.log(status);
		//console.log(typeof(data));
	})
	.done(function() {
    	//alert( "second success" );
  	})
	.fail(function() {
		swal("Loggin failed", "No match found between this username and password.", "error");
  	});




	var playersList = $(".queue_container .queue_line .queue_item");
	for(var i = 0 ; i < 8 ; i++){
		var playerItem = $(playersList[i]);
		if(players[i]){
			playerItem.children(".queue_name").text(players[i].name);
			playerItem.children(".queue_avatar").css("background-color", players[i].avatar);
		}else{
			playerItem.children(".queue_name").text("Empty");
			playerItem.children(".queue_avatar").css("background-color", "LightGray");

		}
	}
}

function join(){
		
}

function leave(){

}

$(function(){
	update();
})