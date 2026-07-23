resource "aws_cognito_user_pool" "main" {
  name = "${var.project_name}-user-pool-${var.environment}"

  deletion_protection = var.environment == "pro" ? "ACTIVE" : "INACTIVE"

  account_recovery_setting {
    recovery_mechanism {
      name     = "verified_email"
      priority = 1
    }
  }

  # Block reserved for future SES integration
  # email_configuration {
  #   email_sending_account = "DEVELOPER"
  #   source_arn            = var.ses_domain_identity_arn
  #   from_email_address    = "Soporte <no-reply@tudominio.com>"
  # }

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
    name                     = "given_name"
    required                 = true
  }

  schema {
    attribute_data_type      = "String"
    developer_only_attribute = false
    mutable                  = true
    name                     = "family_name"
    required                 = true
  }

  schema {
    attribute_data_type      = "String"
    developer_only_attribute = false
    mutable                  = true
    name                     = "preferred_username"
    required                 = true

    string_attribute_constraints {
      min_length = 3
      max_length = 30
    }
  }

  # Block for Lambda triggers (Post Confirmation y Pre Token Generation)
  lambda_config {
    post_confirmation    = var.post_confirmation_lambda_arn
  #  pre_token_generation = aws_lambda_function.pre_token_generation_handler.arn
  }

  tags = {
    Name = "${var.project_name}-user-pool-${var.environment}"
  }
}

# Federated Identity Provider: Google
# resource "aws_cognito_identity_provider" "google" {
#   user_pool_id  = aws_cognito_user_pool.main.id
#   provider_name = "Google"
#   provider_type = "Google"
#
#   provider_details = {
#     authorize_scopes = "email profile openid"
#     client_id        = var.google_client_id
#     client_secret    = var.google_client_secret
#   }
#
#   attribute_mapping = {
#     email       = "email"
#     given_name  = "given_name"
#     family_name = "family_name"
#     username    = "sub" # Mapeo interno del identificador de Google
#   }
# }

resource "aws_cognito_user_pool_client" "web_client" {
  name         = "${var.project_name}-nextjs-client-${var.environment}"
  user_pool_id = aws_cognito_user_pool.main.id

  # Required by Auth.js in the server environment (Backend for Frontend)
  generate_secret = true

  # supported_identity_providers = ["COGNITO", "Google"]
  supported_identity_providers = ["COGNITO"]

  allowed_oauth_flows_user_pool_client = true
  allowed_oauth_flows                  = ["code"]
  allowed_oauth_scopes                 = ["email", "openid", "profile"]

  callback_urls = var.callback_urls
  logout_urls   = var.logout_urls

  # depends_on = [aws_cognito_identity_provider.google]
}

resource "aws_cognito_user_pool_domain" "main" {
  domain       = "${var.project_name}-auth-${var.environment}"
  user_pool_id = aws_cognito_user_pool.main.id
}

resource "aws_lambda_permission" "allow_cognito" {
  statement_id  = "AllowExecutionFromCognito"
  action        = "lambda:InvokeFunction"
  function_name = var.post_confirmation_lambda_arn
  principal     = "cognito-idp.amazonaws.com"
  source_arn    = aws_cognito_user_pool.main.arn
}