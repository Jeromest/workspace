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
        // ���ݿ����ӹ�����
        util = new DBUtil();
        // �������
        conn = util.openConnection();
    }

    /**
     * ��ѯ���е���
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
//     * ��ѯ���е���
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
     * ɾ������
     * @param Wordid
     * @return
     */
    public int deleteWord(int Wordid) {
        int row = 0;
        // ��ѯSQL���
        sql = " delete from wordTbl where id=?  ";
        try {
            // ���Ԥ�������
            psmt = conn.prepareStatement(sql);
            // ���ò�ѯ����
            psmt.setInt(1, Wordid);
            // ִ�в�ѯ
            row = psmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return row;
    }

    /**
     * ͨ��id��ѯ
     * @param Wordid
     * @return
     */
    public Word findWordById(int Wordid) {
        // ��ѯSQL���
        sql = " select id,word,detail from wordTbl where id=?";
        try {
            // ���Ԥ�������
            psmt = conn.prepareStatement(sql);
            // ���ò�ѯ����
            psmt.setInt(1, Wordid);
            // ִ�в�ѯ
            ResultSet rs = psmt.executeQuery();
            // �ж��û��Ƿ����
            if (rs.next()) {
                // ����û���Ϣ
                int id = rs.getInt(1);
                String word = rs.getString(2);
                String detail = rs.getString(3);
                // ��װ�û���Ϣ
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
     * ��ӵ���
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
            System.out.print("��ӵ�����Ϣ��");
            e.printStackTrace();
        }
        return row;
    }

    /**
     * �޸ĵ���
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
            System.out.print("���޸ĵ�����Ϣ��");
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
