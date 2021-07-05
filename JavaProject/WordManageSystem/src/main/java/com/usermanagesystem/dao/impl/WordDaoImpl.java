package com.usermanagesystem.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.usermanagesystem.dao.WordDao;
import com.usermanagesystem.entity.Word;
import com.usermanagesystem.util.DBUtil;

public class WordDaoImpl implements WordDao {
    private String sql;
    PreparedStatement psmt;
    DBUtil util;
    Connection conn;

    public WordDaoImpl() {
        super();
        // 数据库连接工具类
        util = new DBUtil();
        // 获得连接
        conn = util.openConnection();
    }

    /**
     * 查询所有单词
     * @return
     */
    public List<Word> wordList() {
        List<Word> words = new ArrayList<Word>();
        sql = "select id, word, detail from wordTbl";
        try {
            psmt = conn.prepareStatement(sql);

            ResultSet rs = psmt.executeQuery();
            while (rs.next()) {
                Word w = new Word();
                w.setId(rs.getInt("id"));
                w.setWord(rs.getString("word"));
                w.setDetail(rs.getString("detail"));
                words.add(w);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return words;
    }

//    /**
//     * 查询所有单词
//     * @param category
//     * @return
//     */
//    public List<Word> wordList(String category) {
//        List<Word> words = new ArrayList<Word>();
////        sql = "select id, word, detail from wordTbl " +
////                "where id in (select wordId  from classification " +
////                "where categoryId in(select id from category where category=?))";
//
//        sql = "select id, word, detail from wordTbl";
//
//        try {
//            psmt = conn.prepareStatement(sql);
////            psmt.setString(1, category);
//            ResultSet rs = psmt.executeQuery();
//            while (rs.next()) {
//                Word w = new Word();
//                w.setId(rs.getInt("id"));
//                w.setWord(rs.getString("word"));
//                w.setDetail(rs.getString("detail"));
////                w.setPing(rs.getString("ping"));
//                words.add(w);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return words;
//    }


    /**
     * 删除单词
     * @param Wordid
     * @return
     */
    public int deleteWord(int Wordid) {
        int row = 0;
        // 查询SQL语句
        sql = " delete from wordTbl where id=?  ";
        try {
            // 获得预定义语句
            psmt = conn.prepareStatement(sql);
            // 设置查询参数
            psmt.setInt(1, Wordid);
            // 执行查询
            row = psmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return row;
    }

    /**
     * 通过id查询
     * @param Wordid
     * @return
     */
    public Word findWordById(int Wordid) {
        // 查询SQL语句
        sql = " select id,word,detail from wordTbl where id=?";
        try {
            // 获得预定义语句
            psmt = conn.prepareStatement(sql);
            // 设置查询参数
            psmt.setInt(1, Wordid);
            // 执行查询
            ResultSet rs = psmt.executeQuery();
            // 判断用户是否存在
            if (rs.next()) {
                // 获得用户信息
                int id = rs.getInt(1);
                String word = rs.getString(2);
                String detail = rs.getString(3);
                // 封装用户信息
                Word w = new Word();
                w.setId(id);
                w.setWord(word);
                w.setDetail(detail);
                return w;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 添加单词
     * @param w
     * @return
     */
    public int insertWord(Word w) {
        int row = 0;
        sql = "insert into wordTbl(word,detail) values(?,?)";
        try {
            psmt = conn.prepareStatement(sql);
            psmt.setString(1, w.getWord());
            psmt.setString(2, w.getDetail());
            row = psmt.executeUpdate();
        } catch (SQLException e) {
            System.out.print("添加单词信息：");
            e.printStackTrace();
        }
        return row;
    }

    /**
     * 修改单词
     * @param w
     * @return
     */
    public int updateWord(Word w) {
        int row = 0;
        sql = "update wordTbl set word=?,detail=? where id=?";
        try {
            psmt = conn.prepareStatement(sql);
            psmt.setString(1, w.getWord());
            psmt.setString(2, w.getDetail());
            psmt.setInt(3, w.getId());
            row = psmt.executeUpdate();
        } catch (SQLException e) {
            System.out.print("添修改单词信息：");
            e.printStackTrace();
        }
        return row;
    }


    //Test
    public static void main(String[] args) {
        WordDaoImpl wordDao = new WordDaoImpl();
        //insert
//        Word word = new Word();
//        word.setWord("hhh");
//        word.setDetail("heihei");
//        int count = wordDao.insertWord(word);
//        System.out.println(count);

        //list
//        List<Word> words = wordDao.wordList();
//        for (Word word : words) {
//            System.out.println(word);
//        }
//        System.out.println(words);

        //delete
//        wordDao.deleteWord(4);


    }


}
