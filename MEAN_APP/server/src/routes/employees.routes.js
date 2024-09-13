const { Router } = require('express');
const router = Router();

const employeesCntrl = require('../controllers/employees.controller.js');

router.get('/', employeesCntrl.getEmployees);
router.get('/:id', employeesCntrl.getEmployee);
router.post('/', employeesCntrl.createEmployee);

module.exports = router;