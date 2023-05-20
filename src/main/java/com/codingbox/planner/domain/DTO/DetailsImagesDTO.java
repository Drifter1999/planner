package com.codingbox.planner.domain.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DetailsImagesDTO {
    private String contentid;
    private String originimgurl;
    private String imgname;
    private String smallimageurl;
    private String cpyrhtDivCd;
    private String serialnum;
}
