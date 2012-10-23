package com.triu

import org.apache.commons.lang.builder.HashCodeBuilder

class CrumbController {
    def grailsApplication

    /**
     * Add current path and then render the list of crumbs
     */
    def add = {
        List crumbtrail = session.crumbtrail ?: []
        def maxCrumbs = grailsApplication.config.breadcrumbs.crumbs.max ?: 10
        def model = [:]

        // Keeps the trail from growing beyond the max number of crumbs
        model.crumbtrail = (crumbtrail.size() < maxCrumbs) ? crumbtrail : crumbtrail.tail()

        if(params.name && params.href) {
            def maxLength = grailsApplication.config.breadcrumbs.crumbs.maxNameLength
            if(maxLength && (params.name.length() > maxLength)) {
                params.name = params.name[0..maxLength - 1] + '...'
            }
            // Adds the crumb to the trail or repositions it in the trail, depending on configuration
            def crumb = new Crumb(name: params.name, href: params.href)
            if(!model.crumbtrail.contains(crumb) || grailsApplication.config.breadcrumbs.crumbs.showDuplicates == "true") {
                model.crumbtrail << crumb
            }
            else {
                model.crumbtrail.remove(crumb)
                model.crumbtrail << crumb
            }
        }
        session.crumbtrail = model.crumbtrail
        model.home = grailsApplication.config.breadcrumbs.home ?: grailsApplication.config.grails.serverURL

        render(template: "/breadcrumbs/crumbs", model: model, plugin: 'bootstrap-crumbs')
    }

    /**
     * Just render the current list of breadcrumbs
     */
    def list = {
        def model = [:]
        model.crumbtrail = session.crumbtrail ?: []
        model.home = grailsApplication.config.breadcrumbs.home ?: grailsApplication.config.grails.serverURL

        render(template: '/breadcrumbs/crumbs', model: model, plugin: 'bootstrap-crumbs')
    }
}

class Crumb implements Serializable {
    String name
    String href

    boolean equals(other) {
        if(!(other instanceof Crumb)) {
            return false
        }
        return other.name == name && other.href == href
    }

    int hashCode() {
        return new HashCodeBuilder().append(name).append(href).toHashCode()
    }
}
