terraform {
  required_providers {
    aws = {
      source  = "hashicorp/aws"
      version = "~> 5.0"
    }
  }

  backend "s3" {
    bucket         = "pedroenlanube-dev-serverless-web-terraform-state"
    key            = "serverless-back/terraform.tfstate"
    region         = "eu-west-1"
    use_lockfile   = true
    encrypt        = true
  }
}

provider "aws" {
  region = var.aws_region

  default_tags {
    tags = {
      "awsApplication"       = var.project_name
      "user:Environment"     = var.environment
      "user:Owner"           = "pedroenlanube"
      "user:ApplicationName" = "pedroenlanube-serverless-web"
    }
  }
}

# Shared infrastructure common to all services (DynamoDB, API Gateway)
module "shared_infrastructure" {
  source = "./modules/shared-infrastructure"

  environment  = var.environment
  project_name = var.project_name
}

# Cognito as Identity Provider
module "cognito" {
  source = "./modules/cognito"
  environment  = var.environment
  project_name = var.project_name

  # Conditional logic: If the environment is ‘pro’, use the real domain. Otherwise, use localhost.
  callback_urls = var.environment == "pro" ? ["https://pedroenlanube.com/api/auth/callback/cognito"] : ["http://localhost:3000/api/auth/callback/cognito"]
  logout_urls   = var.environment == "pro" ? ["https://pedroenlanube.com"] : ["http://localhost:3000"]

  google_client_id     = var.google_client_id
  google_client_secret = var.google_client_secret
}

# 2. Cognito Integration Service
# module "cognito_integration_service" {
#   source = "./cognito-integration-service"
#   ...
# }