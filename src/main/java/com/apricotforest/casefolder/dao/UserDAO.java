package com.apricotforest.casefolder.dao;

import net.paoding.rose.jade.annotation.DAO;
import net.paoding.rose.jade.annotation.SQL;

@DAO
public interface UserDAO {

    @SQL("select id from User limit 1")
    int findOne();
}
