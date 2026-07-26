output "function_arn" {
  description = "ARN of the Lambda function"
  value       = aws_lambda_function.this.arn
}

output "function_name" {
  description = "Name of the Lambda function"
  value       = aws_lambda_function.this.function_name
}

output "alias_arn" {
  description = "ARN of the live alias"
  value       = aws_lambda_alias.live.arn
}

output "alias_name" {
  description = "Name of the live alias"
  value       = aws_lambda_alias.live.name
}

output "role_arn" {
  description = "ARN of the IAM role created for the Lambda"
  value       = aws_iam_role.lambda_role.arn
}