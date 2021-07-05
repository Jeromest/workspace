package com.usermanagesystem.dao;

import java.util.List;

import com.usermanagesystem.entity.User;
import com.usermanagesystem.entity.Word;

public interface WordDao {
    public int insertWord(Word u);

    public Word findWordById(int Wordid);

    public int updateWord(Word u);

    public int deleteWord(int Wordid);

//    public List<Word> wordList(String category);

    public List<Word> wordList();
}
