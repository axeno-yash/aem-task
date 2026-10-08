package com.mysite.core.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(
    adaptables = Resource.class,
    defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
public class TeamMembersModel {

    @ChildResource(name = "members")
    private Resource membersResource;

    private List<MemberItem> members;

    @PostConstruct
    protected void init() {
        if (membersResource != null) {
            members = new ArrayList<>();
            for (Resource item : membersResource.getChildren()) {
                MemberItem member = item.adaptTo(MemberItem.class);
                if (member != null) {
                    members.add(member);
                }
            }
        }
    }

    public List<MemberItem> getMembers() {
        return members != null ? Collections.unmodifiableList(members) : Collections.emptyList();
    }

    @Model(
        adaptables = Resource.class,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
    )
    public static class MemberItem {

        @ValueMapValue
        private String name;

        @ValueMapValue
        private String role;

        @ValueMapValue
        private String photo;

        public String getName() {
            return name;
        }

        public String getRole() {
            return role;
        }

        public String getPhoto() {
            return photo;
        }
    }
}
