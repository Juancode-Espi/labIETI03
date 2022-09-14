# labIETI03

## Part 1:

+ Secured Endpoint User by Id:
![getByIdForbiden](./img/getUserById403.png)
+ Open Endpoint User's List:

![getUsers](./img/getUsers.png)

## Part 2:

+ ***Creación de usuario de prueba:***

![userTest](./img/createUserTest.png)
Algo que podemos observar es que el dto que retorna tiene la contraseña null, esto es debido a que el mapper
encripta y agrega a la entidad y bueno al mapear de vuelta no obtiene el está propiedad 

*Usuario en BD*:

![vistaBd](./img/testUserBD.png)

+ ***Auth Endpoint:***

![auth](./img/login.png)

## Part 3:

+ ***Auth Endpoint:***

![auth2](./img/auth2.png)

```
Token = eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiIzIiwiY2xhaW1zIjpbIlVTRVIiXSwiaWF
0IjoxNjYzMTI5MTMyLCJleHAiOjE2NjMxMzI3MzJ9.nzGbbApJiRrzRrseEiySV92R6CHITQdjt7_ph_8J0fI
```

+ ***Get with auth:***

![getUserAuth](./img/getWithAuth.png)