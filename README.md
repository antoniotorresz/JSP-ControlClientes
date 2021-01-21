---
abstract: |
  Esta aplicación es un simple CRUD a una sola entidad, usando el
  lenguaje de programación Java y las tecnologías relacionadas a Java
  WEB como lo son los Servlets y JSPs.
author:
- Antonio Torres Ramírez
title: JSP-ControlClientes
---

![Pantalla
principal](../../../../../Imágenes/Captura de pantalla de 2021-01-19 21-09-08.png){#fig:captura-de-pantalla-de-2021-01-19-21-09-08
width="0.7\\linewidth"}

![Modal de agregar
nuevo](../../../../../Imágenes/Captura de pantalla de 2021-01-19 21-09-25.png){#fig:captura-de-pantalla-de-2021-01-19-21-09-25
width="0.7\\linewidth"}

# Modelo de bases de datos

La entidad cliente está formada por los siguientes campos:

![Propiedades de la entidad
cliente](../../../../../Imágenes/controlClientes.png){#fig:controlclientes
width="0.7\\linewidth"}

El script SQL para generar la entidad está dentro de este repositorio en
el directorio /src/main/ el archivo se llama *databasechema.sql*

Este script puede ser interpretado por servidores de bases de datos como
MySQL o MariaDB.

# Servidor

![image](../../../../../Descargas/configure-glassfish-with-mysql.jpg){width="0.7\\linewidth"}

GlassFish es un servidor de aplicaciones de software libre desarrollado
por Sun Microsystems, compañía adquirida por Oracle Corporation, que
implementa las tecnologías definidas en la plataforma Java EE y permite
ejecutar aplicaciones que siguen esta especificación. **Es necesario
tener instalado glassfish en la maquina servidor para el correcto
funcionamiento de la aplicación.**

Este puede ser descargado de [centro de descargas de
glassfish](https://javaee.github.io/glassfish/download)
