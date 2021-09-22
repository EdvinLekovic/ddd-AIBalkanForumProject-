package com.example.sharedkernel.domain.image;


import com.example.sharedkernel.domain.base.ValueObject;
import lombok.Getter;
import javax.persistence.Embeddable;

@Embeddable
@Getter
public class Image extends ValueObject {

    private final String imageName;

    private final String imageType;

    private final byte[] imageData;

    protected Image(){
        this.imageName = null;
        this.imageType = null;
        this.imageData = null;
    }

}

