const express = require('express');
const morgan = require('morgan');

const app = express();

app.set('port', 4000);

app.use(morgan('dev'));
app.use(express.json()); //para entender formato json desde un contentType
app.use(express.urlencoded({ extended: false })); //para entender lo de un fomr HTML

app.use("/api/employees", require('./routes/employees.routes'));

module.exports = app;