package com.example.myhome.service;

import com.example.myhome.model.Board;
import com.example.myhome.model.User;
import com.example.myhome.repository.BoardRepository;
import com.example.myhome.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardService {

    @Autowired
    BoardRepository boardRepository;

    @Autowired
    UserRepository userRepository;

    public Board save(Board board, String name){

        User user = userRepository.findByUsername(name);
        board.setUser(user);
        return boardRepository.save(board);
    }

}
