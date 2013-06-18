class BootstrapCrumbsGrailsPlugin {
    def version = "1.0.3"

    // the version or versions of Grails the plugin is designed for
    def grailsVersion = "1.3.5 > *"

    // resources that are excluded from plugin packaging
    def pluginExcludes = [
        "grails-app/views/error.gsp"
    ]

    def title = "Bootstrap Crumbs Plugin"
    def author = "Aaron Long"
    def authorEmail = "longwa@gmail.com"
    def description = 'Provide simple breadcrumb functionality using the twitter bootstrap library'

    // URL to the plugins documentation
    def documentation = "http://github.com/longwa/bootstrap-crumbs"

    // Online location of the plugin's browseable source code.
    def scm = [ url: "https://github.com/longwa/bootstrap-crumbs" ]
}
