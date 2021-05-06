package org.csu.travel.persistence;

import org.csu.travel.domain.AccountInfo;
import org.csu.travel.domain.AccountInfoExample;
import org.csu.travel.domain.AccountInfoExample.Criteria;
import org.csu.travel.domain.AccountInfoExample.Criterion;

import java.util.List;
import java.util.Map;

import static org.apache.ibatis.jdbc.SqlBuilder.*;

public class AccountInfoSqlProvider {

    public String countByExample(AccountInfoExample example) {
        BEGIN();
        SELECT("count(*)");
        FROM("account_info");
        applyWhere(example, false);
        return SQL();
    }

    public String deleteByExample(AccountInfoExample example) {
        BEGIN();
        DELETE_FROM("account_info");
        applyWhere(example, false);
        return SQL();
    }

    public String insertSelective(AccountInfo record) {
        BEGIN();
        INSERT_INTO("account_info");

        if (record.getUserId() != null) {
            VALUES("user_id", "#{userId,jdbcType=VARCHAR}");
        }

        if (record.getUserName() != null) {
            VALUES("user_name", "#{userName,jdbcType=VARCHAR}");
        }

        if (record.getImagePath() != null) {
            VALUES("image_path", "#{imagePath,jdbcType=VARCHAR}");
        }

        if (record.getSex() != null) {
            VALUES("sex", "#{sex,jdbcType=VARCHAR}");
        }

        if (record.getHomelp() != null) {
            VALUES("homeLP", "#{homelp,jdbcType=VARCHAR}");
        }

        if (record.getHomesp() != null) {
            VALUES("homeSP", "#{homesp,jdbcType=VARCHAR}");
        }

        if (record.getLivelp() != null) {
            VALUES("liveLP", "#{livelp,jdbcType=VARCHAR}");
        }

        if (record.getLivesp() != null) {
            VALUES("liveSP", "#{livesp,jdbcType=VARCHAR}");
        }

        if (record.getBirthday() != null) {
            VALUES("birthday", "#{birthday,jdbcType=DATE}");
        }

        if (record.getTag1() != null) {
            VALUES("tag1", "#{tag1,jdbcType=VARCHAR}");
        }

        if (record.getTag2() != null) {
            VALUES("tag2", "#{tag2,jdbcType=VARCHAR}");
        }

        if (record.getTag3() != null) {
            VALUES("tag3", "#{tag3,jdbcType=VARCHAR}");
        }

        if (record.getDescription() != null) {
            VALUES("description", "#{description,jdbcType=LONGVARCHAR}");
        }

        return SQL();
    }

    public String selectByExampleWithBLOBs(AccountInfoExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("user_id");
        } else {
            SELECT("user_id");
        }
        SELECT("user_name");
        SELECT("image_path");
        SELECT("sex");
        SELECT("homeLP");
        SELECT("homeSP");
        SELECT("liveLP");
        SELECT("liveSP");
        SELECT("birthday");
        SELECT("tag1");
        SELECT("tag2");
        SELECT("tag3");
        SELECT("description");
        FROM("account_info");
        applyWhere(example, false);

        if (example != null && example.getOrderByClause() != null) {
            ORDER_BY(example.getOrderByClause());
        }

