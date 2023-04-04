package com.bookStore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookStore.entity.MyBooks;

public interface MyBookRepository extends JpaRepository<MyBooks, Integer>{

}
