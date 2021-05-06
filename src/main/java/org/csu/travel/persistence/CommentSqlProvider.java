package org.csu.travel.persistence;

import org.csu.travel.domain.Comment;
import org.csu.travel.domain.CommentExample;
import org.csu.travel.domain.CommentExample.Criteria;
import org.csu.travel.domain.CommentExample.Criterion;

import java.util.List;
import java.util.Map;

import static org.apache.ibatis.jdbc.SqlBuilder.*;

public class CommentSqlProvider {

    public String countByExample(CommentExample example) {
        BEGIN();
        SELECT("count(*)");
        FROM("comment_ex");
        applyWhere(example, false);
        return SQL();
    }

    public String deleteByExample(CommentExample example) {
        BEGIN();
        DELETE_FROM("comment_ex");
        applyWhere(example, false);
        return SQL();
    }

    public String insertSelective(Comment record) {
        BEGIN();
        INSERT_INTO("comment_ex");

        if (record.getArticleId() != null) {
            VALUES("article_id", "#{articleId,jdbcType=INTEGER}");
        }

        if (record.getAuthorId() != null) {
            VALUES("author_id", "#{authorId,jdbcType=VARCHAR}");
        }

        if (record.getTime() != null) {
            VALUES("time", "#{time,jdbcType=TIMESTAMP}");
        }

        if (record.getContentEx() != null) {
            VALUES("content_ex", "#{contentEx,jdbcType=LONGVARCHAR}");
        }

        return SQL();
    }

    public String selectByExampleWithBLOBs(CommentExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("comment_id");
        } else {
            SELECT("comment_id");
        }
        SELECT("article_id");
        SELECT("author_id");
        SELECT("time");
        SELECT("content_ex");
        FROM("comment_ex");
        applyWhere(example, false);

        if (example != null && example.getOrderByClause() != null) {
            ORDER_BY(example.getOrderByClause());
        }

        return SQL();
    }

    public String selectByExample(CommentExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("comment_id");
        } else {
            SELECT("comment_id");
        }
        SELECT("article_id");
        SELECT("author_id");
        SELECT("time");
        FROM("comment_ex");
        applyWhere(example, false);

        if (example != null && example.getOrderByClause() != null) {
            ORDER_BY(example.getOrderByClause());
        }

        return SQL();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        Comment record = (Comment) parameter.get("record");
        CommentExample example = (CommentExample) parameter.get("example");

        BEGIN();
        UPDATE("comment_ex");

        if (record.getCommentId() != null) {
            SET("comment_id = #{record.commentId,jdbcType=INTEGER}");
        }

        if (record.getArticleId() != null) {
            SET("article_id = #{record.articleId,jdbcType=INTEGER}");
        }

        if (record.getAuthorId() != null) {
            SET("author_id = #{record.authorId,jdbcType=VARCHAR}");
        }

        if (record.getTime() != null) {
            SET("time = #{record.time,jdbcType=TIMESTAMP}");
        }

        if (record.getContentEx() != null) {
            SET("content_ex = #{record.contentEx,jdbcType=LONGVARCHAR}");
        }

        applyWhere(example, true);
        return SQL();
    }

    public String updateByExampleWithBLOBs(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("comment_ex");

        SET("comment_id = #{record.commentId,jdbcType=INTEGER}");
        SET("article_id = #{record.articleId,jdbcType=INTEGER}");
        SET("author_id = #{record.authorId,jdbcType=VARCHAR}");
        SET("time = #{record.time,jdbcType=TIMESTAMP}");
        SET("content_ex = #{record.contentEx,jdbcType=LONGVARCHAR}");

        CommentExample example = (CommentExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    public String updateByExample(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("comment_ex");

        SET("comment_id = #{record.commentId,jdbcType=INTEGER}");
        SET("article_id = #{record.articleId,jdbcType=INTEGER}");
        SET("author_id = #{record.authorId,jdbcType=VARCHAR}");
        SET("time = #{record.time,jdbcType=TIMESTAMP}");

        CommentExample example = (CommentExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    public String updateByPrimaryKeySelective(Comment record) {
        BEGIN();
        UPDATE("comment_ex");

        if (record.getArticleId() != null) {
            SET("article_id = #{articleId,jdbcType=INTEGER}");
        }

        if (record.getAuthorId() != null) {
            SET("author_id = #{authorId,jdbcType=VARCHAR}");
        }

        if (record.getTime() != null) {
            SET("time = #{time,jdbcType=TIMESTAMP}");
        }

        if (record.getContentEx() != null) {
            SET("content_ex = #{contentEx,jdbcType=LONGVARCHAR}");
        }

        WHERE("comment_id = #{commentId,jdbcType=INTEGER}");

        return SQL();
    }

    protected void applyWhere(CommentExample example, boolean includeExamplePhrase) {
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