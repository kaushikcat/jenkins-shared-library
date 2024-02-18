def call() {
    // Define the AWS region and ECR repository URL
    def region = "ap-south-1"
    def registry = "670855725719.dkr.ecr.ap-south-1.amazonaws.com/kaushik-ecr"



   // Perform Docker image push to ECR
    withCredentials([[$class: 'AmazonWebServicesCredentialsBinding', credentialsId: 'kaushik-ecr', accessKeyVariable: 'AWS_ACCESS_KEY_ID', secretKeyVariable: 'AWS_SECRET_ACCESS_KEY']]) {
        sh "aws ecr get-login-password --region ${region} | docker login --username AWS --password-stdin ${registry}"
        sh "docker push ${registry}"
    }
}
