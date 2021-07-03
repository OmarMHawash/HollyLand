package com.hollyland.mvc.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hollyland.mvc.models.Image;

@Repository
public interface ImageRepository extends CrudRepository<Image, Long>{

}
