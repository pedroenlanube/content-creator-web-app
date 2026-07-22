variable "project_name" {
  description = "Project name"
  type        = string
}

variable "environment" {
  description = "Deployment environment (e.g., dev, pro)"
  type        = string
}

variable "callback_urls" {
  description = "List of permitted URLs for the callback after login"
  type        = list(string)
}

variable "logout_urls" {
  description = "List of permitted URLs for redirecting after logout"
  type        = list(string)
}

variable "google_client_id" {
  description = "Client ID provided by the Google Cloud Console for OAuth"
  type        = string
}

variable "google_client_secret" {
  description = "Client Secret provided by the Google Cloud Console for OAuth"
  type        = string
  sensitive   = true
}

# Variable reserved for future integration with Amazon SES
# variable "ses_domain_identity_arn" {
#   description = "Domain Identity ARN in Amazon SES for sending emails"
#   type        = string
# }