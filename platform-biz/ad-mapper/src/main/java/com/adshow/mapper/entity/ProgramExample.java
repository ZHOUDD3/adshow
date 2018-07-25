package com.adshow.mapper.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProgramExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Long offset;

    public ProgramExample() {
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

        public Criteria andTypeIsNull() {
            addCriterion("`type` is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("`type` is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(Byte value) {
            addCriterion("`type` =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(Byte value) {
            addCriterion("`type` <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(Byte value) {
            addCriterion("`type` >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("`type` >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(Byte value) {
            addCriterion("`type` <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(Byte value) {
            addCriterion("`type` <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<Byte> values) {
            addCriterion("`type` in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<Byte> values) {
            addCriterion("`type` not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(Byte value1, Byte value2) {
            addCriterion("`type` between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("`type` not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andProgramDurationIsNull() {
            addCriterion("program_duration is null");
            return (Criteria) this;
        }

        public Criteria andProgramDurationIsNotNull() {
            addCriterion("program_duration is not null");
            return (Criteria) this;
        }

        public Criteria andProgramDurationEqualTo(Integer value) {
            addCriterion("program_duration =", value, "programDuration");
            return (Criteria) this;
        }

        public Criteria andProgramDurationNotEqualTo(Integer value) {
            addCriterion("program_duration <>", value, "programDuration");
            return (Criteria) this;
        }

        public Criteria andProgramDurationGreaterThan(Integer value) {
            addCriterion("program_duration >", value, "programDuration");
            return (Criteria) this;
        }

        public Criteria andProgramDurationGreaterThanOrEqualTo(Integer value) {
            addCriterion("program_duration >=", value, "programDuration");
            return (Criteria) this;
        }

        public Criteria andProgramDurationLessThan(Integer value) {
            addCriterion("program_duration <", value, "programDuration");
            return (Criteria) this;
        }

        public Criteria andProgramDurationLessThanOrEqualTo(Integer value) {
            addCriterion("program_duration <=", value, "programDuration");
            return (Criteria) this;
        }

        public Criteria andProgramDurationIn(List<Integer> values) {
            addCriterion("program_duration in", values, "programDuration");
            return (Criteria) this;
        }

        public Criteria andProgramDurationNotIn(List<Integer> values) {
            addCriterion("program_duration not in", values, "programDuration");
            return (Criteria) this;
        }

        public Criteria andProgramDurationBetween(Integer value1, Integer value2) {
            addCriterion("program_duration between", value1, value2, "programDuration");
            return (Criteria) this;
        }

        public Criteria andProgramDurationNotBetween(Integer value1, Integer value2) {
            addCriterion("program_duration not between", value1, value2, "programDuration");
            return (Criteria) this;
        }

        public Criteria andResolutionIsNull() {
            addCriterion("resolution is null");
            return (Criteria) this;
        }

        public Criteria andResolutionIsNotNull() {
            addCriterion("resolution is not null");
            return (Criteria) this;
        }

        public Criteria andResolutionEqualTo(String value) {
            addCriterion("resolution =", value, "resolution");
            return (Criteria) this;
        }

        public Criteria andResolutionNotEqualTo(String value) {
            addCriterion("resolution <>", value, "resolution");
            return (Criteria) this;
        }

        public Criteria andResolutionGreaterThan(String value) {
            addCriterion("resolution >", value, "resolution");
            return (Criteria) this;
        }

        public Criteria andResolutionGreaterThanOrEqualTo(String value) {
            addCriterion("resolution >=", value, "resolution");
            return (Criteria) this;
        }

        public Criteria andResolutionLessThan(String value) {
            addCriterion("resolution <", value, "resolution");
            return (Criteria) this;
        }

        public Criteria andResolutionLessThanOrEqualTo(String value) {
            addCriterion("resolution <=", value, "resolution");
            return (Criteria) this;
        }

        public Criteria andResolutionLike(String value) {
            addCriterion("resolution like", value, "resolution");
            return (Criteria) this;
        }

        public Criteria andResolutionNotLike(String value) {
            addCriterion("resolution not like", value, "resolution");
            return (Criteria) this;
        }

        public Criteria andResolutionIn(List<String> values) {
            addCriterion("resolution in", values, "resolution");
            return (Criteria) this;
        }

        public Criteria andResolutionNotIn(List<String> values) {
            addCriterion("resolution not in", values, "resolution");
            return (Criteria) this;
        }

        public Criteria andResolutionBetween(String value1, String value2) {
            addCriterion("resolution between", value1, value2, "resolution");
            return (Criteria) this;
        }

        public Criteria andResolutionNotBetween(String value1, String value2) {
            addCriterion("resolution not between", value1, value2, "resolution");
            return (Criteria) this;
        }

        public Criteria andProgramDescriptionIsNull() {
            addCriterion("program_description is null");
            return (Criteria) this;
        }

        public Criteria andProgramDescriptionIsNotNull() {
            addCriterion("program_description is not null");
            return (Criteria) this;
        }

        public Criteria andProgramDescriptionEqualTo(String value) {
            addCriterion("program_description =", value, "programDescription");
            return (Criteria) this;
        }

        public Criteria andProgramDescriptionNotEqualTo(String value) {
            addCriterion("program_description <>", value, "programDescription");
            return (Criteria) this;
        }

        public Criteria andProgramDescriptionGreaterThan(String value) {
            addCriterion("program_description >", value, "programDescription");
            return (Criteria) this;
        }

        public Criteria andProgramDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("program_description >=", value, "programDescription");
            return (Criteria) this;
        }

        public Criteria andProgramDescriptionLessThan(String value) {
            addCriterion("program_description <", value, "programDescription");
            return (Criteria) this;
        }

        public Criteria andProgramDescriptionLessThanOrEqualTo(String value) {
            addCriterion("program_description <=", value, "programDescription");
            return (Criteria) this;
        }

        public Criteria andProgramDescriptionLike(String value) {
            addCriterion("program_description like", value, "programDescription");
            return (Criteria) this;
        }

        public Criteria andProgramDescriptionNotLike(String value) {
            addCriterion("program_description not like", value, "programDescription");
            return (Criteria) this;
        }

        public Criteria andProgramDescriptionIn(List<String> values) {
            addCriterion("program_description in", values, "programDescription");
            return (Criteria) this;
        }

        public Criteria andProgramDescriptionNotIn(List<String> values) {
            addCriterion("program_description not in", values, "programDescription");
            return (Criteria) this;
        }

        public Criteria andProgramDescriptionBetween(String value1, String value2) {
            addCriterion("program_description between", value1, value2, "programDescription");
            return (Criteria) this;
        }

        public Criteria andProgramDescriptionNotBetween(String value1, String value2) {
            addCriterion("program_description not between", value1, value2, "programDescription");
            return (Criteria) this;
        }

        public Criteria andVideoIdsIsNull() {
            addCriterion("video_ids is null");
            return (Criteria) this;
        }

        public Criteria andVideoIdsIsNotNull() {
            addCriterion("video_ids is not null");
            return (Criteria) this;
        }

        public Criteria andVideoIdsEqualTo(String value) {
            addCriterion("video_ids =", value, "videoIds");
            return (Criteria) this;
        }

        public Criteria andVideoIdsNotEqualTo(String value) {
            addCriterion("video_ids <>", value, "videoIds");
            return (Criteria) this;
        }

        public Criteria andVideoIdsGreaterThan(String value) {
            addCriterion("video_ids >", value, "videoIds");
            return (Criteria) this;
        }

        public Criteria andVideoIdsGreaterThanOrEqualTo(String value) {
            addCriterion("video_ids >=", value, "videoIds");
            return (Criteria) this;
        }

        public Criteria andVideoIdsLessThan(String value) {
            addCriterion("video_ids <", value, "videoIds");
            return (Criteria) this;
        }

        public Criteria andVideoIdsLessThanOrEqualTo(String value) {
            addCriterion("video_ids <=", value, "videoIds");
            return (Criteria) this;
        }

        public Criteria andVideoIdsLike(String value) {
            addCriterion("video_ids like", value, "videoIds");
            return (Criteria) this;
        }

        public Criteria andVideoIdsNotLike(String value) {
            addCriterion("video_ids not like", value, "videoIds");
            return (Criteria) this;
        }

        public Criteria andVideoIdsIn(List<String> values) {
            addCriterion("video_ids in", values, "videoIds");
            return (Criteria) this;
        }

        public Criteria andVideoIdsNotIn(List<String> values) {
            addCriterion("video_ids not in", values, "videoIds");
            return (Criteria) this;
        }

        public Criteria andVideoIdsBetween(String value1, String value2) {
            addCriterion("video_ids between", value1, value2, "videoIds");
            return (Criteria) this;
        }

        public Criteria andVideoIdsNotBetween(String value1, String value2) {
            addCriterion("video_ids not between", value1, value2, "videoIds");
            return (Criteria) this;
        }

        public Criteria andMusicIdsIsNull() {
            addCriterion("music_ids is null");
            return (Criteria) this;
        }

        public Criteria andMusicIdsIsNotNull() {
            addCriterion("music_ids is not null");
            return (Criteria) this;
        }

        public Criteria andMusicIdsEqualTo(String value) {
            addCriterion("music_ids =", value, "musicIds");
            return (Criteria) this;
        }

        public Criteria andMusicIdsNotEqualTo(String value) {
            addCriterion("music_ids <>", value, "musicIds");
            return (Criteria) this;
        }

        public Criteria andMusicIdsGreaterThan(String value) {
            addCriterion("music_ids >", value, "musicIds");
            return (Criteria) this;
        }

        public Criteria andMusicIdsGreaterThanOrEqualTo(String value) {
            addCriterion("music_ids >=", value, "musicIds");
            return (Criteria) this;
        }

        public Criteria andMusicIdsLessThan(String value) {
            addCriterion("music_ids <", value, "musicIds");
            return (Criteria) this;
        }

        public Criteria andMusicIdsLessThanOrEqualTo(String value) {
            addCriterion("music_ids <=", value, "musicIds");
            return (Criteria) this;
        }

        public Criteria andMusicIdsLike(String value) {
            addCriterion("music_ids like", value, "musicIds");
            return (Criteria) this;
        }

        public Criteria andMusicIdsNotLike(String value) {
            addCriterion("music_ids not like", value, "musicIds");
            return (Criteria) this;
        }

        public Criteria andMusicIdsIn(List<String> values) {
            addCriterion("music_ids in", values, "musicIds");
            return (Criteria) this;
        }

        public Criteria andMusicIdsNotIn(List<String> values) {
            addCriterion("music_ids not in", values, "musicIds");
            return (Criteria) this;
        }

        public Criteria andMusicIdsBetween(String value1, String value2) {
            addCriterion("music_ids between", value1, value2, "musicIds");
            return (Criteria) this;
        }

        public Criteria andMusicIdsNotBetween(String value1, String value2) {
            addCriterion("music_ids not between", value1, value2, "musicIds");
            return (Criteria) this;
        }

        public Criteria andTextIdsIsNull() {
            addCriterion("text_ids is null");
            return (Criteria) this;
        }

        public Criteria andTextIdsIsNotNull() {
            addCriterion("text_ids is not null");
            return (Criteria) this;
        }

        public Criteria andTextIdsEqualTo(String value) {
            addCriterion("text_ids =", value, "textIds");
            return (Criteria) this;
        }

        public Criteria andTextIdsNotEqualTo(String value) {
            addCriterion("text_ids <>", value, "textIds");
            return (Criteria) this;
        }

        public Criteria andTextIdsGreaterThan(String value) {
            addCriterion("text_ids >", value, "textIds");
            return (Criteria) this;
        }

        public Criteria andTextIdsGreaterThanOrEqualTo(String value) {
            addCriterion("text_ids >=", value, "textIds");
            return (Criteria) this;
        }

        public Criteria andTextIdsLessThan(String value) {
            addCriterion("text_ids <", value, "textIds");
            return (Criteria) this;
        }

        public Criteria andTextIdsLessThanOrEqualTo(String value) {
            addCriterion("text_ids <=", value, "textIds");
            return (Criteria) this;
        }

        public Criteria andTextIdsLike(String value) {
            addCriterion("text_ids like", value, "textIds");
            return (Criteria) this;
        }

        public Criteria andTextIdsNotLike(String value) {
            addCriterion("text_ids not like", value, "textIds");
            return (Criteria) this;
        }

        public Criteria andTextIdsIn(List<String> values) {
            addCriterion("text_ids in", values, "textIds");
            return (Criteria) this;
        }

        public Criteria andTextIdsNotIn(List<String> values) {
            addCriterion("text_ids not in", values, "textIds");
            return (Criteria) this;
        }

        public Criteria andTextIdsBetween(String value1, String value2) {
            addCriterion("text_ids between", value1, value2, "textIds");
            return (Criteria) this;
        }

        public Criteria andTextIdsNotBetween(String value1, String value2) {
            addCriterion("text_ids not between", value1, value2, "textIds");
            return (Criteria) this;
        }

        public Criteria andWeatherIsNull() {
            addCriterion("weather is null");
            return (Criteria) this;
        }

        public Criteria andWeatherIsNotNull() {
            addCriterion("weather is not null");
            return (Criteria) this;
        }

        public Criteria andWeatherEqualTo(String value) {
            addCriterion("weather =", value, "weather");
            return (Criteria) this;
        }

        public Criteria andWeatherNotEqualTo(String value) {
            addCriterion("weather <>", value, "weather");
            return (Criteria) this;
        }

        public Criteria andWeatherGreaterThan(String value) {
            addCriterion("weather >", value, "weather");
            return (Criteria) this;
        }

        public Criteria andWeatherGreaterThanOrEqualTo(String value) {
            addCriterion("weather >=", value, "weather");
            return (Criteria) this;
        }

        public Criteria andWeatherLessThan(String value) {
            addCriterion("weather <", value, "weather");
            return (Criteria) this;
        }

        public Criteria andWeatherLessThanOrEqualTo(String value) {
            addCriterion("weather <=", value, "weather");
            return (Criteria) this;
        }

        public Criteria andWeatherLike(String value) {
            addCriterion("weather like", value, "weather");
            return (Criteria) this;
        }

        public Criteria andWeatherNotLike(String value) {
            addCriterion("weather not like", value, "weather");
            return (Criteria) this;
        }

        public Criteria andWeatherIn(List<String> values) {
            addCriterion("weather in", values, "weather");
            return (Criteria) this;
        }

        public Criteria andWeatherNotIn(List<String> values) {
            addCriterion("weather not in", values, "weather");
            return (Criteria) this;
        }

        public Criteria andWeatherBetween(String value1, String value2) {
            addCriterion("weather between", value1, value2, "weather");
            return (Criteria) this;
        }

        public Criteria andWeatherNotBetween(String value1, String value2) {
            addCriterion("weather not between", value1, value2, "weather");
            return (Criteria) this;
        }

        public Criteria andDateShowIsNull() {
            addCriterion("date_show is null");
            return (Criteria) this;
        }

        public Criteria andDateShowIsNotNull() {
            addCriterion("date_show is not null");
            return (Criteria) this;
        }

        public Criteria andDateShowEqualTo(String value) {
            addCriterion("date_show =", value, "dateShow");
            return (Criteria) this;
        }

        public Criteria andDateShowNotEqualTo(String value) {
            addCriterion("date_show <>", value, "dateShow");
            return (Criteria) this;
        }

        public Criteria andDateShowGreaterThan(String value) {
            addCriterion("date_show >", value, "dateShow");
            return (Criteria) this;
        }

        public Criteria andDateShowGreaterThanOrEqualTo(String value) {
            addCriterion("date_show >=", value, "dateShow");
            return (Criteria) this;
        }

        public Criteria andDateShowLessThan(String value) {
            addCriterion("date_show <", value, "dateShow");
            return (Criteria) this;
        }

        public Criteria andDateShowLessThanOrEqualTo(String value) {
            addCriterion("date_show <=", value, "dateShow");
            return (Criteria) this;
        }

        public Criteria andDateShowLike(String value) {
            addCriterion("date_show like", value, "dateShow");
            return (Criteria) this;
        }

        public Criteria andDateShowNotLike(String value) {
            addCriterion("date_show not like", value, "dateShow");
            return (Criteria) this;
        }

        public Criteria andDateShowIn(List<String> values) {
            addCriterion("date_show in", values, "dateShow");
            return (Criteria) this;
        }

        public Criteria andDateShowNotIn(List<String> values) {
            addCriterion("date_show not in", values, "dateShow");
            return (Criteria) this;
        }

        public Criteria andDateShowBetween(String value1, String value2) {
            addCriterion("date_show between", value1, value2, "dateShow");
            return (Criteria) this;
        }

        public Criteria andDateShowNotBetween(String value1, String value2) {
            addCriterion("date_show not between", value1, value2, "dateShow");
            return (Criteria) this;
        }

        public Criteria andPreviewimageIsNull() {
            addCriterion("previewImage is null");
            return (Criteria) this;
        }

        public Criteria andPreviewimageIsNotNull() {
            addCriterion("previewImage is not null");
            return (Criteria) this;
        }

        public Criteria andPreviewimageEqualTo(String value) {
            addCriterion("previewImage =", value, "previewimage");
            return (Criteria) this;
        }

        public Criteria andPreviewimageNotEqualTo(String value) {
            addCriterion("previewImage <>", value, "previewimage");
            return (Criteria) this;
        }

        public Criteria andPreviewimageGreaterThan(String value) {
            addCriterion("previewImage >", value, "previewimage");
            return (Criteria) this;
        }

        public Criteria andPreviewimageGreaterThanOrEqualTo(String value) {
            addCriterion("previewImage >=", value, "previewimage");
            return (Criteria) this;
        }

        public Criteria andPreviewimageLessThan(String value) {
            addCriterion("previewImage <", value, "previewimage");
            return (Criteria) this;
        }

        public Criteria andPreviewimageLessThanOrEqualTo(String value) {
            addCriterion("previewImage <=", value, "previewimage");
            return (Criteria) this;
        }

        public Criteria andPreviewimageLike(String value) {
            addCriterion("previewImage like", value, "previewimage");
            return (Criteria) this;
        }

        public Criteria andPreviewimageNotLike(String value) {
            addCriterion("previewImage not like", value, "previewimage");
            return (Criteria) this;
        }

        public Criteria andPreviewimageIn(List<String> values) {
            addCriterion("previewImage in", values, "previewimage");
            return (Criteria) this;
        }

        public Criteria andPreviewimageNotIn(List<String> values) {
            addCriterion("previewImage not in", values, "previewimage");
            return (Criteria) this;
        }

        public Criteria andPreviewimageBetween(String value1, String value2) {
            addCriterion("previewImage between", value1, value2, "previewimage");
            return (Criteria) this;
        }

        public Criteria andPreviewimageNotBetween(String value1, String value2) {
            addCriterion("previewImage not between", value1, value2, "previewimage");
            return (Criteria) this;
        }

        public Criteria andTemplateImageIsNull() {
            addCriterion("template_image is null");
            return (Criteria) this;
        }

        public Criteria andTemplateImageIsNotNull() {
            addCriterion("template_image is not null");
            return (Criteria) this;
        }

        public Criteria andTemplateImageEqualTo(String value) {
            addCriterion("template_image =", value, "templateImage");
            return (Criteria) this;
        }

        public Criteria andTemplateImageNotEqualTo(String value) {
            addCriterion("template_image <>", value, "templateImage");
            return (Criteria) this;
        }

        public Criteria andTemplateImageGreaterThan(String value) {
            addCriterion("template_image >", value, "templateImage");
            return (Criteria) this;
        }

        public Criteria andTemplateImageGreaterThanOrEqualTo(String value) {
            addCriterion("template_image >=", value, "templateImage");
            return (Criteria) this;
        }

        public Criteria andTemplateImageLessThan(String value) {
            addCriterion("template_image <", value, "templateImage");
            return (Criteria) this;
        }

        public Criteria andTemplateImageLessThanOrEqualTo(String value) {
            addCriterion("template_image <=", value, "templateImage");
            return (Criteria) this;
        }

        public Criteria andTemplateImageLike(String value) {
            addCriterion("template_image like", value, "templateImage");
            return (Criteria) this;
        }

        public Criteria andTemplateImageNotLike(String value) {
            addCriterion("template_image not like", value, "templateImage");
            return (Criteria) this;
        }

        public Criteria andTemplateImageIn(List<String> values) {
            addCriterion("template_image in", values, "templateImage");
            return (Criteria) this;
        }

        public Criteria andTemplateImageNotIn(List<String> values) {
            addCriterion("template_image not in", values, "templateImage");
            return (Criteria) this;
        }

        public Criteria andTemplateImageBetween(String value1, String value2) {
            addCriterion("template_image between", value1, value2, "templateImage");
            return (Criteria) this;
        }

        public Criteria andTemplateImageNotBetween(String value1, String value2) {
            addCriterion("template_image not between", value1, value2, "templateImage");
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