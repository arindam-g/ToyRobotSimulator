# ToyRobotSimulator

#### ASSUMPTIONS
1. The robot navigates on a rectangular, flat surface with south-west and north-east most coordinates at (0, 0) and (5, 5) respectively. Thus, movement in first quadrant is assumed.
2. The surface coordinates are all whole numbers (defined as Java long).
3. The robot turns right or left at 90 degrees, and makes unit movements in the current orientation.


#### NOTES
1. The application has been developed in Java 8, using Eclipse IDE.
2. The solution is provided as a GitHub project, accessed via the following link: https://github.com/arindam-g/ToyRobotSimulator
3. The project root folder is ToyRobotSimulator, which contains all files pertaining to the application.
4. Sample data is provided via the input file src/main/resources/instruction-input.txt, while config/simulation.properties contains some configurable properties.
5. The /target folder, when built, will contain the compiled and packaged artifacts.
6. Source code are located in src/main/java/... and test code in src/test/java.... The package structure is of the form au.com.whispir.robot.simulation.*
7. Program-execution begins in au.com.whispir.robot.simulation.client.SimulatorApp.main().
8. Maven is used as the build-tool for the application.
9. Program output is seen on standard console.


#### AGILE DEVELOPMENT
1. The software is engineered using test-driven development (TDD) methodology. Small-step refactorings were done as required following the basic test-pass coding, during most “red-green- refactor” cycles.
2. Unit tests are written using JUnit 4, and Mockito is used as the mocking framework.
3. Automated build and test-execution occur using Maven 3.
4. Some further refinements for perfection were perhaps possible, but the temptation has been resisted in favour of simplicity, so as not to fall into the trap of over-engineering.


#### DESIGN
1. Loose coupling and high cohesion have been strived for, and good object-oriented design principles have been followed.
2. Domain-driven design (DDD) has been practiced, and care has been taken to avoid anaemic models.
3. A few glimpses of Java 8 functional programming & lambda expressions can also be found.
4. Javadoc comments of public APIs provide some understanding of the flow of the application. Inline source-code comments can also be found, but their use has been restricted so as not to clutter the readability of the code.
5. TextInstructionDecoder receives text-format instructions (furnished from the input file by SimulationUtils) and parses them into appropriate Command objects legible to ToyRobots. The InstructionType enum, which enumerates the permissible types of instructions, assists here by employing the STRATEGY pattern to construct corresponding command instances.
6. The instruction decoder registers these commands with a CommandController, which, in turn, invokes the seamless execution of the different types of Commands (i.e. MoveCommand, PlaceCommand, etc.). This is an example of the COMMAND design pattern.
7. The robot’s whereabouts are provided by Position, on a TableSurface. The Position class provides a FACADE to Location and Direction objects.
8. Direction is an enum and implements the STATE pattern by providing state-transitioning “rotation” operations resulting in a different state (direction).
9. In order to compute “location advances” in various directions, the Position class delegates to an appropriate instance of DirectedMovementResolver enum, which implements the STRATEGY design pattern by modifying the context argument (location) appropriately for each direction.
10. The correct instance (corresponding to the specified direction) of DirectedMovementResolver is furnished by the FACTORY class MovementResolverFactory.
11. The report command forwards the robot’s position details to DisplayDevice, which prints the output on standard console.
12. Configurable properties (e.g. path for the input file) are placed in config/simulation.properties file, and are conveniently made available via the ConfigUtils class. CommonConstants provides definitions of constant values, and SimulationException is an application-specific exception class.
13. SimulatorApp is a client class that provides an end-to-end execution of the application.
14. A more detailed understanding of the design aspects of the solution may be obtained by your kind perusal of the code-base, since a well-written and clean source-code itself – as we know – is indeed a valuable design document.
