# LAB-8 README


## User Authentication Credentials
<img width="398" alt="image" src="https://github.com/user-attachments/assets/3a308386-a944-45f3-89fa-901e191c3d1d" />

1. An Admin has admin page access only
2. A Caregiver/Parent has different access as mentioned in image above.
   <br>
  •	Caregiver 'silvi' has Caregiver and Admin access both but not parent access. <br>
  •	‘Anna’ is caregiver as well as a parent, therefore she has caregiver and  parent access but no admin access. <br>
  •	Caregiver ‘dimple’ has Caregiver access only. <br>
  •	Parent 'steve' has parent access only. <br>
  •	Parent ‘christin’ has parent access only. <br>
  •	Parent ‘levis’ has parent access only. <br>

## 1. This is Login page with User name and password field.
   <img width="530" alt="image" src="https://github.com/user-attachments/assets/429e9941-9134-4a40-803b-7d84aafa7750" />

## 2. This is  login page with basic validations in place.
<img width="616" alt="image" src="https://github.com/user-attachments/assets/878c3bb6-37ce-4c4a-96cf-99005cc0d53e" />

## 3. This is  login page with wrong credential ,it routes to error page.
<img width="464" alt="image" src="https://github.com/user-attachments/assets/a6226639-9bd7-4802-ab6b-20e847eb3ef2" />

<img width="698" alt="image" src="https://github.com/user-attachments/assets/b34dbc3f-52e2-4483-9051-db8ff69bdc83" />

## 4.login page with right credential username: admin password: admin
![Screenshot 2025-04-05 145251](https://github.com/user-attachments/assets/7c291acb-3c6f-4a39-9172-afebca226dec)
        <br>## Success Page for admin
        ![Screenshot 2025-04-05 145157](https://github.com/user-attachments/assets/ef1cb7ef-d427-4502-8770-d743bed40e91)

## 5.login page with right credential username: silvi password: silvi
![Screenshot 2025-04-05 145409](https://github.com/user-attachments/assets/84d10d34-7a30-4d49-b642-0fdfe47c88f2)
            <br>## Success Page for caregiver silvi
           ![Screenshot 2025-04-05 145446](https://github.com/user-attachments/assets/980cdaed-e323-4c30-a4ba-704e7b19b775)
            ## Restrictions applied to user, silvi  has admin and caregiver page rights only 
                 <br>## admin right
            ![Screenshot 2025-04-05 145622](https://github.com/user-attachments/assets/1c32d1e7-3412-433d-942a-82aa542f2324)
                 <br>## caregiver right
            ![Screenshot 2025-04-05 145729](https://github.com/user-attachments/assets/34c04499-b8af-4faa-a7e2-5f22ef431f25)
                 <br>## No parent page access
            ![Screenshot 2025-04-05 145746](https://github.com/user-attachments/assets/b7b6def8-61cf-4bc3-8e21-61d843280d73)
            
## 6. Discuss your experiences, including any difficulties you had or changes you made 

Answer : In Lab 8, I implemented Jakarta EE security with JSF to enable authentication and role-based authorization. I created User and Group entities with the correct relationships, configured password hashing using PBKDF2, and secured URL paths via web.xml and payara-web.xml.

A major issue I faced was incorrect rendering of pages due to mismatched roles, which prevented authorized users from accessing certain views. I resolved this by fixing the role assignments in the database initializer.

Other changes included insert hashed passwords and proper role mappings, using JSF templates for consistent layout, and adding full login/logout functionality with session invalidation. This lab gave me practical experience in securing Jakarta EE web applications.
               
               







  















