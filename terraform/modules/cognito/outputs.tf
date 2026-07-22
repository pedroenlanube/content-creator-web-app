output "user_pool_id" {
  description = "Cognito User Pool ID"
  value       = aws_cognito_user_pool.main.id
}

output "client_id" {
  description = "Cognito User Pool Client ID"
  value       = aws_cognito_user_pool_client.web_client.id
}

output "client_secret" {
  description = "Cognito User Pool Client Secret"
  value       = aws_cognito_user_pool_client.web_client.client_secret
  sensitive   = true
}

output "cognito_domain" {
  description = "Base domain for Cognito OAuth flows"
  value       = aws_cognito_user_pool_domain.main.domain
}