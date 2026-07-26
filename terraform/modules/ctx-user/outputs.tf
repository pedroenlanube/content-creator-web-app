output "post_confirmation_lambda_arn" {
  value = module.post_confirmation_lambda.alias_arn
}

output "post_confirmation_lambda_name" {
  value = module.post_confirmation_lambda.function_name
}

output "post_confirmation_alias_name" {
  value = module.post_confirmation_lambda.alias_name
}