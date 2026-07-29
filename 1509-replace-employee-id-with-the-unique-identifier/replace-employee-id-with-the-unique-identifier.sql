# Write your MySQL query statement below
-- SELECT unique_id, name
-- FROM Employees d
-- LEFT JOIN EmployeeUNI e
-- ON e.id=d.id;

SELECT EmployeeUNI.unique_id,
       Employees.name
FROM Employees
LEFT JOIN EmployeeUNI
ON Employees.id = EmployeeUNI.id;