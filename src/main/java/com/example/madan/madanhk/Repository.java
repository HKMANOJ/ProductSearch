package com.example.madan.madanhk;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

@org.springframework.stereotype.Repository
public interface Repository extends JpaRepository<Product,Long> {
     @Query("from Product where vendor=?1")
    List<Product> findByVendor(String vendor);
}
