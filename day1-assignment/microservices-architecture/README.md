# Assignment 4 - Microservices Architecture Design | Online Food Delivery App

## Services

 * User Service
 * Restaurant Service
 * Serch Service
 * Cart Service
 * Order Service
 * Payment Service
 * Delivery Service
 * Natification Service
 * Review Service

## Database per Service

  * User DB
  * Restaurant DB
  * Search DB
  * Cart DB
  * Order DB
  * Payment DB
  * Delivery DB
  * Notifications DB
  * Review DB

## API Communication

  * REST API
  * Kafka / Rabbit MQ (for asynchronous communication)

  # Which services should use Kafka

    * Order Service
    * Payment Service
    * Delivery Service
    * Notification Service
    * Review Service
  # Which services need high scaling

    * Search Service
    * Restaurant Service
    * Cart Service
    * Notification Service
    * Delivery Service

  # Which service is business critical

    * Order Service
    * Payment Service
    * Restaurant Service
    * User Service

  # Failure handling strategy

    * Circuite Breaker
    * Retry Mechanism
    * Fallback Mechanism
    * Timeout Configuration
    * Load Balancer
  
    
