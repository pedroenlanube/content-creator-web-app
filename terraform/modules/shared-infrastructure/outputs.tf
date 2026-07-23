output "dynamodb_table_name" {
  description = "Name of the main Single-Table DynamoDB"
  value       = aws_dynamodb_table.main.name
}

output "dynamodb_table_arn" {
  description = "ARN of the main Single-Table DynamoDB"
  value       = aws_dynamodb_table.main.arn
}

output "api_id" {
  value = aws_apigatewayv2_api.main.id
}

output "api_execution_arn" {
  value = aws_apigatewayv2_api.main.execution_arn
}