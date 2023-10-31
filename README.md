# Customer Management System with Stock Products and Orders

This is a robust Customer Management System designed to manage customer data, stock products, and customer orders. It is built using Spring Boot and uses PostgreSQL as the database for data storage.

## Features

- **Customer Management:** Easily create, update, and delete customer profiles, including information such as name, contact details, and address.

- **Product Management:** Maintain a comprehensive list of stock products, including details such as product name, description, price, and available quantity.

- **Order Processing:** Create and manage customer orders, add products to orders, and track order history.

- **Database:** Utilizes PostgreSQL for data storage, ensuring data durability and scalability.

- **Authentication and Authorization:** Implements user authentication and role-based authorization for secure access control.

- **RESTful API:** Provides a RESTful API for easy integration with other applications or front-end frameworks.

## Technologies Used

- Java with Spring Boot
- PostgreSQL
- Spring Data JPA
- Spring Security
- RESTful API
- Docker

## Installation

1. Clone this repository to your local machine:

   ```bash
   git clone https://github.com/yourusername/customer-management-system.git

2. Configure your PostgreSQL database connection in the application.properties or application.yml file.
3. Build and run the application using Maven or your preferred Spring Boot build method:

```bash
mvn clean install
java -jar target/customer-management-system-1.0.0.jar
```
4. Access the system via a web browser or through your API client at http://localhost:8080.


## Usage

- **Register and log in** to access the system.

- **Begin managing customers, products, and orders** using the intuitive web interface or make API requests to interact with the system programmatically.

## API Documentation

The API documentation can be found at [http://localhost:8080/customers](http://localhost:8080/customers) when the application is running. It provides detailed information about the available endpoints and how to use them.

## Database Schema

A simplified representation of the database schema is as follows:

- **Customer Table:**
    - customer_id (Primary Key)
    - name
    - email
    - phone
    - address

- **CustomerIDCard Table:**


- **Product Table:**
    - product_id (Primary Key)
    - name
    - description
    - price
    - quantity

- **Order Table:**
    - order_id (Primary Key)
    - customer_id (Foreign Key)
    - order_date
    - total_amount

- **Order_Item Table:**
    - order_item_id (Primary Key)
    - order_id (Foreign Key)
    - product_id (Foreign Key)
    - quantity
    - unit_price

## Contributing

Contributions are welcome! If you have any ideas, improvements, or bug fixes, please submit a pull request. Before doing so, make sure to:

- **Fork the repository.**
- **Create a new branch** for your feature or fix.
- **Make your changes.**
- **Write tests** if necessary.
- **Run the existing tests** with `mvn test`.
- Ensure your code meets coding standards.
- Submit a pull request.

## License

This project is licensed under the **MIT License**. You are free to use, modify, and distribute the code for your purposes. Please read the license for more details.

## Contact

If you have questions or need assistance, feel free to contact our support team at [yassinechalh9@gmail.com](mailto:yassinechalh9@gmail.com).

**Happy managing your customers, products, and orders with Spring Boot and PostgreSQL!**

