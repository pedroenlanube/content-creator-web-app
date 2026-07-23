variable "project_name" { type = string }
variable "environment" { type = string }
variable "dynamodb_table_name" { type = string }
variable "dynamodb_table_arn" { type = string }
variable "tags" {
  type = map(string)
  default = {}
}