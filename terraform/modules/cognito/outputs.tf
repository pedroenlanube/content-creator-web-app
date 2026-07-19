output "user_pool_id" {
  description = "ID del User Pool de Cognito"
  value       = aws_cognito_user_pool.main.id
}

output "client_id" {
  description = "ID del Cliente de Cognito"
  value       = aws_cognito_user_pool_client.web_client.id
}

output "client_secret" {
  description = "Secreto del Cliente de Cognito"
  value       = aws_cognito_user_pool_client.web_client.client_secret
  sensitive   = true
}

output "cognito_domain" {
  description = "Dominio base de Cognito para flujos OAuth"
  value       = aws_cognito_user_pool_domain.main.domain
}