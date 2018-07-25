package com.adshow.mapper.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SubtitleManageExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Long offset;

    public SubtitleManageExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setOffset(Long offset) {
        this.offset = offset;
    }

    public Long getOffset() {
        return offset;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andUuidIsNull() {
            addCriterion("uuid is null");
            return (Criteria) this;
        }

        public Criteria andUuidIsNotNull() {
            addCriterion("uuid is not null");
            return (Criteria) this;
        }

        public Criteria andUuidEqualTo(String value) {
            addCriterion("uuid =", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidNotEqualTo(String value) {
            addCriterion("uuid <>", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidGreaterThan(String value) {
            addCriterion("uuid >", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidGreaterThanOrEqualTo(String value) {
            addCriterion("uuid >=", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidLessThan(String value) {
            addCriterion("uuid <", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidLessThanOrEqualTo(String value) {
            addCriterion("uuid <=", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidLike(String value) {
            addCriterion("uuid like", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidNotLike(String value) {
            addCriterion("uuid not like", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidIn(List<String> values) {
            addCriterion("uuid in", values, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidNotIn(List<String> values) {
            addCriterion("uuid not in", values, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidBetween(String value1, String value2) {
            addCriterion("uuid between", value1, value2, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidNotBetween(String value1, String value2) {
            addCriterion("uuid not between", value1, value2, "uuid");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("`name` is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("`name` is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("`name` =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("`name` <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("`name` >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("`name` >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("`name` <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("`name` <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("`name` like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("`name` not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("`name` in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("`name` not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("`name` between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("`name` not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andAliasNameIsNull() {
            addCriterion("alias_name is null");
            return (Criteria) this;
        }

        public Criteria andAliasNameIsNotNull() {
            addCriterion("alias_name is not null");
            return (Criteria) this;
        }

        public Criteria andAliasNameEqualTo(String value) {
            addCriterion("alias_name =", value, "aliasName");
            return (Criteria) this;
        }

        public Criteria andAliasNameNotEqualTo(String value) {
            addCriterion("alias_name <>", value, "aliasName");
            return (Criteria) this;
        }

        public Criteria andAliasNameGreaterThan(String value) {
            addCriterion("alias_name >", value, "aliasName");
            return (Criteria) this;
        }

        public Criteria andAliasNameGreaterThanOrEqualTo(String value) {
            addCriterion("alias_name >=", value, "aliasName");
            return (Criteria) this;
        }

        public Criteria andAliasNameLessThan(String value) {
            addCriterion("alias_name <", value, "aliasName");
            return (Criteria) this;
        }

        public Criteria andAliasNameLessThanOrEqualTo(String value) {
            addCriterion("alias_name <=", value, "aliasName");
            return (Criteria) this;
        }

        public Criteria andAliasNameLike(String value) {
            addCriterion("alias_name like", value, "aliasName");
            return (Criteria) this;
        }

        public Criteria andAliasNameNotLike(String value) {
            addCriterion("alias_name not like", value, "aliasName");
            return (Criteria) this;
        }

        public Criteria andAliasNameIn(List<String> values) {
            addCriterion("alias_name in", values, "aliasName");
            return (Criteria) this;
        }

        public Criteria andAliasNameNotIn(List<String> values) {
            addCriterion("alias_name not in", values, "aliasName");
            return (Criteria) this;
        }

        public Criteria andAliasNameBetween(String value1, String value2) {
            addCriterion("alias_name between", value1, value2, "aliasName");
            return (Criteria) this;
        }

        public Criteria andAliasNameNotBetween(String value1, String value2) {
            addCriterion("alias_name not between", value1, value2, "aliasName");
            return (Criteria) this;
        }

        public Criteria andPhysicalPathIsNull() {
            addCriterion("physical_path is null");
            return (Criteria) this;
        }

        public Criteria andPhysicalPathIsNotNull() {
            addCriterion("physical_path is not null");
            return (Criteria) this;
        }

        public Criteria andPhysicalPathEqualTo(String value) {
            addCriterion("physical_path =", value, "physicalPath");
            return (Criteria) this;
        }

        public Criteria andPhysicalPathNotEqualTo(String value) {
            addCriterion("physical_path <>", value, "physicalPath");
            return (Criteria) this;
        }

        public Criteria andPhysicalPathGreaterThan(String value) {
            addCriterion("physical_path >", value, "physicalPath");
            return (Criteria) this;
        }

        public Criteria andPhysicalPathGreaterThanOrEqualTo(String value) {
            addCriterion("physical_path >=", value, "physicalPath");
            return (Criteria) this;
        }

        public Criteria andPhysicalPathLessThan(String value) {
            addCriterion("physical_path <", value, "physicalPath");
            return (Criteria) this;
        }

        public Criteria andPhysicalPathLessThanOrEqualTo(String value) {
            addCriterion("physical_path <=", value, "physicalPath");
            return (Criteria) this;
        }

        public Criteria andPhysicalPathLike(String value) {
            addCriterion("physical_path like", value, "physicalPath");
            return (Criteria) this;
        }

        public Criteria andPhysicalPathNotLike(String value) {
            addCriterion("physical_path not like", value, "physicalPath");
            return (Criteria) this;
        }

        public Criteria andPhysicalPathIn(List<String> values) {
            addCriterion("physical_path in", values, "physicalPath");
            return (Criteria) this;
        }

        public Criteria andPhysicalPathNotIn(List<String> values) {
            addCriterion("physical_path not in", values, "physicalPath");
            return (Criteria) this;
        }

        public Criteria andPhysicalPathBetween(String value1, String value2) {
            addCriterion("physical_path between", value1, value2, "physicalPath");
            return (Criteria) this;
        }

        public Criteria andPhysicalPathNotBetween(String value1, String value2) {
            addCriterion("physical_path not between", value1, value2, "physicalPath");
            return (Criteria) this;
        }

        public Criteria andSizeIsNull() {
            addCriterion("`size` is null");
            return (Criteria) this;
        }

        public Criteria andSizeIsNotNull() {
            addCriterion("`size` is not null");
            return (Criteria) this;
        }

        public Criteria andSizeEqualTo(Long value) {
            addCriterion("`size` =", value, "size");
            return (Criteria) this;
        }

        public Criteria andSizeNotEqualTo(Long value) {
            addCriterion("`size` <>", value, "size");
            return (Criteria) this;
        }

        public Criteria andSizeGreaterThan(Long value) {
            addCriterion("`size` >", value, "size");
            return (Criteria) this;
        }

        public Criteria andSizeGreaterThanOrEqualTo(Long value) {
            addCriterion("`size` >=", value, "size");
            return (Criteria) this;
        }

        public Criteria andSizeLessThan(Long value) {
            addCriterion("`size` <", value, "size");
            return (Criteria) this;
        }

        public Criteria andSizeLessThanOrEqualTo(Long value) {
            addCriterion("`size` <=", value, "size");
            return (Criteria) this;
        }

        public Criteria andSizeIn(List<Long> values) {
            addCriterion("`size` in", values, "size");
            return (Criteria) this;
        }

        public Criteria andSizeNotIn(List<Long> values) {
            addCriterion("`size` not in", values, "size");
            return (Criteria) this;
        }

        public Criteria andSizeBetween(Long value1, Long value2) {
            addCriterion("`size` between", value1, value2, "size");
            return (Criteria) this;
        }

        public Criteria andSizeNotBetween(Long value1, Long value2) {
            addCriterion("`size` not between", value1, value2, "size");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andCreateUserIsNull() {
            addCriterion("create_user is null");
            return (Criteria) this;
        }

        public Criteria andCreateUserIsNotNull() {
            addCriterion("create_user is not null");
            return (Criteria) this;
        }

        public Criteria andCreateUserEqualTo(String value) {
            addCriterion("create_user =", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotEqualTo(String value) {
            addCriterion("create_user <>", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserGreaterThan(String value) {
            addCriterion("create_user >", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserGreaterThanOrEqualTo(String value) {
            addCriterion("create_user >=", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserLessThan(String value) {
            addCriterion("create_user <", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserLessThanOrEqualTo(String value) {
            addCriterion("create_user <=", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserLike(String value) {
            addCriterion("create_user like", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotLike(String value) {
            addCriterion("create_user not like", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserIn(List<String> values) {
            addCriterion("create_user in", values, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotIn(List<String> values) {
            addCriterion("create_user not in", values, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserBetween(String value1, String value2) {
            addCriterion("create_user between", value1, value2, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotBetween(String value1, String value2) {
            addCriterion("create_user not between", value1, value2, "createUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIsNull() {
            addCriterion("update_user is null");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIsNotNull() {
            addCriterion("update_user is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateUserEqualTo(String value) {
            addCriterion("update_user =", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotEqualTo(String value) {
            addCriterion("update_user <>", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserGreaterThan(String value) {
            addCriterion("update_user >", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserGreaterThanOrEqualTo(String value) {
            addCriterion("update_user >=", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserLessThan(String value) {
            addCriterion("update_user <", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserLessThanOrEqualTo(String value) {
            addCriterion("update_user <=", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserLike(String value) {
            addCriterion("update_user like", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotLike(String value) {
            addCriterion("update_user not like", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIn(List<String> values) {
            addCriterion("update_user in", values, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotIn(List<String> values) {
            addCriterion("update_user not in", values, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserBetween(String value1, String value2) {
            addCriterion("update_user between", value1, value2, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotBetween(String value1, String value2) {
            addCriterion("update_user not between", value1, value2, "updateUser");
            return (Criteria) this;
        }

        public Criteria andNoteIsNull() {
            addCriterion("note is null");
            return (Criteria) this;
        }

        public Criteria andNoteIsNotNull() {
            addCriterion("note is not null");
            return (Criteria) this;
        }

        public Criteria andNoteEqualTo(String value) {
            addCriterion("note =", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteNotEqualTo(String value) {
            addCriterion("note <>", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteGreaterThan(String value) {
            addCriterion("note >", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteGreaterThanOrEqualTo(String value) {
            addCriterion("note >=", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteLessThan(String value) {
            addCriterion("note <", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteLessThanOrEqualTo(String value) {
            addCriterion("note <=", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteLike(String value) {
            addCriterion("note like", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteNotLike(String value) {
            addCriterion("note not like", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteIn(List<String> values) {
            addCriterion("note in", values, "note");
            return (Criteria) this;
        }

        public Criteria andNoteNotIn(List<String> values) {
            addCriterion("note not in", values, "note");
            return (Criteria) this;
        }

        public Criteria andNoteBetween(String value1, String value2) {
            addCriterion("note between", value1, value2, "note");
            return (Criteria) this;
        }

        public Criteria andNoteNotBetween(String value1, String value2) {
            addCriterion("note not between", value1, value2, "note");
            return (Criteria) this;
        }

        public Criteria andContentIsNull() {
            addCriterion("content is null");
            return (Criteria) this;
        }

        public Criteria andContentIsNotNull() {
            addCriterion("content is not null");
            return (Criteria) this;
        }

        public Criteria andContentEqualTo(String value) {
            addCriterion("content =", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotEqualTo(String value) {
            addCriterion("content <>", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThan(String value) {
            addCriterion("content >", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThanOrEqualTo(String value) {
            addCriterion("content >=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThan(String value) {
            addCriterion("content <", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThanOrEqualTo(String value) {
            addCriterion("content <=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLike(String value) {
            addCriterion("content like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotLike(String value) {
            addCriterion("content not like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentIn(List<String> values) {
            addCriterion("content in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotIn(List<String> values) {
            addCriterion("content not in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentBetween(String value1, String value2) {
            addCriterion("content between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotBetween(String value1, String value2) {
            addCriterion("content not between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("`type` is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("`type` is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(Integer value) {
            addCriterion("`type` =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(Integer value) {
            addCriterion("`type` <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(Integer value) {
            addCriterion("`type` >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("`type` >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(Integer value) {
            addCriterion("`type` <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(Integer value) {
            addCriterion("`type` <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<Integer> values) {
            addCriterion("`type` in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<Integer> values) {
            addCriterion("`type` not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(Integer value1, Integer value2) {
            addCriterion("`type` between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("`type` not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andFontIsNull() {
            addCriterion("font is null");
            return (Criteria) this;
        }

        public Criteria andFontIsNotNull() {
            addCriterion("font is not null");
            return (Criteria) this;
        }

        public Criteria andFontEqualTo(String value) {
            addCriterion("font =", value, "font");
            return (Criteria) this;
        }

        public Criteria andFontNotEqualTo(String value) {
            addCriterion("font <>", value, "font");
            return (Criteria) this;
        }

        public Criteria andFontGreaterThan(String value) {
            addCriterion("font >", value, "font");
            return (Criteria) this;
        }

        public Criteria andFontGreaterThanOrEqualTo(String value) {
            addCriterion("font >=", value, "font");
            return (Criteria) this;
        }

        public Criteria andFontLessThan(String value) {
            addCriterion("font <", value, "font");
            return (Criteria) this;
        }

        public Criteria andFontLessThanOrEqualTo(String value) {
            addCriterion("font <=", value, "font");
            return (Criteria) this;
        }

        public Criteria andFontLike(String value) {
            addCriterion("font like", value, "font");
            return (Criteria) this;
        }

        public Criteria andFontNotLike(String value) {
            addCriterion("font not like", value, "font");
            return (Criteria) this;
        }

        public Criteria andFontIn(List<String> values) {
            addCriterion("font in", values, "font");
            return (Criteria) this;
        }

        public Criteria andFontNotIn(List<String> values) {
            addCriterion("font not in", values, "font");
            return (Criteria) this;
        }

        public Criteria andFontBetween(String value1, String value2) {
            addCriterion("font between", value1, value2, "font");
            return (Criteria) this;
        }

        public Criteria andFontNotBetween(String value1, String value2) {
            addCriterion("font not between", value1, value2, "font");
            return (Criteria) this;
        }

        public Criteria andFontSizeIsNull() {
            addCriterion("font_size is null");
            return (Criteria) this;
        }

        public Criteria andFontSizeIsNotNull() {
            addCriterion("font_size is not null");
            return (Criteria) this;
        }

        public Criteria andFontSizeEqualTo(Integer value) {
            addCriterion("font_size =", value, "fontSize");
            return (Criteria) this;
        }

        public Criteria andFontSizeNotEqualTo(Integer value) {
            addCriterion("font_size <>", value, "fontSize");
            return (Criteria) this;
        }

        public Criteria andFontSizeGreaterThan(Integer value) {
            addCriterion("font_size >", value, "fontSize");
            return (Criteria) this;
        }

        public Criteria andFontSizeGreaterThanOrEqualTo(Integer value) {
            addCriterion("font_size >=", value, "fontSize");
            return (Criteria) this;
        }

        public Criteria andFontSizeLessThan(Integer value) {
            addCriterion("font_size <", value, "fontSize");
            return (Criteria) this;
        }

        public Criteria andFontSizeLessThanOrEqualTo(Integer value) {
            addCriterion("font_size <=", value, "fontSize");
            return (Criteria) this;
        }

        public Criteria andFontSizeIn(List<Integer> values) {
            addCriterion("font_size in", values, "fontSize");
            return (Criteria) this;
        }

        public Criteria andFontSizeNotIn(List<Integer> values) {
            addCriterion("font_size not in", values, "fontSize");
            return (Criteria) this;
        }

        public Criteria andFontSizeBetween(Integer value1, Integer value2) {
            addCriterion("font_size between", value1, value2, "fontSize");
            return (Criteria) this;
        }

        public Criteria andFontSizeNotBetween(Integer value1, Integer value2) {
            addCriterion("font_size not between", value1, value2, "fontSize");
            return (Criteria) this;
        }

        public Criteria andFontColorIsNull() {
            addCriterion("font_color is null");
            return (Criteria) this;
        }

        public Criteria andFontColorIsNotNull() {
            addCriterion("font_color is not null");
            return (Criteria) this;
        }

        public Criteria andFontColorEqualTo(String value) {
            addCriterion("font_color =", value, "fontColor");
            return (Criteria) this;
        }

        public Criteria andFontColorNotEqualTo(String value) {
            addCriterion("font_color <>", value, "fontColor");
            return (Criteria) this;
        }

        public Criteria andFontColorGreaterThan(String value) {
            addCriterion("font_color >", value, "fontColor");
            return (Criteria) this;
        }

        public Criteria andFontColorGreaterThanOrEqualTo(String value) {
            addCriterion("font_color >=", value, "fontColor");
            return (Criteria) this;
        }

        public Criteria andFontColorLessThan(String value) {
            addCriterion("font_color <", value, "fontColor");
            return (Criteria) this;
        }

        public Criteria andFontColorLessThanOrEqualTo(String value) {
            addCriterion("font_color <=", value, "fontColor");
            return (Criteria) this;
        }

        public Criteria andFontColorLike(String value) {
            addCriterion("font_color like", value, "fontColor");
            return (Criteria) this;
        }

        public Criteria andFontColorNotLike(String value) {
            addCriterion("font_color not like", value, "fontColor");
            return (Criteria) this;
        }

        public Criteria andFontColorIn(List<String> values) {
            addCriterion("font_color in", values, "fontColor");
            return (Criteria) this;
        }

        public Criteria andFontColorNotIn(List<String> values) {
            addCriterion("font_color not in", values, "fontColor");
            return (Criteria) this;
        }

        public Criteria andFontColorBetween(String value1, String value2) {
            addCriterion("font_color between", value1, value2, "fontColor");
            return (Criteria) this;
        }

        public Criteria andFontColorNotBetween(String value1, String value2) {
            addCriterion("font_color not between", value1, value2, "fontColor");
            return (Criteria) this;
        }

        public Criteria andBackColorIsNull() {
            addCriterion("back_color is null");
            return (Criteria) this;
        }

        public Criteria andBackColorIsNotNull() {
            addCriterion("back_color is not null");
            return (Criteria) this;
        }

        public Criteria andBackColorEqualTo(String value) {
            addCriterion("back_color =", value, "backColor");
            return (Criteria) this;
        }

        public Criteria andBackColorNotEqualTo(String value) {
            addCriterion("back_color <>", value, "backColor");
            return (Criteria) this;
        }

        public Criteria andBackColorGreaterThan(String value) {
            addCriterion("back_color >", value, "backColor");
            return (Criteria) this;
        }

        public Criteria andBackColorGreaterThanOrEqualTo(String value) {
            addCriterion("back_color >=", value, "backColor");
            return (Criteria) this;
        }

        public Criteria andBackColorLessThan(String value) {
            addCriterion("back_color <", value, "backColor");
            return (Criteria) this;
        }

        public Criteria andBackColorLessThanOrEqualTo(String value) {
            addCriterion("back_color <=", value, "backColor");
            return (Criteria) this;
        }

        public Criteria andBackColorLike(String value) {
            addCriterion("back_color like", value, "backColor");
            return (Criteria) this;
        }

        public Criteria andBackColorNotLike(String value) {
            addCriterion("back_color not like", value, "backColor");
            return (Criteria) this;
        }

        public Criteria andBackColorIn(List<String> values) {
            addCriterion("back_color in", values, "backColor");
            return (Criteria) this;
        }

        public Criteria andBackColorNotIn(List<String> values) {
            addCriterion("back_color not in", values, "backColor");
            return (Criteria) this;
        }

        public Criteria andBackColorBetween(String value1, String value2) {
            addCriterion("back_color between", value1, value2, "backColor");
            return (Criteria) this;
        }

        public Criteria andBackColorNotBetween(String value1, String value2) {
            addCriterion("back_color not between", value1, value2, "backColor");
            return (Criteria) this;
        }

        public Criteria andBackTransparencyIsNull() {
            addCriterion("back_transparency is null");
            return (Criteria) this;
        }

        public Criteria andBackTransparencyIsNotNull() {
            addCriterion("back_transparency is not null");
            return (Criteria) this;
        }

        public Criteria andBackTransparencyEqualTo(String value) {
            addCriterion("back_transparency =", value, "backTransparency");
            return (Criteria) this;
        }

        public Criteria andBackTransparencyNotEqualTo(String value) {
            addCriterion("back_transparency <>", value, "backTransparency");
            return (Criteria) this;
        }

        public Criteria andBackTransparencyGreaterThan(String value) {
            addCriterion("back_transparency >", value, "backTransparency");
            return (Criteria) this;
        }

        public Criteria andBackTransparencyGreaterThanOrEqualTo(String value) {
            addCriterion("back_transparency >=", value, "backTransparency");
            return (Criteria) this;
        }

        public Criteria andBackTransparencyLessThan(String value) {
            addCriterion("back_transparency <", value, "backTransparency");
            return (Criteria) this;
        }

        public Criteria andBackTransparencyLessThanOrEqualTo(String value) {
            addCriterion("back_transparency <=", value, "backTransparency");
            return (Criteria) this;
        }

        public Criteria andBackTransparencyLike(String value) {
            addCriterion("back_transparency like", value, "backTransparency");
            return (Criteria) this;
        }

        public Criteria andBackTransparencyNotLike(String value) {
            addCriterion("back_transparency not like", value, "backTransparency");
            return (Criteria) this;
        }

        public Criteria andBackTransparencyIn(List<String> values) {
            addCriterion("back_transparency in", values, "backTransparency");
            return (Criteria) this;
        }

        public Criteria andBackTransparencyNotIn(List<String> values) {
            addCriterion("back_transparency not in", values, "backTransparency");
            return (Criteria) this;
        }

        public Criteria andBackTransparencyBetween(String value1, String value2) {
            addCriterion("back_transparency between", value1, value2, "backTransparency");
            return (Criteria) this;
        }

        public Criteria andBackTransparencyNotBetween(String value1, String value2) {
            addCriterion("back_transparency not between", value1, value2, "backTransparency");
            return (Criteria) this;
        }

        public Criteria andScrollSpeedIsNull() {
            addCriterion("scroll_speed is null");
            return (Criteria) this;
        }

        public Criteria andScrollSpeedIsNotNull() {
            addCriterion("scroll_speed is not null");
            return (Criteria) this;
        }

        public Criteria andScrollSpeedEqualTo(Integer value) {
            addCriterion("scroll_speed =", value, "scrollSpeed");
            return (Criteria) this;
        }

        public Criteria andScrollSpeedNotEqualTo(Integer value) {
            addCriterion("scroll_speed <>", value, "scrollSpeed");
            return (Criteria) this;
        }

        public Criteria andScrollSpeedGreaterThan(Integer value) {
            addCriterion("scroll_speed >", value, "scrollSpeed");
            return (Criteria) this;
        }

        public Criteria andScrollSpeedGreaterThanOrEqualTo(Integer value) {
            addCriterion("scroll_speed >=", value, "scrollSpeed");
            return (Criteria) this;
        }

        public Criteria andScrollSpeedLessThan(Integer value) {
            addCriterion("scroll_speed <", value, "scrollSpeed");
            return (Criteria) this;
        }

        public Criteria andScrollSpeedLessThanOrEqualTo(Integer value) {
            addCriterion("scroll_speed <=", value, "scrollSpeed");
            return (Criteria) this;
        }

        public Criteria andScrollSpeedIn(List<Integer> values) {
            addCriterion("scroll_speed in", values, "scrollSpeed");
            return (Criteria) this;
        }

        public Criteria andScrollSpeedNotIn(List<Integer> values) {
            addCriterion("scroll_speed not in", values, "scrollSpeed");
            return (Criteria) this;
        }

        public Criteria andScrollSpeedBetween(Integer value1, Integer value2) {
            addCriterion("scroll_speed between", value1, value2, "scrollSpeed");
            return (Criteria) this;
        }

        public Criteria andScrollSpeedNotBetween(Integer value1, Integer value2) {
            addCriterion("scroll_speed not between", value1, value2, "scrollSpeed");
            return (Criteria) this;
        }
    }

    /**
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}