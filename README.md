# Prime Number Application - Producer & Consumer
## Table of Contents
- [Setup Instructions](#setup-instructions)
- [Testing & Validation](#testing--validation)


## Setup Instructions

Before running the services, ensure that you have **Docker** and **Maven** installed on your machine.

1. Clone the repository:
   ```bash
   git clone https://github.com/ralitsa-dimitrova/offerista-interview-task.git
   cd offerista-interview-task
   ```
   
2. Build the services:
   1. For the Consumer service:
   ```bash
   cd consumer/
   mvn clean package
   docker build -t consumer-service .
   ```

   2. For the Producer service:
   ```bash
   cd ../producer/
   mvn clean package
   docker build -t producer-service .
   ```

3. Start services using Docker

Navigate to the root of the project and run the following command:
   ```bash
   docker-compose up --build
   ```

Once the services are up and running:

- Producer can be accessed at: http://localhost:8082
- Consumer can be accessed at: http://localhost:8081

## Testing & Validation

Shortly after starting the services, the **Producer** will begin generating `POST` requests to the **Consumer** service with the generated numbers.

- The generated numbers can be found in the file `generatedData.csv` located in the root folder of the **Producer** container.
- The filtered prime numbers can be found in the file `transformedData.csv` located in the root folder of the **Consumer** container.