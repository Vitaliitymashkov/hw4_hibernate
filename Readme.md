# Hibernate hometask
1. Create a new gradle/maven project
2. Add to your project hibernate-core dependency
3. Create hibernate.cfg.xml file in resources directory with the appropriate
   configuration according to your database
4. Create EntityManagerFactory and establish a connection with a database
5. Get Session object
6. Create classes that represent structure:
    
    Class Carriage represents railway carriage and has attributes: serial number
   (UUID), year of manufacturing, max number of passengers
   
    Class Train represents railway train and has attributes: route number, class
   (intercity, night, etc.), max speed, depot address, and list of carriages that included
   to train
   
    Depot address has attributes: city, serial number
    
    One train could be associated only with one depot
   
7. Save in the database Train (705, intercity, 160 km/h, Kyiv 1st depot) with 5
   carriages of the 2011 year of manufacturing. 3 of the carriages have 80 max
   passengers and 2 with 56 passengers
   
8. Load from database existing train using route number parameters
9. Print to the console all information of the loaded train

# Solution

1. Start PostgreSQL in docker


    docker run --name gl-db-pg-13.3 -p 5432:5432 -e POSTGRES_USER=glpguser -e POSTGRES_PASSWORD=pgpwd4gl -e POSTGRES_DB=hometask postgres:13.3

To enter PostgreSQL and database use 


    docker exec -it gl-db-pg-13.3 /bin/sh

    psql --username=glpguser --dbname=hometask

