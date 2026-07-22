variable "aws_region" {
  description = "AWS region"
  type        = string
  default     = "eu-west-1"
}

variable "environment" {
  description = "Deployment environment (e.g., dev, pro)"
  type        = string
  default     = "dev"
}

variable "project_name" {
  description = "Project name"
  type        = string
  default     = "pedroenlanube-serverless-web"
}

variable "google_client_id" {
  description = "Client ID provided by the Google Cloud Console for OAuth"
  type        = string
  default     = "DUMMY_ID"
}

variable "google_client_secret" {
  description = "Client Secret provided by the Google Cloud Console for OAuth"
  type        = string
  default     = "DUMMY_SECRET"
  sensitive   = true
}