package com.nixmash.springdata.jpa.repository;

import com.nixmash.springdata.jpa.model.Like;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LikeRepository extends CrudRepository<Like, Long> {

    List<Like> findByUserIdAndContentTypeId(long userId, int contentTypeId);
    List<Like> findByContentTypeId(int contentTypeId);

    List<Like> findAll();

    @Query("select l.itemId from Like l where l.contentTypeId = 1 and l.userId = ?1")
    List<Long> findLikedPostIds(long userId);
}
