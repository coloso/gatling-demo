.PHONY: help docker-up docker-down gatling

help: ## shows this help.
	@awk 'BEGIN {FS = ":.*?## "} /^[a-zA-Z_\-\.]+:.*?## / {printf "\033[36m%-30s\033[0m %s\n", $$1, $$2}' $(MAKEFILE_LIST)

docker-up: ## starts php-fpm and nginx.
	docker-compose run -d php && docker-compose run -d nginx

docker-down: ## stops all container.
	docker-compose down

gatling: ## starts loadtest.
	docker-compose run gatling