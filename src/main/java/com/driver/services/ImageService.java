package com.driver.services;

import com.driver.models.*;
import com.driver.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageService {

    @Autowired
    BlogRepository blogRepository2;
    @Autowired
    ImageRepository imageRepository2;

    public Image addImage(Integer blogId, String description, String dimensions){
        //add an image to the blog
        Image image = new Image();
        image.setId(blogId);
        image.setDescription(description);
        image.setDimensions(dimensions);

        imageRepository2.save(image);
        return image;
    }

    public void deleteImage(Integer id){
      imageRepository2.deleteById(id);
    }

    public int countImagesInScreen(Integer id, String screenDimensions) {
        //Find the number of images of given dimensions that can fit in a screen having `screenDimensions`
        Image image=imageRepository2.findById(id).get();

        String imageDim[]=image.getDimensions().split("X");
        String screenDim[]=screenDimensions.split("X");

        int imageDimensionhori=Integer.parseInt(imageDim[0]);
        int imageDimensionvert=Integer.parseInt(imageDim[1]);
        int screenDimensionhori=Integer.parseInt(screenDim[0]);
        int screenDimensionveri=Integer.parseInt(screenDim[1]);
        int count=(screenDimensionhori/imageDimensionhori)*(screenDimensionveri/imageDimensionvert);

        return count;
    }
}
