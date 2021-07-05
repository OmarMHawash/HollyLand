<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link
      rel="stylesheet"
      href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
      integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
      crossorigin="anonymous"
    />
    <link
      rel="stylesheet"
      href="https://cdn.jsdelivr.net/npm/charts.css/dist/charts.min.css"
    />
    <link rel="stylesheet" href="/css/village.css">

    <title>Village</title>
  </head>
  <body>
    <header>
      <div></div>
      <div>
        <a href="#"><img src="/image/logo.png" alt="logo" /></a>
      </div>
      <div class="go-back"><a href="">Go Back</a></div>
    </header>
    <main>
      <h3 class="cName" style="font-size: 26px">City name</h3>
      <h1 class="vName" style="font-size: 40px">Village name</h1>
      <div class="images">
        <img src="./village_test.jpg" alt="image of village" />
        <img src="./village_test.jpg" alt="image of village" />
        <img src="./village_test.jpg" alt="image of village" />
      </div>
      <section>
        <div class="left" style="width: 35%">
          <table
            id="bar-example-17"
            class="
              charts-css
              bar
              show-labels show-primary-axis show-data-axes
              data-spacing-15
            "
          >
            <caption></caption>
            <thead>
              <tr>
                <th scope="col">Year</th>
                <th scope="col">Progress</th>
              </tr>
            </thead>
            <tbody>
              <tr>
                <th scope="row">Population</th>
                <td style="--size: 1.5">30000 people</td>
              </tr>
              <tr>
                <th scope="row">area</th>
                <td style="--size: 1.2">16 km</td>
              </tr>
            </tbody>
          </table>
        </div>
        <div class="right" style="width: 55%">
          <p>
            Lorem Ipsum is simply dummy text of the printing and typesetting
            industry. Lorem Ipsum has been the industry's standard dummy text
            ever since the 1500s, when an unknown printer took a galley of type
            and scrambled it to make a type specimen book. It has survived not
            only five centuries, but also the leap into electronic typesetting,
            remaining essentially unchanged. It was popularised in the 1960s
            with the release of Letraset sheets containing Lorem Ipsum passages,
            and more recently with desktop publishing software like Aldus
            PageMaker including versions of Lorem Ipsum
          </p>
        </div>
      </section>
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
            <h6 class="text-md-right">Report this Page</h6>
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
  </body>
</html>