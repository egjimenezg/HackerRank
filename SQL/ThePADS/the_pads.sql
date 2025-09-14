SELECT CONCAT(name, "(",UPPER(SUBSTRING(occupation, 1, 1)), ")")
  AS result FROM occupations UNION
SELECT CONCAT("There are a total of ", count(occupation), " ", LOWER(occupation), "s.") as result
  FROM occupations group by occupation order by result;
