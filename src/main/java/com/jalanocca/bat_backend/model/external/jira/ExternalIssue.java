package com.jalanocca.bat_backend.model.external.jira;

import java.time.OffsetDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ExternalIssue {
    private String expand;
    private String id;
    private String self;
    private String key;
    private Fields fields;

    public String getExpand() { return expand; }
    public void setExpand(String expand) { this.expand = expand; }
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getSelf() { return self; }
    public void setSelf(String self) { this.self = self; }
    public String getKey() { return key; }
    public void setKey(String key) { this.key = key; }
    public Fields getFields() { return fields; }
    public void setFields(Fields fields) { this.fields = fields; }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Fields {
        private String summary;
        private IssueType issuetype;

        @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSZ")
        private OffsetDateTime created;

        private User assignee;
        private Priority priority;

        @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSZ")
        private OffsetDateTime updated;

        private Status status;

        public String getSummary() { return summary; }
        public void setSummary(String summary) { this.summary = summary; }
        public IssueType getIssuetype() { return issuetype; }
        public void setIssuetype(IssueType issuetype) { this.issuetype = issuetype; }
        public OffsetDateTime getCreated() { return created; }
        public void setCreated(OffsetDateTime created) { this.created = created; }
        public User getAssignee() { return assignee; }
        public void setAssignee(User assignee) { this.assignee = assignee; }
        public Priority getPriority() { return priority; }
        public void setPriority(Priority priority) { this.priority = priority; }
        public OffsetDateTime getUpdated() { return updated; }
        public void setUpdated(OffsetDateTime updated) { this.updated = updated; }
        public Status getStatus() { return status; }
        public void setStatus(Status status) { this.status = status; }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class IssueType {
        private String self;
        private String id;
        private String description;
        private String iconUrl;
        private String name;
        private boolean subtask;
        private Integer avatarId;
        private String hierarchyLevel;

        public String getSelf() { return self; }
        public void setSelf(String self) { this.self = self; }
        public String getId() { return id; }
        public void setId(String id) { this.id = id; }
        public String getDescription() { return description; }
        public void setDescription(String description) { this.description = description; }
        public String getIconUrl() { return iconUrl; }
        public void setIconUrl(String iconUrl) { this.iconUrl = iconUrl; }
        public String getName() { return name; }
        public void setName(String name) { this.name = name; }
        public boolean isSubtask() { return subtask; }
        public void setSubtask(boolean subtask) { this.subtask = subtask; }
        public Integer getAvatarId() { return avatarId; }
        public void setAvatarId(Integer avatarId) { this.avatarId = avatarId; }
        public String getHierarchyLevel() { return hierarchyLevel; }
        public void setHierarchyLevel(String hierarchyLevel) { this.hierarchyLevel = hierarchyLevel; }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class User {
        private String self;
        private String accountId;
        private String emailAddress;
        private AvatarUrls avatarUrls;
        private String displayName;
        private boolean active;
        private String timeZone;
        private String accountType;

        public String getSelf() { return self; }
        public void setSelf(String self) { this.self = self; }
        public String getAccountId() { return accountId; }
        public void setAccountId(String accountId) { this.accountId = accountId; }
        public String getEmailAddress() { return emailAddress; }
        public void setEmailAddress(String emailAddress) { this.emailAddress = emailAddress; }
        public AvatarUrls getAvatarUrls() { return avatarUrls; }
        public void setAvatarUrls(AvatarUrls avatarUrls) { this.avatarUrls = avatarUrls; }
        public String getDisplayName() { return displayName; }
        public void setDisplayName(String displayName) { this.displayName = displayName; }
        public boolean isActive() { return active; }
        public void setActive(boolean active) { this.active = active; }
        public String getTimeZone() { return timeZone; }
        public void setTimeZone(String timeZone) { this.timeZone = timeZone; }
        public String getAccountType() { return accountType; }
        public void setAccountType(String accountType) { this.accountType = accountType; }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class AvatarUrls {
        @JsonProperty("48x48")
        private String _48x48;
        @JsonProperty("24x24")
        private String _24x24;
        @JsonProperty("16x16")
        private String _16x16;
        @JsonProperty("32x32")
        private String _32x32;

        public String get48x48() { return _48x48; }
        public void set48x48(String _48x48) { this._48x48 = _48x48; }
        public String get24x24() { return _24x24; }
        public void set24x24(String _24x24) { this._24x24 = _24x24; }
        public String get16x16() { return _16x16; }
        public void set16x16(String _16x16) { this._16x16 = _16x16; }
        public String get32x32() { return _32x32; }
        public void set32x32(String _32x32) { this._32x32 = _32x32; }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Priority {
        private String self;
        private String iconUrl;
        private String name;
        private String id;

        public String getSelf() { return self; }
        public void setSelf(String self) { this.self = self; }
        public String getIconUrl() { return iconUrl; }
        public void setIconUrl(String iconUrl) { this.iconUrl = iconUrl; }
        public String getName() { return name; }
        public void setName(String name) { this.name = name; }
        public String getId() { return id; }
        public void setId(String id) { this.id = id; }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Status {
        private String self;
        private String description;
        private String iconUrl;
        private String name;
        private String id;
        private StatusCategory statusCategory;

        public String getSelf() { return self; }
        public void setSelf(String self) { this.self = self; }
        public String getDescription() { return description; }
        public void setDescription(String description) { this.description = description; }
        public String getIconUrl() { return iconUrl; }
        public void setIconUrl(String iconUrl) { this.iconUrl = iconUrl; }
        public String getName() { return name; }
        public void setName(String name) { this.name = name; }
        public String getId() { return id; }
        public void setId(String id) { this.id = id; }
        public StatusCategory getStatusCategory() { return statusCategory; }
        public void setStatusCategory(StatusCategory statusCategory) { this.statusCategory = statusCategory; }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class StatusCategory {
        private String self;
        private Integer id;
        private String key;
        private String colorName;
        private String name;

        public String getSelf() { return self; }
        public void setSelf(String self) { this.self = self; }
        public Integer getId() { return id; }
        public void setId(Integer id) { this.id = id; }
        public String getKey() { return key; }
        public void setKey(String key) { this.key = key; }
        public String getColorName() { return colorName; }
        public void setColorName(String colorName) { this.colorName = colorName; }
        public String getName() { return name; }
        public void setName(String name) { this.name = name; }
    }
}
