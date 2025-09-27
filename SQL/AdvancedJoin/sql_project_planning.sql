SELECT s_d.start_date, min(e_d.end_date) FROM (
  SELECT p1.start_date as start_date
  FROM projects p1 LEFT JOIN projects p2 ON
    STR_TO_DATE(p2.start_date, '%Y-%m-%d') = (STR_TO_DATE(p1.start_date, '%Y-%m-%d') - 1)
  WHERE p2.start_date IS NULL
) s_d
JOIN (
   SELECT p3.end_date, p4.end_date as next_date
   FROM projects p3 LEFT JOIN projects p4 ON
    STR_TO_DATE(p4.end_date, '%Y-%m-%d') = (STR_TO_DATE(p3.end_date, '%Y-%m-%d') + 1)
   WHERE p4.end_date IS NULL
) e_d
ON s_d.start_date < e_d.end_date
GROUP BY s_d.start_date
ORDER BY DATEDIFF(s_d.start_date, min(e_d.end_date)) desc, s_d.start_date
