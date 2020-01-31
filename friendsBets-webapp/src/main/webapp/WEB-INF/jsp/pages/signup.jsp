
    <link rel="stylesheet" href="css/loginStyle.css">
    <link rel="stylesheet" href="css/form.css">
    <script src="js/form.js"></script>
    <script src="js/signup-validator.js"></script>
    <script src="js/login.js"></script>

    <content>
    
    
	    <div class="row text-center d-flex justify-content-center">
	        <img src="img/logo.png" alt="Friend's Bets">
	    </div>
        <form action="signup" method="post" class="content p-2 mx-auto">
            <div class="input-group mt-3">
                <input type="text" class="form-control rounded ${empty errors ? '' : (errors.containsKey('alias') ? 'is-invalid' : 'is-valid')}" name="alias" value="${editedMember.alias}" required>
                <span class="floating-label">Alias</span>
                <p class="invalid-feedback">${errors.alias}</p>
            </div>
            <div class="input-group mt-3">
                <input type="text" class="form-control rounded ${empty errors ? '' : (errors.containsKey('email') ? 'is-invalid' : 'is-valid')}" name="email" value="${editedMember.email}" required>
                <span class="floating-label">Email</span>
                <p class="invalid-feedback">${errors.email}</p>
            </div>
            <div class="input-group mt-3">
                <input type="password" class="form-control rounded ${empty errors ? '' : (errors.containsKey('password') ? 'is-invalid' : 'is-valid')}" name="password" value="${editedMember.password}" required>
                <span class="floating-label">Password</span>
                <p class="invalid-feedback">${errors.password}</p>
            </div>
            <button type="submit" class="btn btn-success btn-block mt-3">
                    <i class="fas fa-check mr-2"></i>Sign up
            </button>
        </form>
    </content>


