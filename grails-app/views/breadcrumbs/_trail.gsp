<%@ page import="grails.converters.JSON" %>
<g:javascript>
    $(document).ready(function() {
        // Select the current crumb URL and name
        var href = window.location.href;
        var name = $('${selector}').text();

        // If the crumb name isnt found be we have additional selectors, try those
        if(!name && Boolean("${selectors ? 'true' : ''}")) {
            var selectors = ${selectors.encodeAsJSON()};
            $(selectors).each( function() {
                if(!name) {
                    name = $(this.toString()).text();
                }
            });
        }

        if(!name) { // If we don't find a crumb URL and name, still show the crumbtrail
            $.ajax({
                type: 'POST',
                url: '${createLink(controller: 'crumb', action: 'list')}',
                success: function(template){
                    $('#breadCrumb').html(template);
                }
            });
        } else { // Otherwise tell the server of our new crumb, and display the results
            $.ajax({
                type: 'POST',
                url: '${createLink(controller: 'crumb', action: 'add')}',
                data: 'name=' + encodeURIComponent(name) + '&href=' + encodeURIComponent(href),
                success: function(template){
                    $('#breadCrumb').html(template);
                }
            });
        }
    });
</g:javascript>

<div id="breadCrumb" class="row-fluid">
    <ul class="breadcrumb"><li>&nbsp;</li></ul>
</div>

