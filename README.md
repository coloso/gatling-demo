# Symfony-Gatling-Demo
This Repo running Loadtest locally with Gatling 3.3.1 and Symfony 5.

[![Build Status](https://travis-ci.org/coloso/symfony-docker.svg?branch=master)](https://travis-ci.org/coloso/symfony-docker)
### Prerequisites
* [Docker](https://www.docker.com/)

### Container
 - [nginx](https://pkgs.alpinelinux.org/packages?name=nginx&branch=v3.10) 1.16.+
 - [php-fpm](https://pkgs.alpinelinux.org/packages?name=php7&branch=v3.10) 7.3.+
    - [composer](https://getcomposer.org/) 
    - [yarn](https://yarnpkg.com/lang/en/) and [node.js](https://nodejs.org/en/) (if you will use [Encore](https://symfony.com/doc/current/frontend/encore/installation.html) for managing JS and CSS)
- [gatling](https://gatling.io) 3.3.+

### Installing
#### Symfony

run docker and connect to container:
```
 docker-compose up --build
```
```
 docker-compose exec php sh
```

install latest version of [Symfony](http://symfony.com/doc/current/setup.html) via composer:
```
# traditional web application: 
$ composer create-project symfony/website-skeleton .
```
or
```
# microservice, console application or API:
$ composer create-project symfony/skeleton .
```

call [localhost](http://localhost/) in your browser

## Gatling
Compose looks for a network called my-pre-existing-network and connect your app’s containers to it.
So if you want your containers to join a pre-existing network, it's necessary to build nginx & php container first.
 
