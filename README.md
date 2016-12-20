Żeby uruchomić należy wpisać w cmd:

_gradlew build_ -kompilacja przez gradle

_java -jar build/libs/spring-bus-0.1.0.jar_ -uruchomienie aplikacji

Link do tutoriala jak odpalić aplikację przez IntelliJ:
https://1drv.ms/b/s!AtvW1h_4ksS-yit1BtjvEagoL-Lc

Przydatna informacja:
user
kot

=================
What you’ll build
You’ll build an application that has a static home page, and also will accept HTTP GET requests at:
http://localhost:8080/greeting
and respond with a web page displaying HTML. The body of the HTML contains a greeting:
"Hello, World!"
You can customize the greeting with an optional name parameter in the query string:
http://localhost:8080/greeting?name=User
The name parameter value overrides the default value of "World" and is reflected in the response:
"Hello, User!"
