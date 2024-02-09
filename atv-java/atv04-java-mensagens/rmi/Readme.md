# Java RMI

## 1. Compilar, registrar e iniciar servidor

```java
javac *.java
rmiregistry 11099 &
java CalculadoraServer
```

## 2. Iniciar cliente

```java
java CalculadoraClient
```
