# The Drones

There is a major new technology that is destined to be a disruptive force in the field of  transportation: the drone. The drone has the potential to leapfrog traditional  transportation infrastructure. 

## Built with Spring Boot

Maven build tool
./mvnw clean install

java -jar target/drones-0.0.1-SNAPSHOT.jar

h2 in-memory database


## API END POINTS

### Drones

Get All Drones

curl -X GET \
  'http://127.0.0.1:9092/drones' 

Add Drone

curl -X POST \
  'http://127.0.0.1:9092/drones' \
  --header 'Content-Type: application/json' \
  --data '{
    "serialNumber": "CW01",
    "model": "Middleweight",
    "weightLimit": 300.0,
    "batteryPercentage": 50.0,
    "state": "IDLE"
  }'

### Medications

Get All Medications

curl -X GET \
  'http://127.0.0.1:9092/medications'

Add Medication

curl -X POST \
  'http://127.0.0.1:9092/medications' \
  --header 'Content-Type: application/json' \
  --data '  {
    "name": "MARALIA-_23JEE",
    "weight": 40.0,
    "code": "MARSSJ_W",
    "image": "OBJ"
  }'