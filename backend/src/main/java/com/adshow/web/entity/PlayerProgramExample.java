package com.adshow.web.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PlayerProgramExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Long offset;

    public PlayerProgramExample() {
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

        public Criteria andProgramIdIsNull() {
            addCriterion("program_id is null");
            return (Criteria) this;
        }

        public Criteria andProgramIdIsNotNull() {
            addCriterion("program_id is not null");
            return (Criteria) this;
        }

        public Criteria andProgramIdEqualTo(String value) {
            addCriterion("program_id =", value, "programId");
            return (Criteria) this;
        }

        public Criteria andProgramIdNotEqualTo(String value) {
            addCriterion("program_id <>", value, "programId");
            return (Criteria) this;
        }

        public Criteria andProgramIdGreaterThan(String value) {
            addCriterion("program_id >", value, "programId");
            return (Criteria) this;
        }

        public Criteria andProgramIdGreaterThanOrEqualTo(String value) {
            addCriterion("program_id >=", value, "programId");
            return (Criteria) this;
        }

        public Criteria andProgramIdLessThan(String value) {
            addCriterion("program_id <", value, "programId");
            return (Criteria) this;
        }

        public Criteria andProgramIdLessThanOrEqualTo(String value) {
            addCriterion("program_id <=", value, "programId");
            return (Criteria) this;
        }

        public Criteria andProgramIdLike(String value) {
            addCriterion("program_id like", value, "programId");
            return (Criteria) this;
        }

        public Criteria andProgramIdNotLike(String value) {
            addCriterion("program_id not like", value, "programId");
            return (Criteria) this;
        }

        public Criteria andProgramIdIn(List<String> values) {
            addCriterion("program_id in", values, "programId");
            return (Criteria) this;
        }

        public Criteria andProgramIdNotIn(List<String> values) {
            addCriterion("program_id not in", values, "programId");
            return (Criteria) this;
        }

        public Criteria andProgramIdBetween(String value1, String value2) {
            addCriterion("program_id between", value1, value2, "programId");
            return (Criteria) this;
        }

        public Criteria andProgramIdNotBetween(String value1, String value2) {
            addCriterion("program_id not between", value1, value2, "programId");
            return (Criteria) this;
        }

        public Criteria andTaskIdIsNull() {
            addCriterion("task_id is null");
            return (Criteria) this;
        }

        public Criteria andTaskIdIsNotNull() {
            addCriterion("task_id is not null");
            return (Criteria) this;
        }

        public Criteria andTaskIdEqualTo(String value) {
            addCriterion("task_id =", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdNotEqualTo(String value) {
            addCriterion("task_id <>", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdGreaterThan(String value) {
            addCriterion("task_id >", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdGreaterThanOrEqualTo(String value) {
            addCriterion("task_id >=", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdLessThan(String value) {
            addCriterion("task_id <", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdLessThanOrEqualTo(String value) {
            addCriterion("task_id <=", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdLike(String value) {
            addCriterion("task_id like", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdNotLike(String value) {
            addCriterion("task_id not like", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdIn(List<String> values) {
            addCriterion("task_id in", values, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdNotIn(List<String> values) {
            addCriterion("task_id not in", values, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdBetween(String value1, String value2) {
            addCriterion("task_id between", value1, value2, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdNotBetween(String value1, String value2) {
            addCriterion("task_id not between", value1, value2, "taskId");
            return (Criteria) this;
        }

        public Criteria andPlayerIdIsNull() {
            addCriterion("player_id is null");
            return (Criteria) this;
        }

        public Criteria andPlayerIdIsNotNull() {
            addCriterion("player_id is not null");
            return (Criteria) this;
        }

        public Criteria andPlayerIdEqualTo(String value) {
            addCriterion("player_id =", value, "playerId");
            return (Criteria) this;
        }

        public Criteria andPlayerIdNotEqualTo(String value) {
            addCriterion("player_id <>", value, "playerId");
            return (Criteria) this;
        }

        public Criteria andPlayerIdGreaterThan(String value) {
            addCriterion("player_id >", value, "playerId");
            return (Criteria) this;
        }

        public Criteria andPlayerIdGreaterThanOrEqualTo(String value) {
            addCriterion("player_id >=", value, "playerId");
            return (Criteria) this;
        }

        public Criteria andPlayerIdLessThan(String value) {
            addCriterion("player_id <", value, "playerId");
            return (Criteria) this;
        }

        public Criteria andPlayerIdLessThanOrEqualTo(String value) {
            addCriterion("player_id <=", value, "playerId");
            return (Criteria) this;
        }

        public Criteria andPlayerIdLike(String value) {
            addCriterion("player_id like", value, "playerId");
            return (Criteria) this;
        }

        public Criteria andPlayerIdNotLike(String value) {
            addCriterion("player_id not like", value, "playerId");
            return (Criteria) this;
        }

        public Criteria andPlayerIdIn(List<String> values) {
            addCriterion("player_id in", values, "playerId");
            return (Criteria) this;
        }

        public Criteria andPlayerIdNotIn(List<String> values) {
            addCriterion("player_id not in", values, "playerId");
            return (Criteria) this;
        }

        public Criteria andPlayerIdBetween(String value1, String value2) {
            addCriterion("player_id between", value1, value2, "playerId");
            return (Criteria) this;
        }

        public Criteria andPlayerIdNotBetween(String value1, String value2) {
            addCriterion("player_id not between", value1, value2, "playerId");
            return (Criteria) this;
        }

        public Criteria andPlayerNameIsNull() {
            addCriterion("player_name is null");
            return (Criteria) this;
        }

        public Criteria andPlayerNameIsNotNull() {
            addCriterion("player_name is not null");
            return (Criteria) this;
        }

        public Criteria andPlayerNameEqualTo(String value) {
            addCriterion("player_name =", value, "playerName");
            return (Criteria) this;
        }

        public Criteria andPlayerNameNotEqualTo(String value) {
            addCriterion("player_name <>", value, "playerName");
            return (Criteria) this;
        }

        public Criteria andPlayerNameGreaterThan(String value) {
            addCriterion("player_name >", value, "playerName");
            return (Criteria) this;
        }

        public Criteria andPlayerNameGreaterThanOrEqualTo(String value) {
            addCriterion("player_name >=", value, "playerName");
            return (Criteria) this;
        }

        public Criteria andPlayerNameLessThan(String value) {
            addCriterion("player_name <", value, "playerName");
            return (Criteria) this;
        }

        public Criteria andPlayerNameLessThanOrEqualTo(String value) {
            addCriterion("player_name <=", value, "playerName");
            return (Criteria) this;
        }

        public Criteria andPlayerNameLike(String value) {
            addCriterion("player_name like", value, "playerName");
            return (Criteria) this;
        }

        public Criteria andPlayerNameNotLike(String value) {
            addCriterion("player_name not like", value, "playerName");
            return (Criteria) this;
        }

        public Criteria andPlayerNameIn(List<String> values) {
            addCriterion("player_name in", values, "playerName");
            return (Criteria) this;
        }

        public Criteria andPlayerNameNotIn(List<String> values) {
            addCriterion("player_name not in", values, "playerName");
            return (Criteria) this;
        }

        public Criteria andPlayerNameBetween(String value1, String value2) {
            addCriterion("player_name between", value1, value2, "playerName");
            return (Criteria) this;
        }

        public Criteria andPlayerNameNotBetween(String value1, String value2) {
            addCriterion("player_name not between", value1, value2, "playerName");
            return (Criteria) this;
        }

        public Criteria andProgramNameIsNull() {
            addCriterion("program_name is null");
            return (Criteria) this;
        }

        public Criteria andProgramNameIsNotNull() {
            addCriterion("program_name is not null");
            return (Criteria) this;
        }

        public Criteria andProgramNameEqualTo(String value) {
            addCriterion("program_name =", value, "programName");
            return (Criteria) this;
        }

        public Criteria andProgramNameNotEqualTo(String value) {
            addCriterion("program_name <>", value, "programName");
            return (Criteria) this;
        }

        public Criteria andProgramNameGreaterThan(String value) {
            addCriterion("program_name >", value, "programName");
            return (Criteria) this;
        }

        public Criteria andProgramNameGreaterThanOrEqualTo(String value) {
            addCriterion("program_name >=", value, "programName");
            return (Criteria) this;
        }

        public Criteria andProgramNameLessThan(String value) {
            addCriterion("program_name <", value, "programName");
            return (Criteria) this;
        }

        public Criteria andProgramNameLessThanOrEqualTo(String value) {
            addCriterion("program_name <=", value, "programName");
            return (Criteria) this;
        }

        public Criteria andProgramNameLike(String value) {
            addCriterion("program_name like", value, "programName");
            return (Criteria) this;
        }

        public Criteria andProgramNameNotLike(String value) {
            addCriterion("program_name not like", value, "programName");
            return (Criteria) this;
        }

        public Criteria andProgramNameIn(List<String> values) {
            addCriterion("program_name in", values, "programName");
            return (Criteria) this;
        }

        public Criteria andProgramNameNotIn(List<String> values) {
            addCriterion("program_name not in", values, "programName");
            return (Criteria) this;
        }

        public Criteria andProgramNameBetween(String value1, String value2) {
            addCriterion("program_name between", value1, value2, "programName");
            return (Criteria) this;
        }

        public Criteria andProgramNameNotBetween(String value1, String value2) {
            addCriterion("program_name not between", value1, value2, "programName");
            return (Criteria) this;
        }

        public Criteria andProgramResolutionIsNull() {
            addCriterion("program_resolution is null");
            return (Criteria) this;
        }

        public Criteria andProgramResolutionIsNotNull() {
            addCriterion("program_resolution is not null");
            return (Criteria) this;
        }

        public Criteria andProgramResolutionEqualTo(String value) {
            addCriterion("program_resolution =", value, "programResolution");
            return (Criteria) this;
        }

        public Criteria andProgramResolutionNotEqualTo(String value) {
            addCriterion("program_resolution <>", value, "programResolution");
            return (Criteria) this;
        }

        public Criteria andProgramResolutionGreaterThan(String value) {
            addCriterion("program_resolution >", value, "programResolution");
            return (Criteria) this;
        }

        public Criteria andProgramResolutionGreaterThanOrEqualTo(String value) {
            addCriterion("program_resolution >=", value, "programResolution");
            return (Criteria) this;
        }

        public Criteria andProgramResolutionLessThan(String value) {
            addCriterion("program_resolution <", value, "programResolution");
            return (Criteria) this;
        }

        public Criteria andProgramResolutionLessThanOrEqualTo(String value) {
            addCriterion("program_resolution <=", value, "programResolution");
            return (Criteria) this;
        }

        public Criteria andProgramResolutionLike(String value) {
            addCriterion("program_resolution like", value, "programResolution");
            return (Criteria) this;
        }

        public Criteria andProgramResolutionNotLike(String value) {
            addCriterion("program_resolution not like", value, "programResolution");
            return (Criteria) this;
        }

        public Criteria andProgramResolutionIn(List<String> values) {
            addCriterion("program_resolution in", values, "programResolution");
            return (Criteria) this;
        }

        public Criteria andProgramResolutionNotIn(List<String> values) {
            addCriterion("program_resolution not in", values, "programResolution");
            return (Criteria) this;
        }

        public Criteria andProgramResolutionBetween(String value1, String value2) {
            addCriterion("program_resolution between", value1, value2, "programResolution");
            return (Criteria) this;
        }

        public Criteria andProgramResolutionNotBetween(String value1, String value2) {
            addCriterion("program_resolution not between", value1, value2, "programResolution");
            return (Criteria) this;
        }

        public Criteria andProgramStatusIsNull() {
            addCriterion("program_status is null");
            return (Criteria) this;
        }

        public Criteria andProgramStatusIsNotNull() {
            addCriterion("program_status is not null");
            return (Criteria) this;
        }

        public Criteria andProgramStatusEqualTo(Byte value) {
            addCriterion("program_status =", value, "programStatus");
            return (Criteria) this;
        }

        public Criteria andProgramStatusNotEqualTo(Byte value) {
            addCriterion("program_status <>", value, "programStatus");
            return (Criteria) this;
        }

        public Criteria andProgramStatusGreaterThan(Byte value) {
            addCriterion("program_status >", value, "programStatus");
            return (Criteria) this;
        }

        public Criteria andProgramStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("program_status >=", value, "programStatus");
            return (Criteria) this;
        }

        public Criteria andProgramStatusLessThan(Byte value) {
            addCriterion("program_status <", value, "programStatus");
            return (Criteria) this;
        }

        public Criteria andProgramStatusLessThanOrEqualTo(Byte value) {
            addCriterion("program_status <=", value, "programStatus");
            return (Criteria) this;
        }

        public Criteria andProgramStatusIn(List<Byte> values) {
            addCriterion("program_status in", values, "programStatus");
            return (Criteria) this;
        }

        public Criteria andProgramStatusNotIn(List<Byte> values) {
            addCriterion("program_status not in", values, "programStatus");
            return (Criteria) this;
        }

        public Criteria andProgramStatusBetween(Byte value1, Byte value2) {
            addCriterion("program_status between", value1, value2, "programStatus");
            return (Criteria) this;
        }

        public Criteria andProgramStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("program_status not between", value1, value2, "programStatus");
            return (Criteria) this;
        }

        public Criteria andProgramScenecountIsNull() {
            addCriterion("program_scenecount is null");
            return (Criteria) this;
        }

        public Criteria andProgramScenecountIsNotNull() {
            addCriterion("program_scenecount is not null");
            return (Criteria) this;
        }

        public Criteria andProgramScenecountEqualTo(Integer value) {
            addCriterion("program_scenecount =", value, "programScenecount");
            return (Criteria) this;
        }

        public Criteria andProgramScenecountNotEqualTo(Integer value) {
            addCriterion("program_scenecount <>", value, "programScenecount");
            return (Criteria) this;
        }

        public Criteria andProgramScenecountGreaterThan(Integer value) {
            addCriterion("program_scenecount >", value, "programScenecount");
            return (Criteria) this;
        }

        public Criteria andProgramScenecountGreaterThanOrEqualTo(Integer value) {
            addCriterion("program_scenecount >=", value, "programScenecount");
            return (Criteria) this;
        }

        public Criteria andProgramScenecountLessThan(Integer value) {
            addCriterion("program_scenecount <", value, "programScenecount");
            return (Criteria) this;
        }

        public Criteria andProgramScenecountLessThanOrEqualTo(Integer value) {
            addCriterion("program_scenecount <=", value, "programScenecount");
            return (Criteria) this;
        }

        public Criteria andProgramScenecountIn(List<Integer> values) {
            addCriterion("program_scenecount in", values, "programScenecount");
            return (Criteria) this;
        }

        public Criteria andProgramScenecountNotIn(List<Integer> values) {
            addCriterion("program_scenecount not in", values, "programScenecount");
            return (Criteria) this;
        }

        public Criteria andProgramScenecountBetween(Integer value1, Integer value2) {
            addCriterion("program_scenecount between", value1, value2, "programScenecount");
            return (Criteria) this;
        }

        public Criteria andProgramScenecountNotBetween(Integer value1, Integer value2) {
            addCriterion("program_scenecount not between", value1, value2, "programScenecount");
            return (Criteria) this;
        }

        public Criteria andProgramPlaytimecountIsNull() {
            addCriterion("program_playtimecount is null");
            return (Criteria) this;
        }

        public Criteria andProgramPlaytimecountIsNotNull() {
            addCriterion("program_playtimecount is not null");
            return (Criteria) this;
        }

        public Criteria andProgramPlaytimecountEqualTo(Integer value) {
            addCriterion("program_playtimecount =", value, "programPlaytimecount");
            return (Criteria) this;
        }

        public Criteria andProgramPlaytimecountNotEqualTo(Integer value) {
            addCriterion("program_playtimecount <>", value, "programPlaytimecount");
            return (Criteria) this;
        }

        public Criteria andProgramPlaytimecountGreaterThan(Integer value) {
            addCriterion("program_playtimecount >", value, "programPlaytimecount");
            return (Criteria) this;
        }

        public Criteria andProgramPlaytimecountGreaterThanOrEqualTo(Integer value) {
            addCriterion("program_playtimecount >=", value, "programPlaytimecount");
            return (Criteria) this;
        }

        public Criteria andProgramPlaytimecountLessThan(Integer value) {
            addCriterion("program_playtimecount <", value, "programPlaytimecount");
            return (Criteria) this;
        }

        public Criteria andProgramPlaytimecountLessThanOrEqualTo(Integer value) {
            addCriterion("program_playtimecount <=", value, "programPlaytimecount");
            return (Criteria) this;
        }

        public Criteria andProgramPlaytimecountIn(List<Integer> values) {
            addCriterion("program_playtimecount in", values, "programPlaytimecount");
            return (Criteria) this;
        }

        public Criteria andProgramPlaytimecountNotIn(List<Integer> values) {
            addCriterion("program_playtimecount not in", values, "programPlaytimecount");
            return (Criteria) this;
        }

        public Criteria andProgramPlaytimecountBetween(Integer value1, Integer value2) {
            addCriterion("program_playtimecount between", value1, value2, "programPlaytimecount");
            return (Criteria) this;
        }

        public Criteria andProgramPlaytimecountNotBetween(Integer value1, Integer value2) {
            addCriterion("program_playtimecount not between", value1, value2, "programPlaytimecount");
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

        public Criteria andGroupIdEqualTo(Integer value) {
            addCriterion("group_id =", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdNotEqualTo(Integer value) {
            addCriterion("group_id <>", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdGreaterThan(Integer value) {
            addCriterion("group_id >", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("group_id >=", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdLessThan(Integer value) {
            addCriterion("group_id <", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdLessThanOrEqualTo(Integer value) {
            addCriterion("group_id <=", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdIn(List<Integer> values) {
            addCriterion("group_id in", values, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdNotIn(List<Integer> values) {
            addCriterion("group_id not in", values, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdBetween(Integer value1, Integer value2) {
            addCriterion("group_id between", value1, value2, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdNotBetween(Integer value1, Integer value2) {
            addCriterion("group_id not between", value1, value2, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupNameIsNull() {
            addCriterion("group_name is null");
            return (Criteria) this;
        }

        public Criteria andGroupNameIsNotNull() {
            addCriterion("group_name is not null");
            return (Criteria) this;
        }

        public Criteria andGroupNameEqualTo(String value) {
            addCriterion("group_name =", value, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameNotEqualTo(String value) {
            addCriterion("group_name <>", value, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameGreaterThan(String value) {
            addCriterion("group_name >", value, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameGreaterThanOrEqualTo(String value) {
            addCriterion("group_name >=", value, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameLessThan(String value) {
            addCriterion("group_name <", value, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameLessThanOrEqualTo(String value) {
            addCriterion("group_name <=", value, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameLike(String value) {
            addCriterion("group_name like", value, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameNotLike(String value) {
            addCriterion("group_name not like", value, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameIn(List<String> values) {
            addCriterion("group_name in", values, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameNotIn(List<String> values) {
            addCriterion("group_name not in", values, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameBetween(String value1, String value2) {
            addCriterion("group_name between", value1, value2, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameNotBetween(String value1, String value2) {
            addCriterion("group_name not between", value1, value2, "groupName");
            return (Criteria) this;
        }

        public Criteria andExpirationTimeIsNull() {
            addCriterion("expiration_time is null");
            return (Criteria) this;
        }

        public Criteria andExpirationTimeIsNotNull() {
            addCriterion("expiration_time is not null");
            return (Criteria) this;
        }

        public Criteria andExpirationTimeEqualTo(Date value) {
            addCriterion("expiration_time =", value, "expirationTime");
            return (Criteria) this;
        }

        public Criteria andExpirationTimeNotEqualTo(Date value) {
            addCriterion("expiration_time <>", value, "expirationTime");
            return (Criteria) this;
        }

        public Criteria andExpirationTimeGreaterThan(Date value) {
            addCriterion("expiration_time >", value, "expirationTime");
            return (Criteria) this;
        }

        public Criteria andExpirationTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("expiration_time >=", value, "expirationTime");
            return (Criteria) this;
        }

        public Criteria andExpirationTimeLessThan(Date value) {
            addCriterion("expiration_time <", value, "expirationTime");
            return (Criteria) this;
        }

        public Criteria andExpirationTimeLessThanOrEqualTo(Date value) {
            addCriterion("expiration_time <=", value, "expirationTime");
            return (Criteria) this;
        }

        public Criteria andExpirationTimeIn(List<Date> values) {
            addCriterion("expiration_time in", values, "expirationTime");
            return (Criteria) this;
        }

        public Criteria andExpirationTimeNotIn(List<Date> values) {
            addCriterion("expiration_time not in", values, "expirationTime");
            return (Criteria) this;
        }

        public Criteria andExpirationTimeBetween(Date value1, Date value2) {
            addCriterion("expiration_time between", value1, value2, "expirationTime");
            return (Criteria) this;
        }

        public Criteria andExpirationTimeNotBetween(Date value1, Date value2) {
            addCriterion("expiration_time not between", value1, value2, "expirationTime");
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

        public Criteria andAcceptTimeIsNull() {
            addCriterion("accept_time is null");
            return (Criteria) this;
        }

        public Criteria andAcceptTimeIsNotNull() {
            addCriterion("accept_time is not null");
            return (Criteria) this;
        }

        public Criteria andAcceptTimeEqualTo(Date value) {
            addCriterion("accept_time =", value, "acceptTime");
            return (Criteria) this;
        }

        public Criteria andAcceptTimeNotEqualTo(Date value) {
            addCriterion("accept_time <>", value, "acceptTime");
            return (Criteria) this;
        }

        public Criteria andAcceptTimeGreaterThan(Date value) {
            addCriterion("accept_time >", value, "acceptTime");
            return (Criteria) this;
        }

        public Criteria andAcceptTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("accept_time >=", value, "acceptTime");
            return (Criteria) this;
        }

        public Criteria andAcceptTimeLessThan(Date value) {
            addCriterion("accept_time <", value, "acceptTime");
            return (Criteria) this;
        }

        public Criteria andAcceptTimeLessThanOrEqualTo(Date value) {
            addCriterion("accept_time <=", value, "acceptTime");
            return (Criteria) this;
        }

        public Criteria andAcceptTimeIn(List<Date> values) {
            addCriterion("accept_time in", values, "acceptTime");
            return (Criteria) this;
        }

        public Criteria andAcceptTimeNotIn(List<Date> values) {
            addCriterion("accept_time not in", values, "acceptTime");
            return (Criteria) this;
        }

        public Criteria andAcceptTimeBetween(Date value1, Date value2) {
            addCriterion("accept_time between", value1, value2, "acceptTime");
            return (Criteria) this;
        }

        public Criteria andAcceptTimeNotBetween(Date value1, Date value2) {
            addCriterion("accept_time not between", value1, value2, "acceptTime");
            return (Criteria) this;
        }

        public Criteria andFinishTimeIsNull() {
            addCriterion("finish_time is null");
            return (Criteria) this;
        }

        public Criteria andFinishTimeIsNotNull() {
            addCriterion("finish_time is not null");
            return (Criteria) this;
        }

        public Criteria andFinishTimeEqualTo(Date value) {
            addCriterion("finish_time =", value, "finishTime");
            return (Criteria) this;
        }

        public Criteria andFinishTimeNotEqualTo(Date value) {
            addCriterion("finish_time <>", value, "finishTime");
            return (Criteria) this;
        }

        public Criteria andFinishTimeGreaterThan(Date value) {
            addCriterion("finish_time >", value, "finishTime");
            return (Criteria) this;
        }

        public Criteria andFinishTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("finish_time >=", value, "finishTime");
            return (Criteria) this;
        }

        public Criteria andFinishTimeLessThan(Date value) {
            addCriterion("finish_time <", value, "finishTime");
            return (Criteria) this;
        }

        public Criteria andFinishTimeLessThanOrEqualTo(Date value) {
            addCriterion("finish_time <=", value, "finishTime");
            return (Criteria) this;
        }

        public Criteria andFinishTimeIn(List<Date> values) {
            addCriterion("finish_time in", values, "finishTime");
            return (Criteria) this;
        }

        public Criteria andFinishTimeNotIn(List<Date> values) {
            addCriterion("finish_time not in", values, "finishTime");
            return (Criteria) this;
        }

        public Criteria andFinishTimeBetween(Date value1, Date value2) {
            addCriterion("finish_time between", value1, value2, "finishTime");
            return (Criteria) this;
        }

        public Criteria andFinishTimeNotBetween(Date value1, Date value2) {
            addCriterion("finish_time not between", value1, value2, "finishTime");
            return (Criteria) this;
        }

        public Criteria andDeleteTimeIsNull() {
            addCriterion("delete_time is null");
            return (Criteria) this;
        }

        public Criteria andDeleteTimeIsNotNull() {
            addCriterion("delete_time is not null");
            return (Criteria) this;
        }

        public Criteria andDeleteTimeEqualTo(Date value) {
            addCriterion("delete_time =", value, "deleteTime");
            return (Criteria) this;
        }

        public Criteria andDeleteTimeNotEqualTo(Date value) {
            addCriterion("delete_time <>", value, "deleteTime");
            return (Criteria) this;
        }

        public Criteria andDeleteTimeGreaterThan(Date value) {
            addCriterion("delete_time >", value, "deleteTime");
            return (Criteria) this;
        }

        public Criteria andDeleteTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("delete_time >=", value, "deleteTime");
            return (Criteria) this;
        }

        public Criteria andDeleteTimeLessThan(Date value) {
            addCriterion("delete_time <", value, "deleteTime");
            return (Criteria) this;
        }

        public Criteria andDeleteTimeLessThanOrEqualTo(Date value) {
            addCriterion("delete_time <=", value, "deleteTime");
            return (Criteria) this;
        }

        public Criteria andDeleteTimeIn(List<Date> values) {
            addCriterion("delete_time in", values, "deleteTime");
            return (Criteria) this;
        }

        public Criteria andDeleteTimeNotIn(List<Date> values) {
            addCriterion("delete_time not in", values, "deleteTime");
            return (Criteria) this;
        }

        public Criteria andDeleteTimeBetween(Date value1, Date value2) {
            addCriterion("delete_time between", value1, value2, "deleteTime");
            return (Criteria) this;
        }

        public Criteria andDeleteTimeNotBetween(Date value1, Date value2) {
            addCriterion("delete_time not between", value1, value2, "deleteTime");
            return (Criteria) this;
        }

        public Criteria andProgramPriorityIsNull() {
            addCriterion("program_priority is null");
            return (Criteria) this;
        }

        public Criteria andProgramPriorityIsNotNull() {
            addCriterion("program_priority is not null");
            return (Criteria) this;
        }

        public Criteria andProgramPriorityEqualTo(Integer value) {
            addCriterion("program_priority =", value, "programPriority");
            return (Criteria) this;
        }

        public Criteria andProgramPriorityNotEqualTo(Integer value) {
            addCriterion("program_priority <>", value, "programPriority");
            return (Criteria) this;
        }

        public Criteria andProgramPriorityGreaterThan(Integer value) {
            addCriterion("program_priority >", value, "programPriority");
            return (Criteria) this;
        }

        public Criteria andProgramPriorityGreaterThanOrEqualTo(Integer value) {
            addCriterion("program_priority >=", value, "programPriority");
            return (Criteria) this;
        }

        public Criteria andProgramPriorityLessThan(Integer value) {
            addCriterion("program_priority <", value, "programPriority");
            return (Criteria) this;
        }

        public Criteria andProgramPriorityLessThanOrEqualTo(Integer value) {
            addCriterion("program_priority <=", value, "programPriority");
            return (Criteria) this;
        }

        public Criteria andProgramPriorityIn(List<Integer> values) {
            addCriterion("program_priority in", values, "programPriority");
            return (Criteria) this;
        }

        public Criteria andProgramPriorityNotIn(List<Integer> values) {
            addCriterion("program_priority not in", values, "programPriority");
            return (Criteria) this;
        }

        public Criteria andProgramPriorityBetween(Integer value1, Integer value2) {
            addCriterion("program_priority between", value1, value2, "programPriority");
            return (Criteria) this;
        }

        public Criteria andProgramPriorityNotBetween(Integer value1, Integer value2) {
            addCriterion("program_priority not between", value1, value2, "programPriority");
            return (Criteria) this;
        }

        public Criteria andProgramSizeIsNull() {
            addCriterion("program_size is null");
            return (Criteria) this;
        }

        public Criteria andProgramSizeIsNotNull() {
            addCriterion("program_size is not null");
            return (Criteria) this;
        }

        public Criteria andProgramSizeEqualTo(Long value) {
            addCriterion("program_size =", value, "programSize");
            return (Criteria) this;
        }

        public Criteria andProgramSizeNotEqualTo(Long value) {
            addCriterion("program_size <>", value, "programSize");
            return (Criteria) this;
        }

        public Criteria andProgramSizeGreaterThan(Long value) {
            addCriterion("program_size >", value, "programSize");
            return (Criteria) this;
        }

        public Criteria andProgramSizeGreaterThanOrEqualTo(Long value) {
            addCriterion("program_size >=", value, "programSize");
            return (Criteria) this;
        }

        public Criteria andProgramSizeLessThan(Long value) {
            addCriterion("program_size <", value, "programSize");
            return (Criteria) this;
        }

        public Criteria andProgramSizeLessThanOrEqualTo(Long value) {
            addCriterion("program_size <=", value, "programSize");
            return (Criteria) this;
        }

        public Criteria andProgramSizeIn(List<Long> values) {
            addCriterion("program_size in", values, "programSize");
            return (Criteria) this;
        }

        public Criteria andProgramSizeNotIn(List<Long> values) {
            addCriterion("program_size not in", values, "programSize");
            return (Criteria) this;
        }

        public Criteria andProgramSizeBetween(Long value1, Long value2) {
            addCriterion("program_size between", value1, value2, "programSize");
            return (Criteria) this;
        }

        public Criteria andProgramSizeNotBetween(Long value1, Long value2) {
            addCriterion("program_size not between", value1, value2, "programSize");
            return (Criteria) this;
        }

        public Criteria andDownloadSizeIsNull() {
            addCriterion("download_size is null");
            return (Criteria) this;
        }

        public Criteria andDownloadSizeIsNotNull() {
            addCriterion("download_size is not null");
            return (Criteria) this;
        }

        public Criteria andDownloadSizeEqualTo(Long value) {
            addCriterion("download_size =", value, "downloadSize");
            return (Criteria) this;
        }

        public Criteria andDownloadSizeNotEqualTo(Long value) {
            addCriterion("download_size <>", value, "downloadSize");
            return (Criteria) this;
        }

        public Criteria andDownloadSizeGreaterThan(Long value) {
            addCriterion("download_size >", value, "downloadSize");
            return (Criteria) this;
        }

        public Criteria andDownloadSizeGreaterThanOrEqualTo(Long value) {
            addCriterion("download_size >=", value, "downloadSize");
            return (Criteria) this;
        }

        public Criteria andDownloadSizeLessThan(Long value) {
            addCriterion("download_size <", value, "downloadSize");
            return (Criteria) this;
        }

        public Criteria andDownloadSizeLessThanOrEqualTo(Long value) {
            addCriterion("download_size <=", value, "downloadSize");
            return (Criteria) this;
        }

        public Criteria andDownloadSizeIn(List<Long> values) {
            addCriterion("download_size in", values, "downloadSize");
            return (Criteria) this;
        }

        public Criteria andDownloadSizeNotIn(List<Long> values) {
            addCriterion("download_size not in", values, "downloadSize");
            return (Criteria) this;
        }

        public Criteria andDownloadSizeBetween(Long value1, Long value2) {
            addCriterion("download_size between", value1, value2, "downloadSize");
            return (Criteria) this;
        }

        public Criteria andDownloadSizeNotBetween(Long value1, Long value2) {
            addCriterion("download_size not between", value1, value2, "downloadSize");
            return (Criteria) this;
        }

        public Criteria andProgramRetimeIsNull() {
            addCriterion("program_retime is null");
            return (Criteria) this;
        }

        public Criteria andProgramRetimeIsNotNull() {
            addCriterion("program_retime is not null");
            return (Criteria) this;
        }

        public Criteria andProgramRetimeEqualTo(Date value) {
            addCriterion("program_retime =", value, "programRetime");
            return (Criteria) this;
        }

        public Criteria andProgramRetimeNotEqualTo(Date value) {
            addCriterion("program_retime <>", value, "programRetime");
            return (Criteria) this;
        }

        public Criteria andProgramRetimeGreaterThan(Date value) {
            addCriterion("program_retime >", value, "programRetime");
            return (Criteria) this;
        }

        public Criteria andProgramRetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("program_retime >=", value, "programRetime");
            return (Criteria) this;
        }

        public Criteria andProgramRetimeLessThan(Date value) {
            addCriterion("program_retime <", value, "programRetime");
            return (Criteria) this;
        }

        public Criteria andProgramRetimeLessThanOrEqualTo(Date value) {
            addCriterion("program_retime <=", value, "programRetime");
            return (Criteria) this;
        }

        public Criteria andProgramRetimeIn(List<Date> values) {
            addCriterion("program_retime in", values, "programRetime");
            return (Criteria) this;
        }

        public Criteria andProgramRetimeNotIn(List<Date> values) {
            addCriterion("program_retime not in", values, "programRetime");
            return (Criteria) this;
        }

        public Criteria andProgramRetimeBetween(Date value1, Date value2) {
            addCriterion("program_retime between", value1, value2, "programRetime");
            return (Criteria) this;
        }

        public Criteria andProgramRetimeNotBetween(Date value1, Date value2) {
            addCriterion("program_retime not between", value1, value2, "programRetime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeIsNull() {
            addCriterion("publish_time is null");
            return (Criteria) this;
        }

        public Criteria andPublishTimeIsNotNull() {
            addCriterion("publish_time is not null");
            return (Criteria) this;
        }

        public Criteria andPublishTimeEqualTo(Date value) {
            addCriterion("publish_time =", value, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeNotEqualTo(Date value) {
            addCriterion("publish_time <>", value, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeGreaterThan(Date value) {
            addCriterion("publish_time >", value, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("publish_time >=", value, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeLessThan(Date value) {
            addCriterion("publish_time <", value, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeLessThanOrEqualTo(Date value) {
            addCriterion("publish_time <=", value, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeIn(List<Date> values) {
            addCriterion("publish_time in", values, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeNotIn(List<Date> values) {
            addCriterion("publish_time not in", values, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeBetween(Date value1, Date value2) {
            addCriterion("publish_time between", value1, value2, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeNotBetween(Date value1, Date value2) {
            addCriterion("publish_time not between", value1, value2, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTypeIsNull() {
            addCriterion("publish_type is null");
            return (Criteria) this;
        }

        public Criteria andPublishTypeIsNotNull() {
            addCriterion("publish_type is not null");
            return (Criteria) this;
        }

        public Criteria andPublishTypeEqualTo(String value) {
            addCriterion("publish_type =", value, "publishType");
            return (Criteria) this;
        }

        public Criteria andPublishTypeNotEqualTo(String value) {
            addCriterion("publish_type <>", value, "publishType");
            return (Criteria) this;
        }

        public Criteria andPublishTypeGreaterThan(String value) {
            addCriterion("publish_type >", value, "publishType");
            return (Criteria) this;
        }

        public Criteria andPublishTypeGreaterThanOrEqualTo(String value) {
            addCriterion("publish_type >=", value, "publishType");
            return (Criteria) this;
        }

        public Criteria andPublishTypeLessThan(String value) {
            addCriterion("publish_type <", value, "publishType");
            return (Criteria) this;
        }

        public Criteria andPublishTypeLessThanOrEqualTo(String value) {
            addCriterion("publish_type <=", value, "publishType");
            return (Criteria) this;
        }

        public Criteria andPublishTypeLike(String value) {
            addCriterion("publish_type like", value, "publishType");
            return (Criteria) this;
        }

        public Criteria andPublishTypeNotLike(String value) {
            addCriterion("publish_type not like", value, "publishType");
            return (Criteria) this;
        }

        public Criteria andPublishTypeIn(List<String> values) {
            addCriterion("publish_type in", values, "publishType");
            return (Criteria) this;
        }

        public Criteria andPublishTypeNotIn(List<String> values) {
            addCriterion("publish_type not in", values, "publishType");
            return (Criteria) this;
        }

        public Criteria andPublishTypeBetween(String value1, String value2) {
            addCriterion("publish_type between", value1, value2, "publishType");
            return (Criteria) this;
        }

        public Criteria andPublishTypeNotBetween(String value1, String value2) {
            addCriterion("publish_type not between", value1, value2, "publishType");
            return (Criteria) this;
        }

        public Criteria andProgramExclusiveIsNull() {
            addCriterion("program_exclusive is null");
            return (Criteria) this;
        }

        public Criteria andProgramExclusiveIsNotNull() {
            addCriterion("program_exclusive is not null");
            return (Criteria) this;
        }

        public Criteria andProgramExclusiveEqualTo(Boolean value) {
            addCriterion("program_exclusive =", value, "programExclusive");
            return (Criteria) this;
        }

        public Criteria andProgramExclusiveNotEqualTo(Boolean value) {
            addCriterion("program_exclusive <>", value, "programExclusive");
            return (Criteria) this;
        }

        public Criteria andProgramExclusiveGreaterThan(Boolean value) {
            addCriterion("program_exclusive >", value, "programExclusive");
            return (Criteria) this;
        }

        public Criteria andProgramExclusiveGreaterThanOrEqualTo(Boolean value) {
            addCriterion("program_exclusive >=", value, "programExclusive");
            return (Criteria) this;
        }

        public Criteria andProgramExclusiveLessThan(Boolean value) {
            addCriterion("program_exclusive <", value, "programExclusive");
            return (Criteria) this;
        }

        public Criteria andProgramExclusiveLessThanOrEqualTo(Boolean value) {
            addCriterion("program_exclusive <=", value, "programExclusive");
            return (Criteria) this;
        }

        public Criteria andProgramExclusiveIn(List<Boolean> values) {
            addCriterion("program_exclusive in", values, "programExclusive");
            return (Criteria) this;
        }

        public Criteria andProgramExclusiveNotIn(List<Boolean> values) {
            addCriterion("program_exclusive not in", values, "programExclusive");
            return (Criteria) this;
        }

        public Criteria andProgramExclusiveBetween(Boolean value1, Boolean value2) {
            addCriterion("program_exclusive between", value1, value2, "programExclusive");
            return (Criteria) this;
        }

        public Criteria andProgramExclusiveNotBetween(Boolean value1, Boolean value2) {
            addCriterion("program_exclusive not between", value1, value2, "programExclusive");
            return (Criteria) this;
        }

        public Criteria andServerIdIsNull() {
            addCriterion("server_id is null");
            return (Criteria) this;
        }

        public Criteria andServerIdIsNotNull() {
            addCriterion("server_id is not null");
            return (Criteria) this;
        }

        public Criteria andServerIdEqualTo(String value) {
            addCriterion("server_id =", value, "serverId");
            return (Criteria) this;
        }

        public Criteria andServerIdNotEqualTo(String value) {
            addCriterion("server_id <>", value, "serverId");
            return (Criteria) this;
        }

        public Criteria andServerIdGreaterThan(String value) {
            addCriterion("server_id >", value, "serverId");
            return (Criteria) this;
        }

        public Criteria andServerIdGreaterThanOrEqualTo(String value) {
            addCriterion("server_id >=", value, "serverId");
            return (Criteria) this;
        }

        public Criteria andServerIdLessThan(String value) {
            addCriterion("server_id <", value, "serverId");
            return (Criteria) this;
        }

        public Criteria andServerIdLessThanOrEqualTo(String value) {
            addCriterion("server_id <=", value, "serverId");
            return (Criteria) this;
        }

        public Criteria andServerIdLike(String value) {
            addCriterion("server_id like", value, "serverId");
            return (Criteria) this;
        }

        public Criteria andServerIdNotLike(String value) {
            addCriterion("server_id not like", value, "serverId");
            return (Criteria) this;
        }

        public Criteria andServerIdIn(List<String> values) {
            addCriterion("server_id in", values, "serverId");
            return (Criteria) this;
        }

        public Criteria andServerIdNotIn(List<String> values) {
            addCriterion("server_id not in", values, "serverId");
            return (Criteria) this;
        }

        public Criteria andServerIdBetween(String value1, String value2) {
            addCriterion("server_id between", value1, value2, "serverId");
            return (Criteria) this;
        }

        public Criteria andServerIdNotBetween(String value1, String value2) {
            addCriterion("server_id not between", value1, value2, "serverId");
            return (Criteria) this;
        }

        public Criteria andServerTaskIdIsNull() {
            addCriterion("server_task_id is null");
            return (Criteria) this;
        }

        public Criteria andServerTaskIdIsNotNull() {
            addCriterion("server_task_id is not null");
            return (Criteria) this;
        }

        public Criteria andServerTaskIdEqualTo(String value) {
            addCriterion("server_task_id =", value, "serverTaskId");
            return (Criteria) this;
        }

        public Criteria andServerTaskIdNotEqualTo(String value) {
            addCriterion("server_task_id <>", value, "serverTaskId");
            return (Criteria) this;
        }

        public Criteria andServerTaskIdGreaterThan(String value) {
            addCriterion("server_task_id >", value, "serverTaskId");
            return (Criteria) this;
        }

        public Criteria andServerTaskIdGreaterThanOrEqualTo(String value) {
            addCriterion("server_task_id >=", value, "serverTaskId");
            return (Criteria) this;
        }

        public Criteria andServerTaskIdLessThan(String value) {
            addCriterion("server_task_id <", value, "serverTaskId");
            return (Criteria) this;
        }

        public Criteria andServerTaskIdLessThanOrEqualTo(String value) {
            addCriterion("server_task_id <=", value, "serverTaskId");
            return (Criteria) this;
        }

        public Criteria andServerTaskIdLike(String value) {
            addCriterion("server_task_id like", value, "serverTaskId");
            return (Criteria) this;
        }

        public Criteria andServerTaskIdNotLike(String value) {
            addCriterion("server_task_id not like", value, "serverTaskId");
            return (Criteria) this;
        }

        public Criteria andServerTaskIdIn(List<String> values) {
            addCriterion("server_task_id in", values, "serverTaskId");
            return (Criteria) this;
        }

        public Criteria andServerTaskIdNotIn(List<String> values) {
            addCriterion("server_task_id not in", values, "serverTaskId");
            return (Criteria) this;
        }

        public Criteria andServerTaskIdBetween(String value1, String value2) {
            addCriterion("server_task_id between", value1, value2, "serverTaskId");
            return (Criteria) this;
        }

        public Criteria andServerTaskIdNotBetween(String value1, String value2) {
            addCriterion("server_task_id not between", value1, value2, "serverTaskId");
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