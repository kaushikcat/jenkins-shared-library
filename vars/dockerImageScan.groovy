def call(String aws_account_id, String region, String ecr_repoName){
    
    sh """
    trivy image ${registry}/${imagename}:${tagname} > scan.txt
    cat scan.txt
    """
}
