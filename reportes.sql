SELECT *
FROM CLIENTE
;

--------------------


SELECT COUNT(vi.fecha) as "pasajeros", vi.fecha, bu.nombre_ruta
FROM VIAJE as vi,BUS bu
WHERE vi.placa_bus = bu.placa 
GROUP BY vi.fecha, bu.nombre_ruta

;
---------------------


SELECT COUNT(fecha)*3000 as "TOTAL VENTAS", fecha
FROM VENTA_TARJETAS
WHERE fecha = '2016-08-21'---fecha solicitada
GROUP BY fecha
;

----------------------------

SELECT cli.nombre as "USUARIO", recl.descripcion as "DESCRIPCION RECLAMO", emp.nombre, emp.apellido director
FROM RECLAMOS as recl, CLIENTE as cli,EMPLEADO as emp
WHERE recl.cedula_cliente = cli.cedula AND recl.director_id = emp.empleado_id 

;
------------------------------------

SELECT DISTINCT b.placa, conductor.nombre, conductor.apellido
FROM BUS b,MANEJO_BUSES man, EMPLEADO conductor
WHERE b.tipo = 1 AND b.placa = man.placa_bus AND man.conductor_id = conductor.empleado_id
ORDER BY b.placa;

-------------------------------------


SELECT nombre, descripcion
FROM RUTA;

---------------------------------------


SELECT num_tiquete, motivo, descripcion
FROM RECLAMOS




