<%@include  file="header.jsp" %>

<div class="container my-3">
    <div class="bg-success text-center">
        <h1 class="jumborton">Add User</h1>
    </div>
    <!--    start form-->
    <form action="addUser.jsp"  method="post">
        <div class="row">
            <div class="col-md-6">
                <label for="exampleInputEmail1" class="form-label">Full Name</label>
                <input type="text" class="form-control" id="givenName" name="fullName" placeholder="Jack Sparrow">
            </div>

            <div class="col-md-6">
                <label for="exampleInputEmail1" class="form-label">User Name</label>
                <input type="text" class="form-control" id="lastName" name="userName" placeholder="username">
            </div>        
        </div>
        <!-- start 2nd row-->
            <div class="row">
            <div class="col-md-6">
                <label for="exampleInputEmail1" class="form-label">Password</label>
                <input type="password" class="form-control" id="givenName" name="password" placeholder="*******">
            </div>

            <div class="col-md-6">
                <label for="exampleInputEmail1" class="form-label">Email: </label>
                <input type="email" class="form-control" id="lastName" name="email" placeholder="example@gmail.com">
            </div>        
        </div>
        
        <!--end 2nd row-->
        <div class="row mt-3 text-center">
            <div class="col-md-6">
                <button type="submit" class="btn btn-success text-center" >Save</button>

            </div>
            
             <div class="col-md-6">
                 <button type="reset" class="btn btn-danger text-center" >Reset</button>

            </div>
        </div>
    </form>

    <!--end form    -->
</div>


<%@include file="footer.jsp" %>