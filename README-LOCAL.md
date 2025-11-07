# Proyecto práctica-mvn-mvc-bd-g412 — instrucciones locales

Pasos rápidos para compilar y ejecutar en tu máquina (Windows + PowerShell):

1) Asegúrate de tener JDK 21 y Maven instalados y en el PATH:

```powershell
java -version
mvn -v
```

2) Rellena las plantillas de configuración en `src/main/resources`:
- `config.properties` (o `config-postgres.properties`) con tus credenciales/URL.

3) Compila el proyecto (sin tests rápidos):

```powershell
mvn -DskipTests package
```

4) Si quieres ejecutar la clase `Main` directamente con Maven:

```powershell
mvn exec:java -Dexec.mainClass="com.uniajc.Main"
```

(Si no tienes el plugin `exec` configurado, puedes ejecutar el JAR generado en `target/` o añadir el plugin al POM.)

Problemas comunes
- "mvn' no se reconoce": instala Maven y añade al PATH.
- FileNotFound al cargar `config.properties`: asegurate de completar `src/main/resources/config.properties` — el código ahora intenta cargar desde classpath.

Si la compilación falla, pega aquí la salida de Maven y corregiré los errores restantes.
