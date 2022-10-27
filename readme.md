Для того чтобы зарегистрировать пользователя, необходимо отправить POST запрос, с FormData в котором есть поля username, email, password:
http://3.145.97.83:3333/user/create

Получить список всех зарегистрированных пользователей в системе можно GET запросом URI
http://3.145.97.83:3333/user/get

1. Необходимо описать все возможные тест кейсы (и/или чек листы) для проверки API и
   приоритизировать по необходимости автотестирования.
2. Автоматизировать 2-3 наиболее приоритетных тест кейса из первой части задания,
   выложить результат в github.