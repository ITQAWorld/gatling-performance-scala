# Run automation
cd to project path 
mvn gatling:execute -Dgatling.simulationClass=api.%TestName% -Dusers=%ConstantUsersPerSecond% -Dduration=%TestDuration%