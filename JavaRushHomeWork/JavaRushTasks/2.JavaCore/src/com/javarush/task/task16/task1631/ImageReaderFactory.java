/*
 * Copyright (c) 2017. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.javarush.task.task16.task1631;

import com.javarush.task.task16.task1631.common.*;

/**
 * Created by iliashebanov on 12.03.17.
 */
public class ImageReaderFactory {
    public static ImageReader getImageReader(ImageTypes imageTypes) {

        if (imageTypes == ImageTypes.JPG) return new JpgReader();
        if (imageTypes == ImageTypes.BMP) return new BmpReader();
        if (imageTypes == ImageTypes.PNG) return new PngReader();
        else throw new IllegalArgumentException("Неизвестный тип картинки");


//        switch (imageTypes) {
//            case BMP:
//                return new BmpReader();
//            case JPG:
//                return new JpgReader();
//            case PNG:
//                return new PngReader();
//            default:
//                throw new IllegalArgumentException("Неизвестный тип картинки");
//        }
    }
}
