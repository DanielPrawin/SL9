def newGit(repo)
{
  git "https://github.com/DanielPrawin/${repo}.git"
}
def build()
{
   sh "mvn package"
}
def copyBuilt(jobName,Ip,contextName)
{
  sh "scp /var/lib/jenkins/workspace/${jobName}/webapp/target/webapp.war ubuntu@${Ip}:/var/lib/tomcat9/webapps/${contextName}.war"
}
def test(jobName)
{
  sh "java -jar /var/lib/jenkins/workspace/${jobName}/testing.jar"
}
