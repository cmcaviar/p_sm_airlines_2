Здесь располагаются конфигурационные классы, в т.ч. Spring Security

Гайд по работе с keycloak.
1) Скачайте и установите докер.
2) Найдите в корне проекта файл docker-compose.yml. Нажмите на Run рядом со строкой "services:", таким образом
   Вы запустите все вложенные контейнеры. В Docker Desktop появится контейнер p_sm_airlines_2, в котором будут вложены еще
   3 контейнера(postgres, pgadmin4_container, keycloak). Проверьте, чтобы все контейнеры функционировали.
3) Зайдите на admin panel keycloak(http://localhost:8484/), далее Administration Console, имя пользователя admin, пароль
   admin_password. Проверьте, что существует airline_realm(левый верхний угол, помимо него еще есть master),
   если такого реалма еще нет, https://habr.com/ru/company/reksoft/blog/552346/ прочитайте вот эту статью, настройте по
   следующим параметрам: реалм - airline_realm, клиент airline_client, порт редиректа в клиенте http://localhost:8888/*,
   роли(supeAdmin, admin, manager, passenger), их можно создать как во вкладке Roles, так и внутри клиента. Потом создайте
   пользователей во вкладке Users, полет фантазии не ограничен.
4) (Optional!) зайти в pgadmin и посмотреть базы данных(придется создать сервер, чтобы подключится к бд постгреса из
   докер контейнера), ИЛИ подключите бд через идею через localhost. Проверить, что все работает можно увидев, что теперь у
   Вас на 92 таблицы больше. Помните про 5437(!) порт.
5) Можно тестировать код. 

    Дополнение к пункту 2:
    1) Если работаете на маке с чипами m1 и свежее(arm64), то контенер keycloak с образа jboss/keycloak, который прописан
     в docker-compose.yml, у вас не поднимется, вместо образа jboss/keycloak можно использовать образ
     wizzn/keycloak(например версии 14 "wizzn/keycloak:14") или любой другой, который поддерживает архитектуру arm64;
    2) В случае, если при переходе на admin panel keycloak(http://localhost:8484/), Administration Console
     будет неактивна на создание первого админа, то необходимо будет создать его вручную, перейдя внутрь контейнера keycloak. 
     Для этого откройте терминал, далее выполните команду 'docker ps', откроется список всех запущенных 
     контейнеров(удостоверьтесь что контейнер keycloak запущен и скопируйте его id), затем необходимо 
     перейти внурь самого контейнера выполнив команду 'docker exec -it <id keycloak контейнера> bash',
     вам  откроется bash-консоль контейнера в котором надо поочередно выполнить следующие команды
     'export KEYCLOAK_ADMIN="admin" ', 'export KEYCLOAK_ADMIN_PASSWORD="admin_password" ', 'bin/kc.[sh|bat] start',
    таким образом вы создадите нового админа и сможете войти в keycloak. 
    ссылка на документацию keycloak https://www.keycloak.org/docs/latest/server_admin/index.html#creating-first-admin_server_administration_guide
     