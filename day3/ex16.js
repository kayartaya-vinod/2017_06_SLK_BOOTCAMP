
function convertToAge(dt){
	var dob = new Date(dt);
	var today = new Date();
	var diff = today - dob;
	var age = new Date(diff);

	return age.getFullYear() - 1970;
}

function validate(){

	var email, password;
	email = document.getElementById("email").value;
	password = document.getElementById("secret_code").value;

	var out = "";

	// check for mandatory fields
	if(!email){
		out += "<li>Email is required</li>";
	}
	if(!password){
		out += "<li>Password is required</li>";
	}

	// check for emails' format validaty
	var re = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
	if(email && !re.test(email)){
		out += "<li>Invalid email pattern</li>";
	}

	// check for min and max length
	if(password && (password.length<3 || password.length>15)){
		out += "<li>Password should between 3 to 15 letters</li>";
	}

	if(out){
		var output = document.getElementById("output");
		output.innerHTML = "<ul>" + out + "</ul>";
		return false;
	}

	return true;
}