        return SQL();
    }

    public String selectByExample(AccountInfoExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("user_id");
        } else {
            SELECT("user_id");
        }
        SELECT("user_name");
        SELECT("image_path");
        SELECT("sex");
        SELECT("homeLP");
        SELECT("homeSP");
        SELECT("liveLP");
        SELECT("liveSP");
        SELECT("birthday");
        SELECT("tag1");
        SELECT("tag2");
        SELECT("tag3");
        FROM("account_info");
        applyWhere(example, false);

        if (example != null && example.getOrderByClause() != null) {
            ORDER_BY(example.getOrderByClause());
        }

        return SQL();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        AccountInfo record = (AccountInfo) parameter.get("record");
        AccountInfoExample example = (AccountInfoExample) parameter.get("example");

        BEGIN();
        UPDATE("account_info");

        if (record.getUserId() != null) {
            SET("user_id = #{record.userId,jdbcType=VARCHAR}");
        }

        if (record.getUserName() != null) {
            SET("user_name = #{record.userName,jdbcType=VARCHAR}");
        }

        if (record.getImagePath() != null) {
            SET("image_path = #{record.imagePath,jdbcType=VARCHAR}");
        }

        if (record.getSex() != null) {
            SET("sex = #{record.sex,jdbcType=VARCHAR}");
        }

        if (record.getHomelp() != null) {
            SET("homeLP = #{record.homelp,jdbcType=VARCHAR}");
        }

        if (record.getHomesp() != null) {
            SET("homeSP = #{record.homesp,jdbcType=VARCHAR}");
        }

        if (record.getLivelp() != null) {
            SET("liveLP = #{record.livelp,jdbcType=VARCHAR}");
        }

        if (record.getLivesp() != null) {
            SET("liveSP = #{record.livesp,jdbcType=VARCHAR}");
        }

        if (record.getBirthday() != null) {
            SET("birthday = #{record.birthday,jdbcType=DATE}");
        }

        if (record.getTag1() != null) {
            SET("tag1 = #{record.tag1,jdbcType=VARCHAR}");
        }

        if (record.getTag2() != null) {
            SET("tag2 = #{record.tag2,jdbcType=VARCHAR}");
        }

        if (record.getTag3() != null) {
            SET("tag3 = #{record.tag3,jdbcType=VARCHAR}");
        }

        if (record.getDescription() != null) {
            SET("description = #{record.description,jdbcType=LONGVARCHAR}");
        }

        applyWhere(example, true);
        return SQL();
    }

    public String updateByExampleWithBLOBs(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("account_info");

        SET("user_id = #{record.userId,jdbcType=VARCHAR}");
        SET("user_name = #{record.userName,jdbcType=VARCHAR}");
        SET("image_path = #{record.imagePath,jdbcType=VARCHAR}");
        SET("sex = #{record.sex,jdbcType=VARCHAR}");
        SET("homeLP = #{record.homelp,jdbcType=VARCHAR}");
        SET("homeSP = #{record.homesp,jdbcType=VARCHAR}");
        SET("liveLP = #{record.livelp,jdbcType=VARCHAR}");
        SET("liveSP = #{record.livesp,jdbcType=VARCHAR}");
        SET("birthday = #{record.birthday,jdbcType=DATE}");
        SET("tag1 = #{record.tag1,jdbcType=VARCHAR}");
        SET("tag2 = #{record.tag2,jdbcType=VARCHAR}");
        SET("tag3 = #{record.tag3,jdbcType=VARCHAR}");
        SET("description = #{record.description,jdbcType=LONGVARCHAR}");

        AccountInfoExample example = (AccountInfoExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    public String updateByExample(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("account_info");

        SET("user_id = #{record.userId,jdbcType=VARCHAR}");
        SET("user_name = #{record.userName,jdbcType=VARCHAR}");
        SET("image_path = #{record.imagePath,jdbcType=VARCHAR}");
        SET("sex = #{record.sex,jdbcType=VARCHAR}");
        SET("homeLP = #{record.homelp,jdbcType=VARCHAR}");
        SET("homeSP = #{record.homesp,jdbcType=VARCHAR}");
        SET("liveLP = #{record.livelp,jdbcType=VARCHAR}");
        SET("liveSP = #{record.livesp,jdbcType=VARCHAR}");
        SET("birthday = #{record.birthday,jdbcType=DATE}");
        SET("tag1 = #{record.tag1,jdbcType=VARCHAR}");
        SET("tag2 = #{record.tag2,jdbcType=VARCHAR}");
        SET("tag3 = #{record.tag3,jdbcType=VARCHAR}");

        AccountInfoExample example = (AccountInfoExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    public String updateByPrimaryKeySelective(AccountInfo record) {
        BEGIN();
        UPDATE("account_info");

        if (record.getUserName() != null) {
            SET("user_name = #{userName,jdbcType=VARCHAR}");
        }

        if (record.getImagePath() != null) {
            SET("image_path = #{imagePath,jdbcType=VARCHAR}");
        }

        if (record.getSex() != null) {
            SET("sex = #{sex,jdbcType=VARCHAR}");
        }

        if (record.getHomelp() != null) {
            SET("homeLP = #{homelp,jdbcType=VARCHAR}");
        }

        if (record.getHomesp() != null) {
            SET("homeSP = #{homesp,jdbcType=VARCHAR}");
        }

        if (record.getLivelp() != null) {
            SET("liveLP = #{livelp,jdbcType=VARCHAR}");
        }

        if (record.getLivesp() != null) {
            SET("liveSP = #{livesp,jdbcType=VARCHAR}");
        }

        if (record.getBirthday() != null) {
            SET("birthday = #{birthday,jdbcType=DATE}");
        }

        if (record.getTag1() != null) {
            SET("tag1 = #{tag1,jdbcType=VARCHAR}");
        }

        if (record.getTag2() != null) {
            SET("tag2 = #{tag2,jdbcType=VARCHAR}");
        }

        if (record.getTag3() != null) {
            SET("tag3 = #{tag3,jdbcType=VARCHAR}");
        }

        if (record.getDescription() != null) {
            SET("description = #{description,jdbcType=LONGVARCHAR}");
        }

        WHERE("user_id = #{userId,jdbcType=VARCHAR}");

        return SQL();
    }

    protected void applyWhere(AccountInfoExample example, boolean includeExamplePhrase) {
        if (example == null) {
            return;
        }

        String parmPhrase1;
        String parmPhrase1_th;
        String parmPhrase2;
        String parmPhrase2_th;
        String parmPhrase3;
        String parmPhrase3_th;
        if (includeExamplePhrase) {
            parmPhrase1 = "%s #{example.oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{example.oredCriteria[%d].allCriteria[%d].value} and #{example.oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{example.oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{example.oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{example.oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        } else {
            parmPhrase1 = "%s #{oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{oredCriteria[%d].allCriteria[%d].value} and #{oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        }

        StringBuilder sb = new StringBuilder();
        List<Criteria> oredCriteria = example.getOredCriteria();
        boolean firstCriteria = true;
        for (int i = 0; i < oredCriteria.size(); i++) {
            Criteria criteria = oredCriteria.get(i);
            if (criteria.isValid()) {
                if (firstCriteria) {
                    firstCriteria = false;
                } else {
                    sb.append(" or ");
                }

                sb.append('(');
                List<Criterion> criterions = criteria.getAllCriteria();
                boolean firstCriterion = true;
                for (int j = 0; j < criterions.size(); j++) {
                    Criterion criterion = criterions.get(j);
                    if (firstCriterion) {
                        firstCriterion = false;
                    } else {
                        sb.append(" and ");
                    }

                    if (criterion.isNoValue()) {
                        sb.append(criterion.getCondition());
                    } else if (criterion.isSingleValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase1, criterion.getCondition(), i, j));
                        } else {
                            sb.append(String.format(parmPhrase1_th, criterion.getCondition(), i, j, criterion.getTypeHandler()));
                        }
                    } else if (criterion.isBetweenValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase2, criterion.getCondition(), i, j, i, j));
                        } else {
                            sb.append(String.format(parmPhrase2_th, criterion.getCondition(), i, j, criterion.getTypeHandler(), i, j, criterion.getTypeHandler()));
                        }
                    } else if (criterion.isListValue()) {
                        sb.append(criterion.getCondition());
                        sb.append(" (");
                        List<?> listItems = (List<?>) criterion.getValue();
                        boolean comma = false;
                        for (int k = 0; k < listItems.size(); k++) {
                            if (comma) {
                                sb.append(", ");
                            } else {
                                comma = true;
                            }
                            if (criterion.getTypeHandler() == null) {
                                sb.append(String.format(parmPhrase3, i, j, k));
                            } else {
                                sb.append(String.format(parmPhrase3_th, i, j, k, criterion.getTypeHandler()));
                            }
                        }
                        sb.append(')');
                    }
                }
                sb.append(')');
            }
        }

        if (sb.length() > 0) {
            WHERE(sb.toString());
        }
    }
}