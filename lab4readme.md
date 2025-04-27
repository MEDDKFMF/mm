#Lab4
#itmd4515-fp-csule1 itmd4515-fp-csule1 created by GitHub Classroom

1.Describe the business domain you have chosen to work with, and why. 

**Answer**:I have chosen to work with a Child Daycare Management System because I have firsthand knowledge of how daycare centers operate. My parent runs a daycare in my home country, and I have seen the daily operations, challenges, and processes involved in managing children, staff, and parent communications. From maintaining records of each child's health details and attendance to scheduling activities and ensuring timely communication with parents, I understand the critical aspects that need to be streamlined. This system will help daycare centers efficiently manage child enrollment, attendance tracking, caregiver assignments, and emergency contact handling, ensuring a well-structured and organized approach to childcare management.

2.There is only one entity required for Lab 4, but what other entities from your business domain can you think of?  How might they relate to one another?

**Answer**:While Lab 4 requires only one entity, the Child entity, several other entities could be added to expand the system's functionality. These include:

Parent: Stores information about a child's parents or guardians, including contact details and emergency contacts.
Staff: Represents daycare caregivers and administrative personnel, tracking their roles, schedules, and assigned children.
Classroom: Defines the different daycare groups or rooms where children are assigned based on age or learning programs.
Activity: Tracks scheduled activities such as playtime, nap time, or learning sessions.
MedicalRecord: Stores important health information, including allergies, medical conditions, and vaccination records.

**These entities relate to one another in the following ways:**
A Child is associated with one or more Parents.
A Child is assigned to a Classroom where they participate in scheduled Activities.
A Staff member is responsible for managing one or more Children in a Classroom.
Each Child has a MedicalRecord that tracks their health details and vaccinations.

3. **ChildJPATest Results**
   Test case for** **Beforeeach** test**,creating a child entry with name 'Aline'.
   ![image](https://github.com/user-attachments/assets/a2aa4307-502e-48c5-8da5-557d479cd660)
   Data entered in database
   ![image](https://github.com/user-attachments/assets/994704b4-c4f9-4c6b-b8c5-53d05a1b4cc0)

   Creating a child entry with name 'Aline Test Rayan' **beforeeach**() test and deleting **aftereach**() test
   ![image](https://github.com/user-attachments/assets/f9f3ff74-4138-42c3-a7b6-42c62f25b870)
   ![image](https://github.com/user-attachments/assets/77cd0dda-aed3-4539-8443-4d6c091305e5)

   Testing **CreateTest()** Test.Create child with name 'Brian'
   ![image](https://github.com/user-attachments/assets/99afd36f-7ef7-4bd9-b1c4-95c2d4f7633e)
   Cleanup Test data in createTest()
   ![image](https://github.com/user-attachments/assets/561d40d8-6488-4ef7-9e1f-05900475ffc9)
   Entry deleted from database
   ![image](https://github.com/user-attachments/assets/2c14f4df-6253-4fa5-93b3-b4afa98c6fa5)

    AfterUpdate Test case
   ![image](https://github.com/user-attachments/assets/769adf79-e66e-4121-9229-c6d57cd6ea72)

  **Testing Read test case**
  •	Creates and persists a Child Emma.
  •	Retrieves the entity from the database and verifies that the values match the expected ones name, MealPreference and Gender
  •	Cleans up by removing the test data.
  ![image](https://github.com/user-attachments/assets/dda8e603-8a83-44fe-8e10-ddd99524309f)

  **Delete Test Case**
  •	Creates and persists a Child named Dakota.
  •	Verifies its existence before deletion.
  •	Deletes the entity and confirms it's no longer in the database.
  ![image](https://github.com/user-attachments/assets/d1054c11-f00a-4baf-be78-380ee363eb8b)
  ![image](https://github.com/user-attachments/assets/6bab83ca-0265-424d-9a92-e9f953cc9ed5)
  ![image](https://github.com/user-attachments/assets/494e1d3a-b7c5-46ea-8438-f0a55ccec8d1)
  ![image](https://github.com/user-attachments/assets/3d8bd927-3642-40f0-a3f4-ed9c62ea99b2)

**ChildValidationTest**
1. **childShouldValidateAndPass:** This test ensures that a Child object with valid data (non-null, non-empty name, birthDate, gender, and mealPreference) passes all the validation constraints.
![image](https://github.com/user-attachments/assets/b0f318ec-d108-4e74-8040-4bad5f208a79)
2. **blankNameShouldNotValidate:** Tests that if the name attribute is blank, violations count is 1 which matches assertEquals value.
Success Scenario -   When Name is blank (Name =””, violations=1)
![image](https://github.com/user-attachments/assets/c3eea618-25fa-4d11-9871-c0fed953d1bb)
Fail Scenario -   When Name is passed(Name =Naya, violations=0)
![image](https://github.com/user-attachments/assets/e02f41cc-bc31-4825-897a-d6df797f7f74)
3. ****nullBirthDateShouldNotValidate**: **Tests that if the birthDate is null, violations count is 1 which matches assertEquals value.
Pass Scenario- Birthdate passed is Null( violation size is 1)
![image](https://github.com/user-attachments/assets/905b340a-a186-493b-92cc-80a9cf3ffe84)
Fail Scenario -   When Birthdate is passed(Date = 2022-06-25, violations=0)
![image](https://github.com/user-attachments/assets/20c52ad4-a6ee-4aa0-a52e-34dd58de0cb0)
4. **invalidGenderShouldNotValidate**: Tests that if the Gender is null, violations count is 1 which matches assertEquals value.
Pass Scenario- Gender passed is Null( violation size is 1)
![image](https://github.com/user-attachments/assets/8914b965-e78d-4078-ae83-b942b86c9f37)
Fail Scenario -   When gender is passed(gender =male, violations=0)
![image](https://github.com/user-attachments/assets/8628bc9c-b227-4ef7-90ba-71853f7d0a4a)
5. **nullMealPreferenceShouldNotValidate**: Tests that if the mealPreference is null, the validation will fail.
   Pass Scenario- MealPreference passed is Null( violation size is 1)
![image](https://github.com/user-attachments/assets/309e8f69-5fdb-4773-b87d-cade6b952720)
Fail Scenario -   When MealPreference is passed(MealPreference =Vegetarian, violations=0)
![image](https://github.com/user-attachments/assets/2029bfb3-46b3-47bd-a34f-4ea6efc02689)
6. **invalidMealPreferenceShouldNotValidate**: Tests that if the mealPreference is set to an invalid enum value, the validation will fail.
 Invalid MealPreference Enum value(MealPreference = INVALID_MEAL)
![image](https://github.com/user-attachments/assets/89c6acf4-01c3-4948-816b-f996af3f7df6)













   







 

 

