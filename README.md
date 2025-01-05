# Conversor de Monedas

Este proyecto es un conversor de monedas desarrollado en Java. Utiliza la API de ExchangeRate para obtener tasas de cambio actualizadas y 
permite convertir entre diferentes monedas de manera sencilla.

## Características
- Conversión entre monedas populares:
  - Dólar estadounidense (USD)
  - Peso argentino (ARS)
  - Real brasileño (BRL)
  - Peso colombiano (COP)
- Tasas de cambio obtenidas en tiempo real mediante la API de ExchangeRate.
- Interfaz de consola fácil de usar.

## Tecnologías utilizadas
- Java 17+
- Gson para el manejo de datos en formato JSON.
- HttpClient para realizar solicitudes HTTP.

## Requisitos previos
- Tener instalado Java 17 o superior.
- Contar con acceso a internet para obtener las tasas de cambio.

## Configuración
1. Clonar este repositorio:
   ```bash
   git clone <url-del-repositorio>
   ```

2. Importar el proyecto en tu IDE favorito.

3. Asegurarte de tener configurada la dependencia de Gson (si usas un gestor de dependencias como Maven o Gradle, agrega la dependencia correspondiente). Si no, incluye la biblioteca manualmente.

4. Reemplazar `a012ae51f5e93292bcc4bde2` en la URL de la API por tu propia clave de API de ExchangeRate.

## Uso
1. Ejecuta la clase principal `Principal.java`.

2. Selecciona una opción del menú para realizar una conversión:
   ```plaintext
   *********************************************************************
   BIENVENIDO AL CONVERSOR DE MONEDAS
   1) Dólar >>> Peso Argentino
   2) Peso Argentino >>> Dólar
   3) Dólar >>> Real Brasileño
   4) Real Brasileño >>> Dólar
   5) Dólar >>> Peso Colombiano
   6) Peso Colombiano >>> Dólar
   7) Salir
   Eliga una opción valida
   *********************************************************************
   ```

3. Ingresa el valor que deseas convertir.

4. El programa mostrará el resultado basado en las tasas de cambio actuales.

## Ejemplo de salida
```plaintext
{ARS=1034.75, COP=4412.52, USD=1.0, BRL=6.15}
Resultado: 100 USD equivalen a 103475 ARS
```
