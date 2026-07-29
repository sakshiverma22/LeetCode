# Write your MySQL query statement below
SELECT unique_id, name
FROM Employees d
LEFT JOIN EmployeeUNI e
ON e.id=d.id;