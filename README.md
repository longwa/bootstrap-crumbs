Bootstrap Breadcrumbs Plugin
============================
This plugin is based off of the Grails Breadcrumbs plugin (http://grails.org/plugin/breadcrumbs). It works in exactly the same way 
and supports the same options but uses the Twitter Bootstrap styles and pure CSS instead of requiring the jQuery breadcrumbs library.

Thanks to *hardwickj* for doing all the work, I mostly just copied and hacked his code.

Usage
-----
To use the plugin, simply add the following to your layout:

    <crumbs:trail selector="title"/>

You can specify any valid CSS selector from which to extract the crumb text. If the selector is not available, the bar will render but the new page
will not be added to the list of crumbs.

If you use a common element as the title of your crumbs for each page, for example a <title> element, you can specify this within your
Config.groovy file by adding the following snippet:
    breadcrumbs.selector="title"

Bootstrap-crumbs will use the in-page taglib defined element over the Config.groovy defined element when it exists. Any standard jquery-style selector should work in specifying the element to use for crumb naming.

Configuring Behavior
--------------------
Breadcrumbs offers several properties that can be defined in Config.groovy to alter it's default behavior. These are described as follows:

    breadcrumbs.home

By default the home icon in the crumb trail will forward to the grails.serverURL property. You can alter this location by defining the breadcrumbs.home property in Config.groovy

    breadcrumbs.selector

You can optionally specify a default selector to use in determining crumb names across all pages that contain the crumb trail. This can also be defined as described in Usage -> Adding the Taglib

    breadcrumbs.crumbs.max

By default the crumb trail is limited to a maximum of 10 crumbs. If the number of crumbs exceeds this, the oldest crumb is dropped from the trail. You can alter the number of crumbs to allow before this cut off by defining the breadcrumbs.crumbs.max property in Config.groovy

    breadcrumbs.crumbs.showDuplicates

By default the crumb trail will not show duplicate crumbs. If a crumb is already in the crumb trail and you revisit the page represented by that crumb, it will reposition the crumb to the front of the crumb trail. By enabling the showing of duplicates, the original crumb is left in it's position while a new one is added to the front of the crumb trail.

    breadcrumbs.crumbs.maxNameLength

By default each crumb name does not have a maximum length. This can potentially result in lengthy crumb names which cause the crumb trail to expand to an undesirable width. Defining breadcrumbs.crumbs.maxNameLength will cause any crumb name in excess of said length to be truncated and appended with a "..." to indicate the truncation.

TODO
----
Ideally this functionality should be merged into the Twitter Bootstrap plugin (http://grails.org/plugin/twitter-bootstrap).
