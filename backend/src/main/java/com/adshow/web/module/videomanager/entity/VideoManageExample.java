package com.adshow.web.module.videomanager.entity;

import java.util.ArrayList;
import java.util.List;

public class VideoManageExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Long offset;

    public VideoManageExample() {
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

        public Criteria andIdEqualTo(String value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("id like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("id not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("id not between", value1, value2, "id");
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

        public Criteria andVirtualPathIsNull() {
            addCriterion("virtual_path is null");
            return (Criteria) this;
        }

        public Criteria andVirtualPathIsNotNull() {
            addCriterion("virtual_path is not null");
            return (Criteria) this;
        }

        public Criteria andVirtualPathEqualTo(String value) {
            addCriterion("virtual_path =", value, "virtualPath");
            return (Criteria) this;
        }

        public Criteria andVirtualPathNotEqualTo(String value) {
            addCriterion("virtual_path <>", value, "virtualPath");
            return (Criteria) this;
        }

        public Criteria andVirtualPathGreaterThan(String value) {
            addCriterion("virtual_path >", value, "virtualPath");
            return (Criteria) this;
        }

        public Criteria andVirtualPathGreaterThanOrEqualTo(String value) {
            addCriterion("virtual_path >=", value, "virtualPath");
            return (Criteria) this;
        }

        public Criteria andVirtualPathLessThan(String value) {
            addCriterion("virtual_path <", value, "virtualPath");
            return (Criteria) this;
        }

        public Criteria andVirtualPathLessThanOrEqualTo(String value) {
            addCriterion("virtual_path <=", value, "virtualPath");
            return (Criteria) this;
        }

        public Criteria andVirtualPathLike(String value) {
            addCriterion("virtual_path like", value, "virtualPath");
            return (Criteria) this;
        }

        public Criteria andVirtualPathNotLike(String value) {
            addCriterion("virtual_path not like", value, "virtualPath");
            return (Criteria) this;
        }

        public Criteria andVirtualPathIn(List<String> values) {
            addCriterion("virtual_path in", values, "virtualPath");
            return (Criteria) this;
        }

        public Criteria andVirtualPathNotIn(List<String> values) {
            addCriterion("virtual_path not in", values, "virtualPath");
            return (Criteria) this;
        }

        public Criteria andVirtualPathBetween(String value1, String value2) {
            addCriterion("virtual_path between", value1, value2, "virtualPath");
            return (Criteria) this;
        }

        public Criteria andVirtualPathNotBetween(String value1, String value2) {
            addCriterion("virtual_path not between", value1, value2, "virtualPath");
            return (Criteria) this;
        }

        public Criteria andWidthHeightIsNull() {
            addCriterion("width_height is null");
            return (Criteria) this;
        }

        public Criteria andWidthHeightIsNotNull() {
            addCriterion("width_height is not null");
            return (Criteria) this;
        }

        public Criteria andWidthHeightEqualTo(String value) {
            addCriterion("width_height =", value, "widthHeight");
            return (Criteria) this;
        }

        public Criteria andWidthHeightNotEqualTo(String value) {
            addCriterion("width_height <>", value, "widthHeight");
            return (Criteria) this;
        }

        public Criteria andWidthHeightGreaterThan(String value) {
            addCriterion("width_height >", value, "widthHeight");
            return (Criteria) this;
        }

        public Criteria andWidthHeightGreaterThanOrEqualTo(String value) {
            addCriterion("width_height >=", value, "widthHeight");
            return (Criteria) this;
        }

        public Criteria andWidthHeightLessThan(String value) {
            addCriterion("width_height <", value, "widthHeight");
            return (Criteria) this;
        }

        public Criteria andWidthHeightLessThanOrEqualTo(String value) {
            addCriterion("width_height <=", value, "widthHeight");
            return (Criteria) this;
        }

        public Criteria andWidthHeightLike(String value) {
            addCriterion("width_height like", value, "widthHeight");
            return (Criteria) this;
        }

        public Criteria andWidthHeightNotLike(String value) {
            addCriterion("width_height not like", value, "widthHeight");
            return (Criteria) this;
        }

        public Criteria andWidthHeightIn(List<String> values) {
            addCriterion("width_height in", values, "widthHeight");
            return (Criteria) this;
        }

        public Criteria andWidthHeightNotIn(List<String> values) {
            addCriterion("width_height not in", values, "widthHeight");
            return (Criteria) this;
        }

        public Criteria andWidthHeightBetween(String value1, String value2) {
            addCriterion("width_height between", value1, value2, "widthHeight");
            return (Criteria) this;
        }

        public Criteria andWidthHeightNotBetween(String value1, String value2) {
            addCriterion("width_height not between", value1, value2, "widthHeight");
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

        public Criteria andTypeEqualTo(String value) {
            addCriterion("`type` =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(String value) {
            addCriterion("`type` <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(String value) {
            addCriterion("`type` >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(String value) {
            addCriterion("`type` >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(String value) {
            addCriterion("`type` <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(String value) {
            addCriterion("`type` <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLike(String value) {
            addCriterion("`type` like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotLike(String value) {
            addCriterion("`type` not like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<String> values) {
            addCriterion("`type` in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<String> values) {
            addCriterion("`type` not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(String value1, String value2) {
            addCriterion("`type` between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(String value1, String value2) {
            addCriterion("`type` not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andZipnameIsNull() {
            addCriterion("zipname is null");
            return (Criteria) this;
        }

        public Criteria andZipnameIsNotNull() {
            addCriterion("zipname is not null");
            return (Criteria) this;
        }

        public Criteria andZipnameEqualTo(String value) {
            addCriterion("zipname =", value, "zipname");
            return (Criteria) this;
        }

        public Criteria andZipnameNotEqualTo(String value) {
            addCriterion("zipname <>", value, "zipname");
            return (Criteria) this;
        }

        public Criteria andZipnameGreaterThan(String value) {
            addCriterion("zipname >", value, "zipname");
            return (Criteria) this;
        }

        public Criteria andZipnameGreaterThanOrEqualTo(String value) {
            addCriterion("zipname >=", value, "zipname");
            return (Criteria) this;
        }

        public Criteria andZipnameLessThan(String value) {
            addCriterion("zipname <", value, "zipname");
            return (Criteria) this;
        }

        public Criteria andZipnameLessThanOrEqualTo(String value) {
            addCriterion("zipname <=", value, "zipname");
            return (Criteria) this;
        }

        public Criteria andZipnameLike(String value) {
            addCriterion("zipname like", value, "zipname");
            return (Criteria) this;
        }

        public Criteria andZipnameNotLike(String value) {
            addCriterion("zipname not like", value, "zipname");
            return (Criteria) this;
        }

        public Criteria andZipnameIn(List<String> values) {
            addCriterion("zipname in", values, "zipname");
            return (Criteria) this;
        }

        public Criteria andZipnameNotIn(List<String> values) {
            addCriterion("zipname not in", values, "zipname");
            return (Criteria) this;
        }

        public Criteria andZipnameBetween(String value1, String value2) {
            addCriterion("zipname between", value1, value2, "zipname");
            return (Criteria) this;
        }

        public Criteria andZipnameNotBetween(String value1, String value2) {
            addCriterion("zipname not between", value1, value2, "zipname");
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

        public Criteria andUploadTimeIsNull() {
            addCriterion("upload_time is null");
            return (Criteria) this;
        }

        public Criteria andUploadTimeIsNotNull() {
            addCriterion("upload_time is not null");
            return (Criteria) this;
        }

        public Criteria andUploadTimeEqualTo(String value) {
            addCriterion("upload_time =", value, "uploadTime");
            return (Criteria) this;
        }

        public Criteria andUploadTimeNotEqualTo(String value) {
            addCriterion("upload_time <>", value, "uploadTime");
            return (Criteria) this;
        }

        public Criteria andUploadTimeGreaterThan(String value) {
            addCriterion("upload_time >", value, "uploadTime");
            return (Criteria) this;
        }

        public Criteria andUploadTimeGreaterThanOrEqualTo(String value) {
            addCriterion("upload_time >=", value, "uploadTime");
            return (Criteria) this;
        }

        public Criteria andUploadTimeLessThan(String value) {
            addCriterion("upload_time <", value, "uploadTime");
            return (Criteria) this;
        }

        public Criteria andUploadTimeLessThanOrEqualTo(String value) {
            addCriterion("upload_time <=", value, "uploadTime");
            return (Criteria) this;
        }

        public Criteria andUploadTimeLike(String value) {
            addCriterion("upload_time like", value, "uploadTime");
            return (Criteria) this;
        }

        public Criteria andUploadTimeNotLike(String value) {
            addCriterion("upload_time not like", value, "uploadTime");
            return (Criteria) this;
        }

        public Criteria andUploadTimeIn(List<String> values) {
            addCriterion("upload_time in", values, "uploadTime");
            return (Criteria) this;
        }

        public Criteria andUploadTimeNotIn(List<String> values) {
            addCriterion("upload_time not in", values, "uploadTime");
            return (Criteria) this;
        }

        public Criteria andUploadTimeBetween(String value1, String value2) {
            addCriterion("upload_time between", value1, value2, "uploadTime");
            return (Criteria) this;
        }

        public Criteria andUploadTimeNotBetween(String value1, String value2) {
            addCriterion("upload_time not between", value1, value2, "uploadTime");
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

        public Criteria andGroupIdIsNull() {
            addCriterion("group_id is null");
            return (Criteria) this;
        }

        public Criteria andGroupIdIsNotNull() {
            addCriterion("group_id is not null");
            return (Criteria) this;
        }

        public Criteria andGroupIdEqualTo(String value) {
            addCriterion("group_id =", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdNotEqualTo(String value) {
            addCriterion("group_id <>", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdGreaterThan(String value) {
            addCriterion("group_id >", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdGreaterThanOrEqualTo(String value) {
            addCriterion("group_id >=", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdLessThan(String value) {
            addCriterion("group_id <", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdLessThanOrEqualTo(String value) {
            addCriterion("group_id <=", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdLike(String value) {
            addCriterion("group_id like", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdNotLike(String value) {
            addCriterion("group_id not like", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdIn(List<String> values) {
            addCriterion("group_id in", values, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdNotIn(List<String> values) {
            addCriterion("group_id not in", values, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdBetween(String value1, String value2) {
            addCriterion("group_id between", value1, value2, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdNotBetween(String value1, String value2) {
            addCriterion("group_id not between", value1, value2, "groupId");
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

        public Criteria andUpdateGroupIsNull() {
            addCriterion("update_group is null");
            return (Criteria) this;
        }

        public Criteria andUpdateGroupIsNotNull() {
            addCriterion("update_group is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateGroupEqualTo(String value) {
            addCriterion("update_group =", value, "updateGroup");
            return (Criteria) this;
        }

        public Criteria andUpdateGroupNotEqualTo(String value) {
            addCriterion("update_group <>", value, "updateGroup");
            return (Criteria) this;
        }

        public Criteria andUpdateGroupGreaterThan(String value) {
            addCriterion("update_group >", value, "updateGroup");
            return (Criteria) this;
        }

        public Criteria andUpdateGroupGreaterThanOrEqualTo(String value) {
            addCriterion("update_group >=", value, "updateGroup");
            return (Criteria) this;
        }

        public Criteria andUpdateGroupLessThan(String value) {
            addCriterion("update_group <", value, "updateGroup");
            return (Criteria) this;
        }

        public Criteria andUpdateGroupLessThanOrEqualTo(String value) {
            addCriterion("update_group <=", value, "updateGroup");
            return (Criteria) this;
        }

        public Criteria andUpdateGroupLike(String value) {
            addCriterion("update_group like", value, "updateGroup");
            return (Criteria) this;
        }

        public Criteria andUpdateGroupNotLike(String value) {
            addCriterion("update_group not like", value, "updateGroup");
            return (Criteria) this;
        }

        public Criteria andUpdateGroupIn(List<String> values) {
            addCriterion("update_group in", values, "updateGroup");
            return (Criteria) this;
        }

        public Criteria andUpdateGroupNotIn(List<String> values) {
            addCriterion("update_group not in", values, "updateGroup");
            return (Criteria) this;
        }

        public Criteria andUpdateGroupBetween(String value1, String value2) {
            addCriterion("update_group between", value1, value2, "updateGroup");
            return (Criteria) this;
        }

        public Criteria andUpdateGroupNotBetween(String value1, String value2) {
            addCriterion("update_group not between", value1, value2, "updateGroup");
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

        public Criteria andUpdateTimeEqualTo(String value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(String value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(String value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(String value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(String value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(String value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLike(String value) {
            addCriterion("update_time like", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotLike(String value) {
            addCriterion("update_time not like", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<String> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<String> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(String value1, String value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(String value1, String value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
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

        public Criteria andTimeLengthIsNull() {
            addCriterion("time_length is null");
            return (Criteria) this;
        }

        public Criteria andTimeLengthIsNotNull() {
            addCriterion("time_length is not null");
            return (Criteria) this;
        }

        public Criteria andTimeLengthEqualTo(Integer value) {
            addCriterion("time_length =", value, "timeLength");
            return (Criteria) this;
        }

        public Criteria andTimeLengthNotEqualTo(Integer value) {
            addCriterion("time_length <>", value, "timeLength");
            return (Criteria) this;
        }

        public Criteria andTimeLengthGreaterThan(Integer value) {
            addCriterion("time_length >", value, "timeLength");
            return (Criteria) this;
        }

        public Criteria andTimeLengthGreaterThanOrEqualTo(Integer value) {
            addCriterion("time_length >=", value, "timeLength");
            return (Criteria) this;
        }

        public Criteria andTimeLengthLessThan(Integer value) {
            addCriterion("time_length <", value, "timeLength");
            return (Criteria) this;
        }

        public Criteria andTimeLengthLessThanOrEqualTo(Integer value) {
            addCriterion("time_length <=", value, "timeLength");
            return (Criteria) this;
        }

        public Criteria andTimeLengthIn(List<Integer> values) {
            addCriterion("time_length in", values, "timeLength");
            return (Criteria) this;
        }

        public Criteria andTimeLengthNotIn(List<Integer> values) {
            addCriterion("time_length not in", values, "timeLength");
            return (Criteria) this;
        }

        public Criteria andTimeLengthBetween(Integer value1, Integer value2) {
            addCriterion("time_length between", value1, value2, "timeLength");
            return (Criteria) this;
        }

        public Criteria andTimeLengthNotBetween(Integer value1, Integer value2) {
            addCriterion("time_length not between", value1, value2, "timeLength");
            return (Criteria) this;
        }

        public Criteria andFinishSizeIsNull() {
            addCriterion("finish_size is null");
            return (Criteria) this;
        }

        public Criteria andFinishSizeIsNotNull() {
            addCriterion("finish_size is not null");
            return (Criteria) this;
        }

        public Criteria andFinishSizeEqualTo(Long value) {
            addCriterion("finish_size =", value, "finishSize");
            return (Criteria) this;
        }

        public Criteria andFinishSizeNotEqualTo(Long value) {
            addCriterion("finish_size <>", value, "finishSize");
            return (Criteria) this;
        }

        public Criteria andFinishSizeGreaterThan(Long value) {
            addCriterion("finish_size >", value, "finishSize");
            return (Criteria) this;
        }

        public Criteria andFinishSizeGreaterThanOrEqualTo(Long value) {
            addCriterion("finish_size >=", value, "finishSize");
            return (Criteria) this;
        }

        public Criteria andFinishSizeLessThan(Long value) {
            addCriterion("finish_size <", value, "finishSize");
            return (Criteria) this;
        }

        public Criteria andFinishSizeLessThanOrEqualTo(Long value) {
            addCriterion("finish_size <=", value, "finishSize");
            return (Criteria) this;
        }

        public Criteria andFinishSizeIn(List<Long> values) {
            addCriterion("finish_size in", values, "finishSize");
            return (Criteria) this;
        }

        public Criteria andFinishSizeNotIn(List<Long> values) {
            addCriterion("finish_size not in", values, "finishSize");
            return (Criteria) this;
        }

        public Criteria andFinishSizeBetween(Long value1, Long value2) {
            addCriterion("finish_size between", value1, value2, "finishSize");
            return (Criteria) this;
        }

        public Criteria andFinishSizeNotBetween(Long value1, Long value2) {
            addCriterion("finish_size not between", value1, value2, "finishSize");
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