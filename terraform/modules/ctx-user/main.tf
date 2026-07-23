module "post_confirmation_lambda" {
  source = "../lambda-function"

  function_name = "${var.project_name}-post-confirmation-${var.environment}"
  handler       = "org.springframework.cloud.function.adapter.aws.FunctionInvoker::handleRequest"
  runtime       = "java21"
  memory_size   = 512
  timeout       = 15

  zip_file      = "../backend/ctx-user/target/ctx-user-1.0.0-SNAPSHOT.jar"

  environment_variables = {
    # 1. Dynamic infrastructure configuration
    DYNAMODB_TABLE_NAME              = var.dynamodb_table_name

    # 2. Spring Cloud Function configuration
    SPRING_CLOUD_FUNCTION_DEFINITION = "postConfirmation"
    MAIN_CLASS                       = "dev.pedroenlanube.ctx.user.CtxUserConfiguration"

    # 3. JVM's and Spring hardcore configuration
    JAVA_TOOL_OPTIONS                = "-XX:+UseSerialGC -Xmx512m -XX:+TieredCompilation -XX:TieredStopAtLevel=1"
    SPRING_JMX_ENABLED               = "false"
    SPRING_MAIN_BANNER_MODE          = "off"
  }

  tags = var.tags

  custom_policies = [
    {
      Effect = "Allow"
      Action = [
        "dynamodb:PutItem",
        "dynamodb:UpdateItem",
        "dynamodb:TransactWriteItems"
      ]
      Resource = var.dynamodb_table_arn
    }
  ]
}