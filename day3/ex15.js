function printTable(){
	var t1 = document.getElementById("num");
	var out = document.getElementById("output");

	t1.focus();
	t1.select();

	if(!t1.value){
		out.innerHTML = "<h3 class='err'>Please enter a number!</h3>";
		return;
	}

	if(isNaN(t1.value)){
		out.innerHTML = "<h3 class='err'>Invalid input!</h3>";
		return;
	}

	var num = parseInt(t1.value);
	out.innerHTML = "<h2>Multiplication table for " + num + "</h2>";

	for(var i=1; i<=10; i++){
		var str = "<div>" + num + " X " + i + " = " + (num*i) + "</div>";
		out.innerHTML += str;
	}

	t1.value = "";
	

}

function init(){
	document.getElementById("num").focus();
}

window.onload = init;






