

  function checkForm(form)
  {
    if(form.korIme.value == "") {
      alert("Error: Username cannot be blank!");
      form.username.focus();
      return false;
    }
    re = /^\w+$/;
    if(!re.test(form.korIme.value)) {
      alert("Error: Username must contain only letters, numbers and underscores!");
      form.username.focus();
      return false;
    }
    if(form.sifra.value != "" && form.sifra.value == form.sifra-confirm.value) {
      if(form.sifra.value.length < 6) {
        alert("Error: Password must contain at least six characters!");
        form.sifra.focus();
        return false;
      }
      if(form.sifra.value != form.sifra-confirm.value) {
          if(form.sifra.value.length < 6) {
            alert("Error: Polja za sifru i potvrdu sifre moraju biti ista!");
            form.sifra.focus();
            return false;
          }
      if(form.sifra.value == form.korIme.value) {
        alert("Error: Password must be different from Username!");
        form.sifra.focus();
        return false;
      }
      re = /[0-9]/;
      if(!re.test(form.sifra.value)) {
        alert("Error: password must contain at least one number (0-9)!");
        form.sifra.focus();
        return false;
      }
      re = /[a-z]/;
      if(!re.test(form.sifra.value)) {
        alert("Error: password must contain at least one lowercase letter (a-z)!");
        form.sifra.focus();
        return false;
      }
      re = /[A-Z]/;
      if(!re.test(form.sifra.value)) {
        alert("Error: password must contain at least one uppercase letter (A-Z)!");
        form.sifra.focus();
        return false;
      }
    } else {
      alert("Error: Please check that you've entered and confirmed your password!");
      form.sifra.focus();
      return false;
    }

    alert("You entered a valid password: " + form.sifra.value);
    return true;
    }}
