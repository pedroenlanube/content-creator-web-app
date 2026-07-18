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

# 1. Infraestructura compartida (DynamoDB, API Gateway)
module "shared_infrastructure" {
  source = "./modules/shared-infrastructure"

  environment  = var.environment
  project_name = var.project_name
}

# 2. Cognito Integration Service
# module "cognito_integration_service" {
#   source = "./cognito-integration-service"
#   ...
# }