<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://unpkg.com/leaflet@1.7.1/dist/leaflet.css"/>
    <link
      rel="stylesheet"
      href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
      integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
      crossorigin="anonymous"
    />
    <title>Maps Project</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <link rel="stylesheet" href="/css/homepage.css">

    <script>
    //     $(document).ready(function(){
    //     $(".ct1").hide();
    
    //     $("#s1").click(function(){
    //         $(".ct1").toggle();
    </script>
</head>
<body>
    <header>
        <div></div>
        <div>
          <a href="#"><img src="/img/logo.png" alt="logo" /></a>
        </div>
        <div class="go-back"><a href="">Go Back</a></div>
      </header>
    <main>
        <div id="map">

        </div>
        <div class="other-one">
        </div>

        
    </main>
    <footer class="footer">
        <div class="container">
          <div class="row">
            <div class="col-md-5">
              <h5><i class="fa fa-road"></i> HolyLand</h5>
              <div class="row">
                <div class="col-6">
                  <ul class="list-unstyled">
                    <li><a href="">Homepage</a></li>
                    <li><a href="">Admin page</a></li>
                    <li><a href="">Send Us An Image</a></li>
                  </ul>
                </div>
              </div>
            </div>
            <div class="col-md-2">
              <h6 class="text-md-right">Send Us a Message</h6>
              <hr />
            </div>
            <div class="col-md-5">
              <form action="/add_message">
                <fieldset class="form-group">
                  <textarea class="form-control" placeholder="Message"></textarea>
                </fieldset>
                <fieldset class="form-group text-xs-right">
                  <button type="button" class="btn btn-secondary btn-lg">
                    Send
                  </button>
                </fieldset>
              </form>
            </div>
          </div>
        </div>
      </footer>
    <script src="https://unpkg.com/leaflet@1.7.1/dist/leaflet.js"></script>
    <script src="main.js"></script>
</body>
</html>