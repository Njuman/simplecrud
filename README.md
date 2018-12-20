# Simplecrud (Ports and Adapter)

### Requirements

- Java 8+
- Gradle

### Intent

This is a simple example of how you would setup a simple Hexagonal Architecture using spring. The power is using this design pattern is that is isolates dependency from your business logic using ports.

### Run

Download the git repo 
`git clone git@github.com:Njuman/simplecrud.git`

Run Gradle on root directory or project.
`gradle bootRun`

### Improvement

- Better error handling would be a massive advantage as the controllers are expecting a happy case scenario.
- Using Request, Event, and Command handler on the adapter folder or naming adapter as handlers
- Creating a persistence manager adapter to manage ORMs or Database integration (Using more Generics to make the adapter customizable) making the combinations more customizable without having to develop two repository adapter strategies.

