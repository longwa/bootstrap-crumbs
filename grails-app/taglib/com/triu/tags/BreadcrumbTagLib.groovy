package com.triu.tags

class BreadcrumbTagLib {
    static namespace = "crumbs"

    def trail = { attrs, body ->
        def model = [:]

        model.selector = attrs.selector ?: grailsApplication.config.breadcrumbs.selector
        model.selectors = attrs.selectors ?: grailsApplication.config.breadcrumbs.selectors

        out << render(template: '/breadcrumbs/trail', model: model, plugin: 'bootstrap-crumbs')
    }
}
