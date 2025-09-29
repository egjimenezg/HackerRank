SELECT CONCAT(name, "(",UPPER(SUBSTRING(occupation, 1, 1)), ")")
  AS result FROM occupations UNION
SELECT CONCAT("There are a total of ", COUNT(occupation), " ", LOWER(occupation), "s.") as result
  FROM occupations GROUP BY occupation ORDER BY result;
