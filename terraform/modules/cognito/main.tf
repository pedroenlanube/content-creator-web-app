resource "aws_cognito_user_pool" "main" {
  name = "${var.project_name}-user-pool-${var.environment}"

  alias_attributes         = ["email"]
  auto_verified_attributes = ["email"]

  password_policy {
    minimum_length    = 12
    require_lowercase = true
    require_numbers   = true
    require_symbols   = true
    require_uppercase = true
  }

  schema {
    attribute_data_type      = "String"
    developer_only_attribute = false
    mutable                  = true
    name                     = "email"
    required                 = true

    string_attribute_constraints {
      min_length = 5
      max_length = 256
    }
  }

  schema {
    attribute_data_type      = "String"
    developer_only_attribute = false
    mutable                  = true
    name                     = "name"
    required                 = true
  }

  # Block reserved for Lambda triggers (Post Confirmation y Pre Token Generation)
  # lambda_config {
  #   post_confirmation    = aws_lambda_function.post_confirmation_handler.arn
  #   pre_token_generation = aws_lambda_function.pre_token_generation_handler.arn
  # }

  tags = {
    Name = "${var.project_name}-user-pool-${var.environment}"
  }
}

resource "aws_cognito_user_pool_client" "web_client" {
  name         = "${var.project_name}-nextjs-client-${var.environment}"
  user_pool_id = aws_cognito_user_pool.main.id

  # Required by Auth.js in the server environment (Backend for Frontend)
  generate_secret = true

  supported_identity_providers = ["COGNITO"]

  allowed_oauth_flows_user_pool_client = true
  allowed_oauth_flows                  = ["code"]
  allowed_oauth_scopes                 = ["email", "openid", "profile"]

  callback_urls = var.callback_urls
  logout_urls   = var.logout_urls
}

resource "aws_cognito_user_pool_domain" "main" {
  domain       = "${var.project_name}-auth-${var.environment}"
  user_pool_id = aws_cognito_user_pool.main.id
}