const apiKey = 'pk.eyJ1IjoiYWxmcmVkMjAxNiIsImEiOiJja2RoMHkyd2wwdnZjMnJ0MTJwbnVmeng5In0.E4QbAFjiWLY8k3AFhDtErA';

const mymap = L.map('map').setView([31.991680678023267,35.17389580867246], 9);

L.tileLayer('https://api.mapbox.com/styles/v1/{id}/tiles/{z}/{x}/{y}?access_token={accessToken}', {
    maxZoom: 18,
    id: 'mapbox/streets-v11',
    tileSize: 512,
    zoomOffset: -1,
    accessToken: apiKey
}).addTo(mymap);

// Adding Marker

const marker1 = L.marker([32.22111, 35.25444]).addTo(mymap);
const marker2 = L.marker([32.4646, 35.2939]).addTo(mymap);
const marker3 = L.marker([32.3194,35.0240]).addTo(mymap);
const marker4 = L.marker([31.7054, 35.2024]).addTo(mymap);
const marker5 = L.marker([31.9038, 35.2034]).addTo(mymap);
const marker6 = L.marker([31.5326, 35.0998]).addTo(mymap);
const marker7 = L.marker([31.7683, 35.2137]).addTo(mymap);

// Add popup message
let template1 = 
`
<a href="/city/nablus"><button  class="btn btn-outline-primary" id="s1">Nablus</button></a>
`

let template2 = `

<a href=""><button  class="btn btn-outline-primary" id="s1">Jenin</button></a>

`
let template3 = 
`
<h2><a href="/nablus">tulkarem</a></h2>
`

let template4 = `

<h2><a href="/nablus">beithlehem</a></h2>

`
let template5 = 
`
<h2><a href="/nablus">ramallah</a></h2>
`

let template6 = `

<h2><a href="/nablus">hebron</a></h2>

`
let template7 = 
`
<h2><a href="/nablus">Jerusalem</a></h2>
`
marker1.bindPopup(template1);
marker2.bindPopup(template2);
marker3.bindPopup(template3);
marker4.bindPopup(template4);
marker5.bindPopup(template5);
marker6.bindPopup(template6);
marker7.bindPopup(template7);
