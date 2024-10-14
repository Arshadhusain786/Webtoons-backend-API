package com.assignment.demo.Repository;

import com.assignment.demo.Model.Webtoon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WebtoonRepository extends JpaRepository<Webtoon,Integer>
{

}
