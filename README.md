# aws-lambda-kotlin
AWS Lambda function written in kotlin.

The steps explaining the code can be found [here](https://dev.to/rmpt/aws-lambda-kotlin-4ich).

## Generate a fat jar

Run this in the project root, it generates a fat jar that can be found under `lib/build/libs/lib-all.jar`

`./gradlew shadowJar`

## Deploy to AWS

These commands should be run inside the `lib` folder/module. THey will create an S3 bucket to store the final template 
and use that final template to deploy the function.

1. `aws s3 mb s3://lambda-kotlin`
2. `aws cloudformation package –template-file template.yml –s3-bucket lambda-kotlin –output-template-file template-out.yml`
3. `aws cloudformation deploy –template-file template-out.yml –stack-name lambda-kotlin –capabilities CAPABILITY_NAMED_IAM`

## Test

`aws lambda invoke --function-name <your_function_name> --payload '{ "content": "Hey!" }' out.json`

`out.json` file will contain the content of the response, something like: `{"content":"Echo: Hey!"}`