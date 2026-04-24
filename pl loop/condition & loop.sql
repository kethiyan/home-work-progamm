DO $$
DECLARE
    a INTEGER := 10;
    b INTEGER := 25;
    c INTEGER := 15;
BEGIN
    IF a >= b AND a >= c THEN
        RAISE NOTICE 'Greatest number is %', a;
    ELSIF b >= a AND b >= c THEN
        RAISE NOTICE 'Greatest number is %', b;
    ELSE
        RAISE NOTICE 'Greatest number is %', c;
    END IF;
END $$;



DO $$
DECLARE
    num INTEGER := 15;
BEGIN
    IF num % 2 = 0 THEN
        RAISE NOTICE '% is Even', num;
    ELSE
        RAISE NOTICE '% is Odd', num;
    END IF;
END $$;



DO $$
DECLARE
    age INTEGER := 20;
BEGIN
    IF age >= 18 THEN
        RAISE NOTICE 'Person is eligible for voting.';
    ELSE
        RAISE NOTICE 'Person is not eligible for voting.';
    END IF;
END $$;

DO $$
BEGIN
    FOR i IN 1..20 LOOP
        IF i % 2 <> 0 THEN
            RAISE NOTICE '%', i;
        END IF;
    END LOOP;
END $$;



