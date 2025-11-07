# Script simple para compilar y ejecutar la aplicación en Windows PowerShell

Write-Host "Compilando proyecto con Maven (skip tests)..."
mvn -DskipTests package

if ($LASTEXITCODE -eq 0) {
    Write-Host "Build ok. Ejecutando la aplicación (Main) usando mvn exec:java..."
    mvn exec:java -Dexec.mainClass=com.uniajc.Main
} else {
    Write-Host "Build falló. Revisa la salida anterior para más detalles." -ForegroundColor Red
}
