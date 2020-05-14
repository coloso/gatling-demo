.PHONY: help docker-up docker-down gatling

help: ## shows this help.
	@awk 'BEGIN {FS = ":.*?## "} /^[a-zA-Z_\-\.]+:.*?## / {printf "\033[36m%-30s\033[0m %s\n", $$1, $$2}' $(MAKEFILE_LIST)

# DOCKER
docker-init: ## build
	docker-compose build && docker-compose -f docker-compose.gatling.yml build

docker-up: ## starts php-fpm and nginx.
	docker-compose -f docker-compose.yml up -d

docker-down: ## stops all container.
	docker-compose down

docker-php: ## login shell for php container
	docker-compose exec php sh

# GATLING
gatling: ## starts loadtest.
	docker-compose -f docker-compose.gatling.yml run gatling