<ul class="breadcrumb">
    <li>
        <a href="${home}">Home</a>
        <span class="divider">/</span>
    </li>
    <g:each var="crumb" in="${crumbtrail}" status="i">
        <g:if test="${(i+1) < crumbtrail.size() }">
            <li>
                <a href="${crumb.href}">${crumb.name}</a>
                <span class="divider">/</span>
            </li>
        </g:if>
        <g:else>
            <li class="active">
                ${crumb.name}
            </li>
        </g:else>
    </g:each>
</ul>
