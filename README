# OAuth2 OIDC Keycloak in Microservices

## Section n° 01

### Download Keycloak
To download and set up Keycloak, we utilized Docker to pull the Keycloak image. The process was initiated using the following command:

```bash
docker pull keycloak/keycloak
```

### Start Keycloak
To start Keycloak, we run a container using the previously pulled image.

```bash
docker run -p 8080:8080 -e KC_BOOTSTRAP_ADMIN_USERNAME=admin -e KC_BOOTSTRAP_ADMIN_PASSWORD=admin keycloak/keycloak:latest start-dev
```

![Keycloak Admin Console](docs/imgs/login.png)

### Admin account création
An admin account were created using the command while starting the container. The word `admin` was used as a username and password

![Keycloak Admin Console](docs/imgs/console.png)


### Créer une Realm
In the administration interface, create a new Realm by clicking on **Add Realm** with the name `ayoub-marghad`.


![alt text](docs/imgs/realme.png)


### Create an account to secure
In the new Realm, we navigate to the **Clients** section and click **Create** to add a new client.

![List of clients](docs/imgs/clients.png)

A client or service application is created with the following details:
- **Client ID**: bash
- **Name**: Bash
- **Description**: Bash command line client
- **Client authentication** : OFF
- **Authentication flow** : Standard flow

    - ✅ Standard flow
    - ✅ Direct access grants
    - ❌ Implicit flow
    - ❌ Service accounts roles
    - ❌ OAuth 2.0 Device Authorization Grant
    - ❌ OIDC CIBA Grant


<br>

![Create new client](docs/imgs/create-client.png)


### Create users
To create multiple users, navigate to the **Users** section in the Keycloak administration console and click on **Add User**. For each user, fill in the required details as follows:

1. **User n° 1**:
    - **Full name**: Ayoub Marghad
    - **Username**: ayoub-marghad
    - **Email**: ayoub.marghad@example.com

2. **User n° 2**:
    - **Full name**: Oussama Lahrache
    - **Username**: oussama-lahrache
    - **Email**: oussama.lahrache@example.com

3. **User n° 3**:
    - **Full name**: Rachid Imourigh
    - **Username**: rachid-imourigh
    - **Email**: rachid.imourigh@example.com

Each user has to validate its email on the first login.


![alt text](docs/imgs/users.png)


### Create Roles
In the "Roles" section, click on "Add Role" to create new roles.

1. **Role n° 1**: `admin`: This role provides full access to all features and configurations of the application.

2. **Role n° 2**: `user`: This role provides limited access to the application's features. Users with this role can access the basic functionalities.

<br>

![Create new role](docs/imgs/roles.png)

### Assign roles to users
The user **oussama-lahrache** has been assigned two distinct roles within the application. The first role is `admin`, which grants full access to all features and configurations, allowing for complete control over the application's settings and management. The second role assigned is `user`, which provides a more limited level of access, restricting the user to basic functionalities within the application. This combination of roles enables "oussama-lahrache" to perform both administrative tasks and utilize the essential features available to regular users.

![Assign roles to user](docs/imgs/assign-roles.png)


### Authentification with password test
To authenticate with the Keycloak server using curl and test the authentication to a realm called ayoub-marghad, where the username and password are the same (ayoub-marghad), you can use the following command:

```bash
curl -X POST "http://localhost:8080/realms/ayoub-marghad/protocol/openid-connect/token" \
  -H "Content-Type: application/x-www-form-urlencoded" \
  -d "client_id=bash" \
  -d "username=ayoub-marghad" \
  -d "password=ayoub-marghad" \
  -d "grant_type=password"
```

Response :

