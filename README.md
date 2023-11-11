# Admin-Management-Service
Admin Management Service for a Public Grievance Redressal System.

## Table of Contents

- [Usage](#usage)
- [Endpoints](#endpoints)
- [Schemas](#schemas)


## Usage

Admin Management Service is designed to help in create/get/update user/department in a Public Grievance Redressal System.


## Endpoints

### User Controller

GET: '/user' - To get all users
![Screenshot (6)](https://github.com/Public-Grievance-Redressal-System/Admin-Management-Service/assets/55571940/852515ed-6055-4596-92a3-52b06a9201bb)


GET : '/user/{id}' - To fetch user details with the userId
![image](https://github.com/Public-Grievance-Redressal-System/Admin-Management-Service/assets/55571940/567ce1e8-3f52-4029-87dc-565e85a3361e)


POST : '/user' - To create user details
![image](https://github.com/Public-Grievance-Redressal-System/Admin-Management-Service/assets/55571940/5ec309d5-115d-4d86-bb19-760bccae9a82)


PUT : '/user/{id}' - To update user details with the userId
![image](https://github.com/Public-Grievance-Redressal-System/Admin-Management-Service/assets/55571940/62973bbc-4049-4b4a-8a4a-a84aa3f79e1f)


DELETE : '/user/{id}' - To delete user details with userId
![Screenshot (5)](https://github.com/Public-Grievance-Redressal-System/Admin-Management-Service/assets/55571940/73ce28ec-3007-47c1-97de-9b1a89eb74cf)

GET : '/user/{id}/role' - To fetch the role details of user
![image](https://github.com/Public-Grievance-Redressal-System/Admin-Management-Service/assets/55571940/41a24d4d-ae25-4df8-84d2-590546b4e6bf)


### Department Controller : All the CRUD operations related to department

![Screenshot (10)](https://github.com/Public-Grievance-Redressal-System/Admin-Management-Service/assets/55571940/29d44f9c-795c-4d36-90b9-d2de74c3abdf)


### Grievance Controller : To assign grivance to appropriate department
  ![image](https://github.com/Public-Grievance-Redressal-System/Admin-Management-Service/assets/55571940/3da82e82-b20a-4dec-87b9-56eb2127b772)


### Role Controller : To get all the roles supported by the system
![image](https://github.com/Public-Grievance-Redressal-System/Admin-Management-Service/assets/55571940/0b22c65e-9bab-439c-814c-276eeb36d3c1)


## Schemas
![image](https://github.com/Public-Grievance-Redressal-System/Admin-Management-Service/assets/55571940/c6e5ffa0-aad2-4de2-acbc-789d2647b78e)


