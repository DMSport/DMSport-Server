package com.project.dmsport.domain.club.presentation;

import com.project.dmsport.domain.club.service.VoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/clubs")
@RestController
public class ClubController {

    private final VoteService voteService;

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PostMapping("/vote/{vote-id}")
    public void vote(@PathVariable(name = "vote-id") Long voteId) {
        voteService.execute(voteId);
    }

}
