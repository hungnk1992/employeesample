# employeesample
To illustrate how app works with DB

# DB employees.sql
Create DB and load data follow tutorials

# SP
CREATE PROCEDURE SelectEmployees(
	IN empNum INT,
	IN gen VARCHAR(1)
)
BEGIN
	SELECT * 
 	FROM employees WHERE 
		CASE 
			WHEN gen= 'F' THEN gender = 'F'
            WHEN gen= 'M' THEN gender = 'M'
            ELSE gender = 'F' OR gender = 'M'
        END
    LIMIT empNum;
END //

DELIMITER ;
