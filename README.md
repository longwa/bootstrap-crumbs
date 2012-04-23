Bootstrap Breadcrumbs Plugin
============================
This plugin is based off of the Grails Breadcrumbs plugin (http://grails.org/plugin/breadcrumbs). It works in exactly the same way 
and supports the same options but uses the Twitter Bootstrap styles and pure CSS instead of requiring the jQuery breadcrumbs library.

Usage
-----
To use the plugin, simply add:

    <crumbs:trail selector="title"/>

You indicate the title of the crumb using a CSS selector which is evaluated after the page loads. The bar itself is rendered via an AJAX
call once the page has loaded and the selector is available. If the selector is not available, the bar will render but the new page
will not be added.

Adding the Taglib

Once you have the necessary resources, adding the following taglib to your layout to generate crumb names based on the contents of html <title> elements:
    <crumbs:trail selector="title"/>

If you use a common element as the title of your crumbs for each page, for example a <title> element, you can specify this within your Config.groovy file by adding the following snippet:
    breadcrumbs.selector="title"

Feel free to make use of both methods. Breadcrumbs will use the in-page taglib defined element over the Config.groovy defined element when it exists. Any standard jquery-style selector should work in specifying the element to use for crumb naming.

Configuring Behavior
--------------------
Breadcrumbs offers several properties that can be defined in Config.groovy to alter it's default behavior. These are described as follows:

    breadcrumbs.home

By default the home icon in the crumb trail will forward to the grails.serverURL property. You can alter this location by defining the breadcrumbs.home property in Config.groovy
    breadcrumbs.selector

You can optionally specify a default selector to use in determining crumb names across all pages that contain the crumb trail. This can also be defined as described in Usage -> Adding the Taglib
    breadcrumbs.selectors

Soon to come
    breadcrumbs.crumbs.max

By default the crumb trail is limited to a maximum of 10 crumbs. If the number of crumbs exceeds this, the oldest crumb is dropped from the trail. You can alter the number of crumbs to allow before this cut off by defining the breadcrumbs.crumbs.max property in Config.groovy
    breadcrumbs.crumbs.showDuplicates

By default the crumb trail will not show duplicate crumbs. If a crumb is already in the crumb trail and you revisit the page represented by that crumb, it will reposition the crumb to the front of the crumb trail. By enabling the showing of duplicates, the original crumb is left in it's position while a new one is added to the front of the crumb trail.
    breadcrumbs.crumbs.maxNameLength

By default each crumb name does not have a maximum length. This can potentially result in lengthy crumb names which cause the crumb trail to expand to an undesirable width. Defining breadcrumbs.crumbs.maxNameLength will cause any crumb name in excess of said length to be truncated and appended with a "..." to indicate the truncation.
