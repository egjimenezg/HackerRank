SELECT s.name FROM students s
  INNER JOIN packages sp ON sp.id = s.id
LEFT JOIN friends f ON f.id = s.id
  INNER JOIN packages bfp ON bfp.id = f.friend_id
WHERE bfp.salary > sp.salary ORDER BY bfp.salary;
