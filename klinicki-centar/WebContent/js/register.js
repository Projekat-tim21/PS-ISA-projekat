$(document).ready(()=> {
	
	if(sessionStorage.getItem("user")){
		window.location='./';
	}
	$('#registracija').submit((event)=>{
		event.preventDefault();
		let username=$('#username').val();
		let ime=$('#ime').val();
		let grad=$('#grad').val();
		let prezime=$('#prezime').val();
		let telefon=$('#telefon').val();
		let password=$('#password').val();
		let email=$('#email').val();
		let password_confirm=$('#passwordConfirm').val();
		
		if (username.length < 3)                                  
	    { 
	        window.alert("Username mora sadrzati vise od 3 karaktera."); 
	        username.focus(); 
	        return false; 
	    } 
		if(password.length<5){
			window.alert("Password mora sadrzati vise od 5 karaktera."); 
	        username.focus(); 
	        return false; 
		}
		
		if(password!=password_confirm){
			window.alert("Polja za password i potvrdu password-a moraju biti ista");
			return false;
		}
		
		console.log('username', username);
		console.log('password', password);
		console.log(JSON.stringify({username, password, ime, prezime, grad, telefon, email}));
		
		
		$.post({
			url: 'rest/registracija',
			
			data: JSON.stringify({username, password, ime, prezime, grad, telefon, email}),
			contentType: 'application/json',
			success: function() {
				alert('Registrovali ste se');
				window.location='./logovanje.html';
					
				
			},
			error: function(e) {
				console.log(e);
				alert('Pogresni podaci!');
			}
		});		
		
		
	});
		
});


