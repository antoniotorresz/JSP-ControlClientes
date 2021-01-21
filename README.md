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
principal](https://user-images.githubusercontent.com/43243319/105259671-e0631300-5b51-11eb-9b4f-ac1d0293f75f.png)

![Modal de agregar
nuevo](https://user-images.githubusercontent.com/43243319/105259673-e0fba980-5b51-11eb-8cdc-99352778dea1.png)

# Modelo de bases de datos

La entidad cliente está formada por los siguientes campos:

![Propiedades de la entidad
cliente](https://user-images.githubusercontent.com/43243319/105259667-dfca7c80-5b51-11eb-8551-da6244234b4e.png)

El script SQL para generar la entidad está dentro de este repositorio en
el directorio /src/main/ el archivo se llama *databasechema.sql*

Este script puede ser interpretado por servidores de bases de datos como
MySQL o MariaDB.

# Servidor

![Glassfish logo](https://3.bp.blogspot.com/-eihtIptOpM4/WXjssuS7j-I/AAAAAAAABO4/18YysX3t_bgyLukoB-nOhATzzdwDeA6sACLcBGAs/w1200-h630-p-k-no-nu/glassfish_logo.png)

GlassFish es un servidor de aplicaciones de software libre desarrollado
por Sun Microsystems, compañía adquirida por Oracle Corporation, que
implementa las tecnologías definidas en la plataforma Java EE y permite
ejecutar aplicaciones que siguen esta especificación. **Es necesario
tener instalado glassfish en la maquina servidor para el correcto
funcionamiento de la aplicación.**

Este puede ser descargado de [centro de descargas de
glassfish](https://javaee.github.io/glassfish/download)
