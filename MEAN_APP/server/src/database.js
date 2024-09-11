const mongoose = require('mongoose');

mongoose
  .connect("mongodb://127.0.0.1:27017/mean-employee")
  .then((db) => console.log("db is connected"))
  .catch((err) => console.error(err));
