--Funcion de buscar por tabla
CREATE OR REPLACE FUNCTION public.sp_get_users(
	)
    RETURNS TABLE(id character varying, fullname character varying, email character varying)
    LANGUAGE 'plpgsql'
    COST 100
    VOLATILE PARALLEL UNSAFE
    ROWS 1000

AS $BODY$
	BEGIN
		RETURN QUERY
			SELECT USERS.ID as "a", USERS.FULLNAME as "b", USERS.EMAIL as "c" FROM USERS;
	END;
$BODY$;

--Procedimiento de almacenar

CREATE OR REPLACE PROCEDURE public.sp_save_user(
	IN i_fullname character varying,
	IN i_email character varying,
	INOUT r_id character varying)
LANGUAGE 'plpgsql'
AS $BODY$
DECLARE
	_conteo integer;
begin
	if i_fullname is NULL then
		r_id = 'x';
		RAISE EXCEPTION 'Falta nombre';
		return;
	end if;

	if i_email is NULL then
		r_id = 'x';
		RAISE EXCEPTION 'Falta email';
		return;
	end if;

-- 	busca otros correos
	SELECT COUNT(*) into _conteo
		from users
		where email = i_email;

	if(_conteo>0) then
        RAISE EXCEPTION 'email ya existe';
        r_id = 'x';
        RETURN;
	end if;

	INSERT INTO users(id,fullname,email)
		VALUES (r_id,i_fullname,i_email)
		RETURNING id INTO r_id;
end;
$BODY$;
