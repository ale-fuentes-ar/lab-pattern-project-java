
# Hands-On |  JAVA Design Pattern
<img src="https://img.shields.io/badge/by-Alejandro.Fuentes-informational?style=for-the-badge&logoColor=white&color=cdcdcd" />
<img src="https://img.shields.io/badge/Design_Pattern-Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white" />

## About patterns

The design patter is one model that help us when we want to use best practice over our code avoid duplication, complexity and so on.
In this hands-on I to use three os more common design patterns:

* [Singleton](#singlenton--criational-pattern)
* [Strategy](#strategy--comportamental-pattern)
* [Facade](#facade--structural-pattern)

### Singlenton | criational pattern
To create a unique instance of class with a way how to use.

```mermaid
classDiagram
    class Singleton {
        +static instance()
    }

    Singleton <|--  Singleton
    Client -- Singleton

```




### Strategy | comportamental pattern
For the same problem, to simplificating the variation code.

```mermaid
classDiagram
    class Context {
    }
    class Strategy {
	    <<interface>>
	    +algorithm()
    }
    class ImplementationOne {
	    +agorithm()
    }
    class ImplementationTwo {
	    +agorithm()
    }
    class ImplementationN {
	    +agorithm()
    }

    Client --> Context
    Context *--> Strategy: -strategy
	ImplementationOne --> Strategy
	ImplementationTwo --> Strategy
	ImplementationN --> Strategy

```

### Facade | structural pattern
With interfaces to reduce the complex integrations with to subsystem.

```mermaid
classDiagram

	class Client {
	}
	class Facade {
		+doIt()
	}
	class OptionalAditionalFacade {
	}
	class CloudForeignSystem {
	}

	Client --> Facade
	OptionalAditionalFacade <.. Facade
	CloudForeignSystem <-- Facade
	CloudForeignSystem <-- OptionalAditionalFacade
	
```