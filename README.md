# ComboBox Form – Spring Boot + JSP +MySQL

This project demonstrates a simple web form using a dropdown (`<form:select>`) in JSP, integrated with Spring Boot MVC. 
It captures user input via a combo box and processes it on the backend.


## 🔧 Technologies Used
- Java 8+
- Spring Boot
- Spring MVC
- JSP
- Maven
- Eclipse IDE


## 📁 Folder Structure
```
src/
├── main/
│ ├── java/com/example/ComboBox/
│ │ ├── controller/
│ │ │ └── SaleController.java
│ │ ├── entity/
│ │ │ ├── Customer.java
│ │ │ ├── Item.java
│ │ │ └── Sale.java
│ │ ├── repository/
│ │ │ ├── CustomerRepository.java
│ │ │ ├── ItemRepository.java
│ │ │ └── SaleRepository.java
│ │ └── ComboBoxApplication.java
│ ├── resources/
│ │ └── application.properties
│ └── webapp/WEB-INF/views/
│ ├── add-customer.jsp
│ ├── add-item.jsp
│ ├── add-sale.jsp
│ ├── edit-sale.jsp
│ ├── index.jsp
│ └── report.jsp
└── test/java/com/example/ComboBox/
````


## 🧠 Features

- Displays a dropdown (combo box) in a form using Spring's `<form:select>`
- Handles form submission with Spring MVC
- Add/Edit/Delete Sales entries
- Generates report view of all sales
- Simple and beginner-friendly setup



🙋‍♀️ Author  
Parvana Arun  
GitHub: @ParvanaArun
