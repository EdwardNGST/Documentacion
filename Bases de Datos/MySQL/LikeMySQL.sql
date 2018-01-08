#To find names beginning with b:
SELECT * FROM pet WHERE name LIKE 'b%';
#To find names ending with fy:
SELECT * FROM pet WHERE name LIKE '%fy';
#To find names containing a w:
SELECT * FROM pet WHERE name LIKE '%w%';