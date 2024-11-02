package com.project.wusuowei.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum FilePathEnum {


    PHOTO("aurora/photos/", "相册路径");

    private final String path;

    private final String desc;

}
