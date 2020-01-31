

    <!-- login css/js -->
    <link rel="stylesheet" href="css/loginStyle.css">
    <script src="js/login.js"></script>
    <script src="js/dynamicTransition.js"></script>

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
            <button class="btn btn-lg btn-primary btn-block" type="submit">MagicButton</button>
        </a>
    </main>