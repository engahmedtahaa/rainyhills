This Application will calculte the numbers of volumes of given surface profiles 

#To start Application 
1.open source code on any prefered IDE 
2.build using maven 
3.run as spring boot application 
4.it will be runs on embedded Tomcat server he will runs on port 3000

you can also run it as jar by running this command on CMD
	java -jar target/crxmarkets.rainyHills-0.0.1-SNAPSHOT.jar
Using the Maven Plugin
	mvn spring-boot:run 

#To Test Application 
1.open your browser 
2.type on your browser http://localhost:3000/
3.you should view swagger page 
4.click on Water Volume Controller
5./WaterVolumeController/get-volumes-number will be expanded 
6.click on try out 
7.enter your inputs For Example 
	{
  "surfaceProfileList": [
    4, 1, 1, 0, 2, 3
  ]
}
8.click on Exceute 
9.then you should view the result 

You can test it through postman also 
you can also use curl 
	curl -X POST "http://localhost:3000/WaterVolumeController/get-volumes-number" -H "accept: application/json;charset=UTF-8" -H "Content-Type: application/json;charset=UTF-8" -d "{ \"surfaceProfileList\": [ 4, 1, 1, 0, 2, 3 ]}"


Note* My Algorithm to calculate the number of water volumes complexity is O(n) time.

