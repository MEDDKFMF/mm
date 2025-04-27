#itmd4515-fp-csule1
itmd4515-fp-csule1 created by GitHub Classroom

1. Form View
   ![image](https://github.com/user-attachments/assets/c2af7525-d424-4413-a727-80d269d52bc1)
2. Confirmation View
  ![image](https://github.com/user-attachments/assets/379106cb-539c-412c-b7ad-6bd13e10d9a7)
3. Form with bad input
   ![image](https://github.com/user-attachments/assets/b5766c0d-804c-45b8-823e-ab0b977276bb)
4.Form with error message
  ![image](https://github.com/user-attachments/assets/108c6364-365d-437b-a8d9-92e2f8135267)

1. Your understanding of the difference between the forward and redirect operations.
Answer: The difference between forward and redirect operations in a Servlet-based application lies in how they handle requests. Forwarding (RequestDispatcher.forward()) keeps the request within the server, allowing data to be shared between resources without changing the URL in the browser. It is efficient for internal navigation within an application. In contrast, a redirect (response.sendRedirect()) tells the browser to make a new request to a different URL, resetting request attributes and making it suitable for scenarios where a fresh request-response cycle is needed, such as form submissions to prevent duplicate processing.

2.How would you be validating user submissions without the Bean Validation API standard? 
Answer: Without using the Bean Validation API, user inputs could be validated manually using Java methods such as regular expressions, string checks (e.g., length, null values), and custom validation logic in the Servlet before processing the form submission. This approach is more error-prone, harder to maintain, and requires additional effort to handle complex validation rules.

3.How do you think this approach would scale to a real application with 100's of entities? 
Answer: Scaling this approach to a real-world application with hundreds of entities would become unmanageable due to redundant code and lack of standardized validation and persistence handling. A more scalable solution involves using frameworks like Jakarta EE, JPA, and Bean Validation, which automate validation and data persistence, reducing code duplication and improving maintainability.

4.Why didn't we need to include any additional dependencies (i.e. Bean Validation, JDBC) in this project? 
Answer: We did not need to include additional dependencies like Bean Validation or JDBC in this project because Jakarta EE 10 Web already provides built-in support for these features. The Jakarta Validation API is included within the framework, and JDBC connectivity is handled through Payara’s built-in resources, eliminating the need for explicit dependency management.
