

    <!-- login css/js -->
    <link rel="stylesheet" href="css/loginStyle.css">
    <link rel="stylesheet" href="css/form.css">
    <script src="js/form.js"></script>
    <script src="js/signup-validator.js"></script>
    <script src="js/login.js"></script>
    <script src="js/loginTransition.js"></script>

    <div class="row text-center d-flex justify-content-center">
        <img src="img/logo.png" alt="Friend's Bets">
    </div>
    <main class="row text-center d-flex justify-content-center">
        <form class="form-signin text-center">
            <h1 class="h3 mb-3 font-weight-normal">Please sign in</h1>
            <label for="inputEmail" class="sr-only">Email address</label>
            <input type="email" id="inputEmail" class="form-control" placeholder="Email address" required autofocus>
            <label for="inputPassword" class="sr-only">Password</label>
            <input type="password" id="inputPassword" class="form-control" placeholder="Password" required>
            <div class="checkbox mb-3">
                <label>
                    <input type="checkbox" value="remember-me"> Remember me
                </label>
            </div>
            <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
        </form>
        <!-- 
        <a class ="col-12" href="signup">
            <button class="btn btn-lg btn-primary btn-block" type="submit">Register</button>
        </a>
         -->
        <button class="signup btn btn-lg btn-primary btn-block" type="submit">Register</button>
        <a class ="col-12" href="${pageContext.request.contextPath}/">
            <button class="btn btn-lg btn-primary btn-block" type="submit">AdminButton</button>
        </a>
    </main>
    
       <form class="signup-form" action="signup" method="post" class="content p-2 mx-auto">
           <button class="backtologin btn btn-danger btn-block mt-3">
                   <i class="fas fa-undo mr-2"></i>Back to loggin
           </button>
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
               <input type="text" class="form-control rounded ${empty errors ? '' : (errors.containsKey('picture') ? 'is-invalid' : 'is-valid')}" name="picture" value="${editedMember.picture}">
               <span class="floating-label">picture</span>
               <p class="invalid-feedback">${errors.picture}</p>
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