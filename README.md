# Agent
This is JAVA Application which can :
- collect operation system Logs : Security , Application ,...
- parse Logs structure
- split very large file of logs into configured chunk file ( time frame in minutes)
- Apply PowerShell commands over Windows 
- Apply Linux commands 
- Load and Store Configuration into Configuration file 
- Work offline , store last processing point , even if App were closed it will know how to continue from the last point.
- work Async 

This Application Design is Compound of different Design Patterns and principles:
- Factory 
- implementing interfaces 
- inhereting abstract classes 
- lots of Polymorphism behaviors
- Safe Thread Singlton 
- using Composite 
- Reflection 

 
![alt text](https://user-images.githubusercontent.com/18490274/36945444-ee0f7806-1fb6-11e8-8364-d68a5da2043d.PNG)
