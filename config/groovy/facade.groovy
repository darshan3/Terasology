
class facade {

    def excludedItems = ["PC", "TeraEd"]

    def getGithubDefaultHome(Properties properties) {
        return properties.alternativeGithubHome ?: "MovingBlocks"
    }

    def targetDirectory = "facades"
    def itemType = "facade"

    // Facades currently do not care about dependencies
    String[] findDependencies(File targetDir) {
        return []
    }

    def copyInTemplateFiles(File targetDir) {
        println "In copyInTemplateFiles for facade $targetDir.name - reviewing Gradle needs"
        File targetBuildGradle = new File(targetDir, 'build.gradle')
        if (!targetBuildGradle.exists()) {
            targetBuildGradle << new File('templates/facades.gradle').text
        }
    }
}
