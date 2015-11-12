var express = require('express');
var request = require('request');
var xml2js = require('xml2js');

var parser = new xml2js.Parser();
var router = express.Router();
var app = express();
var port = 2000;

app.use(express.static(__dirname + "/public"));

var data = {
    "978-0071605526": "$25.00",
    "978-0321815736": "$46.29",
    "978-0321718334": "$39.99"
};

var convertPrice = function (price, type, cb) {
    request.get("http://webservicex.net/CurrencyConvertor.asmx/ConversionRate?FromCurrency=USD&ToCurrency=" + type, function (error, response, body) {
        if (!error && response.statusCode == 200) {
            cb(body);
        }
    });
};

router.get("/book-price/:book_id", function (req, res) {
    res.json({price: data[req.params.book_id]});
});

router.get("/book-price/:book_id/ToCurrency/:type_currency", function (req, res) {
    convertPrice(data[req.params.book_id], req.params.type_currency, function (resp) {
        parser.parseString(resp, function (err, result) {
            res.json({price: parseFloat(result.double._) * parseFloat(data[req.params.book_id].replace("$", ""))});
        });
    })
});

app.use("/api", router);

app.listen(port, function () {
    console.log('run on port', port);
});