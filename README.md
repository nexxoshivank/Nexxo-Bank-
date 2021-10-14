# Nexxo-Bank
<div align="center">
<a>
<img src="webpages/bankicon.png" alt="Logo" width="80" height="80">
</a>
<h3 align="center">NEXXO BANK</h3>
  </div>
  
  <details>
  <summary>Table of Contents</summary>
  <ol>
    <li>
      <a href="#about-the-project">About The Project</a>
      <ul>
        <li><a href="#built-with">Built With</a></li>
      </ul>
    </li>
    <li>
      <a href="#getting-started">Getting Started</a>
      <ul>
        <li><a href="#prerequisites">Prerequisites</a></li>
        <li><a href="#installation">Installation</a></li>
      </ul>
    </li>
    <li><a href="#usage">Usage</a></li>
    <li><a href="#roadmap">Roadmap</a></li>
    <li><a href="#contributing">Contributing</a></li>
    <li><a href="#license">License</a></li>
    <li><a href="#contact">Contact</a></li>
    <li><a href="#acknowledgments">Acknowledgments</a></li>
  </ol>
</details>


## About The Project

Hey, this project is an bank application of a virtual bank where we can manage most of the
bank related tasks, in which we have two different portals for admin and customer both where they can handle 
all of there bank related functionality and queries.


### What can admin do ?

* First of all, no customers can register theirself on their own. So only admin can register a customer in the bank.
* Admin can check the total number of customers and their statuses whether the one is Active or Inactive.
* Can activate or deactivate customers. 
* Admin can check the feedback given by number of customers.

### What customers can do?

* Once admin registers one, customers can see their profile details on their dashboard.
* Customers can give feedback about bank which will be reviewed by admin once submitted.
* Customers can send money to anyone using account number and ifsc code.
* Can check the transaction history of their account.

#### How project is made?

It is basically an 3 tier arhitecture project where i have used tomcat to host all the html pages on server
and the API's are implemented on IntelliJ in java and have connected it to SQL databse (workbench) for saving 
all the information of the entities.

### Built With

* [Java]
* [SQl]
* [HTML]
* [Jquery]


##  Installation & Getting Started

To run with this project, one firstly needs to install external dependencies or pre requities :-

* IntelliJ Idea and some plugins like scala, ebean and have to configure them in intellij.
* Java 1.8 or higher.
* Sbt version 1.5.2 and sbt executer.
* Play framework for API development.
* MySQL workbench.
* Tomcat Server Host.

After installing all the tools and plugins, one has to open the main project in Intellij Idea
and if all the dependencies are good to go, Open all the html pages in a seperate document and host
them on tomcat server, before doing that please ensure you have setted up the databse (You can have dummy data too).
And after doing all neccessary steps run sbt and html pages.

You're Done.

## Contact

Your Name - [nexxoshivank] - shivank.sharma@nexxo.com

Project Link: [https://github.com/your_username/repo_name](https://github.com/your_username/repo_name)





