package org.csu.travelbyex.persistence;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.csu.travelbyex.domain.Article;
import org.csu.travelbyex.domain.ArticleExample;

import java.util.Date;
import java.util.List;

public interface ArticleMapper {
    @SelectProvider(type = ArticleSqlProvider.class, method = "countByExample")
    int countByExample(ArticleExample example);

    @DeleteProvider(type = ArticleSqlProvider.class, method = "deleteByExample")
    int deleteByExample(ArticleExample example);

    @Delete({
            "delete from article",
            "where article_id = #{articleId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer articleId);

    @Insert({
            "insert into article (author_id, title, ",
            "time, cover_path, ",
            "likes, readers, ",
            "LP, SP, spot_name, ",
            "tag1, tag2, tag3, ",
            "content_ex)",
            "values (#{authorId,jdbcType=VARCHAR}, #{title,jdbcType=VARCHAR}, ",
            "#{time,jdbcType=TIMESTAMP}, #{coverPath,jdbcType=VARCHAR}, ",
            "#{likes,jdbcType=INTEGER}, #{readers,jdbcType=INTEGER}, ",
            "#{lp,jdbcType=VARCHAR}, #{sp,jdbcType=VARCHAR}, #{spotName,jdbcType=VARCHAR}, ",
            "#{tag1,jdbcType=VARCHAR}, #{tag2,jdbcType=VARCHAR}, #{tag3,jdbcType=VARCHAR}, ",
            "#{contentEx,jdbcType=LONGVARCHAR})"
    })
    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "articleId", before = false, resultType = Integer.class)
    int insert(Article record);

    @InsertProvider(type = ArticleSqlProvider.class, method = "insertSelective")
    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "articleId", before = false, resultType = Integer.class)
    int insertSelective(Article record);

    @SelectProvider(type = ArticleSqlProvider.class, method = "selectByExampleWithBLOBs")
    @ConstructorArgs({
            @Arg(column = "article_id", javaType = Integer.class, jdbcType = JdbcType.INTEGER, id = true),
            @Arg(column = "author_id", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Arg(column = "title", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Arg(column = "time", javaType = Date.class, jdbcType = JdbcType.TIMESTAMP),
            @Arg(column = "cover_path", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Arg(column = "likes", javaType = Integer.class, jdbcType = JdbcType.INTEGER),
            @Arg(column = "readers", javaType = Integer.class, jdbcType = JdbcType.INTEGER),
            @Arg(column = "LP", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Arg(column = "SP", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Arg(column = "spot_name", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Arg(column = "tag1", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Arg(column = "tag2", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Arg(column = "tag3", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Arg(column = "content_ex", javaType = String.class, jdbcType = JdbcType.LONGVARCHAR)
    })
    List<Article> selectByExampleWithBLOBs(ArticleExample example);

    @SelectProvider(type = ArticleSqlProvider.class, method = "selectByExample")
    @ConstructorArgs({
            @Arg(column = "article_id", javaType = Integer.class, jdbcType = JdbcType.INTEGER, id = true),
            @Arg(column = "author_id", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Arg(column = "title", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Arg(column = "time", javaType = Date.class, jdbcType = JdbcType.TIMESTAMP),
            @Arg(column = "cover_path", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Arg(column = "likes", javaType = Integer.class, jdbcType = JdbcType.INTEGER),
            @Arg(column = "readers", javaType = Integer.class, jdbcType = JdbcType.INTEGER),
            @Arg(column = "LP", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Arg(column = "SP", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Arg(column = "spot_name", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Arg(column = "tag1", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Arg(column = "tag2", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Arg(column = "tag3", javaType = String.class, jdbcType = JdbcType.VARCHAR)
    })
    List<Article> selectByExample(ArticleExample example);

    @Select({
            "select",
            "article_id, author_id, title, time, cover_path, likes, readers, LP, SP, spot_name, ",
            "tag1, tag2, tag3, content_ex",
            "from article",
            "where article_id = #{articleId,jdbcType=INTEGER}"
    })
    @ConstructorArgs({
            @Arg(column = "article_id", javaType = Integer.class, jdbcType = JdbcType.INTEGER, id = true),
            @Arg(column = "author_id", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Arg(column = "title", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Arg(column = "time", javaType = Date.class, jdbcType = JdbcType.TIMESTAMP),
            @Arg(column = "cover_path", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Arg(column = "likes", javaType = Integer.class, jdbcType = JdbcType.INTEGER),
            @Arg(column = "readers", javaType = Integer.class, jdbcType = JdbcType.INTEGER),
            @Arg(column = "LP", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Arg(column = "SP", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Arg(column = "spot_name", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Arg(column = "tag1", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Arg(column = "tag2", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Arg(column = "tag3", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Arg(column = "content_ex", javaType = String.class, jdbcType = JdbcType.LONGVARCHAR)
    })
    Article selectByPrimaryKey(Integer articleId);

    @UpdateProvider(type = ArticleSqlProvider.class, method = "updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Article record, @Param("example") ArticleExample example);

    @UpdateProvider(type = ArticleSqlProvider.class, method = "updateByExampleWithBLOBs")
    int updateByExampleWithBLOBs(@Param("record") Article record, @Param("example") ArticleExample example);

    @UpdateProvider(type = ArticleSqlProvider.class, method = "updateByExample")
    int updateByExample(@Param("record") Article record, @Param("example") ArticleExample example);

    @UpdateProvider(type = ArticleSqlProvider.class, method = "updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Article record);

    @Update({
            "update article",
            "set author_id = #{authorId,jdbcType=VARCHAR},",
            "title = #{title,jdbcType=VARCHAR},",
            "time = #{time,jdbcType=TIMESTAMP},",
            "cover_path = #{coverPath,jdbcType=VARCHAR},",
            "likes = #{likes,jdbcType=INTEGER},",
            "readers = #{readers,jdbcType=INTEGER},",
            "LP = #{lp,jdbcType=VARCHAR},",
            "SP = #{sp,jdbcType=VARCHAR},",
            "spot_name = #{spotName,jdbcType=VARCHAR},",
            "tag1 = #{tag1,jdbcType=VARCHAR},",
            "tag2 = #{tag2,jdbcType=VARCHAR},",
            "tag3 = #{tag3,jdbcType=VARCHAR},",
            "content_ex = #{contentEx,jdbcType=LONGVARCHAR}",
            "where article_id = #{articleId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKeyWithBLOBs(Article record);

    @Update({
            "update article",
            "set author_id = #{authorId,jdbcType=VARCHAR},",
            "title = #{title,jdbcType=VARCHAR},",
            "time = #{time,jdbcType=TIMESTAMP},",
            "cover_path = #{coverPath,jdbcType=VARCHAR},",
            "likes = #{likes,jdbcType=INTEGER},",
            "readers = #{readers,jdbcType=INTEGER},",
            "LP = #{lp,jdbcType=VARCHAR},",
            "SP = #{sp,jdbcType=VARCHAR},",
            "spot_name = #{spotName,jdbcType=VARCHAR},",
            "tag1 = #{tag1,jdbcType=VARCHAR},",
            "tag2 = #{tag2,jdbcType=VARCHAR},",
            "tag3 = #{tag3,jdbcType=VARCHAR}",
            "where article_id = #{articleId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Article record);
}