# Jdbc_Servlet
Para realizar esta aplicación, utilizo el xammp para conectar con el servidor y para acceder a una base de datos la cual recibe el nombre de "colegio". La base de datos está asociada en un documento llamado "colegio.sql" dentro de la carpeta src del proyecto.

Este proyecto consiste en una aplicación web con un formulario desplegable de alumnos. El usuario debe elegir al estudiante y enviar el formulario. Tras el envío aparecerá por pantalla una tabla con una lista de sus asignaturas y de las tutorías a las que se ha apuntado.

Una vez creado el proyecto se crean diferentes paquetes. Yo me centraré en explicar solo tres: 
 - Web Pages
 - Source Packages
 - Libraries
El resto lo dejo como viene.

- El paquete de Web Pages.
   - Contiene el paquete WEB-INF en el cual se crea una clase jsp por defecto que recibe el nombre de index. En este jsp es donde cargo      la información de la base de datos y la imprimo en forma de desplegable.

- El Source Packages de esta aplicación web se estructura mediante la siguiente división.
   - Paquete: databases:
      - Clase. Connection_Databases. Mediante esta clase me conecto con a la base de datos
      - Clase. Sql_sentences. Creo dos métodos, cada uno de los cuales me servirá para realizar una consulta diferente a la base de             datos.
   - Paquete: servlet
      - Clase. Student_Servlet. Es una clase de tipo servlet, mediante la cual imprimo en una tabla los datos demandados según el alumno         seleccionado.
   - Paquete: students
       - Clase. Studnet_Attributes. Es una clase con tres variables: "studentName", "tutoria", "subject" con sus respectivos getters              mediante los cuales obtengo los datos tras la consulta sql.
       
- El paquete de libraries.
   - Lo utilizaremos para importar la librería de mysql connector.

Tras la ejecución del programa se abrirá el navegador predefinido por el entorno de desarrollo. Aparece el "index.jsp" con un desplegable cargado por el metodo StudentList() de la clase Sql_sentences con el nombre de todos los alumnos de la tabla "alumne".

Si en el desplegable se elige la opción por defecto "select a student", el formulario va a parar al método processRequest() de la clase Student_Servlet, el cual imprime el mensaje "Por favor, seleccione el nombre de un estudiante". En cambio, al seleccionar al alumno, se envía el formulario, el cual irá a parar en el método doPost() de la clase Student_Servlet. 

El método doPost() llama a el método SearchStudent() de la clase Sql_sentences y guarda el resultado de la query en un ArrayList el cual  recibe el nombre de "sal" (student attributes array) ya que proviene de la Clase Student_Attributes.

Finalmente se imprimen los datos en una tabla mediante un bucle for. Cada dato se incluye en la tabla mediante los getters de la clase Student_Attributes.
