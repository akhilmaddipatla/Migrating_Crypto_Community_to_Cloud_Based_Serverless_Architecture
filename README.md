# Migrating_Crypto_Community_to_Cloud_Based_Serverless_Architecture
Migrating CryptoCommunity to a Cloud-Based Serverless
Architecture
By Richard Castaneda, Ernest Gurish, Zhiyuan Luo, and Akhil Maddipatla
Introduction & Use Case:

Cryptocurrency and similar blockchain technologies have entered a realm of
unexpected popularity. What began as an obscure piece of technology has evolved to
something many are considering useful. Cryptocurrencies like Bitcoin are now widely
reported on and, in some places like Argentina, are being considered a more valuable
form of payment than plain money.

1 Cryptocurrencies have multiple layers of complexity.
It is used as a form of currency though the value of any individual cryptocurrency is
quite variable. Not only are there economic and technological complexities, but also
concerns around the environmental impact of proof-of-work systems.2 As a result of this
rapidly growing multifaceted technology, people will no doubt look for resources
dedicated to understanding it as well as sharing their opinions on it. This is where our
motivation for CryptoCommunity, our cloud-based cryptocurrency community and
forum, begins.

The Problem:
The problem we are looking to solve is creating a lightweight, user friendly solution to
gaining valuable information about Cryptocurrency while minimizing long term and
upfront startup cost. CryptoCommunity is currently hosted locally, and while this allows
for greater control of our product, we are looking to implement a solution that reduces
costs and maintenance time on our end. 

Our project migrates an existing React web application and the associated database management to Amazon Web Services. In this
project we took a web application CryptoCommunity created by one of our project
members, Richard Castaneda, and migrated it over to be hosted and maintained on
AWS using all free-tier eligible products. This means that CryptoCommunity can enjoy
the added security and reliability benefits of cloud-computing while significantly reducing
cost using free-tier eligible products.

This work is important in that it creates an environment in which CryptoCommunity can
utilize some of the basic characteristics of cloud computing while providing a platform
for easy growth in the future as well as low upfront startup cost. In addition, this project
displays the convenience of being able to provision resources from a wide array of
available services on AWS without needing the help of onsite AWS staff to implement
our design. The work we did was able to be done with the assistance of any at AWS
while still producing a full implementation of our product and having it go live that very
same day.
2
https://www.washingtonpost.com/business/energy/why-bitcoins-environmental-problems-are-so-hard-to-fi
x/2022/03/16/b71e1d22-a4df-11ec-8628-3da4fa8f8714_story.html
1 https://www.bbc.com/news/business-60912789

A cloud-based solution offers a number of key advantages. The ease at which the
front-end can be hosted and accessible in multiple different regions and countries is one
advantage. Rather than just be localized to the U.S. on a personal server, in a few
simple steps it can be deployed in Europe and Asia as well, giving the application a far
more global reach. 

Moving the implementation to the cloud also gives us all the tools
and services needed to modularize and improve our current deployment model.
Perhaps the front-end offerings would expand, necessitating a move to a dynamic
website hosted on EC2. Likely the API would need to be extended and expanded upon
as well which would be better served by the AWS API Gateway. Lastly, the cloud-based
solution creates a far more easily scalable product. 

If the back-end database cannot keep up with requests, it can be upscaled to a more powerful RDS instance with a few
clicks. Overall, a cloud-based solution gives the application a global reach with the
flexibility to continuously improve and scale our current implementation with the wide
array of AWS services.

Cloud Computing Characteristics:
CryptoCommunity’s unique problem and use case calls for three primary characteristics
of cloud computing. First and foremost, our objective is to keep both initial startup costs
and monthly maintenance costs low. Second, this website was created, and maintained
by us as there are no intermediary services required to help upkeep the website and its
content. Finally, we want our website to be available to a multitude of clientele and
minimize downtime for our customers. With these goals in mind, we chose a cloud
computing model for its measured service, broad network access, and on-demand
self service. 

Measured service allows us to provision only what is absolutely necessary
to host our site at dynamic periods of volume. This means that as we grow, we can
provision more resources but only as we need them rather than investing in large
startup costs to get our product off the ground. Broad network access helps us ensure
that our product is deliverable to many points around the globe without having to worry
about content delivery or high propagation and transmission delays. Finally, on-demand
self service allows us full control over our provisioned services and website front and
backend allowing us to have the engineers in control and access to our website 24/7
without requiring the help from someone at AWS.

Early Iterations:
Our implementation went through two major shifts in strategy before arriving at our final
architecture. Our initial project proposal was to decompose the original web application
into a small set of microservices.

As a group, we wanted to gain experience with
planning and implementing a microservice architecture as well as learn more about
Docker. Since the original CryptoCommunity web application was relatively compact in
terms of codebase size and scope, we thought it would be a good candidate for getting
this experience with microservices. 