```json
{
"access_token":"eyJhbGciOiJSUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICJRYy1YMk9WVFFyT1dZNWdmTHZoVThvblI1THRUSDhkYXZHdEF1SDBJc3RvIn0.eyJleHAiOjE3MzY1MzgyODcsImlhdCI6MTczNjUzNzk4NywianRpIjoiZWRjM2Y0NDMtOTlhZC00ZmU1LWFjZTctODUyMmVlNDlhMTgwIiwiaXNzIjoiaHR0cDovL2xvY2FsaG9zdDo4MDgwL3JlYWxtcy9heW91Yi1tYXJnaGFkIiwiYXVkIjoiYWNjb3VudCIsInN1YiI6IjIwOTlhZDAwLTFkYzgtNDA1Mi1iYjZiLThmYzFkMDQ1ZWE4NiIsInR5cCI6IkJlYXJlciIsImF6cCI6ImJhc2giLCJzaWQiOiJjYzJkZmQ4My0yNWZiLTQ3MDgtODUxZS0wYzc5MTg1NzI5YTYiLCJhY3IiOiIxIiwiYWxsb3dlZC1vcmlnaW5zIjpbIi8qIl0sInJlYWxtX2FjY2VzcyI6eyJyb2xlcyI6WyJkZWZhdWx0LXJvbGVzLWF5b3ViLW1hcmdoYWQiLCJvZmZsaW5lX2FjY2VzcyIsInVtYV9hdXRob3JpemF0aW9uIl19LCJyZXNvdXJjZV9hY2Nlc3MiOnsiYWNjb3VudCI6eyJyb2xlcyI6WyJtYW5hZ2UtYWNjb3VudCIsIm1hbmFnZS1hY2NvdW50LWxpbmtzIiwidmlldy1wcm9maWxlIl19fSwic2NvcGUiOiJlbWFpbCBwcm9maWxlIiwiZW1haWxfdmVyaWZpZWQiOmZhbHNlLCJuYW1lIjoiQXlvdWIgTWFyZ2hhZCIsInByZWZlcnJlZF91c2VybmFtZSI6ImF5b3ViLW1hcmdoYWQiLCJnaXZlbl9uYW1lIjoiQXlvdWIiLCJmYW1pbHlfbmFtZSI6Ik1hcmdoYWQiLCJlbWFpbCI6ImF5b3ViLm1hcmdoYWRAZXhhbXBsZS5jb20ifQ.KKzK1EZJuNvvUqwMg8jz6wyBz9wU8zAVqI5feOnMZJpHj-9yaHi1n85xjwe9EU1L5zthHk93pXEualt4ouzk6egl3olr_AOgg0HFjDEublKJwUttUhu3BdP32l2xyGe66cRV_d7fs0DdDLBxS8J2QSeqsC0-cxcyTqBp41BIzfpPPPswKmBU_59N6UrfgY7PUOH-uXHQ1nS__nNwIgxUwrf76ACXa-CdKg-YmMA9yU1SiRRQzjRZiwcZ30iws4NEJ667e6ZPwN6t9X6IwoZwDLw3Pf6NTcMHa-0NHNFjL0Fo1lYth0aiSY0rGgCIepV7zDePNAab1YiStOl602G6sQ",
"expires_in":300,
"refresh_expires_in":1800,
"refresh_token":"eyJhbGciOiJIUzUxMiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICIyZDJjNTI4ZS0wNzI1LTQ1MDUtOTg5Ny02OGIzYzdiY2Y2ZjkifQ.eyJleHAiOjE3MzY1Mzk3ODcsImlhdCI6MTczNjUzNzk4NywianRpIjoiZGI3OTZlMDAtMmEyOS00NDgxLTgxNGQtZDhmYjIyZDZlMWNjIiwiaXNzIjoiaHR0cDovL2xvY2FsaG9zdDo4MDgwL3JlYWxtcy9heW91Yi1tYXJnaGFkIiwiYXVkIjoiaHR0cDovL2xvY2FsaG9zdDo4MDgwL3JlYWxtcy9heW91Yi1tYXJnaGFkIiwic3ViIjoiMjA5OWFkMDAtMWRjOC00MDUyLWJiNmItOGZjMWQwNDVlYTg2IiwidHlwIjoiUmVmcmVzaCIsImF6cCI6ImJhc2giLCJzaWQiOiJjYzJkZmQ4My0yNWZiLTQ3MDgtODUxZS0wYzc5MTg1NzI5YTYiLCJzY29wZSI6ImVtYWlsIGFjciByb2xlcyB3ZWItb3JpZ2lucyBwcm9maWxlIGJhc2ljIn0.kmAJiKBiTAFFWEemnDvIoSYGxuqNw4AI-FvjdVdd0PEk5uWy1Wf5FZtUBL2mzSQCBHka5FYuLPEIQGUYwaVpIA",
"token_type":"Bearer",
"not-before-policy":0,
"session_state":"cc2dfd83-25fb-4708-851e-0c79185729a6",
"scope":"email profile"
}
```