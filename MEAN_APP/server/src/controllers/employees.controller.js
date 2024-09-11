const employeesCntrl = {};

employeesCntrl.getEmployees = (req, res) => {
  res.send('getEmployees');
};
employeesCntrl.createEmployee = (req, res) => {
  res.send('createEmployees');
};

module.exports = employeesCntrl;