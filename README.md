# Performance base

Load and Performance Testing Using Gatling

Gatling's code-like scripting enables to easily maintain testing scenarios and easily automate them in  continuous delivery pipeline.
Official documentation: https://gatling.io/

Getting Started
-------------
These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

Prerequisites
--------------
Maven  
Git

Installing
-------------
Clone the repo to get a working project

Running the tests - command line mode
-------------------
cd to project path 
mvn gatling:execute -Dgatling.simulationClass=api.%TestName% -Dusers=%ConstantUsersPerSecond% -Dduration=%TestDuration%

Built With
-------------
* [Gatling](https://gatling.io/) - Load and Performance Testing
* [Maven](https://maven.apache.org/) - Dependency Management

Contributing
-------------
Please read [CONTRIBUTING.md](doc/CONTRIBUTING.md) for details of the process for submitting pull requests.

Versioning
-------------
[SemVer](http://semver.org/) is in use for versioning.   
For the versions available, see the [tags on this repository](https://github.com/your/project/tags). 

Authors
-------------
**Pavel Yampolsky**  - Skype: pavel.yampolsky.willhill Email: 2pavelya@gmail.com

License
-------------
This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details
