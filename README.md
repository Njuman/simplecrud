# Simplecrud (Ports and Adapter)

### Requirements

- Java 8+
- Gradle

### Intent

This example of how you would develop a simple Hexagonal Architecture Java application using spring. The power is using this design pattern that is isolated dependency from your business logic using ports.

### Run

Download the git repo 
`git clone git@github.com:Njuman/simplecrud.git`

Run Gradle on root directory or project.
`gradle bootRun`

### Possible Improvements

- Better error handling would be a massive advantage as currently the system would work in happy case scenario.
- Using Request, Event, and Command handler in the domain layer instead of adapters.
- Creating a persistence manager adapter to manage ORMs or Database integration (Using more Generics to make the adapter customizable) making the combinations more customizable without having to develop two repository adapter strategies.

