.PHONY: help docker-up docker-down gatling

help: ## shows this help.
	@awk 'BEGIN {FS = ":.*?## "} /^[a-zA-Z_\-\.]+:.*?## / {printf "\033[36m%-30s\033[0m %s\n", $$1, $$2}' $(MAKEFILE_LIST)

# DOCKER
init: ## builds container with webserver, php-fpm and gatling.
	docker-compose build && docker-compose -f docker-compose.gatling.yml build

up: ## starts webserver.
	docker-compose -f docker-compose.yml up -d

down: ## stops all container.
	docker-compose down

ssh: ## login shell for php container
	docker-compose exec php sh

# GATLING
gatling: ## starts loadtest.
	docker-compose -f docker-compose.gatling.yml run gatling