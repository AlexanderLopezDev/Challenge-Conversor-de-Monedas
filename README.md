# Challenge conversor divisas
Challenge conversor de monedas en tiempo real consultando API.

## Caracteristicas
1. Eficiencia en la Consulta. La aplicación utiliza el cliente HTTP de Java para realizar consultas rápidas y eficientes a la API, obteniendo resultados en tiempo real.
2. La aplicación obtiene las tasas de cambio directamente de una API de tasas de cambio (ExchangeRate-API).
3. La aplicación incluye un manejo robusto de errores para:
   * Errores de conexión: Informa al usuario si no hay conexión a Internet.
   * Errores en la consulta: Notifica si la consulta es interrumpida o si no se encuentra la moneda especificada.
   * Monedas no válidas: Indica al usuario si intenta utilizar una moneda que no está soportada por la aplicación.
4. El conversor permite realizar conversiones únicamente entre las siguientes monedas:
   * SD (Dólar Estadounidense)
   * EUR (Euro)
   * COP (Peso Colombiano)
   * CLP (Peso Chileno)
   * BRL (Real Brasileño)
   * BOB (Boliviano)
   * ARS (Peso Argentino)
5. El usuario puede ingresar un monto específico de la moneda base y la aplicación mostrará el equivalente en la moneda de destino utilizando la tasa de conversión actual.
6. La aplicación ofrece una interfaz de texto en consola, fácil de usar, donde el usuario puede ingresar las monedas y el monto que desea convertir.

## Requisitos
1. Java Development Kit (JDK): Debes tener instalado JDK 17 o superior.
2. Algún IDE de preferencia (Personalmete utilizo IntelliJ IDEA).
3. Conexión a Internet: La aplicación necesita una conexión activa para consultar las tasas de cambio en la API.
4. Librerías Externas
   * Gson (de Google).

## API utilizada
* [ExchangeRate-API](https://v6.exchangerate-api.com/)

## Autor
### Alexander López Bueno

### Herramientas utilizadas:

* Java

### Linkedin: https://linkedin.com/in/alexanderlópezbuenodev
### Instagram: https://instagram.com/alexander_lo12
### GitHub: https://github.com/AlexanderLopezDev
