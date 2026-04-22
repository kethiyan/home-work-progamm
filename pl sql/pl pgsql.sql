CREATE OR REPLACE FUNCTION get_total(
    m1 INT,
    m2 INT,
    m3 INT
)
RETURNS INT AS $$
BEGIN
    RETURN m1 + m2 + m3;
END;
$$ LANGUAGE plpgsql;


CREATE OR REPLACE PROCEDURE student_result(
    m1 INT,
    m2 INT,
    m3 INT
)
LANGUAGE plpgsql
AS $$
DECLARE
    total INT;
BEGIN
    total := get_total(m1, m2, m3);

    RAISE NOTICE 'Total Marks: %', total;

    IF total >= 150 THEN
        RAISE NOTICE 'Result: PASS';
    ELSE
        RAISE NOTICE 'Result: FAIL';
    END IF;
END;
$$;



CALL student_result(50, 60, 70);



CREATE OR REPLACE FUNCTION calc_si(
    p NUMERIC,
    r NUMERIC,
    t NUMERIC
)
RETURNS NUMERIC AS $$
BEGIN
    RETURN (p * r * t) / 100;
END;
$$ LANGUAGE plpgsql;


CREATE OR REPLACE PROCEDURE show_interest(
    p NUMERIC,
    r NUMERIC,
    t NUMERIC
)
LANGUAGE plpgsql
AS $$
DECLARE
    si NUMERIC;
    total NUMERIC;
BEGIN
    si := calc_si(p, r, t);
    total := p + si;

    RAISE NOTICE 'Principal Amount : %', p;
    RAISE NOTICE 'Simple Interest  : %', si;
    RAISE NOTICE 'Total Amount     : %', total;
END;
$$;


CALL show_interest(10000, 5, 2);

