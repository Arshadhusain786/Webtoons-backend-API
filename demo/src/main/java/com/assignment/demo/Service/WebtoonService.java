package com.assignment.demo.Service;

import com.assignment.demo.Model.Webtoon;
import com.assignment.demo.Repository.WebtoonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WebtoonService
{
    @Autowired
    private WebtoonRepository webtoonRepository;

    public List<Webtoon> getAllWebtoons() {
        return webtoonRepository.findAll();
    }

    public Webtoon getWebtoonById(int id) {
        // Find webtoon by ID, return null if not found
        Webtoon webtoon = webtoonRepository.findById(id).orElse(null);
        return webtoon;
    }

    public Webtoon addWebtoon(Webtoon webtoon) {
        return webtoonRepository.save(webtoon);
    }

    public void deleteWebtoon(int id) {
        webtoonRepository.deleteById(id);
    }
}
