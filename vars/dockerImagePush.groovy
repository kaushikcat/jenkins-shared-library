def call() {
    // Define the AWS region and ECR repository URL
    def region = "ap-south-1"
    def registry = "785236889276.dkr.ecr.ap-south-1.amazonaws.com/ecr3-ecr"



   // Perform Docker image push to ECR
    withCredentials([[$class: 'AmazonWebServicesCredentialsBinding', credentialsId: 'ecr3-ecr', accessKeyVariable: 'AWS_ACCESS_KEY_ID', secretKeyVariable: 'AWS_SECRET_ACCESS_KEY']]) {
        sh "aws ecr get-login-password --region ${region} | docker login --username AWS --password-stdin ${registry}"
        sh "docker push ${registry}"
    }
}
