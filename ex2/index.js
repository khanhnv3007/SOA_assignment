var express = require('express');
var router = express.Router();
var app = express();
var port = 2000;

app.use(express.static(__dirname + "/public"));

var data = {
    "978-0071605526": "$25.00",
    "978-0321815736": "$46.29",
    "978-0321718334": "$39.99"
};

router.get("/book-price/:book_id", function (req, res) {
    res.json({price: data[req.params.book_id]});
});

app.use("/api", router);

app.listen(port, function () {
    console.log('run on port', port);
});