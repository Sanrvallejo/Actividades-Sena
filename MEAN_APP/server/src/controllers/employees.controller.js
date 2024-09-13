const employeesCntrl = {};
const Employee = require('../models/Employee');

//método para obtener todos los empleados
employeesCntrl.getEmployees = async (req, res) => {
  const employees = await Employee.find();
  res.json(employees);
};

//método para obtener un empleado
employeesCntrl.getEmployee = async (req, res) => {
  const employee = await Employee.findById(req.params.id);
  //Otra forma para obtener un solo registro mediante findOne
  //const employees = await Employee.findOne({ _id: req.params.id });
  res.json(employee);
};

//método para crear un empleado
employeesCntrl.createEmployee = async (req, res) => {
  const newEmployee = new Employee(req.body);
  
  await newEmployee.save()
  
  res.send({ message: 'Employee created successfully' });
};

module.exports = employeesCntrl;