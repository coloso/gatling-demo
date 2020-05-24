# Symfony-Gatling-Demo
This Repo shows how to run Loadtests in local dev environment with Gatling3 and Symfony5 with Docker-Compose and Make.

[![Build Status](https://travis-ci.org/coloso/symfony-docker.svg?branch=master)](https://travis-ci.org/coloso/symfony-docker)

### Prerequisites
- [Docker](https://www.docker.com/)

### Container
- [nginx](https://pkgs.alpinelinux.org/packages?name=nginx&branch=v3.10) 1.16.+
- [php-fpm](https://pkgs.alpinelinux.org/packages?name=php7&branch=v3.10) 7.3.+
- [gatling](https://gatling.io) 3.3.+

### Installing
Clone this repo:
```
git clone https://github.com/coloso/gatling-demo 
```
Build container:
```
make init
```

#### Symfony
```
make up
```
You should see the Symfony welcome-page after calling [http://localhost](http://localhost/) in your browser.

#### Gatling
Compose looks for a network called `loadtestnet` and connect your app’s containers to it.
So if you want your containers to join a pre-existing network, it's necessary to start the symfony container first with: `make up`!

Run your Tests written in Scala located at `/gatling/simulations/`:
```
make gatling
```
In this example we have two simulations that comprise our load tests. After choosing one, the results can be viewed in the `/gatling/results/` directory.
```
Choose a simulation number:
     [0] BasicSimulation
     [1] ExampleControllerSimulation
```
That's it!