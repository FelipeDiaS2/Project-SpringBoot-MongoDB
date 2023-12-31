package com.estudo.Project.config;


import com.estudo.Project.domain.Post;
import com.estudo.Project.domain.User;
import com.estudo.Project.dto.AutorDTO;
import com.estudo.Project.dto.CommentDTO;
import com.estudo.Project.repository.PostRepository;
import com.estudo.Project.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PostRepository postRepository;
    @Override
    public void run(String... args) throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        userRepository.deleteAll();
        postRepository.deleteAll();

        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");

        userRepository.saveAll(Arrays.asList(maria, alex, bob));

        Post post1 = new Post(null,sdf.parse("21/03/2018"),"Partiu viagem","Vou viajar para Londres. Abraços!",new AutorDTO(maria));
        Post post2 = new Post(null,sdf.parse("25/03/2018"),"Bom dia","Acordei feliz hoje",new AutorDTO(maria));

        CommentDTO c1 = new CommentDTO("Boa viagem mano",sdf.parse("21/03/2018"),new AutorDTO(alex));
        CommentDTO c2 = new CommentDTO("Aproveite",sdf.parse("22/03/2018"),new AutorDTO(bob));
        CommentDTO c3 = new CommentDTO("Salve",sdf.parse("22/03/2018"),new AutorDTO(bob));

        post1.getComments().addAll((Arrays.asList(c1,c2)));
        post2.getComments().addAll((Arrays.asList(c3)));

        postRepository.saveAll(Arrays.asList(post1,post2));

        maria.getPosts().addAll(Arrays.asList(post1,post2));
        userRepository.save(maria);
    }
}
