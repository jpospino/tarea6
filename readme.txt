201710_CSOF5101_01 - CONCEPTOS AVANZADOS DE INGENIERÍA DE SOFTWARE
Tarea 6 - Encontrar el valor X que cumple la Integral numérica con reglas de Simpson
JUAN PABLO OSPINO SOLANO
20170406
repositorio: https://github.com/jpospino/tarea6.git

0. Clonar el repositorio
para clonar ejecute el siguiente comando en DOS
 	
	git clone https://github.com/jpospino/tarea6.git
	
a continuación vaya a la ruta de las fuentes con el siguiente comando
	
	cd tarea6\src\tarea6\

1. Compilación en maven
ubicado en la ruta donde se encuenrtan las fuentes ejecute los siguientes comandos para compilar

	mvn clean
	mvn package

también puede compilar utilizando el siguiente comando como lo sugiere heroku
	
	mvn clean install

y el comando para correr local:
	
	heroku local web

y en un navegador web o un cliente de servicios rest como Postman enviar el siguiente request

	http://localhost:5000/calculoXIntegral?valorIntegral=0.495&DOF=4
	
se adjunta dentro de las carpeta de test el resultado de la compilación y pruebas unitarias ver compilacion.txt.


2. Acceso a heroku


el programa está publicado en heroku como un servicio REST para su ejecución. 

https://safe-eyrie-29300.herokuapp.com/calculoXIntegral?valorIntegral=0.495&DOF=4

cambie los parametros segun los valores que se quiera introducir
valorIntegral
DOV

3. Accesos a JAVADOC
Entre a la ruta src/tarea6/target/site/apidocs/index.html


***************************************