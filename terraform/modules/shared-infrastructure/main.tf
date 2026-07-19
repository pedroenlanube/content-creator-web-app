# ServiceCatalog AppRegistry Application
resource "aws_servicecatalogappregistry_application" "main" {
  name        = "${var.project_name}-app-${var.environment}"
  description = "Aplicación web serverless"
}

# DynamoDB Single Table
resource "aws_dynamodb_table" "main" {
  name           = "${var.project_name}-table-${var.environment}"
  billing_mode   = "PAY_PER_REQUEST"
  hash_key       = "PK"
  range_key      = "SK"

  # Table attributes
  attribute {
    name = "PK"
    type = "S"
  }

  attribute {
    name = "SK"
    type = "S"
  }

  # Table attributes for GSI1
  attribute {
    name = "GSI1PK"
    type = "S"
  }

  attribute {
    name = "GSI1SK"
    type = "S"
  }

  # Table attributes for GSI2
  attribute {
    name = "GSI2PK"
    type = "S"
  }

  attribute {
    name = "GSI2SK"
    type = "S"
  }

  # Global Secondary Index 1
  global_secondary_index {
    name               = "GSI1"
    hash_key           = "GSI1PK"
    range_key          = "GSI1SK"
    projection_type    = "ALL"
  }

  # Global Secondary Index 2
  global_secondary_index {
    name               = "GSI2"
    hash_key           = "GSI2PK"
    range_key          = "GSI2SK"
    projection_type    = "ALL"
  }
}

# API Gateway HTTP API
resource "aws_apigatewayv2_api" "main" {
  name          = "${var.project_name}-api-${var.environment}"
  protocol_type = "HTTP"
}

# API Gateway Stage
resource "aws_apigatewayv2_stage" "dev" {
  api_id      = aws_apigatewayv2_api.main.id
  name        = var.environment
  auto_deploy = true
}