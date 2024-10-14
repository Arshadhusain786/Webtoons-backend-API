package com.assignment.demo.Controller;

import com.assignment.demo.Model.Webtoon;
import com.assignment.demo.Service.WebtoonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/webtoons")
public class WebtoonController {

    @Autowired
    private WebtoonService webtoonService;

    @GetMapping
    public ResponseEntity<List<Webtoon>> getAllWebtoons()
    {
        List<Webtoon> webtoons = webtoonService.getAllWebtoons();
        return new ResponseEntity<>(webtoons, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Webtoon> getWebtoonById(@PathVariable int id) {
        Webtoon webtoon = webtoonService.getWebtoonById(id);
        if (webtoon == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(webtoon, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Webtoon> createWebtoon(@RequestBody Webtoon webtoon) {
        Webtoon createdWebtoon = webtoonService.addWebtoon(webtoon);
        return new ResponseEntity<>(createdWebtoon, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWebtoon(@PathVariable int id) {
        Webtoon webtoon = webtoonService.getWebtoonById(id);
        if (webtoon == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        webtoonService.deleteWebtoon(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
