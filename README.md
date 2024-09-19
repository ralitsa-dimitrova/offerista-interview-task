# Prime Number Application - Producer & Consumer
## Table of Contents
- [Implementation Overview](#implementation-overview)
- [Setup Instructions](#setup-instructions)
- [Testing & Validation](#testing--validation)
## Implementation Overview

The producer microservice contains a `DataGenerationScheduler` class that is responsible for scheduling the generation and sending of data to the consumer service. The scheduler sends batches of 1-5 numbers at regular intervals until 100 numbers have been sent. These numbers are sent to the consumer's exposed REST API `POST` handler in `DataProcessingController#processData` located at:


To minimize dependencies between classes, generic interfaces are provided, making the system easy to extend in the future. Consider the following modifications:
- Maybe we would want the consumer to find all even numbers, instead of primes
- Make the consumer and the producer save the numbers to a database, instead of a CSV file
- The producer to send string data instead of integers.

This design allows for easy extension of the system with minimal changes to the existing codebase. You can easily swap out or add new implementations for data generation, sending, or processing as needed.

Note: There's some data duplication in the CSV writing logic, which is identical for the producer and the consumer. This is unavoidable because building a shared library for this would be overkill for the current scope of the project.

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