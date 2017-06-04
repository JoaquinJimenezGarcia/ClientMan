# [ClientMan](http://jojigarcia.me/ClientManWeb/)
Gestor de clientes escrita en Java para escritorio. Edición especial Thermomix.

## Cómo funciona.
Antes de nada, el usuario deberá iniciar sesión en el servidor de ClientMan para poder hacer uso de la aplicación. Por defecto vienen configurados dos: root (con todos los permisos) e invitado (solo con permisos de lectura).

El gestor trae cargado por defecto varios clientes registrados que puede borrar. Están ahí solamente para comprobar su funcionamiento antes de ingresar nuevos clientes y llevar acabo acciones con ellos.

### Opción 1: 
Permite registrar un cliente persona en el gestor con todos sus datos.
### Opción 2:
Permite registrar una empresa como cliente con todos sus datos y los de una persona de contacto.
### Opción 3: 
Lista todos los clientes, tanto personas como empresas, registrados en el gestor, ordenados alfabéticamente por el nombre.
### Opción 4: 
Permite borrar un cliente del gestor (si se ha vendido, sus datos se mantendrán entre los clientes a los que se les ha vendido una máquina para futuras referencias y compras, solo se borra de la lista actual de clientes).
### Opción 5:
Seleccionando un cliente, lleva a cabo una venta de una Thermomix a dicho cliente (ya sea persona o empresa), enviando un email a su correo electrónico avisando de que se ha completado la compra existosamente. Así mismo, copia los datos de dicho cliente a una lista nueva dónde apareceran todos los clientes que están esperando recibir su producto.
### Opción 6:
Establece una búsqueda de todos los clientes por nombre (ya sea de la persona en concreto o de la empresa). Opción ideal cuando buscamos el teléfono, correo, o DNI/NIF de algún cliente.
### Opción 7:
Muestra una lista de clientes que están a la espera de recibir su Thermomix ordenada alfabéticamente por nombre. Los clientes serán añadidos a esta lista automáticamente cuando les sea asignada una venta, y desaparecerán una vez el plazo de espera haya llegado a su fin (recibió la máquina y ya no pertenece a la lista de clientes que la esperan).
### Opción 8:
Comprueba teniendo en cuenta la fecha y hora actual si algún cliente ya cumplió el plazo de espera predefinido para marcarlo como cliente que ya recibió su producto. Elimina a dicho cliente instantaneamente de la lista de clientes esperados y lo traslada a la de transiciones terminandas.
### Opción 9:
Lista alfabéticamente todos los clientes que recibieron su máquina, indicando la fecha y el vendedor (usuario con el que se llevó a cabo la venta)
### Opción 10: 
Establece una búsqueda de todos los clientes por DNI/NIF (ya sea de la persona en concreto o de la empresa). Opción ideal cuando buscamos el teléfono, correo, o nombre de algún cliente.
### Opción 11:
Habiendo establecido la conexión con el servidor de ClientMan, te permite registrar nuevos usuarios en caso de que la aplicación sea compartida y se quieran diferenciar las ventas. 

## Envio de emails al correo de clientes.
Antes de hacer uso de esta funcionalidad, tiene que escribir en el código la cuenta de email desde la que quiere mandar los correos (el que aparecerá como remitente) y la clave que le proporcionará su cliente de mensajería para utilizarlo en aplicaciones de terceros. Para las pruebas, se usó Gmail. 

### Powered by [Joaquín Jiménez García](http://jojigarcia.me)
