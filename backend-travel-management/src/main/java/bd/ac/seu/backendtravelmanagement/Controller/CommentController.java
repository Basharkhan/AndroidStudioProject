package bd.ac.seu.backendtravelmanagement.Controller;

import bd.ac.seu.backendtravelmanagement.Entity.Comment;
import bd.ac.seu.backendtravelmanagement.Repository.CommentRepository;
import bd.ac.seu.backendtravelmanagement.TripResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CommentController {
    @Autowired
    CommentRepository commentRepository;

    @RequestMapping(path = "/comments")
    public List<Comment> getComments(){
        return commentRepository.findAll();
    }

    @RequestMapping(path = "/addComment", method = RequestMethod.POST)
    public TripResponse addComment(@RequestBody Comment comment){
        commentRepository.save(comment);
        return new TripResponse(HttpStatus.OK.value(), "Posted");
    }
}
