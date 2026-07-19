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