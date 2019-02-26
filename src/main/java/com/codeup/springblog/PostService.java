package com.codeup.springblog;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
class PostService {
    private List<Post> posts;

    public PostService() {
        posts = new ArrayList<>();
    }

    //retrieving all posts
    public List<Post> all() {
        return posts;
    }

    //finding a posts
    public Post one(long id) {
        return posts.get((int) (id - 1));
    }

    //save method
    void save(Post post){
        post.setId(posts.size() + 1);
        posts.add(post);
    }

    public static List<Post> generatePost() {
        List<Post> posts = new ArrayList<>();
        
        posts.add(new Post(
                "finibus",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed dictum pretium metus sagittis euismod. Suspendisse tristique elit eget turpis fermentum congue. Morbi mauris massa, hendrerit at diam at, tincidunt bibendum lacus. Praesent finibus sagittis nulla, eu auctor massa. Morbi et pellentesque lacus. Suspendisse feugiat sem ut augue sodales, id interdum mi volutpat. Maecenas magna enim, placerat non leo a, ultricies elementum metus. Morbi consequat dolor eget tincidunt fermentum. Donec eu enim ut ante faucibus dignissim ac mattis ante."
        ));
        posts.add(new Post(
                "metus sagittis",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed dictum pretium metus sagittis euismod. Suspendisse tristique elit eget turpis fermentum congue. Morbi mauris massa, hendrerit at diam at, tincidunt bibendum lacus. Praesent finibus sagittis nulla, eu auctor massa. Morbi et pellentesque lacus. Suspendisse feugiat sem ut augue sodales, id interdum mi volutpat. Maecenas magna enim, placerat non leo a, ultricies elementum metus. Morbi consequat dolor eget tincidunt fermentum. Donec eu enim ut ante faucibus dignissim ac mattis ante."
        ));
        posts.add(new Post(
                "mauris massa",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed dictum pretium metus sagittis euismod. Suspendisse tristique elit eget turpis fermentum congue. Morbi mauris massa, hendrerit at diam at, tincidunt bibendum lacus. Praesent finibus sagittis nulla, eu auctor massa. Morbi et pellentesque lacus. Suspendisse feugiat sem ut augue sodales, id interdum mi volutpat. Maecenas magna enim, placerat non leo a, ultricies elementum metus. Morbi consequat dolor eget tincidunt fermentum. Donec eu enim ut ante faucibus dignissim ac mattis ante."
        ));
        posts.add(new Post(
                "Cras non nunc",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed dictum pretium metus sagittis euismod. Suspendisse tristique elit eget turpis fermentum congue. Morbi mauris massa, hendrerit at diam at, tincidunt bibendum lacus. Praesent finibus sagittis nulla, eu auctor massa. Morbi et pellentesque lacus. Suspendisse feugiat sem ut augue sodales, id interdum mi volutpat. Maecenas magna enim, placerat non leo a, ultricies elementum metus. Morbi consequat dolor eget tincidunt fermentum. Donec eu enim ut ante faucibus dignissim ac mattis ante."
        ));

        return posts;
    }
}